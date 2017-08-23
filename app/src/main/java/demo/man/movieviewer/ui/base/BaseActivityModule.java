package demo.man.movieviewer.ui.base;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import demo.man.movieviewer.inject.PerActivity;

/**
 * Created by leo on 8/23/17.
 */
@Module
public abstract class BaseActivityModule {
    static final String ACTIVITY_FRAGEMENT_MANAGER = "BaseActivityModule.activityFragmentManager";

    @Binds
    @PerActivity
    abstract Context activityContext(Activity activity);

    @Provides
    @Named(ACTIVITY_FRAGEMENT_MANAGER)
    @PerActivity
    static FragmentManager activityFragmentManager(Activity activity) {
        return activity.getFragmentManager();
    }
}
