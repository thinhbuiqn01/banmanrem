package com.example.cuoiky_thuchanh;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get Quyen Truy Cap
        Intent intent= getIntent();
        int quyenTruyCap= intent.getIntExtra("quyenTruyCap",0);
        drawerLayout= findViewById(R.id.drawer_layout);
        Toast.makeText(this,String.valueOf(quyenTruyCap),Toast.LENGTH_SHORT).show();
    }
    public void ClickMenu(View view)
    {
        openDrawer(drawerLayout);
    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view)
    {
        closeDrawer(drawerLayout);
    }
    public static void closeDrawer(DrawerLayout drawerLayout)
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public void ClickHome(View view)
    {
        recreate();
    }
    public void ClickDanhSach(View view)
    {
        rederictActivity(this,DanhSach.class);
    }
    public void ClickCaNhan(View view)
    {
        rederictActivity(this,CaNhan.class);
    }
    public void ClickDangXuat(View view)
    {
        logout(this);
    }

    public static void logout(Activity activity) {
        AlertDialog.Builder builder= new AlertDialog.Builder(activity);
        builder.setTitle("Đăng xuất");
        builder.setMessage("Bạn có muốn đăng xuất?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }


    public static void rederictActivity(Activity activity,Class aClass) {
        Intent intent= new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}