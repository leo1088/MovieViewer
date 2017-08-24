package demo.man.movieviewer.ui.detail.fragment.presenter;

import dagger.Binds;
import dagger.Module;
import demo.man.movieviewer.inject.PerFragment;

/**
 * Created by leo on 8/24/17.
 */
@Module
public abstract class DetailPresenterModule {

    @Binds
    @PerFragment
    abstract DetailPresenter detailPresenter(DetailPresenterImp presenterImp);
}
