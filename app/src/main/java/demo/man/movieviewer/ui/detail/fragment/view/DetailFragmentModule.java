package demo.man.movieviewer.ui.detail.fragment.view;

import android.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import demo.man.movieviewer.inject.PerFragment;
import demo.man.movieviewer.ui.base.view.BaseFragmentModule;
import demo.man.movieviewer.ui.detail.fragment.presenter.DetailPresenterModule;

/**
 * Created by leo on 8/24/17.
 */
@Module(includes = {
        BaseFragmentModule.class,
        DetailPresenterModule.class})
public abstract class DetailFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(DetailFragment fragment);

    @Binds
    @PerFragment
    abstract DetailView detailView(DetailFragment fragment);
}
