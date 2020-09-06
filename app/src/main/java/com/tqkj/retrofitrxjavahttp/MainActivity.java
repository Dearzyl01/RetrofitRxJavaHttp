package com.tqkj.retrofitrxjavahttp;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tqkj.retrofitrxjavahttp.bean.WangYiNews;
import com.tqkj.retrofitrxjavahttp.bean.WangYiNewss;
import com.tqkj.retrofitrxjavahttp.http.BaseObserver;
import com.tqkj.retrofitrxjavahttp.http.BaseRequest;
import com.tqkj.retrofitrxjavahttp.http.BaseResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_news = this.findViewById(R.id.tv_news);
        getNews();
        tv_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNews();
            }
        });


    }

    /**
     * 获取网易新闻
     */
    private void getNews() {

        BaseRequest.getInstance()
                .getApiService()
                .getNews("1", "10")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<WangYiNewss>>(this) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onSuccess(BaseResponse<List<WangYiNewss>> baseResponse) {
                        //成功回调方法,可以直接在此更新ui,AndroidSchedulers.mainThread()表示切换到主线程
                        if (baseResponse.isSuccess()) {
                            LogUtils.d(baseResponse.getMessage());
                            LogUtils.json(baseResponse.getResults());
                            List<WangYiNewss> list = baseResponse.getResults();
                            String allStr = null;
                            for (int i = 0; i < list.size(); i++) {
                                allStr += list.get(i).getTitle()
                                        + "\n" + list.get(i).getPath()
                                        + "\n" + list.get(i).getImage()
                                        + "\n" + list.get(i).getPasstime()
                                        + "\n" + "\n";
                                tv_news.setText(allStr);
                            }

                        } else {
                            ToastUtils.showShort("失败了");
                        }
                    }

                    @Override
                    public void onCodeError(BaseResponse baseResponse) {
                        //失败回调方法,可以直接在此更新ui,AndroidSchedulers.mainThread()表示切换到主线程

                    }

                    @Override
                    public void onFailure(Throwable e, boolean network) throws Exception {

                    }
                });


    }


}