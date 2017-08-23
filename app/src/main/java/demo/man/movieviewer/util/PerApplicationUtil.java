package demo.man.movieviewer.util;

import android.app.Application;

import javax.inject.Inject;
import javax.inject.Singleton;

import demo.man.movieviewer.util.alog.MyLog;

/**
 * Created by leo on 8/23/17.
 */
@Singleton
public final class PerApplicationUtil {
    private final Application application;

    @Inject
    PerApplicationUtil(Application application) {
        this.application = application;
    }
    public void perApplicationDoSomeThing(){
        MyLog.e("perApplicationDoSomeThing");
    }
}
