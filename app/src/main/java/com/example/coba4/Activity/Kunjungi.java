package com.example.coba4.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.coba4.LoginActivity;
import com.example.coba4.R;

public class Kunjungi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunjungi);

        getSupportActionBar().setTitle("Go-Trash");
    }
    public void instagram(View view) {
        Intent instagramIntent = new Intent (Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/banksampah_malang/?hl=id"));
        startActivity(instagramIntent);
    }
    public void youtube(View view) {
        Intent youtubeIntent = new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCxWPYPmIJ1ocEr3LxWsD-Lw/featured"));
        startActivity(youtubeIntent);
    }
    public void facebook(View view) {
        Intent facebookIntent = new Intent (Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/alvinasalafi"));
        startActivity(facebookIntent);
    }
    public void gmail(View view) {
        Intent gmailIntent = new Intent (Intent.ACTION_VIEW,Uri.parse("https://mail.google.com/mail/u/0/#inbox"));
        startActivity(gmailIntent);
    }
    public void location(View view) {
        Intent locationIntent = new Intent (Intent.ACTION_VIEW,Uri.parse("https://www.google.com/maps/place/Gg.+2+No.17,+Dusun+Krajan,+Putat+Kidul,+Gondanglegi,+Malang,+Jawa+Timur+65174/@-8.1733539,112.6446066,17z/data=!3m1!4b1!4m5!3m4!1s0x2dd61f8da043e315:0x18bb6db3e44994f8!8m2!3d-8.1733592!4d112.6467953"));
        startActivity(locationIntent);
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