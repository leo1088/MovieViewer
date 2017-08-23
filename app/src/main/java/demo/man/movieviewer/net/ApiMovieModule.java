package demo.man.movieviewer.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.man.movieviewer.util.define.DfLink;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by leo on 8/23/17.
 */
@Module
public class ApiMovieModule {
    /**
     * co singleton thi phai dung o app module
     */
    @Provides
    @Named(DfLink.NAME_BASE_URL)
    String providerBaseUrl() {
        return DfLink.BASE_URL;
    }

    @Provides
//    @Singleton
    Retrofit providerRetrofit(@Named(DfLink.NAME_BASE_URL) String baseUrl,
                              Converter.Factory converter,
                              RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build();
    }

    @Provides
//    @Singleton
    RxJava2CallAdapterFactory providerRxAdapter() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
//    @Singleton
    Converter.Factory providerConverter() {
        return GsonConverterFactory.create();
    }

    @Provides
//    @Singleton
    ApiMovie providerInterfaceApi(Retrofit retrofit) {
        return retrofit.create(ApiMovie.class);
    }
}
