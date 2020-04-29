package com.images.models.homeitems;

import android.graphics.drawable.Drawable;

public class HomeItems {

    public int image;

    public HomeItems( Drawable imageDrw, String title) {

        this.imageDrw = imageDrw;
        this.title = title;

    }

    public Drawable imageDrw;
    public String title;
    public String brief;
    public int image_bg;


}
