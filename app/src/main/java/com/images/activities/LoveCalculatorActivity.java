package com.images.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.bumptech.glide.Glide;
import com.images.GenerateToast;
import com.images.adapters.Corona19IndiaAdapter;
import com.images.apiurl.NetworkClient;
import com.images.models.indiaStatewise.Covid19India;
import com.images.network.ApiNetwork;
import com.restaurant.birthdaywish.R;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class LoveCalculatorActivity extends AppCompatActivity {

    String love_image = "https://cdn.imgbin.com/23/14/23/imgbin-heart-love-android-transparent-heart-strips-heart-red-lace-3d-digital-illustration-cWtKJ89DJt55u9GRXZ9EYEjyc.jpg";
    String love_gif = "https://media.giphy.com/media/l41JWw65TcBGjPpRK/giphy.gif";
    String love__success_gif = "https://media.giphy.com/media/yc2pHdAoxVOrJ2m5Ha/giphy.gif";


    Context context;
    @BindView(R.id.first_name)
    EditText first_name;
    @BindView(R.id.second_name)
    EditText second_name;
    @BindView(R.id.okay)
    Button okay;
    @BindView(R.id.love_pic)
    ImageView love_pic;

    @BindView(R.id.another_lyt)
    LinearLayout another_lyt;
    @BindView(R.id.calculate_lyt)
    LinearLayout calculate_lyt;

    @BindView(R.id.percent)
    Button percent;
    @BindView(R.id.f_n_cal)
    Button f_n_cal;
    @BindView(R.id.second_r_name)
    Button second_r_name;
    @BindView(R.id.another_cal)
    Button another_cal;

    @BindView(R.id.gif_success)
    ImageView gif_success;
    @BindView(R.id.comment)
    TextView comment;


    ProgressDialog progressDialog;
    String f;
    String S;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_test);
        context = LoveCalculatorActivity.this;
        ButterKnife.bind(this);
        calculate_lyt.setVisibility(View.VISIBLE);
        another_lyt.setVisibility(View.GONE);
        love_pic.post(new Runnable() {
            @Override
            public void run() {

                Glide.with(context)
                        .load(love_gif)
                        .into(love_pic);

            }
        });

    }
    @OnClick(R.id.okay)
    public void checkValidation(){
        f = first_name.getText().toString();

        S = second_name.getText().toString();
        if(!f.equals("") & !S.equals("") & !S.equals(f)){
            first_name.setText("");
            second_name.setText("");
            f.replace(" ", "%20");
            S.replace(" ", "%20");
            another_lyt.setVisibility(View.GONE);//
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(second_name.getWindowToken(), 0);
            OkHttpHandler g = new OkHttpHandler();
            g.execute();

        }else if(S.equals(f)){
            GenerateToast.showErrorToastWOI(context, "Both names are same, please try different.");
        }else{
            GenerateToast.showErrorToastWOI(context, "Please enter both names.");
        }
    }

    @OnClick(R.id.another_cal)
    public void againTry(){
        Animatoo.animateSplit(context);
        another_lyt.setVisibility(View.GONE);
        calculate_lyt.setVisibility(View.VISIBLE);

    }



    public void showProgressBar(){
        progressDialog = ProgressDialog.show( context, null, null, false, true );
        progressDialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
        progressDialog.setContentView( R.layout.progress_bar_small );
        progressDialog.setCancelable(false);
    }

    public void hideProgressBar(){
        if (progressDialog != null) {
            progressDialog.hide();
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @OnClick(R.id.back_icon)
    public void backPress(){
        onBackPressed();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateZoom(context);
    }

    public class OkHttpHandler extends AsyncTask<String,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgressBar();
        }

        @Override
        protected String doInBackground(String...params) {

            String Base_URL = "https://love-calculator.p.rapidapi.com/getPercentage?fname=";
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(Base_URL + f +"&sname="+ S)
                    .get()
                    .addHeader("x-rapidapi-host", "love-calculator.p.rapidapi.com")
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
            hideProgressBar();
            try {
                f = ""; S = "";
                JSONObject js = new JSONObject(s);
                String fname = js.getString("fname");
                String sname = js.getString("sname");
                String percentage = js.getString("percentage");
                String result = js.getString("result");
                Log.d("TAG", "onPostExecute: " + fname + sname + percentage + result);

                calculate_lyt.setVisibility(View.GONE);
                percent.setText(percentage + " %");
                f_n_cal.setText(fname);
                second_r_name.setText(sname);
                comment.setText(result);
                gif_success.post(new Runnable() {
                    @Override
                    public void run() {
                       Glide.with(context)
                       .load(love__success_gif)
                       .into(gif_success);
                    }
                });
                another_lyt.setVisibility(View.VISIBLE);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    }














}
