package com.xception.drivingdetection.features.driving;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.xception.drivingdetection.R;
import com.xception.drivingdetection.features.commons.BaseActivity;

import butterknife.BindView;

public class DrivingStateActivity extends BaseActivity implements DrivingStateContract.View {

    @BindView(R.id.driving_car_state_text_view)
    TextView mCarStateTextView;

    @BindView(R.id.driving_acceleration_text_view)
    TextView mAccelerationTextView;

    private DrivingStateContract.Presenter mDrivingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving);

        mDrivingPresenter = new DrivingStatePresenter(this);
        mDrivingPresenter.onViewCreated();
    }

    protected void onResume() {
        super.onResume();
        mDrivingPresenter.onViewResumed();
    }

    protected void onPause() {
        super.onPause();
        mDrivingPresenter.onViewPaused();
    }

    @Override
    protected void onDestroy() {
        mDrivingPresenter.onViewDestroyed();
        super.onDestroy();
    }

    // region DrivingStateContract.View

    @Override
    public void showContent(DrivingStateContract.Data data) {
        mCarStateTextView.setText(data.drivingStateTextResId);
        mCarStateTextView.setTextColor(ContextCompat.getColor(this, data.drivingStateTextColorResId));

        mAccelerationTextView.setText(data.accelerationToDisplay);
    }

    // endregion

}
