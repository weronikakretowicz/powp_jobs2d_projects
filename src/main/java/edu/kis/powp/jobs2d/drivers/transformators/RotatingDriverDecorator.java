package edu.kis.powp.jobs2d.drivers.transformators;

import edu.kis.powp.jobs2d.Job2dDriver;

public class RotatingDriverDecorator extends Job2dDriverDecorator {
    enum RotationOption {
        ROTATE_90_DEG_CLOCKWISE,
        ROTATE_90_DEG_COUNTERCLOCKWISE,
        ROTATE_180_DEG
    }

    private int rotatedX = 0, rotatedY = 0;
    private final RotationOption rotationOption;

    private RotatingDriverDecorator(Job2dDriver job2dDriver, RotationOption rotationOption) {
        super(job2dDriver);
        this.rotationOption = rotationOption;
    }

    @Override
    public void setPosition(int x, int y) {
        rotate(x, y);
        super.setPosition(rotatedX, rotatedY);
    }

    @Override
    public void operateTo(int x, int y) {
        rotate(x, y);
        super.operateTo(rotatedX, rotatedY);
    }

    private void rotate(int x, int y) {
        switch (rotationOption) {
            case ROTATE_90_DEG_CLOCKWISE: {
                rotatedY = x;
                rotatedX = -y;
                break;
            }
            case ROTATE_90_DEG_COUNTERCLOCKWISE: {
                rotatedY = -x;
                rotatedX = y;
                break;
            }
            case ROTATE_180_DEG: {
                rotatedY = -y;
                rotatedX = -x;
                break;
            }
        }
    }

    static public RotatingDriverDecorator getRotating90DegClockwiseDecorator(Job2dDriver job2dDriver) {
        return new RotatingDriverDecorator(job2dDriver, RotationOption.ROTATE_90_DEG_CLOCKWISE);
    }

    static public RotatingDriverDecorator getRotating90DegCounterclockwiseDecorator(Job2dDriver job2dDriver) {
        return new RotatingDriverDecorator(job2dDriver, RotationOption.ROTATE_90_DEG_COUNTERCLOCKWISE);
    }

    static public RotatingDriverDecorator getRotating180DegDecorator(Job2dDriver job2dDriver) {
        return new RotatingDriverDecorator(job2dDriver, RotationOption.ROTATE_180_DEG);
    }
}
