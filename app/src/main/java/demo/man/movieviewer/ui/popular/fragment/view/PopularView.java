package demo.man.movieviewer.ui.popular.fragment.view;

import demo.man.movieviewer.data.moviepopular.Result;
import demo.man.movieviewer.ui.base.view.MVPView;

/**
 * Created by leo on 8/23/17.
 */

public interface PopularView extends MVPView {
    void showPopularMovie(Result result);
}
