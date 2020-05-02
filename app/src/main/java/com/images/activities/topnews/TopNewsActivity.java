package com.images.activities.topnews;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.gson.Gson;
import com.images.GenerateToast;
import com.images.adapters.AdapterTopNews;
import com.images.models.timesofindia.ItemItem;
import com.images.models.timesofindia.topnews.NewsItemItem;
import com.images.models.timesofindia.topnews.TopNewsRes;
import com.restaurant.birthdaywish.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class TopNewsActivity extends AppCompatActivity {
    ItemItem itemItem;
    List<NewsItemItem> newsItemItems;
    Context context;
    @BindView(R.id.back_icon)
    ImageView back_icon;
    @BindView(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_news_layout);
        context = TopNewsActivity.this;
        ButterKnife.bind(this);
        itemItem = (ItemItem) getIntent().getSerializableExtra("data");
        if(itemItem!=null){
            title.setText(itemItem.getName());
        }
        Log.d("TAG", "onCreate: " + itemItem.toString());
        OkHttpHandler ok = new OkHttpHandler();
        ok.execute();

    }

    @OnClick(R.id.back_icon)
    public void back(){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSplit(context);
    }

    private void initComponent(List<NewsItemItem> newsItemItems) {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        AdapterTopNews adapterTopNews = new AdapterTopNews(this, newsItemItems);
        recyclerView.setAdapter(adapterTopNews);
        recyclerView.setOnFlingListener(null);

    }

    public class OkHttpHandler extends AsyncTask<String,String,String> {


        @Override
        protected String doInBackground(String...params) {

            OkHttpClient client = new OkHttpClient();
            String url = "";
            if(itemItem.getDefaulturl()!=null){
                if(!itemItem.getDefaulturl().equals("")){
                    url = itemItem.getDefaulturl();
                } else {
                    if(itemItem.getSectionurl()!=null){
                        if(!itemItem.getSectionurl().equals("")){
                            url = itemItem.getSectionurl();
                        }
                    }
                }
            }
            Request request = new Request.Builder()
                    .url(url.replace("http", "https"))
                    .get()
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                Gson gson = new Gson();

                TopNewsRes newsResponse = gson.fromJson(s,TopNewsRes.class);
                newsItemItems = newsResponse.getNewsItem();
                if(newsItemItems!=null){
                    if(newsResponse.getNewsItem().size()>0){
                        initComponent(newsItemItems);
                    }
                }

            } catch (Exception e){
                GenerateToast.showErrorToastWOI(context, e.toString());
            }
        }


    }

}
