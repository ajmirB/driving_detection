package com.xception.drivingdetection.features.commons;

public interface BaseContract {

    interface Presenter {
        void onViewCreated();
        void onViewDestroyed();
    }

    interface View {
    }
}
