package com.android.sistempakar.semangka_merah;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sistempakar";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 5);
    }



    public void createTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS gejala");
        db.execSQL("CREATE TABLE if not exists gejala (id TEXT PRIMARY KEY, nama TEXT, " +
                "ya VARCHAR(5), tidak VARCHAR(5), mulai VARCHAR(5), selesai VARCHAR(5));");
    }

    public void createTable2(SQLiteDatabase db2) {
        db2.execSQL("DROP TABLE IF EXISTS penyakit");
        db2.execSQL("CREATE TABLE if not exists penyakit (kode_penyakit TEXT PRIMARY KEY , " +
                "nama_penyakit TEXT);");
    }

    public void generateData(SQLiteDatabase db) {
    ContentValues cv = new ContentValues();
        db.execSQL("INSERT INTO gejala VALUES ('G001','Terlihat tidak sehat', 'G002', 'B', 'Y', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G002','Tanaman tampak Layu seperti kekurangan Air', 'G003', 'G005', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G003','Tanaman pagi dan sore hari tampak segar', 'G004', 'G005', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G004','Tanaman mengering', 'P001', 'G005', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G005','Tanaman Mengalami layu permanen', 'G006', 'G007', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G006','Saat tanaman di potong tampak pembuluh xylemnya menghitam', 'P002', 'G007', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G007','Timbul Bercak pada tanaman', 'G008', 'G010', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G008','Timbul Bercak kehitaman dan tengah berwarna putih pada buah', 'G009', 'G010', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G009','Spora Berwarna kemerahan', 'P003', 'G010', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G010','Timbul Bercak Keputihan Berbentuk bulat dibawah permukaan daun', 'G011', 'G013', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G011','Daun menjadi coklat dan mengeriput', 'G012', 'G013', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G012','Pertumbuhan tanaman terlambat dan tanaman menjadi lemah', 'P004', 'G013', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G013','Daun keriting', 'G014', 'G014', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G014','Daun berkeriput', 'G015', 'G015', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G015','Timbul bercak kuning pada daun', 'G016', 'G016', 'T', 'T');");
        db.execSQL("INSERT INTO gejala VALUES ('G016','Pertumbuhan semangka yang Abnormal atau kerdil', 'P005', 'B', 'T', 'T');");
     //   db.execSQL("INSERT INTO gejala VALUES ('G017','mata sembab, basah dan berair', 'P005', 'P005', 'T', 'T');");
       // db.execSQL("INSERT INTO gejala VALUES ('G018','kepala sering diangkat tinggi', 'G019', 'G021', 'T', 'T');");
      //  db.execSQL("INSERT INTO gejala VALUES ('G019','mata dan telinganya berwarna kebiruan', 'P006', 'P006', 'T', 'T');");
      //  db.execSQL("INSERT INTO gejala VALUES ('G020','sering menggaruk telinga sehingga menjadi kemerahan', 'G022', 'G022', 'T', 'T');");
     //   db.execSQL("INSERT INTO gejala VALUES ('G021','kepala sering digoyangkan', 'G020', 'G023', 'T', 'T');");
     //   db.execSQL("INSERT INTO gejala VALUES ('G022','keluar cairan dari jaringan yang rusak', 'P007', 'P007', 'T', 'T');");
      //  db.execSQL("INSERT INTO gejala VALUES ('G023','sering menggaruk bagian badan yang gatal', 'G024', 'G026', 'T', 'T');");
      //  db.execSQL("INSERT INTO gejala VALUES ('G024','kulit di sekeliling yang gatal menjadi berubah/berkerak', 'G025', 'G025', 'T', 'T');");
      //  db.execSQL("INSERT INTO gejala VALUES ('G025','bulu di area iritasi menjadi rontok', 'P008', 'P008', 'T', 'T');");
      //  db.execSQL("INSERT INTO gejala VALUES ('G026','serangan pada kulit kepala menimbulkan sisik', 'G027', 'G027', 'T', 'T');");
    //    db.execSQL("INSERT INTO gejala VALUES ('G027','kulit kepala nampak pecah-pecah', 'P009', 'P001', 'T', 'T');");

        db.execSQL("INSERT INTO gejala VALUES ('P001','Layu Fusarium', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P002','Layu Bakteri', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P003','Antraknosa', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P004','Powder Mildew', '0', '0', 'T', 'Y');");
        db.execSQL("INSERT INTO gejala VALUES ('P005','Virus Mozaik', '0', '0', 'T', 'Y');");
        //db.execSQL("INSERT INTO gejala VALUES ('P006','Pneumonia', '0', '0', 'T', 'Y');");
        //db.execSQL("INSERT INTO gejala VALUES ('P007','Kanker Telinga', '0', '0', 'T', 'Y');");
       // db.execSQL("INSERT INTO gejala VALUES ('P008','Scabies', '0', '0', 'T', 'Y');");
       // db.execSQL("INSERT INTO gejala VALUES ('P009','Favus', '0', '0', 'T', 'Y');");

    }

    public void generateData2(SQLiteDatabase db2) {
        db2.execSQL("INSERT INTO penyakit VALUES ('P001', 'Layu Fusarium');");
        db2.execSQL("INSERT INTO penyakit VALUES ('P002', 'Layu Bakteri');");
        db2.execSQL("INSERT INTO penyakit VALUES ('P003', 'Antraknosa');");
        db2.execSQL("INSERT INTO penyakit VALUES ('P004', 'Powder Mildew');");
        db2.execSQL("INSERT INTO penyakit VALUES ('P005', 'Virus Mozaik');");
      //  db2.execSQL("INSERT INTO penyakit VALUES ('P006', 'Pneumonia');");
      //  db2.execSQL("INSERT INTO penyakit VALUES ('P007', 'Kanker Telinga');");
      //  db2.execSQL("INSERT INTO penyakit VALUES ('P008', 'Scabies');");
      //  db2.execSQL("INSERT INTO penyakit VALUES ('P009', 'Favus');");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void onCreate(SQLiteDatabase db) {

    }
}
