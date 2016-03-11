package cc.livvy.data.repository.datastore;


import cc.livvy.fragment.data.model.DataResult;
import cc.livvy.fragment.handler.ThreadToolKit;
import livvy.cc.callback.OnRepositoryCallback;

/**
 *
 * Created by livvy on 16-3-9.
 */
public class CloudUserDataStore implements UserDataStore{

    @Override
    public void VerifyUsers(String username, String password, OnRepositoryCallback callback) {
        //模拟网络加载过程
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (Throwable e) {
            }
            DataResult result = new DataResult();
            if("123456".equals(username) && "123456".equals(password)){
                result.hasError = false;
                result.status = 0;
                result.message = "我也不知道写点啥 ^_^";
            }else{
                result.hasError = false;
                result.status = 1001;
                result.message = "用户和密码都是123456都记不住嘛!!!!!!";
            }
            //回到ui线程
            ThreadToolKit.runOnMainThreadSync(()-> callback.onComplete(result));
        }).start();
    }
}
