package com.example.mainpage.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mainpage.R;



public class MyHorRecyclerListViewAdapter extends RecyclerView.Adapter<MyHorRecyclerListViewAdapter.rvHolder>{
    private Context mContext;

public MyHorRecyclerListViewAdapter(Context context){
    this.mContext=context;
}



    @NonNull
    @Override
    public rvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
   return new rvHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_hor_recycler_list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull rvHolder holder, int position) {
        switch (position){
            case 0:
                holder.iv1.setImageResource(R.drawable.ic_re_1);
                holder.iv2.setImageResource(R.drawable.ic_re_7);
                holder.tv1.setText("找活动");
                holder.tv2.setText("信用分");
                break;
            case 1:
                holder.iv1.setImageResource(R.drawable.ic_re_2);
                holder.iv2.setImageResource(R.drawable.ic_re_8);
                holder.tv1.setText("找组织");
                holder.tv2.setText("扶贫电商");
                break;
            case 2:
                holder.iv1.setImageResource(R.drawable.ic_re_3);
                holder.iv2.setImageResource(R.drawable.ic_re_9);
                holder.tv1.setText("志愿培训");
                holder.tv2.setText("小课堂");
                break;
            case 3:
                holder.iv1.setImageResource(R.drawable.ic_re_4);
                holder.iv2.setImageResource(R.drawable.ic_re_10);
                holder.tv1.setText("领保险");
                holder.tv2.setText("兑福利");
                break;
            case 4:
                holder.iv1.setImageResource(R.drawable.ic_re_5);
                holder.iv2.setImageResource(R.drawable.ic_re_11);
                holder.tv1.setText("违规公示");
                holder.tv2.setText("看资讯");
                break;
            case 5:
                holder.iv1.setImageResource(R.drawable.ic_re_6);
                holder.iv2.setImageResource(R.drawable.ic_re_12);
                holder.tv1.setText("身边公益");
                holder.tv2.setText("爱心榜");
                break;


        }


    }


    @Override
    public int getItemCount() {
        return 6;
    }
    class rvHolder extends RecyclerView.ViewHolder{
        private ImageView iv1;
        private ImageView iv2;
        private TextView tv1;
        private TextView tv2;
    private LinearLayout ll;

        public rvHolder(@NonNull View itemView) {
            super(itemView);
            iv1=(ImageView)itemView.findViewById(R.id.iv_1);
            iv2=(ImageView)itemView.findViewById(R.id.iv_2);
            tv1=(TextView) itemView.findViewById(R.id.tv_1);
            tv2=(TextView) itemView.findViewById(R.id.tv_2);
            int screenWidth = getScreenWidth(mContext);
            LinearLayout linearLayout = itemView.findViewById(R.id.ll);
            ViewGroup.LayoutParams params =linearLayout.getLayoutParams();
            params.width = (screenWidth-50 )/ 5;
           linearLayout.setLayoutParams(params);





        }
    }
    public static int getScreenWidth(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);

        return dm.widthPixels;
    }


}
