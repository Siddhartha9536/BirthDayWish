package com.images;

import android.content.Context;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class GenerateToast {
    static Toasty mToast;

    public static void showSuccessToast(Context context, String statusMsg){
        if(mToast != null) {

        }else {
        Toasty.success(context, statusMsg, Toast.LENGTH_SHORT, true).show();



        }
    }

    public static void showErrorToast(Context context, String statusMsg){
        if(mToast != null) {

        }else {
            Toasty.error(context, statusMsg, Toast.LENGTH_SHORT, true).show();



        }
    }
    public static void showErrorToastWOI(Context context, String statusMsg){
        if(mToast != null) {

        }else {
            Toasty.error(context, statusMsg, Toast.LENGTH_SHORT, false).show();



        }
    }
    public static void showInfo(Context context, String statusMsg){
        if(mToast != null) {

        }else {
            Toasty.info(context, statusMsg, Toast.LENGTH_SHORT, true).show();

        }
    }
    public static void warning(Context context, String statusMsg){
        if(mToast != null) {

        }else {
            Toasty.warning(context, statusMsg, Toast.LENGTH_SHORT, true).show();



        }
    }


}
