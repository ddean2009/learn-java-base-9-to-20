package com.flydean.serialization;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author wayne
 * @version SerUsage,  2020/5/11 5:03 下午
 */
@Slf4j
public class SerUsage {

    @Test
    public void testCusUser() throws IOException, ClassNotFoundException {
        CustUser custUserA=new CustUser("jack","www.flydean.com");
        CustUser custUserB=new CustUser("mark","www.flydean.com");

        try(FileOutputStream fileOutputStream = new FileOutputStream("target/custUser.ser")){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(custUserA);
            objectOutputStream.writeObject(custUserB);
        }
        
        try(FileInputStream fileInputStream = new FileInputStream("target/custUser.ser")){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            CustUser custUser1 = (CustUser) objectInputStream.readObject();
            CustUser custUser2 = (CustUser) objectInputStream.readObject();
            log.info("{}",custUser1);
            log.info("{}",custUser2);
        }
    }

    @Test
    public void testCusUserV2() throws IOException, ClassNotFoundException {
        CustUserV2 custUserA=new CustUserV2("jack","www.flydean.com",40);
        CustUserV2 custUserB=new CustUserV2("mark","www.flydean.com",30);

        try(FileOutputStream fileOutputStream = new FileOutputStream("target/custUser.ser")){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(custUserA);
            objectOutputStream.writeObject(custUserB);
        }

        try(FileInputStream fileInputStream = new FileInputStream("target/custUser.ser")){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            CustUserV2 custUser1 = (CustUserV2) objectInputStream.readObject();
            CustUserV2 custUser2 = (CustUserV2) objectInputStream.readObject();
            log.info("{}",custUser1);
            log.info("{}",custUser2);
        }
    }

    @Test
    public void testCusUserSealed() throws IOException, ClassNotFoundException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        CustUser custUserA=new CustUser("jack","www.flydean.com");
        Cipher enCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        Cipher deCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKey secretKey = new SecretKeySpec("saltkey111111111".getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec("vectorKey1111111".getBytes());
        enCipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        deCipher.init(Cipher.DECRYPT_MODE,secretKey,iv);
        SealedObject sealedObject= new SealedObject(custUserA, enCipher);

        try(FileOutputStream fileOutputStream = new FileOutputStream("target/custUser.ser")){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(sealedObject);
        }

        try(FileInputStream fileInputStream = new FileInputStream("target/custUser.ser")){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SealedObject custUser1 = (SealedObject) objectInputStream.readObject();
            CustUser custUserV2= (CustUser) custUser1.getObject(deCipher);
            log.info("{}",custUserV2);
        }
    }


    @Test
    public void testCusUserV3() throws IOException, ClassNotFoundException {
        CustUserV3 custUserA=new CustUserV3("jack","www.flydean.com");

        try(FileOutputStream fileOutputStream = new FileOutputStream("target/custUser.ser")){
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(custUserA);
        }

        try(FileInputStream fileInputStream = new FileInputStream("target/custUser.ser")){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            CustUserV3 custUser1 = (CustUserV3) objectInputStream.readObject();
            log.info("{}",custUser1);
        }
    }
}
