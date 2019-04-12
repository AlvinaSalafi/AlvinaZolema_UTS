package com.example.coba4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.coba4.Activity.BiayaAdministrasi;
import com.example.coba4.Activity.JenisSampah;
import com.example.coba4.Activity.Kunjungi;
import com.example.coba4.Activity.PengertianActivity;
import com.example.coba4.Activity.Prosedure;
import com.example.coba4.Activity.SyaratProsedure;

public class MainActivity extends AppCompatActivity {

    ViewFlipper viewFlipper;
    Animation fadein, fadeout;
    Button btnJenisSampah, btnKunjungi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Go-Trash");

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.startFlipping();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

        //fungsi pemanggilan button
        btnJenisSampah = (Button) findViewById(R.id.btnJenisSampah);
        btnKunjungi = (Button) findViewById(R.id.btnKunjungi);

        btnJenisSampah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), JenisSampah.class);
                startActivity(i);
            }
        });

        btnKunjungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Kunjungi.class);
                startActivity(i);
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
