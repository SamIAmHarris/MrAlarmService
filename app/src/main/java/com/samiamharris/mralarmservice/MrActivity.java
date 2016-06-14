package com.samiamharris.mralarmservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scheduleAlarm();

        Toast.makeText(this, MrSharedPref.getMostRecentAlarmAsString(), Toast.LENGTH_LONG).show();
    }

    // Setup a recurring alarm every minute
    private void scheduleAlarm() {
        // Construct an intent that will execute the AlarmReceiver
        Intent intent = new Intent(getApplicationContext(), MrAlarmReceiver.class);
        // Create a PendingIntent to be triggered when the alarm goes off
        final PendingIntent alarmReceiverIntent = PendingIntent.getBroadcast(this, MrAlarmReceiver.REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // Setup periodic alarm
        long rightMeow = System.currentTimeMillis(); // alarm is set right away
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
        // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, rightMeow,
                MrService.ALARM_RECURRING_TIME, alarmReceiverIntent);
    }
}

