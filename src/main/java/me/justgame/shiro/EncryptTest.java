package me.justgame.shiro;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.*;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Assert;
import org.junit.Test;

import java.security.Key;

/**
 * Created by xcl on 2017-02-08.
 */
public class EncryptTest {
    @Test
    public void encodeAndDecode() {
        String str = "testtesttest";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        String str1 = Base64.decodeToString(base64Encoded);
        System.out.println(base64Encoded);
        System.out.println(str1);

        String base64Encoded1 = Hex.encodeToString(str.getBytes());
        String str2 = new String(Hex.decode(base64Encoded1));
        System.out.println(base64Encoded1);
        System.out.println(str2);
    }

    @Test
    public void md5() {
        String str = "hello";
        String salt = "123";
        String md5 = new Md5Hash(str, salt).toString();
        String md5Base64 = new Md5Hash(str, salt).toBase64();
        String md5Hex = new Md5Hash(str, salt).toHex();

        System.out.println(md5);
        System.out.println("-------");
        System.out.println(md5Base64);
        System.out.println(Base64.encodeToString(md5.getBytes()));
        System.out.println("-------");
        System.out.println(md5Hex);
        System.out.println(Hex.encodeToString(md5.getBytes()));
        System.out.println("-------");
        System.out.println(new Md5Hash(str, salt, 3));
    }

    @Test
    public void sha256() {
        String str = "hello";
        String salt = "123";
        String sha1 = new Sha256Hash(str, salt).toString();
        System.out.println(sha1);
    }

    @Test
    public void sha1() {
        String str = "hello";
        String salt = "123";
        //内部使用MessageDigest
        String simpleHash = new SimpleHash("SHA-1", str, salt).toString();
        System.out.println(simpleHash);
    }

    @Test
    public void hashService() {
        DefaultHashService hashService = new DefaultHashService();
        hashService.setHashAlgorithmName("SHA-512");
        hashService.setPrivateSalt(new SimpleByteSource("123"));
        hashService.setGeneratePublicSalt(true);
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());
        hashService.setHashIterations(1);

        HashRequest hashRequest = new HashRequest.Builder()
                .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
        String hex = hashService.computeHash(hashRequest).toHex();
        System.out.println(hex);

        SecureRandomNumberGenerator randomNumberGenerator =
                new SecureRandomNumberGenerator();
        randomNumberGenerator.setSeed("123".getBytes());
        String hexx = randomNumberGenerator.nextBytes().toHex();
        System.out.println(hexx);
    }

    @Test
    public void aes() {
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); //设置key长度
        //生成key
        Key key = aesCipherService.generateNewKey();
        String text = "hello";
        //加密
        String encrptText =
                aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        //解密
        String text2 =
                new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());

        Assert.assertEquals(text, text2);
    }
}
