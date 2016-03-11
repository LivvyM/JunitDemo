package cc.livvy.demo.inject.component;

import android.app.Activity;
import android.content.Context;

import javax.inject.Singleton;

import cc.livvy.demo.inject.ActivityScope;
import cc.livvy.demo.inject.module.ActivityModule;
import dagger.Component;
import dagger.Module;

/**
 * Created by livvym on 16-3-9.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity getActivity();
}
