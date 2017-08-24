package demo.man.movieviewer.ui.detail.fragment.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.man.movieviewer.R;
import demo.man.movieviewer.data.moviepopular.Movie;
import demo.man.movieviewer.ui.base.view.BaseViewFragment;
import demo.man.movieviewer.ui.detail.fragment.presenter.DetailPresenter;
import demo.man.movieviewer.util.alog.MyLog;
import demo.man.movieviewer.util.define.DfLink;

/**
 * Created by leo on 8/24/17.
 */

public final class DetailFragment extends BaseViewFragment<DetailPresenter> implements DetailView {

    @BindView(R.id.movie_poster)
    ImageView poster;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.movie_name)
    TextView title;
    @BindView(R.id.movie_year)
    TextView releaseDate;
    @BindView(R.id.movie_rating)
    TextView rating;
    @BindView(R.id.movie_description)
    TextView overview;
    @BindView(R.id.trailers_label)
    TextView label;
    @BindView(R.id.trailers)
    LinearLayout trailers;
    @BindView(R.id.trailers_container)
    HorizontalScrollView horizontalScrollView;
    @BindView(R.id.reviews_label)
    TextView reviews;
    @BindView(R.id.reviews)
    LinearLayout reviewsContainer;
    @BindView(R.id.favorite)
    FloatingActionButton favorite;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    private Movie movie;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        movie = getArguments().getParcelable(DfLink.MOVIE_BUNDLE);
        View v = inflater.inflate(R.layout.fragment_detail_layout, container, false);
//        View vInclude = inflater.inflate(R.layout.fragment_detail_layout, (ViewGroup) v, true);
//        ButterKnife.bind(this, vInclude);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.showMovieDetail(movie);
    }


    @Override
    public void displayMovie(Movie movie) {
        Glide.with(activityContext).load(DfLink.BACKDROP_PATH + movie.getBackdropPath()).into(poster);
        title.setText(movie.getTitle());
        releaseDate.setText(String.format(getString(R.string.release_date), movie.getReleaseDate()));
        rating.setText(String.format(getString(R.string.rating), String.valueOf(movie.getVoteAverage())));
        overview.setText(movie.getOverview());
        presenter.showTrailers(movie);
        presenter.showReviews(movie);
    }

    @Override
    public void displayTrailer(Movie movie) {
        MyLog.e("displayTrailer");
    }

    @Override
    public void displayReviews(Movie movie) {
        MyLog.e("displayReviews");
    }
}
