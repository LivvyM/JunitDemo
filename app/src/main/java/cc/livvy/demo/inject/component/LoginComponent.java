package cc.livvy.demo.inject.component;

import cc.livvy.demo.inject.ActivityScope;
import cc.livvy.demo.inject.module.ActivityModule;
import cc.livvy.demo.inject.module.LoginModule;
import cc.livvy.demo.view.impl.LoginActivity;
import dagger.Component;

/**
 *
 * Created by livvy on 16-3-9.
 */
@ActivityScope
@Component(dependencies = AppComponent.class ,modules = {LoginModule.class,ActivityModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
