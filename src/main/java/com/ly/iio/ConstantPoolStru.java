package com.ly.iio;

/**
 * 常量池数据结构
 */
public class ConstantPoolStru {
    private int type ; //常量池项目类型

    static String typeToString(byte type){
        switch (type){
            case 1 : return "UTF-8字符串";
            case 3:  return "整形字面量";
            case 4:  return "浮点型字面量";
            case 5:  return "长整形字面量";
            case 6:  return "双精度字面量";
            case 7:  return "类或接口符号引用 class_info";
            case 8:  return "字符串类型常量 string_info";
            case 9:  return "字段符号引用 fieldRef_info";
            case 10: return "类中方法符号引用 methodRef_info";
            case 11: return "接口中方法引用 InterfaceMethodRef_info";
            case 12: return "字段或方法部分引用 NameAndType_info";
        }
        return "";
    }

}
