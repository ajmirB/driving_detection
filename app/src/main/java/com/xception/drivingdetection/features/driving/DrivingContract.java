package com.xception.drivingdetection.features.driving;

import com.xception.drivingdetection.features.commons.BaseContract;

public interface DrivingContract extends BaseContract {

    interface Presenter extends BaseContract.Presenter {
    }

    interface View extends BaseContract.View {
        void showContent(Data data);
    }

    class Data {
        public Integer textResId;
        public int speed;
    }
}
