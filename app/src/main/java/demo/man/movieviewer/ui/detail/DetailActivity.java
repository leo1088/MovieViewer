package demo.man.movieviewer.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;

import demo.man.movieviewer.R;
import demo.man.movieviewer.ui.base.BaseActivity;
import demo.man.movieviewer.ui.detail.fragment.view.DetailFragment;

/**
 * Created by leo on 8/24/17.
 */

public class DetailActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity_layout);
        if (savedInstanceState == null) {
            Bundle b = getIntent().getExtras();
            if (b != null) {
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setArguments(b);
                addFragment(R.id.detail_container, detailFragment);
            }
        }
    }
}
