package demo.man.movieviewer.ui.popular;

import android.os.Bundle;

import demo.man.movieviewer.R;
import demo.man.movieviewer.ui.base.BaseActivity;
import demo.man.movieviewer.ui.popular.fragment.view.PopularFragment;

public class ListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (null == savedInstanceState) {
            addFragment(R.id.fragment_container, new PopularFragment());
        }
    }
}
