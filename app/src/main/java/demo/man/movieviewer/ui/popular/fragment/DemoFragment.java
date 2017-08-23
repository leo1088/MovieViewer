package demo.man.movieviewer.ui.popular.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.man.movieviewer.R;
import demo.man.movieviewer.util.alog.MyLog;
import demo.man.movieviewer.ui.base.view.BaseFragment;

/**
 * Created by leo on 8/23/17.
 */

public class DemoFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MyLog.e("Fragment Created");
    }
}
