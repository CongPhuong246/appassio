package com.example.apppassiocoffee.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apppassiocoffee.R;
import com.example.apppassiocoffee.model.Milk334;
import com.example.apppassiocoffee.model.TinTuc334;

import java.util.List;

public class AdapterRecycler334 extends RecyclerView.Adapter<AdapterRecycler334.PostViewHolder> {
    private Context context334;
    private List<TinTuc334> list334;

    public AdapterRecycler334(Context context334, List<TinTuc334> list334) {
        this.context334 = context334;
        this.list334 = list334;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lv,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.tentintuc334.setText(list334.get(position).getMtentintuc_334());
        TinTuc334 tinTuc334 = list334.get(position);
        byte[] hinhAnh = tinTuc334.getMigtintuc_334();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        holder.anhtintuc334.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return list334.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{
        TextView tentintuc334;
        ImageView anhtintuc334;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tentintuc334 = (TextView) itemView.findViewById(R.id.tentintuc_334);
            anhtintuc334 = (ImageView) itemView.findViewById(R.id.igtintuc_334);
        }
    }
}
