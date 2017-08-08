package cn.prince.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Md5Util {
    
    // 全局数组
//    private final static String[] strDigits = { "0", "1","b", "c","2", "3","6", "7", "4","5","8", "9", "a",  "d", "e", "f"};
	private final static String[] strDigits = { "0", "1","7", "8","2", "5","6","3","4","9","a", "b", "c",  "d", "e", "f"};
    public Md5Util() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    
    //生成md5值
    public static String GetMD5(String originStr) {
        String resultString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest((originStr).getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
    
    
    //根据salt生成md5值
    public static String GetMD5WithSalt(String originStr,String salt) {
    	//三元表达式
    	salt = salt==null?"":salt;
        String resultString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest((originStr+salt).getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
    
    public static void main(String[] args) {
		System.out.println(GetMD5("123"));
	}
    
}
