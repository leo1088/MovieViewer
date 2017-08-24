package demo.man.movieviewer.ui.detail.fragment.view;

import demo.man.movieviewer.data.moviepopular.Movie;
import demo.man.movieviewer.ui.base.view.MVPView;

/**
 * Created by leo on 8/24/17.
 */

public interface DetailView extends MVPView {
    void displayMovie(Movie movie);
    void displayTrailer(Movie movie);
    void displayReviews(Movie movie);
}
