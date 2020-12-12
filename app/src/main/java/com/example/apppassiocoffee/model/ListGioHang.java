package com.example.apppassiocoffee.model;

import com.example.apppassiocoffee.GioHang;

import java.util.ArrayList;
import java.util.List;

public class ListGioHang {
    public static List<GioHangModel> gioHangList;

    public ListGioHang()
    {
        if(gioHangList==null)
        {
            gioHangList = new ArrayList<>();
        }
    }
}
