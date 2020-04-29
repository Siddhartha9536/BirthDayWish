package com.images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.images.apiurl.ApiUrl;
import com.bumptech.glide.Glide;
import com.restaurant.birthdaywish.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyView> {

    public List<String> list;
    Context mContext;

    public class MyView extends RecyclerView.ViewHolder {

        public TextView user_name;
        public CircleImageView user_image,user_profile;
        public MyView(View view) {
            super(view);
//            user_name =view.findViewById(R.id.user_name);
            user_image =view.findViewById(R.id.user_image);
//            user_profile =view.findViewById(R.id.profile_image);


        }
    }


    public VerticalAdapter(List<String> horizontalList, Context mContext) {
        this.mContext=mContext;
        this.list = horizontalList;

    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_user_feed_item, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, final int position) {
        String details=list.get(position);
//
//        holder.user_name.setText(details.getName());
//        holder.user_profile.setImageResource(details.getProfile_image_resurce());
        holder.user_image.post(new Runnable() {
            @Override
            public void run() {
                Glide.with(mContext)
                        .load(ApiUrl.BASE_URL+details)
                        .error(R.drawable.ic_launcher_background)
                        .into(holder.user_image);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}