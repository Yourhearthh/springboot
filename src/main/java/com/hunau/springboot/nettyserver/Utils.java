package com.hunau.springboot.nettyserver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

/**
 * @author cx
 * @Time 2020/6/29 23:57
 * @Description 服务端工具类
 */
public class Utils {
    /**byte数组转16进制字符串*/
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    /**比特转16进制*/
    public static String byteToHexString(byte src){
        StringBuilder stringBuilder = new StringBuilder("");
        int v = src & 0xFF;
        String hv = Integer.toHexString(v);
        if (hv.length() < 2) {
            stringBuilder.append(0);
        }
        stringBuilder.append(hv);
        return stringBuilder.toString();
    }
    /**
     * Convert hex string to byte[]
     * @param hexString the hex string
     * @return byte[]
     */
    /**十六进制字符串转比特数组*/
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        if(hexString.length()%2>0){
            hexString="0"+hexString;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * Convert char to byte
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
    public static byte[] intToByteArray(int i) {
        byte[] result;
        if(i > 255) {
            result = new byte[4];
            result[3] = (byte) ((i >> 24) & 0xFF);
            /**必须把我们要的值弄到最低位去，有人说不移位这样做也可以， result[0] = (byte)(i  & 0xFF000000);
            这样虽然把第一个字节取出来了，但是若直接转换为byte类型，会超出byte的界限，出现error。再提下数
             之间转换的原则（不管两种类型的字节大小是否一样，原则是不改变值，内存内容可能会变，比如int转为//float肯定会变）所以此时的int转为byte会越界，
             只有int的前三个字节都为0的时候转byte才不会越界。虽//然 result[0] = (byte)(i  & 0xFF000000);
             这样不行，但是我们可以这样 result[0] = (byte)((i  & //0xFF000000) >>24);*/
            result[2] = (byte) ((i >> 16) & 0xFF);
            result[1] = (byte) ((i >> 8) & 0xFF);
            result[0] = (byte) (i & 0xFF);
            return result;
        }else{
            result= new byte[2];
            result[1] = (byte) ((i >> 8) & 0xFF);
            /**低字节在前*/
            result[0] = (byte) (i & 0xFF);
            return result;
        }
    }
    public static int byteToInt(byte b) {
        /**Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值*/
        return b & 0xFF;
    }
    public static byte[] unsignedInteger4ToByte(int data)
    {
        /**将int数据转换为0~4294967295 (0xFFFFFFFF即DWORD)*/
        long value = data&0x0FFFFFFFF;
        String hexString = Long.toHexString(value);
        /**补齐8个16进制字符代表4个字节*/
        while(hexString.length()<2)
        {
            hexString = "0" + hexString;
        }
        byte[] bytes = hexStringToBytes(hexString);
        return bytes;
    }
    /**
     * 计算字节数组的校验和
     * @param buf
     * @return
     */
    public static String checksum(byte[] buf) {
        try {
            CheckedInputStream cis = new CheckedInputStream(
                    new ByteArrayInputStream(buf),new Adler32());
            byte[] tempBuf = new byte[128];
            while (cis.read(tempBuf) >= 0);
            long value = cis.getChecksum().getValue();
            return Long.toHexString(value);
        } catch (IOException e) {
            return "-1";
        }
    }
    /**
     *
     * @param src
     * @param begin
     * @param count
     * @return
     * TODO 在字节数组中截取指定长度数组
     * 时间：2019年7月14日
     */
    public static byte[] subBytes(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }
}
