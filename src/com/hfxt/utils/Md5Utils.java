package com.hfxt.utils;

import java.math.BigInteger;
import java.security.MessageDigest;


// MD5 ���ּ����㷨��һ�ֽ����㷨������������ʹ��

public class Md5Utils {
	/** 
     * ���ַ���md5����(Сд+��ĸ) 
     * @author Xiaowenjun
     * @param str ����Ҫ���ܵ��ַ��� 
     * @return  MD5���ܺ���ַ��� 
     */  
    public static String getMD5(String str) {  
        try {  
            // ����һ��MD5���ܼ���ժҪ  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            // ����md5����  
            md.update(str.getBytes());  
            // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�  
            // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ  
            return new BigInteger(1, md.digest()).toString(16);  
        } catch (Exception e) {  
           e.printStackTrace();  
           return null;  
        }  
    }  
      
      
    /** 
     * ���ַ���md5����(��д+����) 
     * 
     * @param str ����Ҫ���ܵ��ַ��� 
     * @return  MD5���ܺ���ַ��� 
     */  
      
    public static String MD5(String s) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
  
        try {  
            byte[] btInput = s.getBytes();  
            // ���MD5ժҪ�㷨�� MessageDigest ����  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // ʹ��ָ�����ֽڸ���ժҪ  
            mdInst.update(btInput);  
            // �������  
            byte[] md = mdInst.digest();  
            // ������ת����ʮ�����Ƶ��ַ�����ʽ  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
    
    public static String string2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
  
    }  
    
    public static String convertMD5(String inStr){  
    	  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ 't');  
        }  
        String s = new String(a);  
        return s;  
  
    }  
  
     public static void main(String[] args) {  
    	
      /*  String admin= MD5("admin");  
        System.out.println(admin);   */
    	 
    	// һ�μ��ܣ����ν���
    	String s = "md5�Ǹ�������̣�����������Ӧ������ײ������";
    	System.out.println(string2MD5(s));
        System.out.println( convertMD5(s));
        System.out.println(convertMD5(convertMD5(s)));
        
    }  
}
