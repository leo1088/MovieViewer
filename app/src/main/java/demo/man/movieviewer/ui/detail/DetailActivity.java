package demo.man.movieviewer.ui.detail;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

import demo.man.movieviewer.R;
import demo.man.movieviewer.data.moviepopular.Movie;
import demo.man.movieviewer.ui.base.BaseActivity;
import demo.man.movieviewer.ui.detail.fragment.view.DetailFragment;
import demo.man.movieviewer.util.alog.MyLog;
import demo.man.movieviewer.util.define.DfLink;

/**
 * Created by leo on 8/24/17.
 */

public class DetailActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity_layout);
        if (savedInstanceState == null) {
            //add fragment detail sau
            Bundle b = getIntent().getExtras();
            if (b != null) {
//                Movie movie = b.getParcelable(DfLink.MOVIE_BUNDLE);
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setArguments(b);
                addFragment(R.id.detail_container, detailFragment);
            }

        }


    }
}
