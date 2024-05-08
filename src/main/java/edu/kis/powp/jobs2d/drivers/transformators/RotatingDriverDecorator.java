package edu.kis.powp.jobs2d.drivers.transformators;

import edu.kis.powp.jobs2d.Job2dDriver;

public class RotatingDriverDecorator extends Job2dDriverDecorator {
    public static final int ROTATE_90_DEG_CLOCKWISE = 0;
    public static final int ROTATE_90_DEG_COUNTERCLOCKWISE = 1;
    public static final int ROTATE_180_DEG = 2;

    private int rotatedX = 0, rotatedY = 0;
    private int rotationOption;

    public RotatingDriverDecorator(Job2dDriver job2dDriver, int rotationOption) {
        super(job2dDriver);
        this.rotationOption = rotationOption;
    }

    @Override
    public void setPosition(int x, int y)
    {
        rotate(x, y);
        super.setPosition(rotatedX, rotatedY);
    }

    @Override
    public void operateTo(int x, int y)
    {
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

    public void setRotationOption(int rotationOption) {
        this.rotationOption = rotationOption;
    }

    public int getRotationOption() {
        return rotationOption;
    }
}
