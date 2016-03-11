package cc.livvy.data.repository.datastore;


import livvy.cc.callback.OnRepositoryCallback;

/**
 * Created by livvym on 16-3-9.
 */
public interface UserDataStore {

    void VerifyUsers(String username, String password, OnRepositoryCallback callback);

}
