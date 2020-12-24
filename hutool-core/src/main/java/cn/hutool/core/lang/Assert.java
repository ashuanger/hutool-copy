package cn.hutool.core.lang;

import cn.hutool.core.util.StrUtil;

import java.util.function.Supplier;

/**
 * 断言<br>
 * 断言某些对象或值是否符合规定，否则抛出异常。经常用于做变量检查
 *
 * @author 爽
 */
public class Assert {


    /**
     * 断言对象是否不为{@code null} ，如果为{@code null} 抛出{@link IllegalArgumentException} 异常
     *
     * <pre class="code">
     * Assert.notNull(clazz);
     * </pre>
     *
     * @param object 被检查对象类型
     * @param <T> 被检查对象
     * @return 非空对象
     * @throws IllegalArgumentException
     */
    public static <T> T notNull(T object) throws IllegalArgumentException{
        return notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }


    /**
     * 断言对象是否不为{@code null} ，如果为{@code null} 抛出{@link IllegalArgumentException} 异常 Assert that an object is not {@code null} .
     *
     * <pre class="code">
     * Assert.notNull(clazz, "The class must not be null");
     * </pre>
     *
     * @param object  被检查对象泛型类型
     * @param errorMsgTemplate  错误消息模板，变量使用{}表示
     * @param params  参数
     * @param <T>  被检查对象泛型类型
     * @return  被检查后的对象
     * @throws IllegalArgumentException if the object is {@code null}
     */
    public static <T> T notNull(T object,String errorMsgTemplate,Object...params)throws IllegalArgumentException{
        return notNull(object,()->new IllegalArgumentException(StrUtil.format(errorMsgTemplate,params)));
    }

    /**
     *
     *
     * 断言对象是否不为{@code null} ，如果为{@code null} 抛出指定类型异常
     * 并使用指定的函数获取错误信息返回
     * <pre class="code">
     * Assert.notNull(clazz, ()-&gt;{
     *      // to query relation message
     *      return new IllegalArgumentException("relation message to return");
     *  });
     * </pre>
     *
     * @param object  被检查对象
     * @param errorSupplier  错误抛出异常附带的消息生产接口
     * @param <T>   被检查对象泛型类型
     * @param <X>  异常类型
     * @return  被检查后的对象
     * @throws X
     */
    public static <T,X extends Throwable> T notNull(T object, Supplier<X> errorSupplier) throws X{
        if (null==object){
            throw errorSupplier.get();
        }
        return object;
    }


}
