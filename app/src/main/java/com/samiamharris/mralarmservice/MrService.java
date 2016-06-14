package com.samiamharris.mralarmservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by SamMyxer on 6/14/16.
 */

public class MrService extends IntentService {

    public static final int ALARM_RECURRING_TIME = 60000;

    public MrService() {
        super("MrService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        MrSharedPref.saveMostRecentAlarm();
        Log.i("MrService", "onHandleIntent");
        MrAlarmReceiver.completeWakefulIntent(intent);
    }
}
