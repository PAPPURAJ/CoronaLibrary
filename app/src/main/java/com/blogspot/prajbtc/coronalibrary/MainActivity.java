package com.blogspot.prajbtc.coronalibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Corona.getReport(new MyResultInterface() {
            @Override
            public void Success(Report report) {
                Toast.makeText(getApplicationContext(),report.getArrayList().size()+"//"+report.getArrayList().get(0).getCountryName(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void failed(String errorMessage) {

            }
        });


    }
}
