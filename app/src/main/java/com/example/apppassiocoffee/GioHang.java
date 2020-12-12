package com.example.apppassiocoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apppassiocoffee.Adapter.AdapterRecycler334;
import com.example.apppassiocoffee.Adapter.AdapterRecyclerGioHang;
import com.example.apppassiocoffee.model.GioHangModel;
import com.example.apppassiocoffee.model.ListGioHang;

import java.util.List;

public class GioHang extends AppCompatActivity {
    RecyclerView lv;
    TextView tamtinh;
    TextView tongtien_vl1;
    TextView tongTien_vl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        lv = findViewById(R.id.rcv_chitietdonhang_334);
        LinearLayoutManager layoutManager334= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        lv.setLayoutManager(layoutManager334);
        AdapterRecyclerGioHang adapterRecycler334 = new AdapterRecyclerGioHang(this,new ListGioHang().gioHangList);
        lv.setAdapter(adapterRecycler334);
        tamtinh = findViewById(R.id.thanhtien_giohang_334);
        tongtien_vl1 = findViewById(R.id.value_tong334);
        tongTien_vl2 = findViewById(R.id.tongtiendathang334);
        List<GioHangModel> gioHangModels = new ListGioHang().gioHangList;
        int tongien=0;
        int tongsl=0;
        for (int i =0;i< (gioHangModels.size());i++){
            tongsl+=gioHangModels.get(i).getSlg334();
            if(gioHangModels.get(i).getSize334()=="M")
                tongien+=gioHangModels.get(i).getGia334()*gioHangModels.get(i).getSlg334();
            else
                tongien+=gioHangModels.get(i).getGia334()*gioHangModels.get(i).getSlg334() +10*gioHangModels.get(i).getSlg334();
        }
        tamtinh.setText(tongien+".000 đ");
        tongtien_vl1.setText(tongien+".000 đ");
        tongTien_vl2.setText(tongien+".000 đ");

    }
}