package cc.livvy.demo.inject.module;

import android.app.Activity;
import android.content.Context;

import cc.livvy.demo.inject.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by livvym on 16-3-9.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideContext() {
        return activity;
    }
}
