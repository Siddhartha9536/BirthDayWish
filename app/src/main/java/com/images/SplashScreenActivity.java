package com.images;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.restaurant.birthdaywish.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SplashScreenActivity extends AppCompatActivity {

//    https://www.bhagwanbhajan.com/shree-ram/shree-ram-hd-wallpapers/lord-shri-ram-hd-wallpaper-2020.jpg
//    https://www.ecopetit.cat/wpic/mpic/136-1362506_shri-ram-wallpaper-full-size-hanuman-jayanti-pics.jpg
    final String url = "https://www.ecopetit.cat/wpic/mpic/136-1362506_shri-ram-wallpaper-full-size-hanuman-jayanti-pics.jpg";
    final String url_1 = "https://wallpaperaccess.com/full/2476579.jpg";
    Context context;
    @BindView(R.id.splash_screen)
    ImageView splash_screen;
    @BindView(R.id.splash_screen_1)
    ImageView splash_screen_1;
    OkHttpHandler okHttpHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        context = SplashScreenActivity.this;
        ButterKnife.bind(this);
        splash_screen.post(new Runnable() {
            @Override
            public void run() {
                Glide.with(context)
                        .load(url)
                        .into(splash_screen);
            }
        });

        splash_screen_1.post(new Runnable() {
            @Override
            public void run() {
                Glide.with(context)
                        .load(url_1)
                        .into(splash_screen_1);
            }
        });


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(context, GetNameActivity.class));
                Animatoo.animateSplit(context);
                finish();
            }
        },1000);



    }

    @Override
    protected void onResume() {
        super.onResume();
//        okHttpHandler = new OkHttpHandler();
//        okHttpHandler.execute("");
    }
    //    public class OkHttpHandler extends AsyncTask<String, String, String>{
//        @Override
//        protected String doInBackground(String... strings) {
//            return null;
//        }
//    }

    public class OkHttpHandler extends AsyncTask<String,String,String> {

        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String...params) {


            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=Indiai")
                    .get()
                    .addHeader("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
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
            Log.d("hhhh" , s + "     sdjk");
        }


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
        GenerateToast.showInfo(context, "PLEASE CLICK ONCE MORE TO EXIT.");

        new Handler().postDelayed(() -> {
            doubleBackToExitPressedOnce = false;

        }, 2000);
    }
}
