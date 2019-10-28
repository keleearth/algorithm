package com.ly.btr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * java class 执行工具
 */
public class JavaClassExecuter {

    /**
     * 执行外部传过来的代表java类的一个字节数组
     * 将输入类的byte数组更改成java.lang.system的constant_utf8_info 常量修改为劫持后的HackSystem类
     * 执行方法为该类的static main(String[] args) 输出结果为该类项system.out/err输出的信息
     *
     */

    public static String execute(byte[] bytes){
        HackSystem.clearBuffer();
        ClassModifier modifier = new ClassModifier(bytes);
        modifier.modifityUTF8Constant("java/lang/System","com/ly/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class aClass = loader.loadByte(bytes);
        try {
            Method method = aClass.getMethod("main",new Class[]{String[].class});
            method.invoke(null,new String[]{null});
        } catch (NoSuchMethodException e) {
            e.printStackTrace(HackSystem.out);
        } catch (IllegalAccessException e) {
            e.printStackTrace(HackSystem.out);
        } catch (InvocationTargetException e) {
            e.printStackTrace(HackSystem.out);
        }

        return HackSystem.getBufferString();
    }
}
