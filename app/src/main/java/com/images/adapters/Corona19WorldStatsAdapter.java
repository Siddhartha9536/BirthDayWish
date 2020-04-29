package com.images.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.images.models.indiaStatewise.Covid19India;
import com.images.models.worldcovidstatus.Cases;
import com.images.models.worldcovidstatus.Deaths;
import com.images.models.worldcovidstatus.Tests;
import com.restaurant.birthdaywish.R;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Corona19WorldStatsAdapter extends RecyclerView.Adapter<Corona19WorldStatsAdapter.MyView> {

    ArrayList<String> countyArrayList;
    ArrayList<Cases> casesArrayList;
    ArrayList<Tests> testsArrayList;
    ArrayList<Deaths> deathsArrayList;
    ArrayList<String> dayArrayList;
    ArrayList<String> timeArrayList;
    Context mContext;

    public Corona19WorldStatsAdapter(ArrayList<String> countyArrayList, ArrayList<Cases> casesArrayList, ArrayList<Tests> testsArrayList, ArrayList<Deaths> deathsArrayList, ArrayList<String> dayArrayList, ArrayList<String> timeArrayList, Context mContext) {
        this.countyArrayList = countyArrayList;
        this.casesArrayList = casesArrayList;
        this.testsArrayList = testsArrayList;
        this.deathsArrayList = deathsArrayList;
        this.dayArrayList = dayArrayList;
        this.timeArrayList = timeArrayList;
        this.mContext = mContext;
    }


    public class MyView extends RecyclerView.ViewHolder {

        public TextView country_name;
        public TextView new_cases;
        public TextView active_cases;
        public TextView critical_cases;
        public TextView recovered_cases;
        public TextView total_cases;
        public TextView total_deaths;
        public TextView new_deaths;
        public TextView total_tests;
        public TextView day;
        public TextView time;

//        public ImageView covid_mask_icon;
        public ImageView dropdown;
        public CardView all_details;

        public MyView(View view) {
            super(view);

            country_name =view.findViewById(R.id.country_name);
            new_cases =view.findViewById(R.id.new_cases);
            active_cases =view.findViewById(R.id.active_cases);
            critical_cases =view.findViewById(R.id.critical_cases);
            recovered_cases =view.findViewById(R.id.recovered_cases);
            total_cases =view.findViewById(R.id.total_cases);
            total_deaths =view.findViewById(R.id.total_deaths);
            new_deaths =view.findViewById(R.id.new_deaths);
            total_tests =view.findViewById(R.id.total_tests);
            day =view.findViewById(R.id.day);
            time =view.findViewById(R.id.time);
//            covid_mask_icon =view.findViewById(R.id.covid_mask_icon);
            dropdown =view.findViewById(R.id.dropdown);
            all_details =view.findViewById(R.id.all_details);
        }
    }




    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.corona_country_stats1, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, final int position) {

        String countryName = countyArrayList.get(position);
        Cases cases = casesArrayList.get(position);
        Tests tests = testsArrayList.get(position);
        Deaths deaths = deathsArrayList.get(position);
        String date = dayArrayList.get(position);
        String time = timeArrayList.get(position);
        if(countryName!=null) {
            if (!countryName.equals("")) {
                NumberFormat formatter = NumberFormat.getNumberInstance(new Locale("en", "IN"));

                holder.country_name.setText(countryName +"");

                holder.new_cases.setText(formatter.format(cases.getTotal()  ) +"");
                holder.active_cases.setText(formatter.format(cases.getActive() )+ "");
                holder.critical_cases.setText(formatter.format(cases.getCritical()) +"");
                holder.recovered_cases.setText(formatter.format(cases.getRecovered()) + "");
                holder.total_cases.setText(formatter.format(cases.getTotal())+"");

                holder.total_deaths.setText(formatter.format(deaths.getTotal())+"");

                if(deaths.getJsonMemberNew()!=null){
                    holder.new_deaths.setText(deaths.getJsonMemberNew().toString());
                }else {
                    holder.new_deaths.setText("0");
                }

                if(tests.getTotal()!=null){
                    holder.total_tests.setText(tests.getTotal().toString());
                }else {
                    holder.total_tests.setText("0");
                }


                holder.day.setText(date +"");
                holder.time.setText(time +"");

                holder.dropdown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(holder.all_details.getVisibility()==View.VISIBLE){
                        holder.all_details.setVisibility(View.GONE);
                        }else{
                            holder.all_details.setVisibility(View.VISIBLE);
                        }
                    }
                });


//                holder.covid_mask_icon.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        Picasso.with(mContext)
//                                .load("https://cdn4.iconfinder.com/data/icons/coronavirus-color/64/mask-wearing-doctor-protection-flu-512.png")
//                                .error(R.drawable.ic_cv_48)
//                                .into(holder.covid_mask_icon);
//                    }
//                });

            }
        }

    }



    @Override
    public int getItemCount() {

       return countyArrayList.size();
    }
}