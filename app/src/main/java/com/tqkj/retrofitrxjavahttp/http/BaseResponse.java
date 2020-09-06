package com.tqkj.retrofitrxjavahttp.http;

import com.google.gson.annotations.SerializedName;

/**
 * 基础请求的数据实体，统一接口返回的数据基类,其中results的类型是泛型,用于接收具体的数据类；
 * <p>
 * //加上这个注解是因为这得看接口的，
 * 有些接口它写的不是results而是result或者其他的,所以这个就得在注解这里根据接口修改一个接受字段，
 * 但是如果你不想写这些注解，那就直接改定义的字段名称吧
 *
 * @param <T>
 */
public class BaseResponse<T> {

    private static int SUCCESS_CODE = 200;//成功的code
    @SerializedName("code")
    private int code;                   //响应码
    @SerializedName("message")
    private String message;             //提示信息
    @SerializedName("result")
    private T results;                  //返回的具体数据


    public boolean isSuccess() {
        return getCode() == SUCCESS_CODE;
    }


    public static int getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static void setSuccessCode(int successCode) {
        SUCCESS_CODE = successCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", results=" + results +
                '}';
    }
}
