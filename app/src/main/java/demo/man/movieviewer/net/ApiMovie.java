package demo.man.movieviewer.net;

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
}
