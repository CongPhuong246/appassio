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
import com.example.apppassiocoffee.model.GioHangModel;

import java.util.List;

public class AdapterRecyclerGioHang extends RecyclerView.Adapter<AdapterRecyclerGioHang.PostViewHolder> {
    private Context context334;
    private List<GioHangModel> list334;

    public AdapterRecyclerGioHang(Context context334, List<GioHangModel> list334) {
        this.context334 = context334;
        this.list334 = list334;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giohang,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.tenmilkgiohang334.setText(list334.get(position).getTen334());
        GioHangModel gioHangModel = list334.get(position);
        byte[] hinhAnh = gioHangModel.getAnh334();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        holder.anhmilkgiohang334.setImageBitmap(bitmap);
        holder.sizemilkgiohang334.setText(list334.get(position).getSize334());
        holder.slgmilkgiohang334.setText(list334.get(position).getSlg334()+"");
        holder.giamilkgiohang334.setText(list334.get(position).getGia334()+".000đ");
    }

    @Override
    public int getItemCount() {
        return list334.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{
        TextView tenmilkgiohang334;
        ImageView anhmilkgiohang334;
        TextView sizemilkgiohang334;
        TextView slgmilkgiohang334;
        TextView giamilkgiohang334;


        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            tenmilkgiohang334 = (TextView) itemView.findViewById(R.id.tenmilkgiohang334);
            anhmilkgiohang334 = (ImageView) itemView.findViewById(R.id.igmilkgiohang334);
            sizemilkgiohang334 = (TextView) itemView.findViewById(R.id.sizemilkgiohang334);
            slgmilkgiohang334 = (TextView) itemView.findViewById(R.id.slgmilkgiohang334);
            giamilkgiohang334 = (TextView) itemView.findViewById(R.id.giamilkgiohang334);
        }
    }
}
