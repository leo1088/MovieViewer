package demo.man.movieviewer.net;

import java.util.List;

import demo.man.movieviewer.data.moviepopular.Movie;
import demo.man.movieviewer.data.moviepopular.PagePopular;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by leo on 8/23/17.
 */

public interface ApiMovie {
    @GET("popular")
    Observable<PagePopular> getListPopular(@Query("api_key") String key);

    @GET("popular")
    Observable<List<Movie>> getListMovies(@Query("api_key") String key);
}
