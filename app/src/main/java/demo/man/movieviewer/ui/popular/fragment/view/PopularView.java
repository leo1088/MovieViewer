package demo.man.movieviewer.ui.popular.fragment.view;

import java.util.List;

import demo.man.movieviewer.data.moviepopular.Movie;
import demo.man.movieviewer.ui.base.view.MVPView;

/**
 * Created by leo on 8/23/17.
 */

public interface PopularView extends MVPView {

    void showLoading();

    void showMovies(List<Movie> movies);

    void showFailed(Throwable reason);
}
