package com.xception.drivingdetection.features.driving;

import android.content.Context;

import com.xception.drivingdetection.R;
import com.xception.drivingdetection.core.managers.LinearAccelerationManager;
import com.xception.drivingdetection.features.commons.BasePresenter;
import com.xception.drivingdetection.helper.ApplicationHelper;
import com.xception.drivingdetection.helper.DrivingStateHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DrivingStatePresenter extends BasePresenter<DrivingStateContract.View> implements DrivingStateContract.Presenter {

    private LinearAccelerationManager mLinearAccelerationManager;

    private Disposable mCurrentEventsObservable;

    public DrivingStatePresenter(DrivingStateContract.View view) {
        super(view);

        Context context = ApplicationHelper.getInstance().getContext();
        mLinearAccelerationManager = new LinearAccelerationManager(context);
    }

    @Override
    public void onViewResumed() {
        super.onViewResumed();
        mCurrentEventsObservable = mLinearAccelerationManager.getCurrentAcceleration()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        acceleration -> {
                            DrivingStateContract.Data data = new DrivingStateContract.Data();

                            // Car state
                            if (DrivingStateHelper.isCarMoving(acceleration)) {
                                data.drivingStateTextResId = R.string.driving_car_state_in_motion;
                                data.drivingStateTextColorResId = R.color.driving_car_state_in_motion_text_color;
                            } else {
                                data.drivingStateTextResId = R.string.driving_car_state_not_in_motion;
                                data.drivingStateTextColorResId = R.color.driving_car_state_not_in_motion_text_color;
                            }

                            // Acceleration
                            data.accelerationToDisplay = String.valueOf(acceleration);

                            // Display the content
                            mView.showContent(data);
                        },
                        Throwable::printStackTrace,
                        () -> {}
                );
    }

    @Override
    public void onViewPaused() {
        super.onViewPaused();
        mCurrentEventsObservable.dispose();
        mCurrentEventsObservable = null;
    }
}
