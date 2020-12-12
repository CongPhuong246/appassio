package com.example.apppassiocoffee.Adapter;

import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.apppassiocoffee.Fragment.FragmentMilk334;
import com.example.apppassiocoffee.MainActivity;

import java.util.List;

public class AdapterTabLayout334 extends FragmentStatePagerAdapter {
    private List<String> listTab;
    private FragmentMilk334 Ice334;
    private Cursor cursor;


    public AdapterTabLayout334(@NonNull FragmentManager fm) {
        super(fm);
        cursor = MainActivity.dataBase334.rawQuery("SELECT mucsp FROM Product Group by mucsp",null);
    }

    @NonNull
    @Override
    public androidx.fragment.app.Fragment getItem(int position) {
        cursor.moveToPosition(position);
        return new FragmentMilk334(cursor.getString(0));
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        cursor.moveToPosition(position);
        return cursor.getString(0);
    }
}
