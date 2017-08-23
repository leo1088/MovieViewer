package demo.man.movieviewer.di;

import android.app.Application;
import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import demo.man.movieviewer.inject.PerActivity;
import demo.man.movieviewer.ui.popular.ListActivity;
import demo.man.movieviewer.ui.popular.ListActivityModule;

/**
 * Created by leo on 8/23/17.
 */
@Module(includes = AndroidInjectionModule.class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract Application application(App app);

    @PerActivity
    @ContributesAndroidInjector(modules = ListActivityModule.class)
    abstract ListActivity listActivityInjector();
}
