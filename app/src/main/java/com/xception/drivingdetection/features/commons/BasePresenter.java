package com.xception.drivingdetection.features.commons;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter {

    protected T mView;

    protected CompositeDisposable mCompositeDisposable;

    public BasePresenter(T view) {
        mView = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    // region BaseContract.Presenter

    @Override
    public void onViewCreated() {

    }

    @Override
    public void onViewResumed() {

    }

    @Override
    public void onViewPaused() {

    }

    @Override
    public void onViewDestroyed() {
        mCompositeDisposable.dispose();
    }

    // endregion
}
