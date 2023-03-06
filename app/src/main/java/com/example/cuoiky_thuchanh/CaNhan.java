package com.example.cuoiky_thuchanh;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CaNhan extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca_nhan);
        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View view)
    {
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view)
    {
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view)
    {
        MainActivity.rederictActivity(this,MainActivity.class);
    }
    public void ClickDanhSach(View view)
    {
        MainActivity.rederictActivity(this,DanhSach.class);
    }
    public void ClickCaNhan(View view)
    {
        recreate();
    }

    public void ClickDangXuat(View view)
    {
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}