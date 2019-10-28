package com.ly.btr;

/**
 * 为了多次执行类而加入的类加载器
 * 把define方法开放出来，只有外部显示调用时才会使用laodByte方法
 * 由虚拟机调用时按照原有classloader方式调用
 */
public class HotSwapClassLoader extends ClassLoader {
    public HotSwapClassLoader(){
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classBytes){
        return defineClass(null,classBytes,0,classBytes.length);
    }
}
