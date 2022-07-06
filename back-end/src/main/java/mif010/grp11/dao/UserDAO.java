package mif010.grp11.dao;

import mif010.grp11.model.Farm;
import mif010.grp11.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UserDAO {
  private final EntityManager em;

   /** Constructor.
    * Paramaters : EntityManager.
    */
  public UserDAO(EntityManager em) {
    this.em = em;
  }
   /** Accessor of a user by his email.
    * Paramaters : String (email).
    * Return value : user instance
    */

   /*
  public User getUserByEmail(String email) {
    if (email == null) {
      return null;
    }
    TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.email = ?1",User.class);
    q.setParameter(1,email);
    List<User> result = q.getResultList();
    if (result.isEmpty()) {
      return null;
    } else {
      return result.get(0);
    }
  }
    */

  public User getUserByUsername(String username) {
    if (username == null) {
      return null;
    }
    TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.username = ?1",User.class);
    q.setParameter(1,username);
    List<User> result = q.getResultList();
    if (result.isEmpty()) {
      return null;
    } else {
      return result.get(0);
    }
  }

  /** Mutator of a user.
    * Paramaters : String(email), String(username), String(password).
    * If user already exists, user data is updated else, he is created
    * Return value : user instance
    */
  public User createOrUpdate(String username, String password) {
    User user = getUserByUsername(username);
    if (user == null) {
      em.getTransaction().begin();
      user = new User();
      user.setUsername(username);
      MessageDigest messageDigest = null;
      try {
        messageDigest = MessageDigest.getInstance("SHA-256");
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }
      messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
      byte[] pwHash = messageDigest.digest();
      user.setPassword(pwHash);
      em.persist(user);
      em.getTransaction().commit();
    } else {
      user.setUsername(username);
    }
    return user;
  }

  public List<Farm> getFarms(User user) {
    TypedQuery<Farm> q = em.createQuery("SELECT f FROM Farm f WHERE f.uid_FK = ?1",Farm.class);
    q.setParameter(1,user);
    return q.getResultList();
  }

  public String authUser(String username, String password) {
    if (userExists(username) && passwordCorrect(username,password))
      return getUserByUsername(username).getUsername();
    else return null;
  }

  public boolean userExists(String username) {
    return getUserByUsername(username) != null;
  }

  public boolean passwordCorrect(String username, String password) {
    MessageDigest messageDigest = null;
    try {
      messageDigest = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
    byte[] pwHash = messageDigest.digest();
    return getUserByUsername(username).passwordCorrect(pwHash);
  }

  public void delete(User user) {
     em.getTransaction().begin();
     em.remove(user);
     em.getTransaction().commit();
   }
}
