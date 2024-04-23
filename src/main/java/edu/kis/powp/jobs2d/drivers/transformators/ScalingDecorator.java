package edu.kis.powp.jobs2d.drivers.transformators;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ScalingDecorator extends TransformationsDriverDecorator {
    private int unscaledX = 0, unscaledY = 0, scaledX = 0, scaledY = 0;
    private float scalingFactor;

    public ScalingDecorator(Job2dDriver job2dDriver, float scaleValue) {
        super(job2dDriver);
        this.scalingFactor = scaleValue;
    }

    @Override
    public void setPosition(int x, int y)
    {
        scale(x, y);
        super.setPosition(scaledX, scaledY);
    }

    @Override
    public void operateTo(int x, int y)
    {
        scale(x, y);
        super.operateTo(scaledX, scaledY);
    }

    private void scale(int x, int y)
    {
        int distanceX = x - unscaledX;
        int distanceY = y - unscaledY;

        scaledX = Math.round(scaledX + (scalingFactor * distanceX));
        scaledY = Math.round(scaledY + (scalingFactor * distanceY));

        unscaledX = x;
        unscaledY = y;
    }

    public void setScalingFactor(float scalingFactor) {
        this.scalingFactor = scalingFactor;
    }

    public float getScalingFactor() {
        return scalingFactor;
    }
}
