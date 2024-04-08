package org.CurriculumDesign.util;

/**
 * 通用的返回结果类
 * @param <T>
 */
public class ReturnUtil<T> {

    // 编码：1成功，0和其它数字为失败
    private Integer code;
    // 错误信息
    private String msg;
    // 数据
    private T data;

    public static <T> ReturnUtil<T> success(T object) {
        ReturnUtil<T> r = new ReturnUtil<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> ReturnUtil<T> error(String msg) {
        ReturnUtil r = new ReturnUtil();
        r.msg = msg;
        r.code = 0;
        return r;
    }
}