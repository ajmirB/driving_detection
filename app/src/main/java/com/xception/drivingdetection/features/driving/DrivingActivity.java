package com.xception.drivingdetection.features.driving;

import android.os.Bundle;

import com.xception.drivingdetection.R;
import com.xception.drivingdetection.features.commons.BaseActivity;

public class DrivingActivity extends BaseActivity implements DrivingContract.View {

    private DrivingContract.Presenter mDrivingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving);

        mDrivingPresenter = new DrivingPresenter(this);
        mDrivingPresenter.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        mDrivingPresenter.onViewDestroyed();
        super.onDestroy();
    }

    // region DrivingContract.View

    @Override
    public void showContent(DrivingContract.Data data) {

    }

    // endregion
}
