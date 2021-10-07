package com.eup.androidadvancedemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eup.androidadvancedemo.R;
import com.eup.androidadvancedemo.model.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder>{
    private NewsListener listener;
    private ArrayList<News> data;
    private LayoutInflater inflater;

    public NewsAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setOnNewsItemListener(NewsListener listener){
        this.listener = listener;
    }

    public void setData(ArrayList<News> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public ArrayList<News> getData() {
        return data;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_news, parent, false);
        return new NewsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, final int position) {
        holder.bindView(data.get(position));
        if (listener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemNewsClicked(data.get(holder.getAdapterPosition()
                    ));
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onItemNewsLongClicked(holder.getAdapterPosition());
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
    public class NewsHolder extends RecyclerView.ViewHolder {
        private ImageView imNews;
        private TextView tvTitle;
        private TextView tvPubDate;
        private TextView tvDesc;
        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            imNews = itemView.findViewById(R.id.im_news);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvPubDate = itemView.findViewById(R.id.tv_pub_date);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }

        public void bindView(News item) {
            Glide.with(imNews)
                    .load(item.getImage())
                    .into(imNews);

            tvTitle.setText(item.getTitle());
            tvPubDate.setText(item.getPubDate());
            tvDesc.setText(item.getDesc());
        }
    }

    public interface NewsListener {
        void onItemNewsClicked(News news);
        void onItemNewsLongClicked(int position);
    }
}
