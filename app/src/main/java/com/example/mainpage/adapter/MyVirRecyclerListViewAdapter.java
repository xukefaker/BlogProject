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

public class MyVirRecyclerListViewAdapter  extends RecyclerView.Adapter<MyVirRecyclerListViewAdapter.rvHolder>{
    private Context mContext;

    public MyVirRecyclerListViewAdapter(Context context){
        this.mContext=context;
    }
    @NonNull
    @Override
    public rvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         return new MyVirRecyclerListViewAdapter.rvHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_ver_recycler_list_view, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull rvHolder holder, int position) {
          switch (position){
              case 0:
                  holder.iv1.setImageResource(R.drawable.ic_re_bo_1);
                  holder.tv1.setText("志愿汇消费扶贫推广志愿者招募");
                  holder.tv2.setText("消费扶贫 补录荣誉时长");
                  break;
              case 1:
                  holder.iv1.setImageResource(R.drawable.ic_re_bo_2);
                  holder.tv1.setText("志愿汇消费扶贫推广志愿者招募");
                  holder.tv2.setText("消费扶贫 补录荣誉时长");
                  break;
              case 2:
                  holder.iv1.setImageResource(R.drawable.ic_re_bo_3);
                  holder.tv1.setText("志愿汇消费扶贫推广志愿者招募");
                  holder.tv2.setText("消费扶贫 补录荣誉时长");
                  break;
              case 3:
                  holder.iv1.setImageResource(R.drawable.ic_re_bo_4);
                  holder.tv1.setText("志愿汇消费扶贫推广志愿者招募");
                  holder.tv2.setText("消费扶贫 补录荣誉时长");
                  break;
              case 4:
                  holder.iv1.setImageResource(R.drawable.ic_re_bo_5);
                  holder.tv1.setText("志愿汇消费扶贫推广志愿者招募");
                  holder.tv2.setText("消费扶贫 补录荣誉时长");
                  break;
          }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class rvHolder extends RecyclerView.ViewHolder{
        private ImageView iv1;

        private TextView tv1;
        private TextView tv2;


        public rvHolder(@NonNull View itemView) {
            super(itemView);
            iv1=(ImageView)itemView.findViewById(R.id.iv_1);

            tv1=(TextView) itemView.findViewById(R.id.tv_1);
            tv2=(TextView) itemView.findViewById(R.id.tv_2);
            int screenWidth = getScreenWidth(mContext);
            LinearLayout linearLayout = itemView.findViewById(R.id.ll);
            ViewGroup.LayoutParams params =linearLayout.getLayoutParams();
            params.width = screenWidth ;

            linearLayout.setLayoutParams(params);





        }
    }
    public static int getScreenWidth(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
//        int width = dm.widthPixels;         // 屏幕宽度（像素）
//        int height = dm.heightPixels;       // 屏幕高度（像素）
//        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
//        int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
//        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
//        int screenWidth = (int) (width / density);  // 屏幕宽度(dp)
//        int screenHeight = (int) (height / density);// 屏幕高度(dp)
        return dm.widthPixels;
    }
}
