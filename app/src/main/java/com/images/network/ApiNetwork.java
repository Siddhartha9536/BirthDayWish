package com.images.network;


import com.images.models.indiaStatewise.Covid19India;
import com.images.models.worldcovidstatus.CoronaWorldStat;

import org.json.JSONObject;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiNetwork {

    @Headers({"x-rapidapi-host: coronavirus-tracker-india-covid-19.p.rapidapi.com" , "x-rapidapi-key: cb06a72bf9msh14c29c6fae88200p1dee60jsn6a75dfba2585"})
    @GET("api/getStatewise")
     Call<List<Covid19India>> getDetails();

    @Headers({"x-rapidapi-host: covid-193.p.rapidapi.com" , "x-rapidapi-key: cb06a72bf9msh14c29c6fae88200p1dee60jsn6a75dfba2585"})
    @GET("statistics")
    Call<CoronaWorldStat> getWorldStats();

    @Headers({"x-rapidapi-host: love-calculator.p.rapidapi.com" , "x-rapidapi-key: cb06a72bf9msh14c29c6fae88200p1dee60jsn6a75dfba2585"})
    @GET("getPercentage?fname=/{fname}&sname=/{sname}")
    Call<JSONObject> getLoveStatus(@Query("fname") String Query,@Path("sname") String sname,@Query("format") String format);

}
