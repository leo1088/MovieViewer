package demo.man.movieviewer.ui.base.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import javax.annotation.Nullable;
import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.Module;
import dagger.android.AndroidInjection;

/**
 * Created by leo on 8/23/17.
 */

public abstract class BaseFragment  extends Fragment {

    @Inject
    protected Context activityContext;

    @Nullable
    private Unbinder viewUnbinder;


    @Override
    public void onAttach(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            // Perform injection here before M, L (API 22) and below because onAttach(Context)
            // is not yet available at L.
            AndroidInjection.inject(this);
        }
        super.onAttach(activity);
    }


    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidInjection.inject(this);
        }
        super.onAttach(context);
    }


    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        viewUnbinder = ButterKnife.bind(this,getView());
    }

    @Override
    public void onDestroyView() {
        if(null!=viewUnbinder){
            viewUnbinder.unbind();
        }
        super.onDestroyView();
    }
}
