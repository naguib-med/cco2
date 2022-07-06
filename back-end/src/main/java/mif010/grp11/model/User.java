package mif010.grp11.model;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue()
  private Long uid;
  private String username;
  private byte[] password;

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public boolean passwordCorrect(byte[] pwHash) {
    return Arrays.equals(password, pwHash);
  }

  public void setPassword(byte[] password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(uid, user.uid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid);
  }
}