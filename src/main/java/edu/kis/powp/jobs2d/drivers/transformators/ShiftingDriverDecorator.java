package edu.kis.powp.jobs2d.drivers.transformators;

import edu.kis.powp.jobs2d.Job2dDriver;

public class ShiftingDriverDecorator extends Job2dDriverDecorator {
    private final int shiftInXDirection, shiftInYDirection;
    private int shiftedX, shiftedY;

    public ShiftingDriverDecorator(Job2dDriver job2dDriver, int shiftInXDirection, int shiftInYDirection) {
        super(job2dDriver);
        this.shiftInXDirection = shiftInXDirection;
        this.shiftInYDirection = shiftInYDirection;
    }

    @Override
    public void setPosition(int x, int y) {
        shift(x, y);
        super.setPosition(shiftedX, shiftedY);
    }

    @Override
    public void operateTo(int x, int y) {
        shift(x, y);
        super.operateTo(shiftedX, shiftedY);
    }

    private void shift(int x, int y) {
        shiftedX = x + shiftInXDirection;
        shiftedY = y - shiftInYDirection;
    }
}
