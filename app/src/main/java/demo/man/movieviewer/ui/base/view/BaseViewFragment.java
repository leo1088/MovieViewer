package demo.man.movieviewer.ui.base.view;

import android.os.Bundle;

import javax.inject.Inject;

import demo.man.movieviewer.ui.base.presenter.Presenter;

/**
 * Created by leo on 8/23/17.
 */

public abstract class BaseViewFragment<T extends Presenter> extends BaseFragment implements MVPView {
    @Inject
    protected T presenter;


    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        presenter.onStart(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        presenter.onEnd();
        super.onDestroyView();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        presenter.onTrimMemory(level);
    }
}
