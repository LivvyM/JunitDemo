package cc.livvy.data.repository.factory;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import cc.livvy.data.cache.UserCache;
import cc.livvy.data.repository.datastore.CloudUserDataStore;
import cc.livvy.data.repository.datastore.UserDataStore;
import dagger.Provides;

/**
 * Created by livvym on 16-3-9.
 */
@Singleton
public class UserDataStoreFactory {

    private final Context mContext;
//    private final UserCache mUserCache;

    @Inject
    public UserDataStoreFactory(Context mContext){
        if (mContext == null) {
            throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
        }
        this.mContext = mContext.getApplicationContext();
    }

    public UserDataStore create(){
        UserDataStore mUserDataStore;
        //todo 判断是否需要cache
        mUserDataStore = createCloudDataStore();
        return mUserDataStore;
    }

    public UserDataStore createCloudDataStore(){
        return new CloudUserDataStore();
    }

}
