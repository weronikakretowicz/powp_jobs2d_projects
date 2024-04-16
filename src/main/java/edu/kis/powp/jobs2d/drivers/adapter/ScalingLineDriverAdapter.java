package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

public class ScalingLineDriverAdapter implements Job2dDriver {
    private final int UNDEFINED_POINT_VALUE = -10000;

    private final ILine line;
    private int unscaledX = 0, unscaledY = 0;
    private int scaledX = 0, scaledY = 0;
    private int startX = UNDEFINED_POINT_VALUE, startY = UNDEFINED_POINT_VALUE;
    private final String name;
    private final float scalingFactor;
    private final DrawPanelController drawController;

    public ScalingLineDriverAdapter(DrawPanelController drawController, ILine line, String name, float scalingFactor) {
        super();
        this.drawController = drawController;
        this.line = line;
        this.name = name;
        this.scalingFactor = scalingFactor;
    }

    @Override
    public void setPosition(int x, int y) {
        if (startX == UNDEFINED_POINT_VALUE && startY == UNDEFINED_POINT_VALUE) {
            startX = x;
            startY = y;
            scaledX = x;
            scaledY = y;
        } else if (x == startX && y == startY) {
           scaledX = x;
           scaledY = y;
        } else {
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

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(scaledX, scaledY);
        this.setPosition(x, y);
        line.setEndCoordinates(scaledX, scaledY);

        drawController.drawLine(line);
    }

    @Override
    public String toString() {
        return "2d device simulator - " + name;
    }
}
