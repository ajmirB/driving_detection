package com.xception.drivingdetection.features.driving;

import com.xception.drivingdetection.features.commons.BasePresenter;

public class DrivingPresenter extends BasePresenter<DrivingContract.View> implements DrivingContract.Presenter {

    public DrivingPresenter(DrivingContract.View view) {
        super(view);
    }
}
