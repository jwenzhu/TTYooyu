package com.ttyooyu.market.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2016-08-19.
 */
public class EncodeUtils {

    private static final char DECODE[] = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '_'
    };

  private static final char ENCODE[] = {
           'r', '1', '2', 'S', '4', 'z', '6', 't', '8', '9', 'f', 'w', 'B', 'C', 'D', 'n',
           'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', '3', 'T', 'U',
           'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', '_', 'g', 'h', 'i', 'j', 'k',
           'l', 'm', 'E', 'o', 'p', 'q', '0', 's', '7', 'u', 'v', 'A', 'x', 'y', '5'
    };

    /**
     *
     * @param password
     * @return
     */
    public static String changeCode(String password){
        StringBuffer sBuffer = new StringBuffer();
        for(int i = 0;i < password.length();i++){
            char oldChar = password.charAt(i);
            int index = indexCode(oldChar);
            if(index == -1){
                sBuffer.append(oldChar);
            }else{
                sBuffer.append(ENCODE[index]);
            }
        }
        return sBuffer.toString();
    }

    /**
     *
     * @param code
     * @return
     */
    public static int indexCode(char code){
        int index = -1;
        for(int i = 0;i < DECODE.length;i++){
            if(DECODE[i] == code){
               index = i;
            }
        }
        return index;
    }


    /**
     *
     * @param str
     * @return
     */
    public static String getMd5(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }

}

