package com.example.apppassiocoffee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.apppassiocoffee.Adapter.AdapterGridView334;
import com.example.apppassiocoffee.Adapter.AdapterRecycler334;
import com.example.apppassiocoffee.model.Milk334;
import com.example.apppassiocoffee.model.TinTuc334;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView igchon_334;
    RecyclerView lvtintuc334;
    LinearLayout   linearLayout;
    ArrayList<TinTuc334> arr334;
    AdapterRecycler334 adapter334;
    NestedScrollView nestedScrollView;
    String DATABASE_NAME334 ="Passio.db";


    public static SQLiteDatabase dataBase334;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout =findViewById(R.id.trangchu);
        linearLayout.scrollTo(0,0);
        nestedScrollView = findViewById(R.id.trangchu_01);
        nestedScrollView.scrollTo(0,0);
        igchon_334 = (ImageView) findViewById(R.id.igchon334);
        igchon_334.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent334 = new Intent(MainActivity.this,ChonMon.class);
                startActivity(intent334);
            }
        });

        dataBase334 = DataBase334.initDatabase(this,DATABASE_NAME334);
        Anhxa334();
    }

    private void Anhxa334() {
        lvtintuc334 = (RecyclerView) findViewById(R.id.lv_334);
        lvtintuc334.setHasFixedSize(true);
        LinearLayoutManager layoutManager334= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        lvtintuc334.setLayoutManager(layoutManager334);
        DividerItemDecoration itemDecoration334 = new DividerItemDecoration(this,layoutManager334.getOrientation());
        lvtintuc334.addItemDecoration(itemDecoration334);

        Cursor cursor = MainActivity.dataBase334.rawQuery("SELECT * FROM Tintuc",null);
        arr334 = new ArrayList<>();
        while (cursor.moveToNext()){

            byte[] hinhanh334 = cursor.getBlob(1);
            TinTuc334 tinTuc334=new TinTuc334(hinhanh334,cursor.getString(2),cursor.getString(3));
            arr334.add(tinTuc334);
        }

        adapter334 = new AdapterRecycler334(this,arr334);
        lvtintuc334.setAdapter(adapter334);

    }
}