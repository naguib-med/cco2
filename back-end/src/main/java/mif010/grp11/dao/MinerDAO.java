package mif010.grp11.dao;

import mif010.grp11.model.Farm;
import mif010.grp11.model.Miner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MinerDAO {
  private final EntityManager em;

  /**
   * Constructor.
   * Paramaters : EntityManager.
   */
  public MinerDAO(EntityManager em) {
    this.em = em;
  }

  /**
   * Accessor of miners by his farm.
   * Paramaters : farm.
   * Return value : miner list.
   */
  public List<Miner> getMiners() {
    return em.createQuery("SELECT m FROM Miner m", Miner.class).getResultList();
  }

  public List<Miner> getByFarm(Farm farm) {
    TypedQuery<Miner> q = em.createQuery("SELECT m FROM Miner m JOIN m.fid_FK f WHERE f = ?1", Miner.class);
    q.setParameter(1, farm);
    List<Miner> res = q.getResultList();
    return res;
  }

  /**
   * Accessor of a miner by his name.
   * Paramaters : String(name).
   * Return value : miner list.
   */
  public List<Miner> getByName(String name) {
    TypedQuery<Miner> q = em.createQuery("SELECT m FROM Miner m WHERE m.model = ?1", Miner.class);
    q.setParameter(1, name);
    List<Miner> res = q.getResultList();
    return res;
  }

  public Miner getById(Long id) {
    TypedQuery<Miner> q = em.createQuery("SELECT m FROM Miner m WHERE mid = ?1",Miner.class);
    q.setParameter(1,id);
    List<Miner> res = q.getResultList();
    if (!res.isEmpty()) return res.get(0);
    else return null;
  }


  public List<Miner> getByNameFuzzy(String name) {
    String qString = "SELECT m FROM Miner m WHERE lower(m.model) LIKE CONCAT('%',";
    String parts[] = name.split(" +");
    StringBuilder params = new StringBuilder();
    for (int i = 0; i < parts.length; ++i) {
      params.append("lower(?").append(i + 1).append(") ");
    }
    qString += String.join(",'%',",params.toString().split(" +"))+",'%')";

    System.out.println(qString);

    TypedQuery<Miner> q = em.createQuery(qString,Miner.class);
    q.setMaxResults(6);

    for (int i = 0; i < parts.length; ++i) {
      q.setParameter(i+1,parts[i]);
    }

    return q.getResultList();
  }

  /**
   * Creator of a miner.
   * Paramaters : ....
   * Return value : miner instance
   */
  //tester si il existe pas déjà ? 
  public Miner create(String gpu, String manufacter, String model, Integer core_clock, Integer mem_clock, String operating_system, String driver_version, String mining_software, Integer power_consumption, String currency, String algorythm, Long speed, Float revenue_day, Float revenue_month, Float hashrate_watt, Float revenue_month_electricity_deducted) {
    em.getTransaction().begin();
    Miner miner = new Miner();
    miner.setGpu(gpu);
    miner.setManufacter(manufacter);
    miner.setModel(model);
    miner.setCore_clock(core_clock);
    miner.setMem_clock(mem_clock);
    miner.setOperating_system(operating_system);
    miner.setDriver_version(driver_version);
    miner.setMining_software(mining_software);
    miner.setPower_consumption(power_consumption);
    miner.setCurrency(currency);
    miner.setAlgorythm(algorythm);
    miner.setSpeed(speed);
    miner.setRevenue_day(revenue_day);
    miner.setRevenue_month(revenue_month);
    miner.setHashrate_watt(hashrate_watt);
    miner.setRevenue_month_electricity_deducted(revenue_month_electricity_deducted);
    em.persist(miner);
    em.getTransaction().commit();
    return miner;
  }

  public void delete(Miner miner) {
    em.getTransaction().begin();
    em.remove(miner);
    em.getTransaction().commit();
  }
}
