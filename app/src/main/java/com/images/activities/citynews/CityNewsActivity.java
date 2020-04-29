package com.images.activities.citynews;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.images.GenerateToast;
import com.images.common.ViewAnimation;
import com.images.fragments.FragmentTabsStore;
import com.images.models.timesofindia.ItemItem;
import com.images.models.timesofindia.citynews.CityRes;
import com.restaurant.birthdaywish.R;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CityNewsActivity extends AppCompatActivity {

    private ViewPager view_pager;
    private TabLayout tab_layout;
    private final static int LOADING_DURATION = 5500;
    ItemItem itemItem;
    List<com.images.models.timesofindia.citynews.ItemItem> itemItems;
    Context context;
    @BindView(R.id.lyt_progress)
    LinearLayout lyt_progress;
    @BindView(R.id.heading_text)
    TextView heading_text;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_news);

        context = CityNewsActivity.this;
        ButterKnife.bind(this);
        itemItem = (ItemItem) getIntent().getSerializableExtra("data");
        Log.d("TAG", "onCreate: " + itemItem.toString());
        if(itemItem!=null){
            heading_text.setText(itemItem.getDefaultname());
        }

        lyt_progress.setVisibility(View.VISIBLE);
        lyt_progress.setAlpha(1.0f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewAnimation.fadeOut(lyt_progress);
            }
        }, LOADING_DURATION);

        OkHttpHandler ok = new OkHttpHandler();
        ok.execute();


    }

    @OnClick(R.id.back_icon)
    public void back(){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSplit(context);
    }

    private void initComponent() {

        view_pager = (ViewPager) findViewById(R.id.view_pager);

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        for(int i=0;i<itemItems.size();i++){
            adapter.addFragment(FragmentTabsStore.newInstance(itemItems.get(i)), itemItems.get(i).getCategory());
            Log.d("TAG", "initComponent: "+itemItems.get(i).getCategory());
        }

        view_pager.setAdapter(adapter);


        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout.setupWithViewPager(view_pager);
    }


    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public class OkHttpHandler extends AsyncTask<String,String,String> {


        @Override
        protected String doInBackground(String...params) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(itemItem.getSectionurl().replace("http", "https"))
                    .get()
                    .build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                lyt_progress.setVisibility(View.GONE);
                Gson gson = new Gson();

                CityRes cityRes = gson.fromJson(s,CityRes.class);
                itemItems = cityRes.getItem();
                initComponent();


            } catch (Exception e){
                GenerateToast.showErrorToastWOI(context, e.toString());
            }
        }
    }


}