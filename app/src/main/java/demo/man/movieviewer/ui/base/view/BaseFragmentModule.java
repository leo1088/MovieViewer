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
@Module
public abstract class BaseFragmentModule {
    public static final String FRAGMENT = "BaseFragmentModule.fragment";
}
