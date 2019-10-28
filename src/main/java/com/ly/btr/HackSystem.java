package com.ly.btr;

import java.io.*;
import java.nio.channels.Channel;
import java.util.Map;
import java.util.Properties;

public class HackSystem {

    public final static InputStream in = System.in;

    private static ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    public final static PrintStream out = new PrintStream(byteArrayOutputStream);

    public final static PrintStream err = out;

    public static String getBufferString(){
        return byteArrayOutputStream.toString();
    }

    public static void clearBuffer(){
        byteArrayOutputStream.reset();
    }

    public static void setSecurityManager(final SecurityManager manager){
        System.setSecurityManager(manager);
    }

    public static SecurityManager getSecurityManager(){
        return System.getSecurityManager();
    }
    public static void exit(int status){
        System.exit(status);
    }
    public static void loadLibrary(String libname){
        System.loadLibrary(libname);
    }
    public static String getProperty(String key, String def){
        return System.getProperty(key,def);
    }

    public static String getProperty(String key){
        return System.getProperty(key);
    }
    public static void load(String filename){
        System.load(filename);
    }
    public static void gc(){
        System.gc();
    }
    public static String clearPtoperty(String key){
        return System.clearProperty(key);
    }

    public static Console console(){
        return System.console();
    }
    public static Map<String, String> getenv(){
        return System.getenv();
    }
    public static String getenv(String name){
        return System.getenv(name);
    }

    public static Channel inheritedChannel() throws IOException {
        return System.inheritedChannel();
    }
    public static String lineSeparator(){
        return System.lineSeparator();
    }
    public static String mapLibraryName(String libname){
        return System.mapLibraryName(libname);
    }
    public static Properties getProperties(){
        return System.getProperties();
    }
    public static long nanoTime(){
        return System.nanoTime();
    }
    public static void runFinalization(){
        System.runFinalization();
    }

    public static void setErr(PrintStream err){
        System.setErr(err);
    }
    public static void setOut(PrintStream out){
        System.setOut(out);
    }
    public static void setIn(InputStream in){
        System.setIn(in);
    }
    public static void setProperties(Properties props){
        System.setProperties(props);
    }
    public static String setProperty(String key, String value){
        return System.setProperty(key,value);
    }

    public static long currentTimeMillis(){
        return System.currentTimeMillis();
    }

    public static void arrayCopy(Object src,int srcPos,Object dest,int destPos,int length){
        System.arraycopy(src,srcPos,dest,destPos,length);
    }
    @Deprecated
    public static void runFinalizersOnExit(boolean value){
        System.runFinalizersOnExit(value);
    }
    public static int identityhashCode(Object x){
        return System.identityHashCode(x);
    }
}
