package cn.hutool.core.util;

import java.lang.reflect.Modifier;

/**
 * @author 爽
 *
 * 类工具类 <br>
 */
public class ClassUtil {

    /**
     * 是否为标准的类<br>
     * 这个类必须：
     *
     * <pre>
     * 1、非接口
     * 2、非抽象类
     * 3、非Enum枚举
     * 4、非数组
     * 5、非注解
     * 6、非原始类型（int, long等）isPrimitive
     * </pre>
     *
     * @param clazz 类
     * @return 是否为标准类
     */
    public static boolean isNormalClass(Class<?> clazz){
            return null!=clazz
                    && false==clazz.isAnnotation()
                    && false==isAbstract(clazz)
                    && false==clazz.isEnum()
                    && false==clazz.isArray()
                    && false==clazz.isPrimitive();
    }


    /**
     * 判断是否为抽象类
     *
     * @param clazz 类
     * @return 是否为抽象类
     */
    public static boolean isAbstract(Class<?> clazz){
        return Modifier.isAbstract(clazz.getModifiers());
    }
}
