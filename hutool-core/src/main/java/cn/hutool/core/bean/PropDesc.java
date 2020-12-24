package cn.hutool.core.bean;

import cn.hutool.core.util.ClassUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 属性描述，包括了字段、getter、setter和相应的方法执行
 *
 * @author 爽
 */
public class PropDesc {


    /**
     * 字段
     */
    final Field field;

    /**
     *Getter方法
     */
    protected Method getter;

    /**
     * Setter方法
     */
    protected Method setter;

    /**
     *
     *
     * 构造<br>
     * Getter和Setter方法设置为默认可访问
     *
     * @param field     字段
     * @param getter    get方法
     * @param setter    set方法
     */
    public PropDesc(Field field, Method getter, Method setter) {
        this.field = field;
        this.getter = ClassUtil.setAccessible(getter);
        this.setter = ClassUtil.setAccessible(setter);
    }
}
