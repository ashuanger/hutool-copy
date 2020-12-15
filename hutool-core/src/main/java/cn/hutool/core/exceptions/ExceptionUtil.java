package cn.hutool.core.exceptions;

import cn.hutool.core.util.StrUtil;

/**
 * 异常工具类
 *
 * @author 爽
 */
public class ExceptionUtil {

    /**
     * 获得完整消息，包括异常名，消息格式为：{SimpleClassName}: {ThrowableMessage}
     *
     * @param e 异常
     * @return 完整消息
     */
    public static String getMessage(Throwable e){
        if (null==e){
            return StrUtil.NULL;
        }else {
            return StrUtil.format("{}:{}",e.getClass().getSimpleName(),e.getMessage());
        }
    }
}
