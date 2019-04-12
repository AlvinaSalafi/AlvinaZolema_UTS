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
import android.widget.EditText;
import android.widget.Toast;

import com.example.coba4.DataHelper;
import com.example.coba4.LoginActivity;
import com.example.coba4.R;

public class BuatBiodata extends AppCompatActivity {
    // karena kita akan menggunakan Query jadi harus ada cursor
    protected Cursor cursor;
    // karena kita akan mengambil proses dari dataHelper dengan variable dbHelper
    DataHelper dbHelper;
    // untuk button simpan dan kembali
    Button ton1, ton2;
    // penginputan isi (nomor, nama, tanggal lahir ......)
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        getSupportActionBar().setTitle("Go-Trash");

        dbHelper = new DataHelper(this);
        // untuk pendeklarasian dan pengambilan id di xml
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);

        // fungsi button simpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                // dbHelper untuk memproses
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                // untuk menginsertkan data text* yang ada ke table biodata didatabase, yang telah diinputkan (no, nama, tgl....)
                db.execSQL("insert into biodata(no, nama, tgl, jk, alamat) values('" +
                        text1.getText().toString()+"','"+
                        text2.getText().toString() +"','" +
                        text3.getText().toString()+"','"+
                        text4.getText().toString() +"','" +
                        text5.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                BiodataActivity.ma.RefreshList();
                finish();
            }
        });

        //fungsi button kembali
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

