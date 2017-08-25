package demo.man.movieviewer.ui.detail.fragment.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.man.movieviewer.R;
import demo.man.movieviewer.data.Movie;
import demo.man.movieviewer.data.Review;
import demo.man.movieviewer.data.Trailer;
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
        return inflater.inflate(R.layout.fragment_detail_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.showMovieDetail(movie);
        presenter.showTrailers(movie.getId());
        presenter.showReviews(movie.getId());
    }


    @Override
    public void displayMovie(Movie movie) {
        Glide.with(activityContext).load(DfLink.BACKDROP_PATH + movie.getBackdropPath()).into(poster);
        title.setText(movie.getTitle());
        releaseDate.setText(String.format(getString(R.string.release_date), movie.getReleaseDate()));
        rating.setText(String.format(getString(R.string.rating), String.valueOf(movie.getVoteAverage())));
        overview.setText(movie.getOverview());
    }

    @Override
    public void displayTrailer(List<Trailer.Result> trailers) {
        label.setVisibility(View.VISIBLE);
        this.trailers.setVisibility(View.VISIBLE);
        horizontalScrollView.setVisibility(View.VISIBLE);

        this.trailers.removeAllViews();
        LayoutInflater inflater = getActivity().getLayoutInflater();
        RequestOptions ro = new RequestOptions()
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .placeholder(R.drawable.ic_launcher_background)
                .override((int) getResources().getDimension(R.dimen.video_width), (int) getResources().getDimension(R.dimen.video_height));
        for (Trailer.Result result : trailers) {
            View thumbContainer = inflater.inflate(R.layout.video, this.trailers, false);
            ImageView thumbView = ButterKnife.findById(thumbContainer, R.id.video_thumb);
//            thumbView.setTag(result.getUrl());
            thumbView.requestLayout();
//            thumbView.setOnClickListener(this);
            Glide.with(activityContext).asBitmap().load(result.getThumbnailUrl()).apply(ro).into(thumbView);
            this.trailers.addView(thumbContainer);
        }
    }

    @Override
    public void displayReviews(List<Review.Result> reviews) {
        this.reviews.setVisibility(View.VISIBLE);
        reviewsContainer.setVisibility(View.VISIBLE);
        reviewsContainer.removeAllViews();
        LayoutInflater inflater = getActivity().getLayoutInflater();

        for (Review.Result review : reviews) {
            ViewGroup reviewContainer = (ViewGroup) inflater.inflate(R.layout.review, reviewsContainer, false);
            TextView reviewAuthor = ButterKnife.findById(reviewContainer, R.id.review_author);
            TextView reviewContent = ButterKnife.findById(reviewContainer, R.id.review_content);
            reviewAuthor.setText(review.getAuthor());
            reviewContent.setText(review.getContent());
            reviewsContainer.addView(reviewContainer);
        }
    }


}
