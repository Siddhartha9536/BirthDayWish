package com.images.apiurl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ApiUrl {

    public static String BASE_URL = "https://docs.google.com/uc?id=";

    public static String IMG_SLIDER_URL = BASE_URL + "uploads/sliders/";

    public static String API_CORONA_INDIA_STATE_WISE_API = "https://covid19india.p.rapidapi.com/getStateData/";
    public static String API_CORONA_INDIA_STATE_WISE_HOST = "covid19india.p.rapidapi.com";
    public static String API_CORONA_INDIA_STATE_WISE_KEY = "cb06a72bf9msh14c29c6fae88200p1dee60jsn6a75dfba2585";

    public static String API_CORONA_INDIA_STATE_WISE_API_All = "https://coronavirus-tracker-india-covid-19.p.rapidapi.com/api/getStatewise";
    public static String API_CORONA_INDIA_STATE_WISE_HOST_ALL = "coronavirus-tracker-india-covid-19.p.rapidapi.com";
    public static String API_CORONA_INDIA_STATE_WISE_KEY_ALL = "cb06a72bf9msh14c29c6fae88200p1dee60jsn6a75dfba2585";

    public static boolean isConnected(Context context) {
        ConnectivityManager
                cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }
}
