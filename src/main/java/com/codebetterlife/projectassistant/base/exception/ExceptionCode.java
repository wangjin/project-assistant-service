package com.codebetterlife.projectassistant.base.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:13 下午
 */
public enum ExceptionCode implements IResultCode {
    /**
     * 定义响应码
     */
    SUCCESS(0, "请求成功"),
    FAIL(1, "请求失败"),
    ;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
