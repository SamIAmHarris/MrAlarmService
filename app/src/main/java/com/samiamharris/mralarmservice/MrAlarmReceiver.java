package com.samiamharris.mralarmservice;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by SamMyxer on 6/14/16.
 */

public class MrAlarmReceiver extends WakefulBroadcastReceiver {


    public static final int REQUEST_CODE = 54904;
    public static final String ACTION = "com.samiamharris.mralarmservice.alarm";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mrServiceIntent = new Intent(context, MrService.class);
        startWakefulService(context, mrServiceIntent);
    }
}
