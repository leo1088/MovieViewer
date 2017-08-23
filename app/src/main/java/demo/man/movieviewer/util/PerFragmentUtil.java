package demo.man.movieviewer.util;

import android.app.Fragment;

import javax.inject.Inject;
import javax.inject.Named;

import demo.man.movieviewer.inject.PerFragment;
import demo.man.movieviewer.util.alog.MyLog;
import demo.man.movieviewer.ui.base.view.BaseFragmentModule;

/**
 * Created by leo on 8/23/17.
 */
@PerFragment
public final class PerFragmentUtil {
    private final Fragment fragment;

    @Inject
    PerFragmentUtil(@Named(BaseFragmentModule.FRAGMENT) Fragment fragment) {
        this.fragment = fragment;
    }

    public void perFragmentDoSomeThing() {
        MyLog.e("perFragmentDoSomeThing");
    }
}
