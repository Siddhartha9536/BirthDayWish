package com.images.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.images.models.homeitems.HomeItems;
import com.images.models.timesofindia.ItemItem;
import com.restaurant.birthdaywish.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterNewsCategory extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemItem> items = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, ItemItem obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterNewsCategory(Context context, List<ItemItem> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView title_template;
        public View lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.image);
            title = (TextView) v.findViewById(R.id.title);
            title_template = (TextView) v.findViewById(R.id.title_template);
            lyt_parent = (View) v.findViewById(R.id.lyt_parent);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.breaking_news, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            ItemItem p = items.get(position);
            view.title.setText(p.getName());
            view.title_template.setText(p.getTemplate());
//            view.image.setImageDrawable(p.getDefaultname());
            view.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, items.get(position), position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(items.size()>1){
        return 2;
        }else{
            return items.size();
        }
    }

}