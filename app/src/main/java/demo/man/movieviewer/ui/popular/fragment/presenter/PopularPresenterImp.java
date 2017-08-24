package demo.man.movieviewer.ui.popular.fragment.presenter;


import javax.inject.Inject;

import demo.man.movieviewer.BuildConfig;
import demo.man.movieviewer.data.moviepopular.PagePopular;
import demo.man.movieviewer.inject.PerFragment;
import demo.man.movieviewer.net.ApiMovie;
import demo.man.movieviewer.ui.base.presenter.BasePresenter;
import demo.man.movieviewer.ui.popular.fragment.view.PopularView;
import demo.man.movieviewer.util.PerActivityUtil;
import demo.man.movieviewer.util.PerApplicationUtil;
import demo.man.movieviewer.util.PerFragmentUtil;
import demo.man.movieviewer.util.alog.MyLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by leo on 8/23/17.
 */
@PerFragment
public final class PopularPresenterImp extends BasePresenter<PopularView> implements PopularPresenter {

    private final PerApplicationUtil applicationUtil;
    private final PerActivityUtil activityUtil;
    private final PerFragmentUtil fragmentUtil;

    @Inject
    ApiMovie apiMovie;

    @Inject
    PopularPresenterImp(PopularView view,
                        PerApplicationUtil applicationUtil,
                        PerActivityUtil activityUtil,
                        PerFragmentUtil fragmentUtil) {
        super(view);
        this.applicationUtil = applicationUtil;
        this.activityUtil = activityUtil;
        this.fragmentUtil = fragmentUtil;
    }

    @Override
    public void displayMovies() {
        MyLog.e("displayMovies");
        showLoading();
        apiMovie.getListPopular(BuildConfig.TMDB_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onMovieSuccess, this::onMovieFailed);
    }

    private void onMovieSuccess(PagePopular pagePopular) {
        MyLog.e("onMovieSuccess");
        view.showMovies(pagePopular.getMovies());
    }

    private void showLoading() {
        view.showLoading();
    }


    private void onMovieFailed(Throwable throwable) {
        MyLog.e("onMovieFailed:" + throwable.getMessage());
        view.showFailed(throwable);
    }


    @Override
    public void onTrimMemory(int level) {
        view.onMemoryClear(level);
    }

}
