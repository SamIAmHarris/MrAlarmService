package com.samiamharris.mralarmservice;

import android.app.Application;

/**
 * Created by SamMyxer on 6/14/16.
 */

public class MrApplication extends Application {

    private static MrApplication appInstance;

    public MrApplication(){
        this.appInstance = this;
    }

    public static MrApplication getInstance(){
        return appInstance;
    }

}
