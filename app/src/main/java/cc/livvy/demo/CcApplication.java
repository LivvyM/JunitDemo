package cc.livvy.demo;

import cc.livvy.demo.inject.component.AppComponent;
import cc.livvy.demo.inject.component.DaggerAppComponent;
import cc.livvy.demo.inject.module.AppModule;
import cc.livvy.fragment.base.BaseApp;

/**
 * application
 * Created by livvym on 16-3-9.
 */
public class CcApplication extends BaseApp{

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mAppComponent.inject(this);
    }

    public AppComponent getApplicationComponent() {
        return this.mAppComponent;
    }

}
