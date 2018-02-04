package com.xception.drivingdetection.helper;

import junit.framework.Assert;

import org.junit.Test;

public class DrivingStateHelperTest {

    @Test
    public void testCarIsMovingValidation(){
        Assert.assertTrue(DrivingStateHelper.isCarMoving(1));
        Assert.assertTrue(DrivingStateHelper.isCarMoving(34));
    }

    @Test
    public void testCarIsNotMovingValidation(){
        Assert.assertFalse(DrivingStateHelper.isCarMoving(0));
    }
}