package com.xception.drivingdetection.features.commons;

public interface BaseContract {

    interface Presenter {
        void onViewCreated();
        void onViewResumed();
        void onViewPaused();
        void onViewDestroyed();
    }

    interface View {
    }
}
