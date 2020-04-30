package com.images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.images.apiurl.ApiUrl;
import com.bumptech.glide.Glide;
import com.restaurant.birthdaywish.R;

import java.util.List;
import java.util.Random;


public class HorizontalImagesAdapter extends RecyclerView.Adapter<HorizontalImagesAdapter.MyView> {

    public List<String> list;
    List<String> photoNames;
    Context mContext;

    public class MyView extends RecyclerView.ViewHolder {

        public TextView user_name;
        public ImageView user_image;

        public MyView(View view) {
            super(view);
            user_name =view.findViewById(R.id.user_name);
            user_image =view.findViewById(R.id.user_image);

        }
    }


    public HorizontalImagesAdapter(List<String> horizontalList, List<String> photoNames, Context mContext) {
        this.mContext=mContext;
        this.list = horizontalList;
        this.photoNames = photoNames;


    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_user_indiviuals, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, final int position) {
        String details=list.get(position);

        holder.user_image.post(new Runnable() {
            @Override
            public void run() {
                Glide.with(mContext)
                        .load(ApiUrl.BASE_URL+details)
                        .error(R.drawable.ic_back)
                        .into(holder.user_image);
            }
        });
        holder.user_image.setVisibility(View.VISIBLE);
        holder.user_name.setText("@Hashtag_" + randomNu()+": "+photoNames.get(position));

    }

    public String randomNu(){
        Random r = new Random();

        return  String.format("%04d", Integer.valueOf(r.nextInt(1001)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}