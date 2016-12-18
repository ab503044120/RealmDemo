package org.huihui.realmdemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

import io.realm.Realm;

/**
 * User: huihui
 * Date: 2016-12-18 {HOUR}:39
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Stetho.initializeWithDefaults(this);
    }
}