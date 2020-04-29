package com.images.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.images.GenerateToast;
import com.images.apiurl.ApiUrl;
import com.images.models.indiastates.Response1;
import com.images.models.indiastates.StateRes;
import com.restaurant.birthdaywish.R;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Covid19Activity extends AppCompatActivity {
    Context context;
    @BindView(R.id.jai_ram)
    LinearLayout jai_ram;
    @BindView(R.id.covid_lyt)
    LinearLayout covid_lyt;
    OkHttpHandler okHttpHandler;

    @BindView(R.id.state_name)
    TextView state_name;
    @BindView(R.id.confirmed)
    TextView confirmed;
    @BindView(R.id.active_case)
    TextView active_case;
    @BindView(R.id.recovered)
    TextView recovered;
    @BindView(R.id.deaths)
    TextView deaths;
    @BindView(R.id.search_spinner)
    Spinner search_spinner;
    @BindView(R.id.search_button)
    Button search_button;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19);
        context = Covid19Activity.this;
        ButterKnife.bind(this);

        covid_lyt.setVisibility(View.GONE);
        // Spinner click listener
//        search_spinner.setOnItemSelectedListener(context);

        // Spinner Drop down elements
        String[]  mTestArray = getResources().getStringArray(R.array.india_states);
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mTestArray);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        search_spinner.setAdapter(dataAdapter);


    }

    @OnClick(R.id.search_button)
    public void searchButton(){
        covid_lyt.setVisibility(View.GONE);
        String state_code = getISO_CODE_INDIA(search_spinner.getSelectedItem().toString());
        okHttpHandler = new OkHttpHandler();
        okHttpHandler.execute(state_code);
    }

    public String getISO_CODE_INDIA(String state){

        if(state.contains("Andaman and Nicobar Islands")){
            return "AN";
        }else if(state.contains("Andhra Pradesh")){
            return "AP";
        }else if(state.contains("Arunachal Pradesh")){
            return "AR";
        }else if(state.contains("Assam")){
            return "AS";
        }else if(state.contains("Bihar")){
            return "BR";
        }else if(state.contains("Chandigarh")){
            return "CH*";
        }else if(state.contains("Dadra and Nagar Haveli")){
            return "DN";
        }else if(state.contains("Daman and Diu")){
            return "DD";
        }else if(state.contains("Delhi")){
            return "DL";
        }else if(state.contains("Goa")){
            return "GA";
        }else if(state.contains("Gujarat")){
            return "GJ";
        }else if(state.contains("Haryana")){
            return "HR";
        }else if(state.contains("Himachal Pradesh")){
            return "HP";
        }else if(state.contains("Jammu and Kashmir")){
            return "JK";
        }
        else if(state.equals("Jharkhand")){
            return "JK*";
        }
        else if(state.contains("Karnataka")){
            return "KA";
        }else if(state.contains("Ladakh")){
            return "LA";
        }else if(state.contains("Lakshadweep")){
            return "LD";
        }else if(state.contains("Madhya Pradesh")){
            return "MP";
        }else if(state.contains("Maharashtra")){
            return "MH";
        }else if(state.contains("Manipur")){
            return "MN";
        }else if(state.contains("Mizoram")){
            return "MZ";
        }else if(state.contains("Nagaland")){
            return "NL";
        }else if(state.contains("Odisha")){
            return "OR";
        }else if(state.contains("Puducherry")){
            return "PY";
        }else if(state.contains("Punjab")){
            return "PB";
        }else if(state.contains("Rajasthan")){
            return "RJ";
        }else if(state.contains("Sikkim")){
            return "SK";
        }else if(state.contains("Tamil Nadu")){
            return "TN";
        }else if(state.contains("Telangana")){
            return "TG";
        }else if(state.contains("Tripura")){
            return "TR";
        }else if(state.contains("Uttar Pradesh")){
            return "UP";
        }else if(state.contains("Uttarakhand")){
            return "UK";
        }else if(state.contains("West Bengal")){
            return "WB";
        }

        return "";

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    public class OkHttpHandler extends AsyncTask<String,String,String> {

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
        protected String doInBackground(String...params) {


            OkHttpClient client = new OkHttpClient();

//            Request request = new Request.Builder()
//                    .url("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country=Indiai")
//                    .get()
//                    .addHeader("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
//                    .addHeader("x-rapidapi-key", "cb06a72bf9msh14c29c6fae88200p1dee60jsn6a75dfba2585")
//                    .build();

            Request request = new Request.Builder()
                    .url(ApiUrl.API_CORONA_INDIA_STATE_WISE_API + params[0])
                    .get()
                    .addHeader(getString(R.string.host), ApiUrl.API_CORONA_INDIA_STATE_WISE_HOST)
                    .addHeader(getString(R.string.key), ApiUrl.API_CORONA_INDIA_STATE_WISE_KEY)
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
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            boolean status = false;
            Gson gson = new Gson();
            JSONObject jresponse = null;
            try {

                jresponse = new JSONObject(response);
                String message = jresponse.getString("message");
                if(message!=null){
                    if(message.contains("Endpoint")){
                        GenerateToast.showErrorToast(context,"Record not found");
                        status = true;
                    } else {

                    }
                } else {

                }
            } catch (JSONException e) {
                status = true;
                e.printStackTrace();
            }
            try {
                if(status) {
                    StateRes stateRes = gson.fromJson(response, StateRes.class);
                    if (stateRes.getStatus() != null) {
                        if(stateRes.getStatus().equals("Success") && stateRes.getStatusCode().equals("200")) {
                            Response1 res = (Response1) stateRes.getResponse();
                            state_name.setText("" + res.getName());
                            confirmed.setText("" + res.getConfirmed());
                            recovered.setText("" + res.getRecovered());
                            active_case.setText("" + res.getActive());
                            deaths.setText("" + res.getDeaths());
                            covid_lyt.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Animation animLeftToRight1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                                    covid_lyt.setVisibility(View.VISIBLE);
                                    covid_lyt.startAnimation(animLeftToRight1);
                                }
                            }, 0);

                            Log.d("hhhh" , res.toString() + "     sdjk");
                        }
                    }
                }

                if (progressDialog != null) {
                    progressDialog.hide();
                    progressDialog.dismiss();
                    progressDialog = null;
                }

            } catch (Exception e) {
                e.printStackTrace();
                if (progressDialog != null) {
                    progressDialog.hide();
                    progressDialog.dismiss();
                    progressDialog = null;
                }
            }



        }


    }



