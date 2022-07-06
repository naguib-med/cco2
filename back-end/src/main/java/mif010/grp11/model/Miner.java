package mif010.grp11.model;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Miner {
  @Id
  @GeneratedValue()
  private Long mid;
  private String gpu;
  private String manufacter;
  private String model;
  private Integer core_clock;
  private Integer mem_clock;
  private String operating_system;
  private String driver_version;
  private String mining_software;
  private Integer power_consumption;
  private String currency;
  private String algorythm;
  private Long speed;
  private Float revenue_day;
  private Float revenue_month;
  private Float hashrate_watt;
  private Float revenue_month_electricity_deducted;

  @ManyToMany(mappedBy = "mid_FK")
  private Set<Farm> fid_FK = new HashSet<>();

  public Long getMid() {
    return mid;
  }

  public String getGpu() {
    return gpu;
  }

  public void setGpu(String gpu) {
    this.gpu = gpu;
  }

  public String getManufacter() {
    return manufacter;
  }

  public void setManufacter(String manufacter) {
    this.manufacter = manufacter;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getCore_clock() {
    return core_clock;
  }

  public void setCore_clock(Integer core_clock) {
    this.core_clock = core_clock;
  }

  public Integer getMem_clock() {
    return mem_clock;
  }

  public void setMem_clock(Integer mem_clock) {
    this.mem_clock = mem_clock;
  }

  public String getOperating_system() {
    return operating_system;
  }

  public void setOperating_system(String operating_system) {
    this.operating_system = operating_system;
  }

  public String getDriver_version() {
    return driver_version;
  }

  public void setDriver_version(String driver_version) {
    this.driver_version = driver_version;
  }

  public String getMining_software() {
    return mining_software;
  }

  public void setMining_software(String mining_software) {
    this.mining_software = mining_software;
  }

  public Integer getPower_consumption() {
    return power_consumption;
  }

  public void setPower_consumption(Integer power_consumption) {
    this.power_consumption = power_consumption;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getAlgorythm() {
    return algorythm;
  }

  public void setAlgorythm(String algorythm) {
    this.algorythm = algorythm;
  }

  public Long getSpeed() {
    return speed;
  }

  public void setSpeed(Long speed) {
    this.speed = speed;
  }

  public Float getRevenue_day() {
    return revenue_day;
  }

  public void setRevenue_day(Float revenue_day) {
    this.revenue_day = revenue_day;
  }

  public Float getRevenue_month() {
    return revenue_month;
  }

  public void setRevenue_month(Float revenue_month) {
    this.revenue_month = revenue_month;
  }

  public Float getHashrate_watt() {
    return hashrate_watt;
  }

  public void setHashrate_watt(Float hashrate_watt) {
    this.hashrate_watt = hashrate_watt;
  }

  public Float getRevenue_month_electricity_deducted() {
    return revenue_month_electricity_deducted;
  }

  public void setRevenue_month_electricity_deducted(Float revenue_month_electricity_deducted) {
    this.revenue_month_electricity_deducted = revenue_month_electricity_deducted;
  }
}
