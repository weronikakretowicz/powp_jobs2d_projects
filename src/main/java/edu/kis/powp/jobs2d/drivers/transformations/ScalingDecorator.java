package edu.kis.powp.jobs2d.drivers.transformations;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ScalingDecorator extends TransformationsDriverDecorator
{
    private int unscaledX = 0, unscaledY = 0, scaledX = 0, scaledY = 0;
    private Integer startX = null, startY = null;
    private final float scalingFactor;

    public ScalingDecorator(Job2dDriver job2dDriver, float scaleValue) {
        super(job2dDriver);
        this.scalingFactor = scaleValue;
    }

    @Override
    public void setPosition(int x, int y)
    {
        setAllCoordinates(x, y);
        super.setPosition(scaledX, scaledY);
    }


    @Override
    public void operateTo(int x, int y)
    {
        setAllCoordinates(x, y);
        super.operateTo(scaledX, scaledY);
    }

    private void setAllCoordinates(int x, int y)
    {
        if (startX == null && startY == null) {
            startX = x;
            startY = y;
            scaledX = x;
            scaledY = y;
        } else if (startX != null && x == startX && y == startY) {
            scaledX = x;
            scaledY = y;
        } else
        {
            int distanceX = Math.abs(unscaledX - x);
            int distanceY = Math.abs(unscaledY - y);

            if (unscaledX > x) {
                scaledX = Math.round(scaledX - (scalingFactor * distanceX));
            } else if (unscaledX < x) {
                scaledX = Math.round(scaledX + (scalingFactor * distanceX));
            }

            if (unscaledY > y) {
                scaledY = Math.round(scaledY - (scalingFactor * distanceY));
            } else if (unscaledY < y) {
                scaledY = Math.round(scaledY + (scalingFactor * distanceY));
            }
        }

        unscaledX = x;
        unscaledY = y;
    }


}
