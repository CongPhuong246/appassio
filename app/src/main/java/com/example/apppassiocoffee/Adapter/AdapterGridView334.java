package com.example.apppassiocoffee.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.apppassiocoffee.ChonMon;
import com.example.apppassiocoffee.GioHang;
import com.example.apppassiocoffee.R;
import com.example.apppassiocoffee.model.GioHangModel;
import com.example.apppassiocoffee.model.ListGioHang;
import com.example.apppassiocoffee.model.Milk334;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class AdapterGridView334 extends ArrayAdapter<Milk334> {
    private Context context;
    private int resource;
    int tong334;
    int nhap334;
    String size="M";
    private ArrayList<Milk334> arrList;


    public AdapterGridView334(@NonNull Context context, int resource, ArrayList<Milk334> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrList=objects;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_grv,parent,false);
        ImageView igmilk334 = (ImageView) convertView.findViewById(R.id.igmilk_334);
        TextView tenmilk334 = (TextView) convertView.findViewById(R.id.tenmilk_334);
        TextView giamilk334 = (TextView) convertView.findViewById(R.id.giamilk_334);
        LinearLayout sanpham_add = convertView.findViewById(R.id.sanpham_row);
        Milk334 milk334 = arrList.get(position);
        byte[] hinhAnh = milk334.getMigmilk_334();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        igmilk334.setImageBitmap(bitmap);
        tenmilk334.setText(milk334.getMtenmilk_334());
        giamilk334.setText(milk334.getMgiamilk_334()+".000đ");
        sanpham_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView igclose334;


                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context,R.style.BottomSheetDialogTheme);
                View bottomSheetView = LayoutInflater.from(context).inflate(R.layout.dialogbottom334,parent,false);
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
                igclose334 = bottomSheetView.findViewById(R.id.igbackdialog334);
                igclose334.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                    }
                });
                TextView tensp = bottomSheetDialog.findViewById(R.id.tensp_334);
                tensp.setText(milk334.getMtenmilk_334());
                ImageView anhsp = bottomSheetDialog.findViewById(R.id.image_sanpham);
                byte[] hinhAnh = milk334.getMigmilk_334();
                Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
                anhsp.setImageBitmap(bitmap);
                TextView chitietmilk334 = bottomSheetDialog.findViewById(R.id.chitietmilk334);

                chitietmilk334.setText(milk334.getChitiet());
                    chitietmilk334.setText(milk334.getChitiet());
                ImageView tru334;
                ImageView cong334;
                RadioButton sizem334;
                RadioButton sizel334;
                TextView tienmilk334;
                TextView slg334;
                TextView tongtien334;
                TextView themgiohang334;
                TextView gianhap334;

                gianhap334 = bottomSheetView.findViewById(R.id.gianhap334);
                gianhap334.setText(milk334.getMgiamilk_334()+"");
                tienmilk334 = bottomSheetView.findViewById(R.id.giatienmilk334);
                tienmilk334.setText(milk334.getMgiamilk_334()+".000đ");
                slg334 = bottomSheetView.findViewById(R.id.txtslg334);
                tongtien334 = bottomSheetView.findViewById(R.id.txttongtien334);
                tongtien334.setText(milk334.getMgiamilk_334()+".000đ");
                tru334 = bottomSheetView.findViewById(R.id.igtru334);
                tru334.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (Integer.parseInt(slg334.getText().toString())>1){
                            slg334.setText(String.valueOf(Integer.parseInt(slg334.getText().toString())-1));

                            nhap334= Integer.parseInt(gianhap334.getText().toString());
                            tong334 = nhap334*Integer.parseInt(slg334.getText().toString());

                            tongtien334.setText(tong334+".000đ");
                        }}
                });
                cong334 = bottomSheetView.findViewById(R.id.igcong334);
                cong334.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        slg334.setText(String.valueOf(Integer.parseInt(slg334.getText().toString())+1));
                        nhap334= Integer.parseInt(gianhap334.getText().toString());
                        tong334 = nhap334*Integer.parseInt(slg334.getText().toString());

                        tongtien334.setText(tong334+".000đ");
                    }
                });
                sizem334 = bottomSheetView.findViewById(R.id.rbtsizem334);
                sizem334.setChecked(true);
                sizem334.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tong334 = milk334.getMgiamilk_334()*Integer.parseInt(slg334.getText().toString());
                        size ="M";
                        tongtien334.setText(tong334+".000đ");
                        tienmilk334.setText(milk334.getMgiamilk_334()+".000đ");
                        gianhap334.setText(milk334.getMgiamilk_334()+"");
                    }
                });

                sizel334 = bottomSheetView.findViewById(R.id.rbtsizel334);
                sizel334.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tong334 = (milk334.getMgiamilk_334()+10)*Integer.parseInt(slg334.getText().toString());
                        size="L";
                        tongtien334.setText(tong334+".000đ");
                        tienmilk334.setText((milk334.getMgiamilk_334()+10)+".000đ");
                        gianhap334.setText((milk334.getMgiamilk_334()+10)+"");
                    }
                });

                themgiohang334 = bottomSheetView.findViewById(R.id.themgiohang334);
                themgiohang334.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        GioHangModel gioHang = new GioHangModel(tenmilk334.getText().toString(),size,Integer.parseInt(slg334.getText().toString()),Integer.parseInt(gianhap334.getText().toString()),hinhAnh);
                        new ListGioHang().gioHangList.add(gioHang);
                        bottomSheetDialog.dismiss();
                        ChonMon.showGioHang();
                    }
                });

            }
        });

        return convertView;
    }
}
