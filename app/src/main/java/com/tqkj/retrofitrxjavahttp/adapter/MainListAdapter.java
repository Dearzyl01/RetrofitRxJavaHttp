package com.tqkj.retrofitrxjavahttp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.bumptech.glide.Glide;
import com.tqkj.retrofitrxjavahttp.R;
import com.tqkj.retrofitrxjavahttp.bean.WangYiNews;
import com.tqkj.retrofitrxjavahttp.bean.WangYiNewsBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MainViewHolder> {
    private List<WangYiNewsBean> newsListBeans;

    public MainListAdapter(List<WangYiNewsBean> newsListBeans) {
        this.newsListBeans = newsListBeans;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate一条数据的布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_main_news, parent, false);
        final MainViewHolder holder = new MainViewHolder(view);
        view.setTag(holder);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainViewHolder holder1 = (MainViewHolder) view.getTag();
                int position = holder1.getAdapterPosition();
                if (position >= 0 && position < newsListBeans.size()) {
                    onItemListener.onClick(holder1, newsListBeans.get(position));

                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        //一次绑定一条数据
        WangYiNewsBean wangYiNews = newsListBeans.get(position);
        if (wangYiNews != null) {
            holder.title.setText(wangYiNews.getTitle());
            holder.date.setText(wangYiNews.getPasstime());
            Glide.with(ActivityUtils.getTopActivity()).load(wangYiNews.getImage()).into(holder.img);
        }

    }

    @Override
    public int getItemCount() {
        return newsListBeans.size();
    }

    public void updateAll(List<WangYiNewsBean> newsListBeans) {
        this.newsListBeans = newsListBeans;
        notifyDataSetChanged();
    }

    public void clear() {
        if (newsListBeans != null && !newsListBeans.isEmpty()) {
            newsListBeans.clear();
            notifyDataSetChanged();
        }
    }


    static class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView title, date;
        private ImageView img;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            date = itemView.findViewById(R.id.news_date);
            img = itemView.findViewById(R.id.news_img);
        }

    }


    /**
     * 子项点击事件回调接口
     */
    public interface OnItemListener {

        void onClick(RecyclerView.ViewHolder holder, WangYiNewsBean wangYiNew);

    }

    private OnItemListener onItemListener;

    public MainListAdapter setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
        return this;
    }
}
