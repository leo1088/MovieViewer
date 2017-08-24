package demo.man.movieviewer.ui.popular.fragment.presenter;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import demo.man.movieviewer.inject.PerFragment;
import demo.man.movieviewer.net.ApiMovieModule;
import demo.man.movieviewer.util.define.DfLink;

/**
 * Created by leo on 8/23/17.
 */
@Module
public abstract class PopularPresenterModule {

    @Binds
    @PerFragment
    abstract PopularPresenter popularPresenter(PopularPresenterImp popularPresenterImp);

}
