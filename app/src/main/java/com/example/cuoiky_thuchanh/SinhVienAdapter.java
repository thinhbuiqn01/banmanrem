package com.example.cuoiky_thuchanh;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<SinhVien> sinhVienList;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder
    {
        TextView txtHoten,txtDiaChi,txtNamSinh;
        ImageView imgedit,imgdel;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(layout,null);
            holder.txtHoten=(TextView) view.findViewById(R.id.hotenCustom);
            holder.txtNamSinh=(TextView) view.findViewById(R.id.namsinhCustom);
            holder.txtDiaChi=(TextView) view.findViewById(R.id.diachiCustom);
            holder.imgedit= (ImageView) view.findViewById(R.id.editSV);
            holder.imgdel= (ImageView) view.findViewById(R.id.deleteSV);
            view.setTag(holder);
        }
        else {
            holder= (ViewHolder) view.getTag();
        }
        SinhVien sinhVien= sinhVienList.get(i);
        holder.txtHoten.setText(sinhVien.getTenSV());
        holder.txtDiaChi.setText(sinhVien.getDiachi());
        holder.txtNamSinh.setText(sinhVien.getNgaysinh());
        return view;
    }
}