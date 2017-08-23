package demo.man.movieviewer.util;

import android.app.Activity;

import javax.inject.Inject;

import demo.man.movieviewer.inject.PerActivity;
import demo.man.movieviewer.util.alog.MyLog;

/**
 * Created by leo on 8/23/17.
 */
@PerActivity
public final class PerActivityUtil {
    private final Activity activity;

    @Inject
    PerActivityUtil(Activity activity) {
        this.activity = activity;
    }

    public void perActivityDoSomeThing() {
        MyLog.e("perActivityDoSomeThing");
    }
}
