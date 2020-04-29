package com.images.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.images.models.indiaStatewise.Covid19India;
import com.restaurant.birthdaywish.R;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Corona19IndiaAdapter extends RecyclerView.Adapter<Corona19IndiaAdapter.MyView> {

    public List<Covid19India> list;
    Context mContext;


    public class MyView extends RecyclerView.ViewHolder {
        public TextView state_name;
        public TextView confirmed;
        public TextView recovered;
        public TextView deaths;
        public ImageView covid_mask_icon;
        public MyView(View view) {
            super(view);
            state_name =view.findViewById(R.id.state_name);
            confirmed =view.findViewById(R.id.confirmed);
            recovered =view.findViewById(R.id.recovered);
            deaths =view.findViewById(R.id.deaths);
            covid_mask_icon =view.findViewById(R.id.covid_mask_icon);
        }
    }


    public Corona19IndiaAdapter(List<Covid19India> horizontalList, Context mContext) {
        this.mContext=mContext;
        this.list = horizontalList;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.covid19_india_item, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, final int position) {

        Covid19India covid19India = list.get(position);
        if(covid19India!=null) {
            NumberFormat formatter = NumberFormat.getNumberInstance(new Locale("en", "IN"));

            if(!covid19India.getId().equals("") | !covid19India.getId().contains("Our figures are being reconciled with ICMR")) {
                holder.state_name.setText(covid19India.getName());
                if(!covid19India.getCases().equals("")) {
                    holder.confirmed.setText(formatter.format(Long.parseLong(covid19India.getCases())));
                }
                if(!covid19India.getRecovered().equals("")) {
                    holder.recovered.setText(formatter.format(Long.parseLong(covid19India.getRecovered())));
                }
                if(!covid19India.getDeaths().equals("")) {
                    holder.deaths.setText(formatter.format(Long.parseLong(covid19India.getDeaths())));
                }

                holder.covid_mask_icon.post(new Runnable() {
                    @Override
                    public void run() {
                        Picasso.with(mContext)
                                .load("https://cdn4.iconfinder.com/data/icons/coronavirus-color/64/mask-wearing-doctor-protection-flu-512.png")
                                .error(R.drawable.ic_cv_48)
                                .into(holder.covid_mask_icon);
                    }
                });
//                https://cdn4.iconfinder.com/data/icons/coronavirus-color/64/mask-wearing-doctor-protection-flu-512.png
            }
        }

    }

    @Override
    public int getItemCount() {
        if(list.size()>1){
            return list.size()-1;
        }else{
            return list.size();
        }

    }
}