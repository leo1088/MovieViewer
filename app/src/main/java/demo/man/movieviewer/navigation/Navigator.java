package demo.man.movieviewer.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;
import javax.inject.Singleton;

import demo.man.movieviewer.ui.detail.DetailActivity;

/**
 * Created by leo on 8/24/17.
 */
@Singleton
public final class Navigator {

    @Inject
    Navigator() {
    }

    public void toDetailActivity(Context context, Bundle bundle) {
        Intent t = new Intent(context, DetailActivity.class);
        context.startActivity(t);
    }
}
