package edu.kis.powp.jobs2d.drivers.transformators;

import edu.kis.powp.jobs2d.Job2dDriver;

public class FlippingDecorator extends TransformationsDriverDecorator {
    public static final int FLIP_VERTICALLY = 0;
    public static final int FLIP_HORIZONTALLY = 1;
    public static final int FLIP_BOTH_SIDES = 2;

    private int flippedX = 0, flippedY = 0;
    private int flippingDirection;

    public FlippingDecorator(Job2dDriver job2dDriver, int flippingDirection) {
        super(job2dDriver);
        this.flippingDirection = flippingDirection;
    }

    @Override
    public void setPosition(int x, int y)
    {
        flip(x, y);
        super.setPosition(flippedX, flippedY);
    }

    @Override
    public void operateTo(int x, int y)
    {
        flip(x, y);
        super.operateTo(flippedX, flippedY);
    }

    private void flip(int x, int y) {
        switch (flippingDirection) {
            case FLIP_BOTH_SIDES: {
                flippedX = -x;
                flippedY =  -y;
                break;
            }
            case FLIP_VERTICALLY: {
                flippedY = -y;
                flippedX = x;
                break;
            }
            case FLIP_HORIZONTALLY: {
                flippedX = -x;
                flippedY = y;
                break;
            }
        }
    }

    public void setFlippingDirection(int flippingDirection) {
        this.flippingDirection = flippingDirection;
    }

    public int getFlippingDirection() {
        return flippingDirection;
    }
}
