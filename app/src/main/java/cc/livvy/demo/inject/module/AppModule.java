package cc.livvy.demo.inject.module;

import android.content.Context;

import javax.inject.Singleton;

import cc.livvy.data.repository.UserDataRepository;
import cc.livvy.demo.CcApplication;
import dagger.Module;
import dagger.Provides;
import livvy.cc.repository.UserRepository;

/**
 * Created by livvym on 16-3-9.
 */
@Module
public class AppModule {

    private CcApplication mCcApplication;

    public AppModule(CcApplication mCcApplication){
        this.mCcApplication = mCcApplication;
    }

    @Provides
    @Singleton
    Context provideApplication(){
        return mCcApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserDataRepository userDataRepository) {
        return userDataRepository;
    }
}