//        Union territory	IN-AN	Andaman and Nicobar Islands		en
//        state	IN-AP	Andhra Pradesh		en
//        state	IN-AR	Arunachal Pradesh		en
//        state	IN-AS	Assam		en
//        state	IN-BR	Bihar		en
//        Union territory	IN-CH	Chandigarh		en
//        state	IN-CT*	Chhattisgarh		en
//        Union territory	IN-DN	Dadra and Nagar Haveli		en
//        Union territory	IN-DD	Daman and Diu		en
//        Union territory	IN-DL	Delhi		en
//        state	IN-GA	Goa		en
//        state	IN-GJ	Gujarat		en
//        state	IN-HR	Haryana		en
//        state	IN-HP	Himachal Pradesh		en
//        Union territory	IN-JK	Jammu and Kashmir		en
//        state	IN-JH*	Jharkhand		en
//        state	IN-KA	Karnataka		en
//        state	IN-KL	Kerala		en
//        Union territory	IN-LA	Ladakh		en
//        Union territory	IN-LD	Lakshadweep		en
//        state	IN-MP	Madhya Pradesh		en
//        state	IN-MH	Maharashtra		en
//        state	IN-MN	Manipur		en
//        state	IN-ML	Meghalaya		en
//        state	IN-MZ	Mizoram		e
//        state	IN-NL	Nagaland		en
//        state	IN-OR	Odisha		en
//        Union territory	IN-PY	Puducherry	Pondicherry	en
//        state	IN-PB	Punjab		en
//        state	IN-RJ	Rajasthan		en
//        state	IN-SK	Sikkim		en
//        state	IN-TN	Tamil Nadu		en
//        state	IN-TG*	Telangana		en
//        state	IN-TR	Tripura		en
//        state	IN-UP	Uttar Pradesh		en
//        state	IN-UT*	Uttarakhand		en
//        state	IN-WB	West Bengal		en

}
