package com.sby.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

interface EncryptionType {
    String MD5 = "MD5";
    String SHA1 = "SHA-1";
    String SHA256 = "SHA-256";
}

public class Encryption {

    public Encryption(){

    }

    /**
     * MD5、SHA1、SHA256 , 加密后分别输出128bit、160bit、256bit。
     * @param byteArray
     * @return
     */

    private static String bytes2Hex(byte[] byteArray) {
        String resultValue = "";
        String strTemp = "";
        for (int i = 0; i < byteArray.length; i++) {
            strTemp = (Integer.toHexString(byteArray[i] & 0xFF));
            if (strTemp.length() == 1) {
                resultValue += "0";
            }
            resultValue += strTemp;
        }
        return resultValue;
    }

    public static String encryption(EncryptionType encryptionType,String str){
        String param ="";
        if (EncryptionType.MD5.equals(encryptionType)){
            param = EncryptionType.MD5;
        }else if (EncryptionType.SHA1.equals(encryptionType)){
            param = EncryptionType.SHA1;
        }else if (EncryptionType.SHA256.equals(encryptionType)){
            param = EncryptionType.SHA256;
        }
        return encryption(param,str);
    }

    private static String encryption(String type,String str){
        try {
            MessageDigest md = MessageDigest.getInstance(type);
            md.update(str.getBytes());
            return bytes2Hex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        String str = "123456";
        String str2 = "111111";
        String md5Str = encryption(EncryptionType.MD5,str);
        String sha1Str = encryption(EncryptionType.SHA1,str);
        String sha256Str = encryption(EncryptionType.SHA256,str);
        System.out.println(md5Str);
        System.out.println(sha1Str);
        System.out.println(sha256Str);
    }
}
