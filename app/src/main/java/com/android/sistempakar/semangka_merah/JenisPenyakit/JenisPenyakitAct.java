package com.android.sistempakar.semangka_merah.JenisPenyakit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.sistempakar.semangka_merah.HomeAct;
import com.android.sistempakar.semangka_merah.R;

import java.util.ArrayList;

public class JenisPenyakitAct extends AppCompatActivity {

    private static final String TAG = "JenisKelinciAct";

    //vars
    private ArrayList<String> mNamaPenyakit = new ArrayList<>();
    private ArrayList<String> mDefinisi = new ArrayList<>();
    private ArrayList<String> mGejala = new ArrayList<>();
    private ArrayList<String> mSolusi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_penyakit);

        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();

        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(JenisPenyakitAct.this, HomeAct.class);
                startActivity(gotohome);
            }
        });
    }

    private void initImageBitmaps(){
       // Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mNamaPenyakit.add("Layu Fusarium");
        mDefinisi.add("Penyakit ini disebabkan oleh Cendawan Fusarium Oxysporum. \n" +
                "\nGejala terlihat jika ada tanaman yang tampak segar di pagi hari dan layu pada siang hari, kemudian segar kembali pada sore hari.\n");
        mGejala.add("1.\tTanaman tampak Layu seperti kekurangan Air.\n" +
                "2.\tTanaman pagi dan sore hari tampak segar.\n" +
                "3.\tTanaman mengering.\n");
        mSolusi.add("1.\tFumigasi.\n" +
                "2.\tRotasi Tanaman.\n" +
                "3.\tSolarisasi Tanah.\n" +
                "4.\tPengendalian Hayati.\n");

        mNamaPenyakit.add("Layu Bakteri");
        mDefinisi.add("Penyakit ini disebabkan oleh bakteri Erwinia Tracheiphila.\n" +
                "\nTanaman layu permanen dan jika tanaman di potong melintang akan tampak pembuluh xylemnya menghitam.\n");
        mGejala.add("1.\tTanaman Mengalami layu permanen.\n" +
                "2.\tSaat tanaman di potong tampak pembuluh xylemnya menghitam.\n");
        mSolusi.add("1.\tMencabut , Membakar, dan Membuang tanaman yang terinfeksi.\n" +
                "2.\tSemprotkan Bakterisida Agrinicin dan Fungisida berbahan aktif CU (Tembaga).\n");

        mNamaPenyakit.add("Antraknosa");
        mDefinisi.add("Penyakit ini disebut Penyakit Krapak atau Kresek.\n" +
                "\nPenyebab penyakit Antraknosa ini adalah Cendawan Colletotrichum.\n");
        mGejala.add("1.\tTimbul Bercak pada tanaman.\n" +
                "2.\tTimbul Bercak kehitaman dengan bagian tengah berwarna putih pada buah.\n" +
                "3.\tSpora Berwarna kemerahan.\n");
        mSolusi.add("1.\tRotasi Tanaman yang bukan sefamily.\n" +
                "2.\tMenjaga Kebersihan Kebun (Sanitasi).\n" +
                "3.\tSemprotkan Fungisida.\n");

        mNamaPenyakit.add("Powder Mildew");
        mDefinisi.add("Penyebab penyakit ini adalah Jamur Spaerotheca Fuliginea Schech.\n");
        mGejala.add("1.\tTimbul Bercak Keputihan Berbentuk bulat dibawah permukaan daun.\n" +
                "2.\tDaun menjadi coklat dan mengeriput.\n" +
                "3.\tPertumbuhan tanaman terlambat dan tanaman menjadi lemah.\n");
        mSolusi.add("1.\tFungisida Sistemik berbahan aktif Benomil, Karbendazim, Difenokonazol. Metil Tiofanat, atau Tebukonazol\n" +
                "2.\tFungisida Kontak berbahan aktif Klorotalonil, Mankozeb atau Azoksistrobin.\n");

        mNamaPenyakit.add("Virus Mozaik");
        mDefinisi.add("Penyakit ini disebabkan oleh Virus yang disebarkan oleh Aphids dan Thrips.\n");
        mGejala.add("1.\tDaun keriting.\n" +
                "2.\tDaun berkeriput.\n" +
                "3.\tTimbul bercak kuning pada daun.\n" +
                "4.\tPertumbuhan semangka yang Abnormal atau kerdil.\n");
        mSolusi.add("1.\tMemusnahkan tanaman terinfeksi dengan cara dicabut dan dibakar.\n" +
                "2.\tMerotasi tamanan.\n" +
                "3.\tMenjaga sanitasi kebun.\n" +
                "4.\tMenerapkan penggunaan mulsa plastik hitam perak (MPHP).\n" +
                "5.\tMengendalikan hama Aphids dan Thrips.\n");


        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.rv_list_jenis_penyakit);
        AdapterJenisPenyakit adapter = new AdapterJenisPenyakit(this, mNamaPenyakit, mDefinisi, mGejala, mSolusi);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
