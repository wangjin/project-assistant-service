package com.codebetterlife.projectassistant.base.exception;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:12 下午
 */
public interface IResultCode {

    /**
     * 响应码
     *
     * @return Integer
     */
    int getCode();

    /**
     * 响应消息
     *
     * @return String
     */
    String getMessage();
}
