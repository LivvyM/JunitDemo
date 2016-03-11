package cc.livvy.demo.inject.component;

import android.content.Context;

import javax.inject.Singleton;

import cc.livvy.demo.CcApplication;
import cc.livvy.demo.inject.module.AppModule;
import dagger.Component;
import livvy.cc.repository.UserRepository;

/**
 * Created by livvy on 16-3-9.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(CcApplication application);

    Context getApplication();

    UserRepository userRepository();
}
