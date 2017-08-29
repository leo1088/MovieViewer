package demo.man.movieviewer.net;

import java.util.List;

import demo.man.movieviewer.data.Movie;
import demo.man.movieviewer.data.PagePopular;
import demo.man.movieviewer.data.Review;
import demo.man.movieviewer.data.Trailer;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by leo on 8/23/17.
 */

public interface ApiMovie {

    //get What are the most popular movies?
    @GET("discover/movie?language=en&sort_by=popularity.desc")
    Observable<PagePopular> getListPopular(@Query("api_key") String key);

    @GET("discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc")
    Observable<PagePopular> getListHighestRate(@Query("api_key") String key);

    @GET("movie/{id}/videos")
    Observable<Trailer> getListTrailer(@Path("id") String id, @Query("api_key") String key);

    @GET("movie/{id}/reviews")
    Observable<Review> getListReviews(@Path("id") String id, @Query("api_key") String key);
}
