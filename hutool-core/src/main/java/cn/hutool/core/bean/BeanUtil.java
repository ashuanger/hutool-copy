package cn.hutool.core.bean;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ModifierUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 爽
 *
 * <p>
 * 把一个拥有对属性进行set和get方法的类，我们就可以称之为JavaBean。
 * </p>
 * Bean工具类
 */
public class BeanUtil {

    /**
     * 判断是否为可读的Bean对象，判定方法是：
     *
     * <pre>
     *     1、是否存在只有无参数的getXXX方法或者isXXX方法
     *     2、是否存在public类型的字段
     * </pre>
     *
     * @param clazz 待测试类
     * @return 是否为可读的Bean对象
     * @see #hasGetter(Class)
     * @see #hasPublicField(Class)
     */
    public static boolean isReadableBean(Class<?> clazz){return hasGetter(clazz)||hasPublicField(clazz);}

    /**
     * 判断是否为Bean对象，判定方法是：
     *
     * <pre>
     *     1、是否存在只有一个参数的setXXX方法
     *     2、是否存在public类型的字段
     * </pre>
     *
     * @param clazz 待测试类
     * @return 是否为Bean对象
     * @see #hasSetter(Class)
     * @see #hasPublicField(Class)
     */
    public static boolean isBean(Class<?> clazz) {
        return hasSetter(clazz) || hasPublicField(clazz);
    }

    /**
     * 判断是否为Bean对象<br>
     * 是否存在只有无参数的getXXX方法或者isXXX方法
     *
     * @param clazz 待测试类
     * @return 是否为Bean对象
     * @since 4.2.2
     */
    public static boolean hasGetter(Class<?> clazz){
        if (ClassUtil.isNormalClass(clazz)){
            for (Method method:clazz.getMethods()){
                if (method.getParameterTypes().length==0){
                    if (method.getName().startsWith("get")||method.getName().startsWith("is")){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 判断是否为Bean对象<br>
     * 判定方法是是否存在只有一个参数的setXXX方法
     * @param clazz
     * @return
     */
    public static boolean hasSetter(Class<?> clazz){
        if (ClassUtil.isNormalClass(clazz)){
            for (Method method:clazz.getMethods()){
                if (method.getName().startsWith("set")&&method.getParameterTypes().length==1){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 指定类中是否有public类型字段(static字段除外)
     *
     * @param clazz 待测试类
     * @return 是否有public类型字段
     * @since 5.1.0
     */
    public static boolean hasPublicField(Class<?> clazz) {
        if (ClassUtil.isNormalClass(clazz)){
            for (Field field:clazz.getFields()){
                if (ModifierUtil.isPublic(field)&&false==ModifierUtil.isStatic(field)){
                    //非static的public字段
                    return true;
                }
            }
        }
        return false;
    }
}
