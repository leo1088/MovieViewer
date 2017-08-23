package demo.man.movieviewer.ui.popular.fragment.view;

import android.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import demo.man.movieviewer.inject.PerFragment;
import demo.man.movieviewer.ui.base.view.BaseFragmentModule;
import demo.man.movieviewer.ui.popular.fragment.presenter.PopularPresenterModule;

/**
 * Created by leo on 8/23/17.
 */
@Module(includes = {
        BaseFragmentModule.class,
        PopularPresenterModule.class
})
public abstract class PopularFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @PerFragment
    abstract Fragment fragment(PopularFragment fragment);

    @Binds
    @PerFragment
    abstract PopularView popularView(PopularFragment fragment);
}
