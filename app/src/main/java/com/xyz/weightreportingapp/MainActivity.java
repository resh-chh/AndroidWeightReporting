package com.xyz.weightreportingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etWeight;
    Button btnSubmit;
    FloatingActionButton fab1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = (EditText) findViewById(R.id.etWeight);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        fab1= (FloatingActionButton) findViewById(R.id.fab1);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String wt = etWeight.getText().toString();
                if (wt.length() == 0) {
                    Snackbar.make(v, "Please Enter weight", Snackbar.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_TEXT, "My Weight is " + wt);
                    startActivity(i);
                }
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + "8082785714"));
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.Website:
                Intent i= new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://" + "www.google.com"));
                startActivity(i);
                break;

            case R.id.About:
                Snackbar.make(findViewById(android.R.id.content), "Developed by Rashmi", Snackbar.LENGTH_LONG).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
