package cc.livvy.demo.inject.module;

import cc.livvy.demo.inject.ActivityScope;
import dagger.Module;
import dagger.Provides;
import livvy.cc.cases.LoginUserCase;
import livvy.cc.cases.UserCase;
import livvy.cc.repository.UserRepository;

/**
 * Created by livvym on 16-3-9.
 */
@Module
public class LoginModule {

    public LoginModule(){
    }

    @Provides
    @ActivityScope
    UserCase provideLoginUserCase(UserRepository userRepository){
        return new LoginUserCase(userRepository);
    }

}
