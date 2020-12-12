package com.example.apppassiocoffee.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.apppassiocoffee.Adapter.AdapterGridView334;
import com.example.apppassiocoffee.MainActivity;
import com.example.apppassiocoffee.R;
import com.example.apppassiocoffee.model.Milk334;

import java.util.ArrayList;

public class FragmentMilk334 extends Fragment {
    private View mRootView;
    String dieukien334;
    ArrayList<Milk334> arrayList;

    public FragmentMilk334(String dieukien334) {
        this.dieukien334 = dieukien334;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.activity_milk_334,container,false);


        GridView grv = (GridView) mRootView.findViewById(R.id.grvice334);
        Cursor cursor = MainActivity.dataBase334.rawQuery("SELECT * FROM Product WHERE mucsp = '"+dieukien334+"'",null);
        arrayList = new ArrayList<>();
        while (cursor.moveToNext()){

            byte[] hinhanh334 = cursor.getBlob(5);
            Milk334 milk334=new Milk334(hinhanh334,cursor.getString(1),cursor.getInt(3));
            if(cursor.getString(2)==null)
            {
                milk334.setChitiet("Thông tin đang cập nhập");
            }
            else {
                milk334.setChitiet(cursor.getString(2));
            }

            arrayList.add(milk334);
        }
        final AdapterGridView334 adapterGridView334 = new AdapterGridView334(mRootView.getContext(),R.layout.item_grv,arrayList);

        grv.setAdapter(adapterGridView334);



        return mRootView;
    }
}
