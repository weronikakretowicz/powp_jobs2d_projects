package edu.kis.powp.jobs2d.drivers.transformators;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ScalingDriverDecorator extends Job2dDriverDecorator {
    private int scaledX = 0, scaledY = 0;
    private final float scalingFactor;

    public ScalingDriverDecorator(Job2dDriver job2dDriver, float scaleValue) {
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
        scaledX = Math.round(x * scalingFactor);
        scaledY = Math.round(y * scalingFactor);
    }
}
