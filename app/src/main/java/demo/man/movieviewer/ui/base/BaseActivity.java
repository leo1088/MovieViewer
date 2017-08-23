package demo.man.movieviewer.ui.base;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by leo on 8/23/17.
 */

public abstract class BaseActivity extends Activity implements HasFragmentInjector {

    @Inject
    @Named(BaseActivityModule.ACTIVITY_FRAGEMENT_MANAGER)
    protected FragmentManager fragmentManager;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }


    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    protected final void addFragment(@IdRes int containviewId, Fragment fragment) {
        fragmentManager.beginTransaction().add(containviewId, fragment).commit();
    }
}
