package demo.man.movieviewer.ui.detail.fragment.presenter;

import java.util.List;

import javax.inject.Inject;

import demo.man.movieviewer.BuildConfig;
import demo.man.movieviewer.data.Movie;
import demo.man.movieviewer.data.PagePopular;
import demo.man.movieviewer.data.Review;
import demo.man.movieviewer.data.Trailer;
import demo.man.movieviewer.inject.PerFragment;
import demo.man.movieviewer.net.ApiMovie;
import demo.man.movieviewer.ui.base.presenter.BasePresenter;
import demo.man.movieviewer.ui.detail.fragment.view.DetailView;
import demo.man.movieviewer.util.alog.MyLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by leo on 8/24/17.
 */
@PerFragment
public final class DetailPresenterImp extends BasePresenter<DetailView> implements DetailPresenter {

    @Inject
    ApiMovie apiMovie;

    @Inject
    DetailPresenterImp(DetailView view) {
        super(view);
    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void showMovieDetail(Movie movie) {
        view.displayMovie(movie);
    }

    @Override
    public void showTrailers(int id) {
        MyLog.e("showTrailers->" +id);
        apiMovie.getListTrailer(String.valueOf(id), BuildConfig.TMDB_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onTrailerSuccess, this::onTrailerFailed);
        //get list trailers
    }

    private void onTrailerFailed(Throwable throwable) {
        MyLog.e("onTrailerFailed->" + throwable.getMessage());
    }

    private void onTrailerSuccess(Trailer trailer) {
        MyLog.e("onTrailerSuccess" );
        view.displayTrailer(trailer.getResults());
    }

    @Override
    public void showReviews(int id) {
        MyLog.e("showReviews->" + id);
        apiMovie.getListReviews(String.valueOf(id), BuildConfig.TMDB_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onReviewSuccess, this::onReviewFailed);
    }

    private void onReviewSuccess(Review review) {
        view.displayReviews(review.getResults());
    }

    private void onReviewFailed(Throwable throwable) {
        MyLog.e("onReviewFailed->" + throwable.getMessage());
    }


}
