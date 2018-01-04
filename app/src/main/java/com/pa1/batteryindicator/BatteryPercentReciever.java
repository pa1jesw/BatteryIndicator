package com.pa1.batteryindicator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

/**
 * Created by PAWAN on 1/4/2018.
 */

public class BatteryPercentReciever extends BroadcastReceiver {
    MediaPlayer mp;

    public BatteryPercentReciever() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
    int level = intent.getIntExtra("level",0);
    MainActivity.tvPercent.setText("Battery Level : "+level+" %");
    MainActivity.pbBattery.setProgress(level);

    if(MainActivity.BatteryLevel == level)
    {
        mp = MediaPlayer.create(context,R.raw.song);
        mp.start();
    }
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                if(mp != null)
                    mp.stop();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }).start();
    }
}
