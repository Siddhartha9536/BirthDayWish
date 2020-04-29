package com.images.adapters;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.images.activities.FullStoryOfNews;
import com.images.activities.ShowImageActivity;
import com.images.models.timesofindia.topnews.Image;
import com.images.models.timesofindia.topnews.NewsItemItem;
import com.restaurant.birthdaywish.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterCityNews extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NewsItemItem> items = new ArrayList<>();

    private Context ctx;

    public AdapterCityNews(Context context, List<NewsItemItem> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView brief;
        public TextView caption;
        public TextView dateline;
        public TextView ByLine;
        public LinearLayout by_lyt;
        public LinearLayout date_lyt;
        public LinearLayout head_lyt;
        public ScrollView brief_scroll;

        public OriginalViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.image);
            name = (TextView) v.findViewById(R.id.name);
            brief = (TextView) v.findViewById(R.id.brief);
            caption = (TextView) v.findViewById(R.id.caption);
            ByLine = (TextView) v.findViewById(R.id.ByLine);


            dateline = (TextView) v.findViewById(R.id.dateline);
            brief_scroll = (ScrollView) v.findViewById(R.id.brief_scroll);
            head_lyt = (LinearLayout) v.findViewById(R.id.head_lyt);
            by_lyt = (LinearLayout) v.findViewById(R.id.by_lyt);
            date_lyt = (LinearLayout) v.findViewById(R.id.date_lyt);


        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_city_news, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            NewsItemItem p = items.get(position);
            Image image1 = p.getImage();

            if(p.getHeadLine()!=null){
                if(p.getHeadLine().equals("")){
                    view.head_lyt.setVisibility(View.GONE);
                }else{
                    view.head_lyt.setVisibility(View.VISIBLE);
                    view.name.setText(p.getHeadLine());
                }

            }
            if(p.getDateLine()!=null){
                if(p.getDateLine().equals("")){
                    view.date_lyt.setVisibility(View.GONE);
                }else{
                    view.date_lyt.setVisibility(View.VISIBLE);
                    view.dateline.setText(Html.fromHtml(p.getDateLine() + ""));
                }

            }
            if(p.getStory()!=null){
                if(p.getStory().equals("")){
                    view.brief_scroll.setVisibility(View.GONE);
                }else{
                    view.brief_scroll.setVisibility(View.VISIBLE);
                    view.brief.setText(Html.fromHtml(p.getStory() + ""));
                }
            }

            if(image1.getPhotoCaption()!=null){
                if(image1.getPhotoCaption().equals("")){
                    view.caption.setVisibility(View.GONE);
                }else{
                    view.caption.setVisibility(View.VISIBLE);
                    view.caption.setText(Html.fromHtml("Photo Caption: "+image1.getPhotoCaption() + ""));
                }

            }
            if(p.getByLine()!=null){
                if(p.getByLine().equals("")){
                    view.by_lyt.setVisibility(View.GONE);
                }else{
                    view.by_lyt.setVisibility(View.VISIBLE);
                    view.ByLine.setText(Html.fromHtml("By: "+p.getByLine() + ""));
                }

            }

            if(image1.getPhoto().charAt((image1.getPhoto().length())-1) == '='){
                view.image.post(new Runnable() {
                    @Override
                    public void run() {
                         Picasso.with(ctx)
                        .load(image1.getPhoto().replace("http" , "https") + p.getNewsItemId())
                        .into(view.image);

                    }
                });
            } else {
                view.image.post(new Runnable() {
                    @Override
                    public void run() {
                        Picasso.with(ctx)
                        .load(image1.getPhoto().replace("http" , "https"))
                        .into(view.image);
                    }
                });
            }

            view.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(image1.getPhoto().charAt((image1.getPhoto().length())-1) == '='){
                        Intent n = new Intent(ctx , ShowImageActivity.class);
                        n.putExtra("image_url" , image1.getPhoto().replace("http" , "https") + p.getNewsItemId());
                        ctx.startActivity(n);
                        Animatoo.animateSplit(ctx);

                    } else {
                        Intent n = new Intent(ctx , ShowImageActivity.class);
                        n.putExtra("image_url" , image1.getPhoto().replace("http" , "https"));
                        ctx.startActivity(n);
                        Animatoo.animateSplit(ctx);

                    }
                }
            });

            view.name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(p.getWebURL()!=null ) {
                        if(!p.getWebURL().equals("")){
                            Intent n = new Intent(ctx, FullStoryOfNews.class);
                            n.putExtra("url", p.getWebURL());
                            ctx.startActivity(n);
                        }
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}