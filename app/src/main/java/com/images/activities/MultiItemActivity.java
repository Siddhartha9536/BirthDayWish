package com.images.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.gson.Gson;
import com.images.GenerateToast;
import com.images.GetNameActivity;
import com.images.ProfileImagesActivity;
import com.images.activities.citynews.CityNewsActivity;
import com.images.activities.topnews.TopNewsActivity;
import com.images.adapters.AdapterHomeCategory;
import com.images.adapters.AdapterNewsCategory;
import com.images.common.Utility;
import com.images.common.ViewAnimation;
import com.images.models.homeitems.HomeItems;
import com.images.models.timesofindia.ItemItem;
import com.images.models.timesofindia.NewsResponse;
import com.images.widgets.SpacingItemDecoration;
import com.restaurant.birthdaywish.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MultiItemActivity extends AppCompatActivity {
    private final static int LOADING_DURATION = 3500;
    Context context;
//    @BindView(R.id.covid_lyt)
//    LinearLayout covid_lyt;
//    @BindView(R.id.covid_world_lyt)
//    LinearLayout covid_world_lyt;
//    @BindView(R.id.images_lyt)
//    LinearLayout images_lyt;
//    @BindView(R.id.logout_lyt)
//    LinearLayout logout_lyt;
//    @BindView(R.id.logout)
//    TextView logout;
//    @BindView(R.id.love)
//    Button love;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.news_section)
    RecyclerView news_section;
    @BindView(R.id.lyt_progress)
    LinearLayout lyt_progress;

    AdapterHomeCategory mAdapter;

    // New Data
    List<ItemItem> itemItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        context = MultiItemActivity.this;
        ButterKnife.bind(this);
        Animatoo.animateSplit(context);


        initComponent();
        dataNews();

    }

    private void initComponent() {

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addItemDecoration(new SpacingItemDecoration(2, Utility.dpToPx(this, 15), true));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        HomeItems coronaWorld = new HomeItems(getResources().getDrawable(R.drawable.ic_corona_world), "Corona World");
        HomeItems familyImages = new HomeItems(getResources().getDrawable(R.drawable.ic_family_home), "Family Images");
        HomeItems loveCal = new HomeItems(getResources().getDrawable(R.drawable.ic_love_women), "Love Calculator");
        HomeItems coronaIndia = new HomeItems(getResources().getDrawable(R.drawable.ic_corona_india), "Corona India");

        HomeItems logoutApp = new HomeItems(getResources().getDrawable(R.drawable.ic_logout_blue), "Logout");

        List<HomeItems> items = new ArrayList<>(Arrays.asList(coronaWorld,loveCal,familyImages,
                coronaIndia,logoutApp));


        //set data and list adapter
        mAdapter = new AdapterHomeCategory(this, items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterHomeCategory.OnItemClickListener() {
            @Override
            public void onItemClick(View view, HomeItems obj, int position) {

                if(position==0){
                    Intent intent = new Intent(context, Covid19StatsActivity.class);
                    intent.putExtra("key" , "WORLD");
                    context.startActivity(intent);
                    Animatoo.animateZoom(context);
                }else if(position==1){
                    Intent intent = new Intent(context, LoveCalculatorActivity.class);
                    intent.putExtra("key" , "INDIA");
                    context.startActivity(intent);
                    Animatoo.animateDiagonal(context);

                }else if(position==2){
                    startActivity(new Intent(context, ProfileImagesActivity.class));
                    Animatoo.animateDiagonal(context);
                }else if(position==3){
                    Intent intent = new Intent(context, Covid19StatsActivity.class);
                    intent.putExtra("key" , "INDIA");
                    context.startActivity(intent);
                    Animatoo.animateDiagonal(context);
                }else if(position==4){
                    SharedPreferences sharedpreferences = context.getSharedPreferences("UserData",
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedpreferences.edit();


                    editor.remove("UserData");
                    editor.clear();
                    editor.commit();
                    startActivity(new Intent(context, GetNameActivity.class));
                    Animatoo.animateDiagonal(context);
                    finish();
                }else if(position==5){
                    startActivity(new Intent(context, ProfileImagesActivity.class));
                }else if(position==6){
                    startActivity(new Intent(context, ProfileImagesActivity.class));
                }else if(position==7){
                    startActivity(new Intent(context, ProfileImagesActivity.class));
                }


                GenerateToast.showSuccessToast(context, obj.title + " " + position);
            }


        });



    }


    public void dataNews(){

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





    public class OkHttpHandler extends AsyncTask<String,String,String> {


        @Override
        protected String doInBackground(String...params) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://devru-times-of-india.p.rapidapi.com/feeds/feedurllist.cms?catagory=city")
                    .get()
                    .addHeader("x-rapidapi-host", "devru-times-of-india.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "cb06a72bf9msh14c29c6fae88200p1dee60jsn6a75dfba2585")
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

                NewsResponse newsResponse = gson.fromJson(s,NewsResponse.class);

                itemItems = newsResponse.getItem();
                initComponent2(itemItems);
                Log.d("Nesw", "onPostExecute: "+itemItems.size());

            }
//            catch (JSONException e){
//
//            }
            catch (Exception e){

            }
        }


    }

    private void initComponent2(List<ItemItem> itemItems) {

        news_section.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        news_section.addItemDecoration(new SpacingItemDecoration(2, Utility.dpToPx(this, 15), true));
        news_section.setHasFixedSize(true);
        news_section.setNestedScrollingEnabled(false);




        //set data and list adapter
        AdapterNewsCategory newsAdapter = new AdapterNewsCategory(this, itemItems);
        news_section.setAdapter(newsAdapter);

        // on item list clicked
        newsAdapter.setOnItemClickListener(new AdapterNewsCategory.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ItemItem obj, int position) {

                if(position==0){
                    Intent intent = new Intent(context, TopNewsActivity.class);
                    intent.putExtra("data" , obj);
                    startActivity(intent);
                    Animatoo.animateDiagonal(context);



                }else if(position==1){

                    Intent intent = new Intent(context, CityNewsActivity.class);
                    intent.putExtra("data" , obj);
                    startActivity(intent);
                    Animatoo.animateSplit(context);


                }else if(position==1){

                }else if(position==1){

                }else if(position==1){

                }else if(position==1){

                }else if(position==1){

                }else if(position==1){

                }else if(position==1){

                }else if(position==1){

                }else if(position==1){

                }else if(position==1){

                }

                GenerateToast.showSuccessToast(context, obj.getName() + " " + position);
            }


        });



    }
//
//
//    @OnClick(R.id.love)
//    public void loveActivity(){

//    }
//
//    @OnClick(R.id.covid_lyt)
//    public void covidStatus(){

//    }
//
//    @OnClick(R.id.covid_world_lyt)
//    public void covidWorldStatus(){

//    }
//
//    @OnClick(R.id.images_lyt)
//    public void ImagesStatus(){

//    }
//
//
    private boolean doubleBackToExitPressedOnce;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
            return;
        }
        doubleBackToExitPressedOnce = true;
        GenerateToast.showInfo(context, "Press one more time to exit.");

        new Handler().postDelayed(() -> {
            doubleBackToExitPressedOnce = false;

        }, 2000);
    }


}
