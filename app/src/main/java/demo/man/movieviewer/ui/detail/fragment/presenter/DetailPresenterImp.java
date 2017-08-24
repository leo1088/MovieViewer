package demo.man.movieviewer.ui.detail.fragment.presenter;

import javax.inject.Inject;

import demo.man.movieviewer.data.Movie;
import demo.man.movieviewer.inject.PerFragment;
import demo.man.movieviewer.ui.base.presenter.BasePresenter;
import demo.man.movieviewer.ui.detail.fragment.view.DetailView;

/**
 * Created by leo on 8/24/17.
 */
@PerFragment
public final class DetailPresenterImp extends BasePresenter<DetailView> implements DetailPresenter {

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
    public void showTrailers(Movie movie) {
        view.displayTrailer(movie);
    }

    @Override
    public void showReviews(Movie movie) {
        view.displayReviews(movie);
    }
}
