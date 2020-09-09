package com.tqkj.retrofitrxjavahttp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tqkj.retrofitrxjavahttp.activity.WebActivity;
import com.tqkj.retrofitrxjavahttp.adapter.MainListAdapter;
import com.tqkj.retrofitrxjavahttp.bean.WangYiNewsBean;
import com.tqkj.retrofitrxjavahttp.http.BaseObserver;
import com.tqkj.retrofitrxjavahttp.http.BaseRequest;
import com.tqkj.retrofitrxjavahttp.http.BaseResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvNews;
    private TextView tvTitle;
    private MainListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = this.findViewById(R.id.page_title);
        rcvNews = this.findViewById(R.id.rclv_news_list);
        rcvNews.setHasFixedSize(true);
        rcvNews.setNestedScrollingEnabled(false);
        rcvNews.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
        getNews();


    }

    /**
     * 获取网易新闻
     */
    private void getNews() {

        BaseRequest.getInstance()
                .getApiService()
                .getNews("1", "50")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<WangYiNewsBean>>(this) {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onSuccess(BaseResponse<List<WangYiNewsBean>> baseResponse) {
                        //成功回调方法,可以直接在此更新ui,AndroidSchedulers.mainThread()表示切换到主线程
                        if (baseResponse.isSuccess()) {
                            LogUtils.d(baseResponse.getMessage());
                            LogUtils.json(baseResponse.getResults());
                            List<WangYiNewsBean> newsList = baseResponse.getResults();
                            if (newsList != null && !newsList.isEmpty()) {
                                if (adapter == null) {
                                    adapter = new MainListAdapter(newsList);
                                    adapter.setOnItemListener(new MainListAdapter.OnItemListener() {
                                        @Override
                                        public void onClick(RecyclerView.ViewHolder holder, WangYiNewsBean wangYiNew) {
                                            //ToastUtils.showShort("点击了第" + holder.getAdapterPosition() + "行的" + wangYiNew.getTitle());
                                            startActivity(new Intent(MainActivity.this, WebActivity.class)
                                                    .putExtra("webUrl", wangYiNew.getPath()));
                                        }
                                    });
                                    rcvNews.setAdapter(adapter);
                                    tvTitle.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            adapter.clear();
                                            getNews();
                                        }
                                    });
                                } else {
                                    adapter.updateAll(newsList);
                                    LogUtils.d("直接添加了");
                                }
                                ToastUtils.showShort("已经为您推荐" + newsList.size() + "条新闻，请观赏");
                            }
                        } else {
                            ToastUtils.showShort("失败了");
                        }
                    }

                    @Override
                    public void onCodeError(BaseResponse baseResponse) {
                        LogUtils.d(baseResponse.getMessage());
                        //失败回调方法,可以直接在此更新ui,AndroidSchedulers.mainThread()表示切换到主线程

                    }

                    @Override
                    public void onFailure(Throwable e, boolean network) throws Exception {
                        LogUtils.d(e.getMessage());
                    }
                });
    }


}