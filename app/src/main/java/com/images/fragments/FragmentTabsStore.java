package com.images.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.images.GenerateToast;
import com.images.adapters.AdapterTopNews;
import com.images.common.ViewAnimation;
import com.images.models.timesofindia.ItemItem;
import com.images.models.timesofindia.topnews.NewsItemItem;
import com.images.models.timesofindia.topnews.TopNewsRes;
import com.restaurant.birthdaywish.R;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FragmentTabsStore extends Fragment {
    private final static int LOADING_DURATION = 3500;
    com.images.models.timesofindia.citynews.ItemItem itemItem;
    RecyclerView recyclerView;
    LinearLayout lyt_progress;

    public FragmentTabsStore(com.images.models.timesofindia.citynews.ItemItem itemItem) {
        this.itemItem = itemItem;
    }

    public static FragmentTabsStore newInstance(com.images.models.timesofindia.citynews.ItemItem itemItem) {
        FragmentTabsStore fragment = new FragmentTabsStore(itemItem);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_city_news_layout, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        lyt_progress = root.findViewById(R.id.lyt_progress);
        dataLoad();

//        Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();

        return root;
    }


    public void dataLoad(){

        lyt_progress.setVisibility(View.VISIBLE);
        lyt_progress.setAlpha(1.0f);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewAnimation.fadeOut(lyt_progress);
            }
        }, LOADING_DURATION);



        OkHttpHandler httpHandler = new OkHttpHandler();
        httpHandler.execute();
    }

    private void initComponent(List<NewsItemItem> newsItemItems) {


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        AdapterTopNews adapterTopNews = new AdapterTopNews(getActivity(), newsItemItems);
        recyclerView.setAdapter(adapterTopNews);
        recyclerView.setOnFlingListener(null);


    }

    public class OkHttpHandler extends AsyncTask<String,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String...params) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(itemItem.getUrl().replace("http", "https"))
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
                lyt_progress.setVisibility(View.GONE);
                Gson gson = new Gson();
                ItemItem itemItem;
                List<NewsItemItem> newsItemItems;
                TopNewsRes newsResponse = gson.fromJson(s,TopNewsRes.class);
                newsItemItems = newsResponse.getNewsItem();
                initComponent(newsItemItems);


            } catch (Exception e){
                GenerateToast.showErrorToastWOI(getActivity(), e.toString());
            }
        }


    }


}