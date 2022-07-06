package mif010.grp11.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Farm {
  @Id
  @GeneratedValue()
  private Long fid;
  private String name;
  @ManyToOne
  @JoinColumn(name = "uid_FK")
  private User uid_FK;
  @ManyToMany
  @JoinTable(name = "fhasm",
      joinColumns = @JoinColumn(name = "fid_FK"),
      inverseJoinColumns = @JoinColumn(name = "mid_FK"))
  private Set<Miner> mid_FK = new HashSet<>();

  /** Accessor of farm's id.
    * Return value : Long.
    */
  public Long getFid() {
    return fid;
  }

  /** Mutator of farm's id.
    * Paramaters : Long(fid).
    */
  public void setFid(Long fid) {
    this.fid = fid;
  }

  /** Accessor of farm's name.
    * Return value : String.
    */
  public String getName() {
    return name;
  }

  /** Mutator of farm's name.
    * Paramaters : String(name).
    */
  public void setName(String name) {
    this.name = name;
  }

  /** Mutator of farm's user.
    * Paramaters : User.
    */
  public User getUid_FK() {
    return uid_FK;
  }

  /** Accessor of farm's user.
    * Return value : User.
    */
  public void setUid_FK(User uid_FK) {
    this.uid_FK = uid_FK;
  }

  /** Mutator of farm's miners(add a miner to the list of mid).
    * Paramaters : Miner.
    */
  public void addMiner(Miner miner) {
    this.mid_FK.add(miner);
  }
}



    