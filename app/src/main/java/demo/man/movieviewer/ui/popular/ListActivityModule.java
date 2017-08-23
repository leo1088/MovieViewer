package demo.man.movieviewer.ui.popular;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import demo.man.movieviewer.inject.PerActivity;
import demo.man.movieviewer.inject.PerFragment;
import demo.man.movieviewer.ui.base.BaseActivityModule;
import demo.man.movieviewer.ui.popular.fragment.view.PopularFragment;
import demo.man.movieviewer.ui.popular.fragment.view.PopularFragmentModule;

/**
 * Created by leo on 8/23/17.
 */
@Module(includes = BaseActivityModule.class)
public abstract class ListActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = PopularFragmentModule.class)
    abstract PopularFragment mainFragmentInjector();

    @Binds
    @PerActivity
    abstract Activity activity(ListActivity listActivity);
}
