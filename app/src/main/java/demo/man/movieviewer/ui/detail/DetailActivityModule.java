package demo.man.movieviewer.ui.detail;

import android.app.Activity;

import javax.inject.Inject;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import demo.man.movieviewer.inject.PerActivity;
import demo.man.movieviewer.inject.PerFragment;
import demo.man.movieviewer.ui.base.BaseActivityModule;

/**
 * Created by leo on 8/24/17.
 */
@Module(includes = BaseActivityModule.class)
public abstract class DetailActivityModule {
    @Binds
    @PerActivity
    abstract Activity activity(DetailActivity activity);

    //add fragment thi them vo

}
