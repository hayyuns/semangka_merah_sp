package com.android.sistempakar.semangka_merah.Konsultasi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.sistempakar.semangka_merah.Database;
import com.android.sistempakar.semangka_merah.HomeAct;
import com.android.sistempakar.semangka_merah.JenisPenyakit.JenisPenyakitAct;
import com.android.sistempakar.semangka_merah.R;


public class hasil_deteksi extends AppCompatActivity {

    protected Cursor cursor;
    Database dbHelper;
    TextView final_result;
    TextView nama_penyakit;
    private Database datapenyakit;
    private SQLiteDatabase db2;

    public hasil_deteksi() {
        db2 = null;
        datapenyakit = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_deteksi);

        dbHelper = new Database(this);
        datapenyakit = new Database(this);
        db2 = datapenyakit.getWritableDatabase();
        datapenyakit.createTable2(db2);
        datapenyakit.generateData2(db2);

        final_result = findViewById(R.id.final_result);
        TextView persen = findViewById(R.id.persen);
        TextView judul_keterangan = findViewById(R.id.textView5);
        nama_penyakit = findViewById(R.id.namapenyakit);
        TextView penyakitnol = findViewById(R.id.penyakitnol);

        Button carisolusi = findViewById(R.id.btn_cari);
        Button Mulailagi = findViewById(R.id.btn_ulang);
        ImageView btn_back = findViewById(R.id.btn_back);

        cursor = this.dbHelper.getReadableDatabase().rawQuery("SELECT * FROM penyakit WHERE kode_penyakit = '"
                + getIntent().getStringExtra("nama")+"' ", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            judul_keterangan.setVisibility(View.VISIBLE);
            carisolusi.setVisibility(View.VISIBLE);
            nama_penyakit.setText(cursor.getString(1).toString());
            final_result.setText(getIntent().getStringExtra("namagejala"));
            persen.setText(getIntent().getStringExtra("persen"));

        }else{
            final_result.setText(getIntent().getStringExtra("namagejala"));
            final_result.setText("Tidak ada gejala yang dipilih");
            judul_keterangan.setVisibility(View.INVISIBLE);
            carisolusi.setVisibility(View.INVISIBLE);
        }
        penyakitnol.setText(getIntent().getStringExtra("namanol"));



        carisolusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocari = new Intent(hasil_deteksi.this, JenisPenyakitAct.class);
                startActivity(gotocari);
            }
        });

        Mulailagi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent gotomulailagi = new Intent(hasil_deteksi.this, KonsultasiAct.class);
                startActivity(gotomulailagi);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(hasil_deteksi.this, HomeAct.class);
                startActivity(gotohome);
            }
        });

    }
    public void onBackPressed() {

    }
}
