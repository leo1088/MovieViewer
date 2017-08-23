package demo.man.movieviewer.ui.popular.fragment.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import demo.man.movieviewer.R;
import demo.man.movieviewer.data.moviepopular.Movie;
import demo.man.movieviewer.util.alog.MyLog;
import demo.man.movieviewer.ui.base.view.BaseViewFragment;
import demo.man.movieviewer.ui.popular.fragment.presenter.PopularPresenter;

/**
 * Created by leo on 8/23/17.
 */

public final class PopularFragment extends BaseViewFragment<PopularPresenter> implements PopularView {

    @BindView(R.id.some_text)
    TextView someText;

    @BindView(R.id.movies_listing)
    RecyclerView moviesListing;

    private List<Movie> movies = new ArrayList<>();
    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MyLog.e("PopularFragment->onViewCreated");
//        moviesListing.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
//        moviesListing.setLayoutManager(layoutManager);
//        adapter = new PopularAdapter(this,movies);
//        moviesListing.setAdapter(adapter);
//        presenter.displayMovies();
        someText.setText("day la text view");
    }

    @Override
    public void showLoading() {
        Snackbar.make(moviesListing, "Loading movies", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showMovies(List<Movie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        moviesListing.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFailed(Throwable reason) {
        Snackbar.make(moviesListing, "Loading failed: " + reason.getMessage(), Snackbar.LENGTH_SHORT).show();
    }
}


