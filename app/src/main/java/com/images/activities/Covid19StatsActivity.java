package com.images.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.images.GenerateToast;
import com.images.adapters.Corona19IndiaAdapter;
import com.images.adapters.Corona19WorldStatsAdapter;
import com.images.apiurl.NetworkClient;
import com.images.models.indiaStatewise.Covid19India;
import com.images.models.worldcovidstatus.Cases;
import com.images.models.worldcovidstatus.CoronaWorldStat;
import com.images.models.worldcovidstatus.Deaths;
import com.images.models.worldcovidstatus.ResponseItem;
import com.images.models.worldcovidstatus.Tests;
import com.images.network.ApiNetwork;
import com.restaurant.birthdaywish.R;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class Covid19StatsActivity extends AppCompatActivity {

    @BindView(R.id.india_covid19_recycler)
    RecyclerView india_covid19_recycler;
    @BindView(R.id.world_covid19_recycler)
    RecyclerView world_covid19_recycler;
    @BindView(R.id.heading_text)
    TextView heading_text;
    @BindView(R.id.search_item)
    TextView search_item;
    @BindView(R.id.back_icon)
    ImageView back_icon;
    Context context;
    ProgressDialog progressDialog;
    Corona19IndiaAdapter corona19IndiaAdapter;
    Corona19WorldStatsAdapter corona19WorldStatsAdapter;
    ArrayList<String> countyArrayList;
    ArrayList<Cases> casesArrayList;
    ArrayList<Tests> testsArrayList;
    ArrayList<Deaths> deathsArrayList;
    ArrayList<String> dayArrayList;
    ArrayList<String> timeArrayList;
    String whichOneStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19_india);
        context  = Covid19StatsActivity.this;
        ButterKnife.bind(this);

        String whichOneStats = getIntent().getExtras().getString("key");

        if(whichOneStats!=null){
            if(whichOneStats.equalsIgnoreCase("world")){
                heading_text.setText("COVID-19 " + whichOneStats.toUpperCase() + " STATS");
                world_covid19_recycler.setVisibility(View.VISIBLE);
                fetchWorldCoronaStats();

            } else if(whichOneStats.equalsIgnoreCase("India")){
                heading_text.setText("COVID-19 " + whichOneStats.toUpperCase() + " STATS");
                india_covid19_recycler.setVisibility(View.VISIBLE);

                fetchIndiaCoronaStats();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @OnClick(R.id.back_icon)
    public void backPress(){
        onBackPressed();
        Animatoo.animateZoom(context);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateZoom(context);
    }

    private void fetchIndiaCoronaStats() {

        final String BASE_URL = "https://covid19india.p.rapidapi.com/";
        Retrofit retrofit = NetworkClient.getRetrofitClient(BASE_URL);

        ApiNetwork apiNetwork = retrofit.create(ApiNetwork.class);
        showProgressBar();
        Call call = apiNetwork.getDetails();

        call.enqueue(new Callback() {

            @Override
            public void onResponse(Call call, retrofit2.Response response) {
                if (response.body() != null) {
                    hideProgressBar();

                    try {
                        List<Covid19India> wResponse = (List<Covid19India>) response.body();
                        corona19IndiaAdapter = new Corona19IndiaAdapter(wResponse, context);
                        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                        india_covid19_recycler.setLayoutManager(HorizontalLayout);
                        india_covid19_recycler.setAdapter(corona19IndiaAdapter);
                    }catch (Exception e){
                        GenerateToast.showErrorToast(context, e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                hideProgressBar();
                GenerateToast.showErrorToast(context, "Data not found!");
            }
        });
    }

    private void fetchWorldCoronaStats() {

        final String BASE_URL = "https://covid-193.p.rapidapi.com/";
        Retrofit retrofit = NetworkClient.getRetrofitClient(BASE_URL);

        ApiNetwork apiNetwork = retrofit.create(ApiNetwork.class);
        showProgressBar();
        Call call = apiNetwork.getWorldStats();

        call.enqueue(new Callback() {

            @Override
            public void onResponse(Call call, retrofit2.Response response) {
                if (response.body() != null) {
                    hideProgressBar();
                    try {
                        CoronaWorldStat wResponse = (CoronaWorldStat) response.body();
                        if(wResponse.getResponse().size()>0){
                            countyArrayList = new ArrayList<>();
                            casesArrayList = new ArrayList<>();
                            testsArrayList = new ArrayList<>();
                            deathsArrayList = new ArrayList<>();
                            dayArrayList = new ArrayList<>();
                            timeArrayList = new ArrayList<>();

                            List<ResponseItem> list = wResponse.getResponse();

                            for(int i = 0 ;i <list.size();i++){

                                ResponseItem responseItem = list.get(i);
                                if(responseItem!=null){

                                    countyArrayList.add(responseItem.getCountry());
                                    casesArrayList.add(responseItem.getCases());
                                    testsArrayList.add(responseItem.getTests());
                                    deathsArrayList.add(responseItem.getDeaths());
                                    dayArrayList.add(responseItem.getDay());
                                    timeArrayList.add(responseItem.getTime());

                                }

                            }

                            corona19WorldStatsAdapter = new
                                    Corona19WorldStatsAdapter(countyArrayList, casesArrayList, testsArrayList,
                                    deathsArrayList , dayArrayList, timeArrayList, context);

                            LinearLayoutManager HorizontalLayout = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                            world_covid19_recycler.setLayoutManager(HorizontalLayout);
                            world_covid19_recycler.setAdapter(corona19WorldStatsAdapter);


                        } else {

                        }

                    }catch (Exception e){
                        GenerateToast.showErrorToast(context, e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                hideProgressBar();
                GenerateToast.showErrorToast(context, "Data not found!");
            }
        });
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





/*    public class OkHttpHandler extends AsyncTask<String, String, Response> {

        OkHttpClient client = new OkHttpClient();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show( context, null, null, false, true );
            progressDialog.getWindow().setBackgroundDrawable( new ColorDrawable( Color.TRANSPARENT ) );
            progressDialog.setContentView( R.layout.progress_bar_small );
            progressDialog.setCancelable(false);
        }

        @Override
        protected Response doInBackground(String...params) {

//            OkHttpClient client = new OkHttpClient();
//
//            Request request = new Request.Builder()
//                    .url(ApiUrl.API_CORONA_INDIA_STATE_WISE_API_All)
//                    .get()
//                    .addHeader(getString(R.string.host), ApiUrl.API_CORONA_INDIA_STATE_WISE_HOST_ALL)
//                    .addHeader(getString(R.string.key), ApiUrl.API_CORONA_INDIA_STATE_WISE_KEY_ALL)
//                    .build();
            OkHttpClient client = new OkHttpClient();
//            https://coronavirus-tracker-india-covid-19.p.rapidapi.com/api/getStatewise
            Request request = new Request.Builder()
                    .url("https://coronavirus-tracker-india-covid-19.p.rapidapi.com/api/getStatewise")
                    .get()
                    .addHeader("x-rapidapi-host", "coronavirus-tracker-india-covid-19.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "cb06a72bf9msh14c29c6fae88200p1dee60jsn6a75dfba2585")
                    .build();

            try {

                Response response = client.newCall(request).execute();
                return response;
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Response response) {
            super.onPostExecute(response);
         try{
            Log.d("IO Error Tag",response.body().contentType().charset().name());




            Log.d("IO Errorty Tag",response.body().string());


             if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                 final JSONArray myResponse = new JSONArray(response.body().string());
             }

//             String responseBodyString = response.body().toString();
//             String responseBodyString1 = response.body().string();

//             JSONArray j = new JSONArray(responseBodyString1);


//             String responseText = response.body().string();
//             Response response = chain.proceed(chain.request());
//             ResponseBody body = response.body();
////             String bodyString = body.string();
//             MediaType contentType = body.contentType();
////             Log.d("Response", contentType.toString());
////             ResponseBody body = response.body();
//             BufferedSource source = body.source();
////             if (source.request(1024)) throw new IOException("Body too long!");
//             Buffer bufferedCopy = source.buffer().clone();
//             ResponseBody newBody = ResponseBody.create(body.contentType(), body.contentLength(), bufferedCopy);
////             String responseBodyString = newBody.string();
//
////             JSONObject jsonObject = new JSONObject(response.body().string());
////             JSONArray jsonArray = new JSONArray(response.body().string());
////             JSONStringer jsonArray = new  JSONStringer(response.body().string());
//
//
//             Log.d("Response", responseBodyString);

//             Response response1 = response.newBuilder().body(ResponseBody.create(contentType, body.string())).build();


//             Log.d("IO responseText Tag",responseText);
//             JSONObject json = new JSONObject(responseText);
//             JSONArray jsonArray = new JSONArray(response.body().string());
//             JSONArray jsonArray = new JSONArray(response.body().toString());
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.message());
//            StringBuilder stringBuilder = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line).append("\n");
//            }
//            bufferedReader.close();
//            String result = stringBuilder.toString();

        } catch (Exception ex) {
             Log.d("IO 2 Error Tag",ex.toString());
         }
//            Response{protocol=http/1.1, code=200, message=OK, url=https://coronavirus-tracker-india-covid-19.p.rapidapi.com/api/getStatewise}


//            try {
////                JSONObject json = new JSONObject(response.body().string());
//            } catch (JSONException | IOException e) {
//                Log.d("IO 1 Error Tag",e.toString());
//            }

            if (progressDialog != null) {
                progressDialog.hide();
                progressDialog.dismiss();
                progressDialog = null;
            }

            try {

//                    if (response.size() >0) {
//                        listRes = response.toString();
//                        covid19IndiaAdapter = new Covid19IndiaAdapter(response, context);
//                        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
//                        india_covid19_lyt.setLayoutManager(HorizontalLayout);
//                        india_covid19_lyt.setAdapter(covid19IndiaAdapter);
//                    }

            } catch (Exception e) {
                e.printStackTrace();
                if (progressDialog != null) {
                    progressDialog.hide();
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }

    }


}*/


}
