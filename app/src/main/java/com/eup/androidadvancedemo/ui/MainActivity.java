package com.eup.androidadvancedemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.eup.androidadvancedemo.R;
import com.eup.androidadvancedemo.adapter.NewsAdapter;
import com.eup.androidadvancedemo.api.ApiBuilder;
import com.eup.androidadvancedemo.model.News;
import com.eup.androidadvancedemo.model.NewsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Callback<NewsResponse>, NewsAdapter.NewsListener {
    public static final String REQUEST_URL = "url";
    private EditText edtSearch;
    private ImageButton btnSearch;
    private RecyclerView lvNews;
    private NewsAdapter adapter;
    private String url="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        btnSearch = findViewById(R.id.btn_search);
        lvNews = findViewById(R.id.lv_news);
        edtSearch = findViewById(R.id.edt_search);
        btnSearch.setOnClickListener(this);
        adapter = new NewsAdapter(getLayoutInflater());
        lvNews.setAdapter(adapter);
        adapter.setOnNewsItemListener(this);
    }

    @Override
    public void onClick(View v) {
        String key = edtSearch.getText().toString();
        if (key.isEmpty()) return;
        ApiBuilder.getInstance().getNews(
                key, "f70e06a71e524dfa86dbfcf7ca38e62f"
        ).enqueue(this);
    }




    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        NewsResponse newsResponse = response.body();
        adapter.setData(newsResponse.getArrNews());
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
        Toast.makeText(this, "Search fail", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onItemNewsClicked(News news) {
      url = news.getUrl();
        Log.e("Receiver ", "" + url);
        watchNews();
    }

    private void watchNews() {
        Intent intent = new Intent(this, WatchNewsActivity.class);
        intent.putExtra(REQUEST_URL,url);
        startActivity(intent);
    }

    @Override
    public void onItemNewsLongClicked(int position) {
        Toast.makeText(this,"there's nothing wrong with it", Toast.LENGTH_SHORT).show();
    }
}