package com.android.sistempakar.semangka_merah;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.android.sistempakar.semangka_merah.JenisPenyakit.JenisPenyakitAct;
import com.android.sistempakar.semangka_merah.Konsultasi.KonsultasiAct;

import static android.R.attr.x;
import static android.R.attr.y;

public class HomeAct extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        LinearLayout btn_konsultasi = findViewById(R.id.btn_konsultasi);
        btn_konsultasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotokonsul = new Intent(HomeAct.this, KonsultasiAct.class);
                startActivity(gotokonsul);
            }
        });

        LinearLayout btn_penyakit = findViewById(R.id.btn_penyakit);
        btn_penyakit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent gotopenyakit = new Intent(getApplicationContext(), JenisPenyakitAct.class);
                startActivity(gotopenyakit);
                Toast.makeText(HomeAct.this, "Ketuk Nama Penyakit untuk Menampilkan Detail Informasi Penyakit", Toast.LENGTH_LONG).show();
            }
        });

        LinearLayout about = findViewById(R.id.btn_tentang);
        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AboutAct.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Yakin mau keluar?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed yes
                finishAffinity();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed no
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
