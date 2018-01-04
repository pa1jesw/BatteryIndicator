package com.pa1.batteryindicator;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static EditText etPercent;
    static Button btnSubmit;
    static ProgressBar pbBattery;
    static TextView tvPercent;
    static int BatteryLevel;

    BatteryPercentReciever bpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPercent = findViewById(R.id.tvPercent);
        etPercent = findViewById(R.id.etPercent);
        btnSubmit = findViewById(R.id.btnSubmit);
        pbBattery = findViewById(R.id.pbBattery);

        bpr = new BatteryPercentReciever();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BatteryLevel = Integer.parseInt(etPercent.getText().toString());
                registerReceiver(bpr, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

            }
        });

    }
}
