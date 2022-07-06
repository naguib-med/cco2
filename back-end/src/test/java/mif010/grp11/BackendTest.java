package mif010.grp11;

import mif010.grp11.jwt.PemTest;
import sun.security.util.Pem;

import java.io.IOException;

public class BackendTest {

  @org.junit.Test
  public void setupEMTest() {
    boolean testDB = false;
    boolean testJSON = false;
    boolean testServlet = false;


    //EntityManager em = Persistence.createEntityManagerFactory("pu-cco2").createEntityManager();
    //MinerDAO md = new MinerDAO(em);

    //System.out.println(md.getByNameFuzzy("gtx 10").stream().map(m -> m.getModel()).collect(Collectors.toList()));


    /*
    if (testDB) {


      UserDAO ud = new UserDAO(em);
      FarmDAO fd = new FarmDAO(em);

      ud.createOrUpdate("a@a.a", "username", "123");
      User emailedUser = ud.getUserByEmail("a@a.a");

      System.out.println(emailedUser);
      System.out.println(emailedUser.getEmail());
      System.out.println(emailedUser.getUsername());
      System.out.println(emailedUser.getPassword());

      fd.create("test farm 1", emailedUser);
      fd.create("test farm 2", emailedUser);
      List<Farm> farms = fd.getFarms(emailedUser);

      for (Farm f : farms) {
        System.out.println(f.getName());
      }

      for (Farm f : farms) {
        fd.delete(f);
      }

      ud.delete(emailedUser);

      emailedUser = ud.createOrUpdate("a@a.a", "username", "123");
      fd.create("test farm 1", emailedUser);
      fd.create("test farm 2", emailedUser);


      md.create("NVIDIA", "EVGA", "GTX 3070",
          3, 4, "LINUX", "a",
          "haskel?", 19, "BTC",
          "ET", 111L, 3.5f, 153.4f,
          3.3f, 9.0f);

      md.create("AMD", "uh", "AMD 888888",
          -7, 18, "WINDOWS", "b",
          "haskel?", 12, "ETH",
          "ET", 118L, -8.5f, 91.4f,
          3.14f, 21.7f);

      Farm f = fd.getFarms(emailedUser).get(0);
      Miner m = md.getByName("GTX 3070").get(0);

      System.out.println(f);
      System.out.println(m);

      fd.addMiner(f, m);

      List<Miner> minerList = md.getByFarm(f);

      for (Miner mTemp : minerList) {
        System.out.println(mTemp.getGpu());
        md.delete(mTemp);
      }

      m = md.getByName("AMD 888888").get(0);

      md.delete(m);

      ud.delete(emailedUser);

      em.close();
    }

    if (testJSON) {
      List<Miner> minerList = md.getMiners();
      ObjectMapper om = new ObjectMapper();
      try {
        System.out.println(om.writeValueAsString(minerList));
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
      for (Miner m: minerList){
        //System.out.println(m.getManufacter()+ " " + m.getModel());
      }
    }

     */
  }
}