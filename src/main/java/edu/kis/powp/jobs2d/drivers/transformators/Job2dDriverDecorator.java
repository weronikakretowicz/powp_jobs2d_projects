package edu.kis.powp.jobs2d.drivers.transformators;

import edu.kis.powp.jobs2d.Job2dDriver;

public class Job2dDriverDecorator implements Job2dDriver {
    private final Job2dDriver job2dDriver;


    public Job2dDriverDecorator(Job2dDriver job2dDriver) {
        this.job2dDriver = job2dDriver;
    }

    @Override
    public void setPosition(int x, int y) {
        job2dDriver.setPosition(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        job2dDriver.operateTo(x, y);
    }
}
