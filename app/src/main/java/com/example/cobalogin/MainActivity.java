package com.example.cobalogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    KendaliLogin KL = new KendaliLogin();
    private TextView tvSesi;
    private String ambilSesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!KL.isLogin(MainActivity.this, "spPadang")) {
            startActivity(new
                    Intent(MainActivity.this, LoginActivity.class));
            finish();
        } else {
            setContentView(R.layout.activity_main);
            ambilSesi = KL.getPref(MainActivity.this, "spPadang");
            tvSesi = findViewById(R.id.tv_sesi);
            tvSesi.setText(ambilSesi);
        }
    }

    public void prosesLogout(View view) {
        KL.setPref(MainActivity.this, "spPadang", null);
        startActivity(new Intent(MainActivity.this,
                LoginActivity.class));
        finish();
    }
}