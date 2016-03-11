package cc.livvy.demo.presenter;


import javax.inject.Inject;

import cc.livvy.demo.view.ILoginView;
import cc.livvy.fragment.data.model.DataResult;
import livvy.cc.cases.UserCase;

/**
 * Created by livvy on 16-3-9.
 */
public class LoginPresenter {

    private ILoginView mLoginView;
    private UserCase mLoginUserCase;

    @Inject
    public LoginPresenter(UserCase mLoginUserCase) {
        this.mLoginUserCase = mLoginUserCase;
    }

    public void attachView(ILoginView view) {
        mLoginView = view;
    }

    public void login(String username, String password) {
        mLoginView.showDialog(true);
        this.mLoginUserCase.login(username, password, result -> {
            DataResult results = (DataResult) result;
            mLoginView.showToast(results.message);
            mLoginView.dismissDialog();
        });
    }
}
