package com.example.cuoiky_thuchanh;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class login extends AppCompatActivity {
    TextView textView;
    EditText usernameText,passText;
    Button button;
    ArrayList<taiKhoan> listTaiKhoan;
    String url="http://10.0.131.236:8080/Android/thuchanh/taiKhoan.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        listTaiKhoan= new ArrayList<>();
        setContentView(R.layout.activity_login);
        textView = findViewById(R.id.xemdaotao);
        usernameText= findViewById(R.id.username);
        button= findViewById(R.id.button_dangnhap);
        passText= findViewById(R.id.password);
        readjson(url);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://daotao.ute.udn.vn"));
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangNhap(usernameText.getText().toString(),passText.getText().toString());
            }
        });
    }
    private void readjson(String url)
    {

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest request= new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i=0;i<response.length();i++)
                        {
                            try {
                                JSONObject data= response.getJSONObject(i);
                                listTaiKhoan.add(new taiKhoan(
                                        data.getInt("id"),
                                        data.getInt("quyenTruyCap"),
                                        data.getString("tenDangNhap"),
                                        data.getString("matKhau")
                                ));
                            } catch (JSONException e) {
                                Toast.makeText(login.this,e.toString(),Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(login.this,error.toString(),Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(request);
    }
    private taiKhoan kiemtrausername(String username)
    {
        for (taiKhoan user: listTaiKhoan) {
            if (user.getTenDangNhap().equals(username))
                return user;
        }
        return null;
    }

    private int kiemtrapass(String username,String pass) {
        taiKhoan taiKhoanPass;
        taiKhoanPass = kiemtrausername(username);
        if (taiKhoanPass == null)
            return 0;
        else
        {
            if(!(taiKhoanPass.getMatKhau().equals(pass)))
                return 3;
            else
            {
                if(taiKhoanPass.getMaQuyenTruyCap()==1)
                    return 1; else return 2;
            }
        }
    }
    private void DangNhap(String username,String password)
    {
        if(kiemtrapass(username,password)==1)
        {
            Intent intent = new Intent(login.this,MainActivity.class);
            intent.putExtra("quyenTruyCap",1);
            startActivity(intent);
        }else
        if(kiemtrapass(username,password)==2)
        {
            Intent intent = new Intent(login.this,MainActivity.class);
            intent.putExtra("quyenTruyCap",2);
            startActivity(intent);
        } else
                if(kiemtrapass(username,password)==3)
                    Toast.makeText(login.this,"Sai mật khẩu",Toast.LENGTH_SHORT).show(); else
            Toast.makeText(login.this,"Sai tài khoản",Toast.LENGTH_SHORT).show();
    }
}