package demo.man.movieviewer.ui.popular.fragment.presenter;

import android.os.Build;

import javax.inject.Inject;

import demo.man.movieviewer.BuildConfig;
import demo.man.movieviewer.data.moviepopular.PagePopular;
import demo.man.movieviewer.data.moviepopular.Result;
import demo.man.movieviewer.inject.PerFragment;
import demo.man.movieviewer.net.ApiMovie;
import demo.man.movieviewer.ui.base.presenter.BasePresenter;
import demo.man.movieviewer.ui.popular.fragment.view.PopularView;
import demo.man.movieviewer.util.PerActivityUtil;
import demo.man.movieviewer.util.PerApplicationUtil;
import demo.man.movieviewer.util.PerFragmentUtil;
import demo.man.movieviewer.util.alog.MyLog;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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
    public void popularDoSomething() {
        // Do something here. Maybe make an asynchronous call to fetch data...
        Result result = null;
        apiMovie.getListPopular(BuildConfig.TMDB_API_KEY).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PagePopular>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        MyLog.e("onSubscribe");
                    }

                    @Override
                    public void onNext(PagePopular pagePopular) {
                        MyLog.e("onNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        MyLog.e("onError:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        MyLog.e("onComplete");
                    }
                });

        view.showPopularMovie(result);
    }
}
