package demo.man.movieviewer.ui.popular.fragment.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import demo.man.movieviewer.R;
import demo.man.movieviewer.data.moviepopular.Result;
import demo.man.movieviewer.util.alog.MyLog;
import demo.man.movieviewer.ui.base.view.BaseViewFragment;
import demo.man.movieviewer.ui.popular.fragment.presenter.PopularPresenter;

/**
 * Created by leo on 8/23/17.
 */

public final class PopularFragment extends BaseViewFragment<PopularPresenter> implements PopularView {

    @BindView(R.id.movies_listing)
    RecyclerView moviesListing;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MyLog.e("PopularFragment->onViewCreated");
        presenter.popularDoSomething();
    }

    @Override
    public void showPopularMovie(Result result) {

    }
}


