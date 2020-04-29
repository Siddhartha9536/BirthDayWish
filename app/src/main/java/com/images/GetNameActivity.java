package com.images;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.images.activities.MultiItemActivity;
import com.restaurant.birthdaywish.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GetNameActivity extends AppCompatActivity {
    Context context;
    @BindView(R.id.btn_next)
    Button btn_next;
    @BindView(R.id.get_name)
    EditText get_name;
    @BindView(R.id.jai_ram)
    LinearLayout jai_ram;
    @BindView(R.id.input_lyt)
    LinearLayout input_lyt;
    @BindView(R.id.show_quote_lyt)
    LinearLayout show_quote_lyt;
    Animation animLeftToRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);
        context = GetNameActivity.this;
        ButterKnife.bind(this);

        alreadyLogin();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateZoom(context);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            // load the animation
            jai_ram.setVisibility(View.VISIBLE);
            jai_ram.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animLeftToRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                    jai_ram.startAnimation(animLeftToRight);
                }
            }, 0);

            input_lyt.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animLeftToRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                    input_lyt.setVisibility(View.VISIBLE);
                    input_lyt.startAnimation(animLeftToRight);
                }
            }, 1100);

            show_quote_lyt.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animLeftToRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                    show_quote_lyt.setVisibility(View.VISIBLE);
                    show_quote_lyt.startAnimation(animLeftToRight);
                }
            }, 2200);

        }catch (Exception e){

        }

    }

    public void alreadyLogin(){
        SharedPreferences sharedpreferences = getSharedPreferences("UserData",
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains("user_name")) {
            startActivity(new Intent(this, MultiItemActivity.class));
            finish();
        }
    }

    @OnClick(R.id.btn_next)
    public void btnNext(){
        String name = get_name.getText().toString();
        if(name.length()>3){

            saveUserData(name);
            GenerateToast.showSuccessToast(context, "Your Welcome " + name +".");
            startActivity(new Intent(this, MultiItemActivity.class));
            Animatoo.animateDiagonal(context);
            finish();
        }else{
            get_name.setText("");
           GenerateToast.showErrorToastWOI(context, "Please enter at least four letter name.");
        }

    }

    public void saveUserData(String name){
            SharedPreferences pref = getApplicationContext().getSharedPreferences("UserData", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("user_name",name);
            editor.commit();
    }

}
