package com.ly.iio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取class文件格式
 */
public class ReadClassFile {

    /**
     * class文件结构
     * 4字节 魔数
     * 2字节 小版本
     * 2字节主版本
     * 2字节 常量
     * cp-info 常量池
     * 2字节 access flag
     * 2 this class
     * 2 super class
     * 2 interfaces_count
     * 2 interfaces
     * 2 field_count
     * field_info
     * u2 method_count
     * method_info
     * 2 attribute_counts
     * attribute_info
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\project\\idea\\archgit\\VBlog\\blogserver\\target\\classes\\org\\sang\\AA.class";
        //读取文件
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Thread.currentThread().getContextClassLoader();
        try (BufferedInputStream stream = new BufferedInputStream(new FileInputStream(fileName))) {
            //魔数
            byte[] magicSort = new byte[4];
            stream.read(magicSort);
            System.out.println(byteArrayToHexString(magicSort));
            //次版本
            byte[] minorVersion = new byte[2];
            stream.read(minorVersion);
            System.out.println(byteArrayToHexString(minorVersion));
            //主版本
            byte[] majorVersion = new byte[2];
            stream.read(majorVersion);
            System.out.println(byteArrayToHexString(majorVersion));
            //常量池数量
            byte[] constantCount = new byte[2];
            stream.read(constantCount);
            int count = toSt(constantCount);
            System.out.println(count);
            //常量读取

            //System.out.println(new String(magicSort));
        }
    }
    static int toSt(byte[] b){
        String s = byteArrayToHexString(b);
        return Integer.parseInt(s,16);
    }
    static String byteToHexString(byte b){
        return Integer.toHexString(b & 0xFF);
    }
    static String byteArrayToHexString(byte[] bArray){
        StringBuilder sb = new StringBuilder();
        for (byte b : bArray) {
            sb.append(byteToHexString(b));
        }
        return sb.toString();
    }

}
