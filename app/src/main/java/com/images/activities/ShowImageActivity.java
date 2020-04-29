package com.images.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.restaurant.birthdaywish.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.senab.photoview.PhotoViewAttacher;

public class ShowImageActivity extends AppCompatActivity {

    @BindView(R.id.full_image)
    ImageView full_image;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);
        ButterKnife.bind(this);
        context = ShowImageActivity.this;
        String image_url = getIntent().getStringExtra("image_url");

        full_image.post(new Runnable() {
            @Override
            public void run() {
                Picasso.with(context)
                .load(image_url)
                .into(full_image);
            }
        });

        PhotoViewAttacher pAttacher = new PhotoViewAttacher(full_image);
        pAttacher.update();

    }

    @OnClick(R.id.close_image)
    public void closeImage(){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSplit(context);
    }
}
