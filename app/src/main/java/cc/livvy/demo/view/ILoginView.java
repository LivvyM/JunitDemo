package cc.livvy.demo.view;


import cc.livvy.fragment.data.model.DataResult;

/**
 * Created by livvym on 16-3-9.
 */
public interface ILoginView extends IDialogView{

    void processLoginComplete(DataResult result);

    void showToast(String msg);
}
