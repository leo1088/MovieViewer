package demo.man.movieviewer.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import demo.man.movieviewer.net.ApiMovieModule;

/**
 * Created by leo on 8/23/17.
 */
@Singleton
@Component(modules = AppModule.class)
interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
