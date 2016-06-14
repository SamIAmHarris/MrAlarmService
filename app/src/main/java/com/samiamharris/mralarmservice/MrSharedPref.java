package com.samiamharris.mralarmservice;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by SamMyxer on 6/14/16.
 */

public class MrSharedPref {

    private static final String MR_ALARM_SERVICE_PREFS = "MrAlarmService";

    private static final String MOST_RECENT_ALARM = "MOST_RECENT_ALARM";


    private static SharedPreferences getSettings() {
        return MrApplication.getInstance()
                .getSharedPreferences(MR_ALARM_SERVICE_PREFS, Context.MODE_PRIVATE);
    }

    public static String getMostRecentAlarmAsString() {
        Date date = new Date(getMostRecentAlarm());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
        return formatter.format(date);
    }

    public static void saveMostRecentAlarm() {
        Long currentTime = Calendar.getInstance().getTimeInMillis();
        SharedPreferences prefs = getSettings();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(MOST_RECENT_ALARM, currentTime);
        editor.apply();
    }

    public static long getMostRecentAlarm() {
        SharedPreferences prefs = getSettings();
        return prefs.getLong(MOST_RECENT_ALARM, 0);
    }
}
