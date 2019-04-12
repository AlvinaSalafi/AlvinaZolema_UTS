package com.example.coba4.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coba4.Activity.BiayaAdministrasi;
import com.example.coba4.Activity.PengertianActivity;
import com.example.coba4.Activity.Prosedure;
import com.example.coba4.Activity.SyaratProsedure;
import com.example.coba4.DataHelper;
import com.example.coba4.LoginActivity;
import com.example.coba4.R;

public class LihatBiodata extends AppCompatActivity {
    // karena kita akan menggunakan Query jadi harus ada cursor
    protected Cursor cursor;
    // karena kita akan mengambil proses dari dataHelper dengan variable dbHelper
    DataHelper dbHelper;
    // untuk button kembali
    Button ton2;
    // penginputan isi (nomor, nama, tanggal lahir ......)
    TextView text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);

        getSupportActionBar().setTitle("Go-Trash");

        dbHelper = new DataHelper(this);
        // untuk pendeklarasian dan pengambilan id di xml
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        text5 = (TextView) findViewById(R.id.textView5);

        // syntax 'SELECT*FROM' untuk menampilkan table biodata
        // dengan menggunakan filter 'WHERE' dengan nama, apabila kita klik nama dia akan pindah ke layout data yang telah dimasukkan
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            // hanya menampilkan text yang telah diinputkan
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        ton2 = (Button) findViewById(R.id.button1);
        // fungsi button kembali
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
    //memanngil menu main
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menucoba, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    //(intent) pemanggilan ke layout()
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.pengertian) {
            startActivity(new Intent(this, PengertianActivity.class));
        }else if (item.getItemId() == R.id.syarat) {
            startActivity(new Intent(this, SyaratProsedure.class));
        }else if (item.getItemId() == R.id.biaya) {
            startActivity(new Intent(this, BiayaAdministrasi.class));
        }else if (item.getItemId() == R.id.prosedure) {
            startActivity(new Intent(this, Prosedure.class));
        }else if (item.getItemId() == R.id.logout) {
            startActivity(new Intent(this, LoginActivity.class));
            Toast.makeText(getBaseContext(), "Logout sukses", Toast.LENGTH_LONG).show();

        }
        return true;
    }
}

