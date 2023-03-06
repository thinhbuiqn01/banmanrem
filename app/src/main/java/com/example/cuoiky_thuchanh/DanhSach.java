package com.example.cuoiky_thuchanh;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DanhSach extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ListView listView;
    ArrayList<SinhVien> arraySv;
    SinhVienAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach);
        drawerLayout= findViewById(R.id.drawer_layout);
        listView = findViewById(R.id.ListViewSV);
        arraySv = new ArrayList<>();
        readJson();
        adapter = new SinhVienAdapter(this, R.layout.dong_sinhvien, arraySv);
        listView.setAdapter(adapter);

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
        recreate();
    }
    public void ClickCaNhan(View view)
    {
        MainActivity.rederictActivity(this,taiKhoan.class);
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
    private void readJson() {
        String url = "http://10.0.131.236:8080/Android/thuchanh/sinhvien.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                arraySv.add(new SinhVien(
                                        data.getInt("id"),
                                        data.getString("maSV"),
                                        data.getString("tenSV"),
                                        data.getString("email"),
                                        data.getString("lop"),
                                        data.getString("diachi"),
                                        data.getString("gioitinh"),
                                        data.getString("ngaysinh"),
                                        data.getString("anh")
                                ));
                            } catch (JSONException e) {
                                Toast.makeText(DanhSach.this, e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DanhSach.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(request);
    }
}