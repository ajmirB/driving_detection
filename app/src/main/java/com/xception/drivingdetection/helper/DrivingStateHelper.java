package com.xception.drivingdetection.helper;

public class DrivingStateHelper {

    /**
     * Detect if a car is moving or not
     * @param acceleration the acceleration in m/s²
     * @return true if the car is moving, else false
     */
    public static boolean isCarMoving(int acceleration) {
        return acceleration != 0;
    }
}
