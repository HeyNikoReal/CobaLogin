package com.example.cobalogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    KendaliLogin KL = new KendaliLogin();
    private TextView tvSesi, tvNama;
    private String ambilSesi, ambilSesi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((!KL.isLogin(MainActivity.this, "spPadang") || (!KL.isLogin(MainActivity.this, "spPadangs")))) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        } else {
            setContentView(R.layout.activity_main);
            ambilSesi = KL.getPref(MainActivity.this, "spPadang");
            ambilSesi2 = KL.getPref(MainActivity.this, "spPadangs");
            tvSesi = findViewById(R.id.tv_sesi);
            tvNama = findViewById(R.id.tv_name);
            tvSesi.setText(ambilSesi);
            tvNama.setText(ambilSesi2);
        }
    }

    public void prosesLogout(View view) {
        KL.setPref(MainActivity.this, "spPadang", null);
        KL.setPref(MainActivity.this, "spPadangs", null);
        startActivity(new Intent(MainActivity.this,
                LoginActivity.class));
        finish();
    }
}