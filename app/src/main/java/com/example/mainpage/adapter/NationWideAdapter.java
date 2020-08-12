package com.example.mainpage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainpage.R;
import com.example.mainpage.entity.NationWideEntity;

import java.util.ArrayList;
import java.util.List;

public class NationWideAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<NationWideEntity> mDates;


    public NationWideAdapter(Context context, List<NationWideEntity> dates) {
        this.mContext = context;
        this.mDates = dates;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_nation_wide_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        NationWideEntity nationWideEntity = mDates.get(position);
        vh.tvTitle.setText(nationWideEntity.getTitle());
        vh.tvAuthor.setText(nationWideEntity.getAuthor());
        vh.ivHead.setImageResource(nationWideEntity.getHead());
        vh.ivPic.setImageResource(nationWideEntity.getPic());
        vh.tvTime.setText(nationWideEntity.getTime());
    }

    @Override
    public int getItemCount() {
        return mDates.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvAuthor;
        private ImageView ivHead;
        private ImageView ivPic;
        private TextView tvTime;

        public ViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvAuthor = view.findViewById(R.id.tv_author);
            ivHead = view.findViewById(R.id.iv_head);
            ivPic = view.findViewById(R.id.iv_pic);
            tvTime = view.findViewById(R.id.tv_time);

        }
    }
}
