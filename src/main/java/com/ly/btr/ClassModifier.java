package com.ly.btr;

/**
 * 修改class文件，暂时提供修改常量池常量功能
 */
public class ClassModifier {

    /**
     * 常量池起始偏移量
     */

    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /**
     * utf-8_info 常量的tag标志
     */
    private static final int CONSTANT_UTF8_INFO = 1;

    /**
     * 常量池中11中常量所占长度Constant_utf8_info除外，因为它不是定长的
     */
    private static final int[] CONSTANT_ITEM_LENGTH = {-1,-1,-1,5,5,5,9,9,3,3,5,5,5,5};

    private static final int u1 = 1;
    private static final int u2 = 2;

    private byte[] classByte;

    public ClassModifier(byte[] classByte){
        this.classByte = classByte;
    }

    /**
     * 修改常量池中constant_utf8_info中常量的值
     * @param oldStr
     * @param newStr
     * @return
     */
    public byte[] modifityUTF8Constant(String oldStr ,String newStr){
        /**
         * 拿到常量池的数量
         */
        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX + u2;
        for(int i = 0; i < cpc; i++){
            int tag = BytesUtil.bytes2Int(classByte,offset,u1);
            if(tag == CONSTANT_UTF8_INFO){
                int len = BytesUtil.bytes2Int(classByte,offset+u1,u2);
                offset += (u1 + u2);
                String str = BytesUtil.bytes2String(classByte,offset,len);
                if(str.equals(oldStr)){
                    byte[] strBytes = BytesUtil.string2Bytes(newStr);
                    byte[] strlen = BytesUtil.int2Bytes(newStr.length(),u2);
                    classByte = BytesUtil.bytesReplace(classByte,offset - u2, u2, strlen);
                    classByte = BytesUtil.bytesReplace(classByte,offset, len, strBytes);
                    return classByte;
                }else{
                    offset += len;
                }
            }else{
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classByte;
    }

    /**
     * 获取常量池中常量的数量
     * @return
     */
    public int getConstantPoolCount(){
        return BytesUtil.bytes2Int(classByte,CONSTANT_POOL_COUNT_INDEX,u2);
    }
}
