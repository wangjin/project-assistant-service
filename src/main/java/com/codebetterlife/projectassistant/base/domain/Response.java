package com.codebetterlife.projectassistant.base.domain;

import com.codebetterlife.projectassistant.base.exception.ExceptionCode;
import com.codebetterlife.projectassistant.base.exception.IResultCode;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Jin Wang
 * @version 1.0
 * @date 2021-09-01 7:12 下午
 */
@NoRepositoryBean
public class Response<T> {

    private IResultCode resultCode;

    private T data;

    public static <T> Response<T> success(IResultCode resultCode, T data) {
        Response<T> response = new Response<>();
        response.setResultCode(resultCode);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setResultCode(ExceptionCode.SUCCESS);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        response.setResultCode(ExceptionCode.SUCCESS);
        response.setData(null);
        return response;
    }

    public static <T> Response<T> fail(IResultCode resultCode, T data) {
        Response<T> response = new Response<>();
        response.setResultCode(resultCode);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> fail(IResultCode resultCode) {
        Response<T> response = new Response<>();
        response.setResultCode(resultCode);
        response.setData(null);
        return response;
    }

    public static <T> Response<T> fail(T data) {
        Response<T> response = new Response<>();
        response.setResultCode(ExceptionCode.FAIL);
        response.setData(data);
        return response;
    }

    public IResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(IResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
