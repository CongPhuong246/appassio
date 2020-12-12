package com.example.apppassiocoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apppassiocoffee.Adapter.AdapterTabLayout334;
import com.example.apppassiocoffee.model.GioHangModel;
import com.example.apppassiocoffee.model.ListGioHang;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ChonMon extends AppCompatActivity {
    public static RelativeLayout relativeLayout;
    ImageView igback334;
    TextView xemgiohang334;
    public static TextView tongtien334;
    public static TextView soluong334;

    private ViewPager mVp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon_mon);
        initView();
        relativeLayout = (RelativeLayout) findViewById(R.id.giohang334);
        tongtien334 =findViewById(R.id.tongtiengiohang334);
        soluong334 =findViewById(R.id.slggiohang334);
        showGioHang();
        xemgiohang334 = (TextView)findViewById(R.id.xemgiohang334);
        xemgiohang334.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChonMon.this,GioHang.class);
                startActivity(intent);
            }
        });

        igback334 = (ImageView)findViewById(R.id.ig_back334);
        igback334.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChonMon.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.Vpcoffee_334);
        mVp.setAdapter(new AdapterTabLayout334(getSupportFragmentManager()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabcoffee_334);
        tabLayout.setupWithViewPager(mVp);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public static void showGioHang(){
        if (new ListGioHang().gioHangList.size()>0)
        {
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
            tongtien334.setText(tongien+".000 đ");
            soluong334.setText(tongsl+" món");
            relativeLayout.setVisibility(View.VISIBLE);
        }
        else {
            relativeLayout.setVisibility(View.GONE);
        }
    }
}