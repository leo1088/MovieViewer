package demo.man.movieviewer.ui.popular;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import demo.man.movieviewer.R;
import demo.man.movieviewer.ui.base.BaseActivity;
import demo.man.movieviewer.ui.popular.fragment.view.PopularFragment;

public class ListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popular_layout);
        setToolbar();
        if (null == savedInstanceState) {
            addFragment(R.id.fragment_container, new PopularFragment());
        }
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle(R.string.toolbar_title);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popular_menu, menu);
        return true;
    }
}
