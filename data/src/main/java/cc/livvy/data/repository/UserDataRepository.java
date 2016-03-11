package cc.livvy.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import cc.livvy.data.repository.factory.UserDataStoreFactory;
import livvy.cc.callback.OnRepositoryCallback;
import livvy.cc.repository.UserRepository;

/**
 *
 * Created by livvym on 16-3-9.
 */
@Singleton
public class UserDataRepository implements UserRepository {

    private final UserDataStoreFactory mUserDataStoreFactory;

    @Inject
    public UserDataRepository(UserDataStoreFactory mUserDataStoreFactory){
        this.mUserDataStoreFactory = mUserDataStoreFactory;
    }

    @Override
    public void login(String username, String password, OnRepositoryCallback callback) {
        mUserDataStoreFactory.create().VerifyUsers(username,password,callback);
    }

}
