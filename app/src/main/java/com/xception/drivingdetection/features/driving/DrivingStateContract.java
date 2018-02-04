package com.xception.drivingdetection.features.driving;

import com.xception.drivingdetection.features.commons.BaseContract;

public interface DrivingStateContract extends BaseContract {

    interface Presenter extends BaseContract.Presenter {
    }

    interface View extends BaseContract.View {
        void showContent(Data data);
    }

    class Data {
        public int drivingStateTextResId;
        public int drivingStateTextColorResId;
        public String accelerationToDisplay;
    }
}
