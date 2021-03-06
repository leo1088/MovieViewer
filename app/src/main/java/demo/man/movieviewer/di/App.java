package demo.man.movieviewer.di;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by leo on 8/23/17.
 */

public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> androidInjector;


    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().create(this).inject(this);
    }


    @Override
    public AndroidInjector<Activity> activityInjector() {
        return androidInjector;
    }


    private class MyThread extends Thread {
        final int index;

        public MyThread(int a) {
            index = a;
        }

        @Override
        public void run() {
            super.run();
            Log.d("Mandb1", "start " + index);
        }
    }
}
