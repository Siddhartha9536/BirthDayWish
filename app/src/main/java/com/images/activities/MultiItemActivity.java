package com.images.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
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

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MultiItemActivity extends AppCompatActivity {
    private final static int LOADING_DURATION = 3500;
    Context context;

    @BindView(R.id.family_icon)
    ImageView family_icon;

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
        HomeItems family2 = new HomeItems(getResources().getDrawable(R.drawable.ic_family_home), "Family Images 2");
        HomeItems whatsApp = new HomeItems(getResources().getDrawable(R.drawable.ic_whatsapp), "Help by WhatsApp");
        HomeItems callNumber = new HomeItems(getResources().getDrawable(R.drawable.ic_call), "Help by Call");

        List<HomeItems> items = new ArrayList<>(Arrays.asList(coronaWorld, loveCal, familyImages,
                coronaIndia, logoutApp, family2, whatsApp,callNumber));


        //set data and list adapter
        mAdapter = new AdapterHomeCategory(this, items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterHomeCategory.OnItemClickListener() {
            @Override
            public void onItemClick(View view, HomeItems obj, int position) {

                if (position == 0) {
                    Intent intent = new Intent(context, Covid19StatsActivity.class);
                    intent.putExtra("key", "WORLD");
                    context.startActivity(intent);
                    Animatoo.animateZoom(context);
                } else if (position == 1) {
                    Intent intent = new Intent(context, LoveCalculatorActivity.class);
                    intent.putExtra("key", "INDIA");
                    context.startActivity(intent);
                    Animatoo.animateDiagonal(context);

                } else if (position == 2) {
                    startActivity(new Intent(context, ProfileImagesActivity.class));
                    Animatoo.animateDiagonal(context);
                } else if (position == 3) {
                    Intent intent = new Intent(context, Covid19StatsActivity.class);
                    intent.putExtra("key", "INDIA");
                    context.startActivity(intent);
                    Animatoo.animateDiagonal(context);
                } else if (position == 4) {
                    SharedPreferences sharedpreferences = context.getSharedPreferences("UserData",
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.remove("UserData");
                    editor.clear();
                    editor.commit();
                    startActivity(new Intent(context, GetNameActivity.class));
                    Animatoo.animateDiagonal(context);
                    finish();
                } else if (position == 5) {
                    startActivity(new Intent(context, ProfileImagesActivity.class));
                } else if (position == 6) {

                    String smsNumber = "+919557505201";
                    openWhatsApp(smsNumber, "Hi Siddhartha, ");

                } else if (position == 7) {
                    if (isPermissionGranted()) {
                        call_action();
                    }

                }
                GenerateToast.showErrorToastWOI(context, position + "");

            }


        });


    }

    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission is granted");
                return true;
            } else {

                Log.v("TAG", "Permission is revoked");
                ActivityCompat.requestPermissions(MultiItemActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                ActivityCompat.requestPermissions(MultiItemActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG", "Permission is granted");
            return true;
        }
    }

    public void call_action() {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + "+919557505201"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        MultiItemActivity.this.startActivity(callIntent);
    }

    private void openWhatsApp(String numero,String mensaje){

        try{
            PackageManager packageManager = context.getPackageManager();
            Intent i = new Intent(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone="+ numero +"&text=" + URLEncoder.encode(mensaje, "UTF-8");
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            if (i.resolveActivity(packageManager) != null) {
                startActivity(i);
            }else {

            }
        } catch(Exception e) {
            Log.e("ERROR WHATSAPP",e.toString());
        }

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

    @OnClick(R.id.family_icon)
    public void rotate(){
        Log.d("gty" , "vcc");



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
//        news_section.addItemDecoration(new SpacingItemDecoration(1,
//                Utility.dpToPx(this, 15), true));
//        news_section.setHasFixedSize(true);
        news_section.setNestedScrollingEnabled(false);




        //set data and list adapter
        AdapterNewsCategory newsAdapter = new AdapterNewsCategory(this, itemItems);
        news_section.setAdapter(newsAdapter);

        // on item list clicked
        newsAdapter.setOnItemClickListener(new AdapterNewsCategory.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ItemItem obj, int position) {


                    try {
                        if(obj!=null){
                            if(obj.getSubsections()!=null){
                                if (obj.getSubsections().equalsIgnoreCase("yes")) {
                                    sectionYes(obj);
                                } else if (obj.getSubsections().equalsIgnoreCase("no")) {
                                    sectionNo(obj);
                                }
                            }
                        }

                    }catch (Exception e){
                       GenerateToast.showErrorToastWOI(context, e.toString());
                    }

            }


        });



    }

    public void sectionYes(ItemItem obj){
        Intent intent = new Intent(context, CityNewsActivity.class);
        intent.putExtra("data" , obj);
        startActivity(intent);
        Animatoo.animateSplit(context);
    }
    public void sectionNo(ItemItem obj){
        Intent intent = new Intent(context, TopNewsActivity.class);
        intent.putExtra("data" , obj);
        startActivity(intent);
        Animatoo.animateDiagonal(context);
    }

    private boolean doubleBackToExitPressedOnce;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            finish();
            return;
        }
        doubleBackToExitPressedOnce = true;
        GenerateToast.showInfo(context, "Click again to exit.");

        new Handler().postDelayed(() -> {
            doubleBackToExitPressedOnce = false;

        }, 2000);
    }


}
