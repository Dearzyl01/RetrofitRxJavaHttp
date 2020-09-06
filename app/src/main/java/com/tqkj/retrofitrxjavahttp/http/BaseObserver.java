package com.tqkj.retrofitrxjavahttp.http;

import android.accounts.NetworkErrorException;
import android.content.Context;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import rx.Observer;

/**
 * * 请求回调,主要实现Observer类
 * * @param <T>
 */
public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {

    private Context context;

    public BaseObserver(Context context) {
        this.context = context;
    }

    /**
     * //请求成功且返回码为200的回调方法,这里抽象方法申明
     *
     * @param baseResponse
     */
    public abstract void onSuccess(BaseResponse<T> baseResponse);

    /**
     * //请求成功但返回的code码不是200的回调方法,这里抽象方法申明
     *
     * @param baseResponse
     */
    public abstract void onCodeError(BaseResponse baseResponse);


    /**
     * //请求失败回调方法,这里抽象方法申明
     *
     * @param e
     * @param network
     * @throws Exception
     */
    public abstract void onFailure(Throwable e, boolean network) throws Exception;


    //请求完成后调用，如果需要就再新增一个abstract方法来结合他吧
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ConnectException
                || e instanceof TimeoutException
                || e instanceof NetworkErrorException
                || e instanceof UnknownHostException) {
            try {
                onFailure(e, false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                onFailure(e, true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    @Override
    public void onNext(BaseResponse<T> tBaseResponse) {

        if (tBaseResponse.isSuccess()) {
            onSuccess(tBaseResponse);
        } else {
            onCodeError(tBaseResponse);
        }

    }

}
