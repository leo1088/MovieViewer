package demo.man.movieviewer.ui.detail.fragment.view;

import java.util.List;

import demo.man.movieviewer.data.Movie;
import demo.man.movieviewer.data.Review;
import demo.man.movieviewer.data.Trailer;
import demo.man.movieviewer.ui.base.view.MVPView;

/**
 * Created by leo on 8/24/17.
 */

public interface DetailView extends MVPView {

    void displayMovie(Movie movie);

    void displayTrailer(List<Trailer.Result> trailers);

    void displayReviews(List<Review.Result> reviews);
}
