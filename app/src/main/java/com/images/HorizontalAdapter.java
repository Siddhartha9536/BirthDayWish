package com.images;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import com.images.apiurl.ApiUrl;
import com.bumptech.glide.Glide;
import com.restaurant.birthdaywish.R;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyView> {

    public List<String> list;
    List<String> photoNames;
    Context mContext;
    ItemClickListner itemClickListner;

    public class MyView extends RecyclerView.ViewHolder {

        public TextView user_name;
        public CircleImageView user_image,user_profile;
        public MyView(View view) {
            super(view);
            user_name =view.findViewById(R.id.names);
            user_image =view.findViewById(R.id.user_image);
//            user_profile =view.findViewById(R.id.profile_image);



        }
    }


    public HorizontalAdapter(List<String> horizontalList, List<String> photoNames, Context mContext, ItemClickListner itemClickListner) {
        this.mContext=mContext;
        this.list = horizontalList;
        this.photoNames = photoNames;
        this.itemClickListner = itemClickListner;

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

        holder.user_name.setText(photoNames.get(position));

        holder.user_image.post(new Runnable() {
            @Override
            public void run() {
                Glide.with(mContext)
                        .load(ApiUrl.BASE_URL+details)
                        .error(R.drawable.ic_launcher_background)
                        .into(holder.user_image);
            }
        });

        holder.user_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListner.clicks(position);
            }
        });

        holder.user_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProductDetail( position );
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void showProductDetail(int position) {

        final Dialog dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_name_replace);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();

        EditText edit_text = (EditText) dialog.findViewById(R.id.edit_text);
        Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        Button btn_ok = (Button) dialog.findViewById(R.id.btn_ok);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit_text.getText().length()>0){
                    photoNames.set(position, edit_text.getText().toString());
                    notifyDataSetChanged();
                    dialog.dismiss();
                }else {
                    Toast.makeText(mContext, "Please enter the which you want to change here.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}