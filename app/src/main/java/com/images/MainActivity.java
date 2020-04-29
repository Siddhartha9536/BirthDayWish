package com.images;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.images.apiurl.ApiUrl;
import com.bumptech.glide.Glide;
import com.restaurant.birthdaywish.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.base_image)
    ImageView baseimage;
    @BindView(R.id.horizontal_recyclerview)
    RecyclerView horizontal_recyclerview;

    @BindView(R.id.vertical_recyclerview)
    RecyclerView vertical_recyclerview;

    @BindView(R.id.vertical_recyclerview_real)
    RecyclerView user_post;

    ArrayList<String> photosLink;
    HorizontalAdapter horizontalAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        ButterKnife.bind(this);
//        https://docs.google.com/uc?id=
//        https://drive.google.com/open?id=139jBj_GUfmFi_pZN38SS9RMB5wNXMEy9

        assignArrayList();
        setUpHorizontalsImage();
        setUpVerticalImage();
        baseimage.post(new Runnable() {
            @Override
            public void run() {
                Glide.with(context)
                        .load(ApiUrl.BASE_URL+"139jBj_GUfmFi_pZN38SS9RMB5wNXMEy9")
                        .error(R.drawable.ic_launcher_background)
                        .into(baseimage);
            }
        });



    }

    public void assignArrayList(){
        photosLink = new ArrayList<>();
        for(int i = 0 ; i<15;i++){
         photosLink.add("139jBj_GUfmFi_pZN38SS9RMB5wNXMEy9");
        }
    }

    public void setUpHorizontalsImage(){
//        horizontalAdapter = new HorizontalAdapter(photosLink,photosLink,context);
//        LinearLayoutManager HorizontalLayout = new
//                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
//
//
//        horizontal_recyclerview.setLayoutManager(HorizontalLayout);
//
//        horizontal_recyclerview.setAdapter(horizontalAdapter);

    }

    public void setUpVerticalImage(){
        VerticalAdapter verticalAdapter = new VerticalAdapter(photosLink,context);
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);


        vertical_recyclerview.setLayoutManager(linearLayoutManager);

        vertical_recyclerview.setAdapter(verticalAdapter);
        vertical_recyclerview.setNestedScrollingEnabled(false);
    }
}
