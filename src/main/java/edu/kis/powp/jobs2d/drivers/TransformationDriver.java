package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

public class TransformationDriver implements Job2dDriver {

    private int latestX = 0;
    private int latestY = 0;

    @Override
    public void setPosition(int x, int y) {
        latestX = x;
        latestY = y;
    }

    @Override
    public void operateTo(int x, int y) {
        latestX = x;
        latestY = y;
    }

    public int getX() {
        return latestX;
    }

    public int getY() {
        return latestY;
    }
}
