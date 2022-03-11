package top.yuyanmc.util;

import java.lang.reflect.Array;

public class CastUtil {
    public static Object cast(Object array,Class clss){
        if(null==clss)
            throw new IllegalArgumentException("argument clss cannot be null");
        if(null==array)
            throw new IllegalArgumentException("argument array cannot be null");
        if(false==array.getClass().isArray())
            throw new IllegalArgumentException("argument array must be array");
     
     Object[] src=(Object[])array;
     Object[] dest=(Object[])Array.newInstance(clss, src.length);
     System.arraycopy(src, 0, dest, 0, src.length);
     return dest;
 }
}