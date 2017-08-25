package demo.man.movieviewer.ui.base.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.Nullable;
import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.Module;
import dagger.android.AndroidInjection;
import demo.man.movieviewer.util.alog.MyLog;

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
        MyLog.e("BaseFragment->onAttach");
        super.onAttach(activity);
    }


    @Override
    public void onAttach(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Perform injection here for M (API 23) due to deprecation of onAttach(Activity).
            AndroidInjection.inject(this);
        }
        MyLog.e("BaseFragment->onAttach");
        super.onAttach(context);
    }


    @Override
    public void onViewCreated(View view, @android.support.annotation.Nullable Bundle savedInstanceState) {
        viewUnbinder = ButterKnife.bind(this,getView());
        super.onViewCreated(view, savedInstanceState);
        MyLog.e("BaseFragment->onViewCreated");

    }

    //Cause wanna loading DATA WHEN FIRST SO CHANGE TO ONVIEWCREATED
    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        MyLog.e("BaseFragment->onViewStateRestored");
        /*
         * Bind the views here instead of in onViewCreated so that view state changed listeners
         * are not invoked automatically without user interaction.
         *
         * If we bind before this method (e.g. onViewCreated), then any checked changed
         * listeners bound by ButterKnife will be invoked during fragment recreation (since
         * Android itself saves and restores the views' states. Take a look at this gist for a
         * concrete example: https://gist.github.com/vestrel00/982d585144423f728342787341fa001d
         *
         * The lifecycle order is as follows (same if added via xml or java or if retain
         * instance is true):
         *
         * onAttach
         * onCreateView
         * onViewCreated
         * onActivityCreated
         * onViewStateRestored
         * onResume
         *
         * Note that the onCreate (and other lifecycle events) are omitted on purpose. The
         * caveat to this approach is that views, listeners, and resources bound by
         * Butterknife will be null until onViewStatedRestored. Just be careful not to use any
         * objects bound using Butterknife before onViewStateRestored.
         *
         * Fragments that do not return a non-null View in onCreateView results in onViewCreated
         * and onViewStateRestored not being called. This means that Butterknife.bind will not get
         * called, which is completely fine because there is no View to bind. Furthermore, there is
         * no need to check if getView() returns null here because this lifecycle method only gets
         * called with a non-null View.
         */
        /**
         * Not use here
         */
//        viewUnbinder = ButterKnife.bind(this,getView());
    }




    @Override
    public void onDestroyView() {
        if(null!=viewUnbinder){
            viewUnbinder.unbind();
        }
        super.onDestroyView();
    }
}
