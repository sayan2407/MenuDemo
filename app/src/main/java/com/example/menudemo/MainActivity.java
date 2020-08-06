package com.example.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.t1) ;
        t1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu p = new PopupMenu(getApplicationContext() , t1);
                p.getMenuInflater().inflate(R.menu.popup_menu , p.getMenu());

                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, "You Click on "+item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                p.show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.Edit :
                Toast.makeText(this, "You click on Edit", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Cut :
                Toast.makeText(this, "You click on Cut", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Copy :
                Toast.makeText(this, "You click on Copy", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Paste :
                Toast.makeText(this, "You click on Paste", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}