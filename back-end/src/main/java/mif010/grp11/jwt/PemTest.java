package mif010.grp11.jwt;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class PemTest {

  private static String path = "../";

  public static String[] printFile(String path) {
    return new File(path).list();
  }

  public static byte[] readPem(File file) throws IOException {
    if (!file.isFile() || !file.exists()) {
      throw new FileNotFoundException(String.format("The file '%s' doesn't exist.", file.getAbsolutePath()));
    }
    PemReader reader = new PemReader(new FileReader(file));
    PemObject pemObject = reader.readPemObject();
    byte[] content = pemObject.getContent();
    reader.close();
    return content;
  }

  public static PublicKey getPublicKey() throws IOException {
    byte[] keyBytes = PemTest.readPem(new File("/var/opt/keys/public.pem"));
    PublicKey publicKey = null;
    KeyFactory kf;
    try {
      kf = KeyFactory.getInstance("RSA");
      EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
      publicKey = kf.generatePublic(keySpec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      e.printStackTrace();
    }
    return publicKey;
  }

  public static PrivateKey getPrivateKey() throws IOException {
    byte[] keyBytes = PemTest.readPem(new File("/var/opt/keys/private.pem"));
    PrivateKey privateKey = null;
    try {
      KeyFactory kf = KeyFactory.getInstance("RSA");
      EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
      privateKey = kf.generatePrivate(keySpec);
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      e.printStackTrace();
    }
    return privateKey;
  }
}
