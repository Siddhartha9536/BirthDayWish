package com.images;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.restaurant.birthdaywish.R;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileImagesActivity extends AppCompatActivity implements ItemClickListner{

    @BindView(R.id.horizontal_recyclerview)
    RecyclerView horizontal_recyclerview;
    @BindView(R.id.horizontal_view)
    RecyclerView horizontal_view;
    @BindView(R.id.user_name)
    TextView user_name;

    @BindView(R.id.card_photo)
    CardView card_photo;

    @BindView(R.id.lyt_photo)
    LinearLayout lyt_photo;
    @BindView(R.id.lyt_top)
    LinearLayout lyt_top;
    @BindView(R.id.lyt_Bottom)
    LinearLayout lyt_Bottom;

    ArrayList<String> photosLink;
    ArrayList<String> photosName;

    HorizontalAdapter horizontalAdapter;
    HorizontalImagesAdapter horizontalImagesAdapter;
    Context context;
    Animation animLeftToRight;
    @BindView(R.id.back_icon)
    ImageView back_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = ProfileImagesActivity.this;
        ButterKnife.bind(this);
        SharedPreferences sharedpreferences = getSharedPreferences("UserData",
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains("user_name")) {
            user_name.setText("Hello " +sharedpreferences.getString("user_name", ""));
        }



        assignArrayList();
        setUpHorizontalsImage();
        setUpHorizontalImage();

        horizontal_recyclerview.setItemAnimator(new DefaultItemAnimator());



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




    @Override
    protected void onResume() {
        super.onResume();
        try {
            // load the animation



            lyt_photo.postDelayed(new Runnable() {
                @Override
                public void run() {
                    animLeftToRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                    lyt_photo.setVisibility(View.VISIBLE);
                    lyt_photo.startAnimation(animLeftToRight);
                }
            }, 0);

            lyt_top.postDelayed(new Runnable() {
                @Override
                public void run() {
                    lyt_top.setVisibility(View.VISIBLE);
                    animLeftToRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                    lyt_top.startAnimation(animLeftToRight);
                }
            }, 1100);

            lyt_Bottom.postDelayed(new Runnable() {
                @Override
                public void run() {
                    lyt_Bottom.setVisibility(View.VISIBLE);
                    animLeftToRight = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                    lyt_Bottom.startAnimation(animLeftToRight);
                }
            }, 2200);
        }catch (Exception e){

        }

    }

    public void assignArrayList(){
        photosLink = new ArrayList<>();
        photosName = new ArrayList<>();

        photosName.add("Sagar Family");
        photosLink.add("1LYt5fckEAFoDsPJhBwoqdJU1GHe5rCQq");
        photosName.add("Supriya Mathur");
        photosLink.add("1LUQpNx0wD8PhmKLBFrHGoEJqdMCOeB9K");
        photosName.add("DeepiKa, Pallavi");
        photosLink.add("1LYMhl_5ccBEsoq8rQyNlwAcwoMJRacsP");
        photosName.add("Dev Bhatnagar");
        photosLink.add("1LsQwyg8m95DPpP56cUfS6d76y0vvUzBK");
        photosName.add("Oshi, Honey");
        photosLink.add("1LX4__GMiB8nJA7PW2R5mf7pBIQRWCX-m");
        photosName.add("Sanjay John");
        photosLink.add("1LMYwvkwVbx8_nZuk9-5DQf0mtSL0yWe2");
        photosName.add("Shanky");
        photosLink.add("1LXAgBKI3OYVvjWecF1clZbj2l3XNi6rZ");
        photosName.add("Siddhidatri");
        photosLink.add("1Lv_RdvN3nqQy_NfzwY7w69cNP60MV9Q3");
        photosName.add("Supriya Mathur");
        photosLink.add("1LUjDVdqh_Cicy4moe4A7xnNX7mconoVP");
        photosName.add("Vishesh Dubey");
        photosLink.add("1LlBNsSDCNKHVs8TIsaWO8_ioArThaV7Y");
        photosName.add("Oshi John");
        photosLink.add("1LNSd2_wq5ueQXUrZV5H7TOdA9-ToxS04");
        photosName.add("Siddhartha");
        photosLink.add("1Lx4T1xqCrIg46rT7o3c3xi3-Y9C8gjGe");
        photosName.add("Savita John");
        photosLink.add("1LbofwUuZHeUTfW2fF38IjBxUbaAAwaJo");

//        for(int i = 0 ; i<15;i++){
//            photosLink.add("139jBj_GUfmFi_pZN38SS9RMB5wNXMEy9");
//        }
    }

    public void setUpHorizontalsImage(){
        horizontalAdapter = new HorizontalAdapter(photosLink, photosName,context, this);

        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recyclerview.setLayoutManager(HorizontalLayout);
        horizontal_recyclerview.setAdapter(horizontalAdapter);

    }

    public void setUpHorizontalImage(){
        horizontalImagesAdapter = new HorizontalImagesAdapter(photosLink, photosName, context);

        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        horizontal_view.setLayoutManager(HorizontalLayout);
        horizontal_view.setAdapter(horizontalImagesAdapter);

    }



    @Override
    public void clicks(int pos) {
        horizontal_view.smoothScrollToPosition(pos);
    }
}
