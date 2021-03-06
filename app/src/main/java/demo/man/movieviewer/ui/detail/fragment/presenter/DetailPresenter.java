package demo.man.movieviewer.ui.detail.fragment.presenter;

import demo.man.movieviewer.data.Movie;
import demo.man.movieviewer.ui.base.presenter.Presenter;

/**
 * Created by leo on 8/24/17.
 */

public interface DetailPresenter extends Presenter {
    void showMovieDetail(Movie movie);
    void showTrailers(int id);
    void showReviews(int id);
}
