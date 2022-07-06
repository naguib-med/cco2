package mif010.grp11.dao;

import mif010.grp11.model.Farm;
import mif010.grp11.model.Miner;
import mif010.grp11.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * DAO for darm entities.
 */

public class FarmDAO {

  private EntityManager em;

  /**
   * Constructor
   *
   * @param em
   */

  public FarmDAO(EntityManager em) {
    this.em = em;
  }

  public List<Farm> getFarms(User user) {
    System.out.println("HERE HERE HERE");
    TypedQuery<Farm> q = em.createQuery("SELECT f FROM Farm f WHERE f.uid_FK = ?1",Farm.class);
    System.out.println("HERE HERE HERE");
    q.setParameter(1,user);
    return q.getResultList();
  }

  public Farm create(String name, User uid) {
    em.getTransaction().begin();
    Farm farm = new Farm();
    farm.setName(name);
    farm.setUid_FK(uid);
    em.persist(farm);
    em.getTransaction().commit();
    return farm;
  }

  public void delete(Farm farm) {
    em.getTransaction().begin();
    em.remove(farm);
    em.getTransaction().commit();
  }

  public Farm getById(Long id) {
    TypedQuery<Farm> q = em.createQuery("SELECT f FROM Farm f WHERE fid = ?1",Farm.class);
    q.setParameter(1,id);
    List<Farm> res = q.getResultList();
    if (!res.isEmpty()) return res.get(0);
    else return null;
  }


  public void addMiner(Farm farm, Miner miner) {
    em.getTransaction().begin();
    farm.addMiner(miner);
    em.merge(farm);
    em.getTransaction().commit();
  }
}
