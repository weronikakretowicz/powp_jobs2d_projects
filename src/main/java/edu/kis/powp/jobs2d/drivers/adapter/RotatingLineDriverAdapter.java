package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

public class RotatingLineDriverAdapter implements Job2dDriver {
    private final int UNDEFINED_POINT_VALUE = -10000;
    public static final int ROTATE_90_CLOCKWISE = 0;
    public static final int ROTATE_90_COUNTERCLOCKWISE = 1;
    public static final int ROTATE_180 = 2;

    private final ILine line;
    private int rotatedX = 0, rotatedY = 0;
    private int startX = UNDEFINED_POINT_VALUE, startY = UNDEFINED_POINT_VALUE;
    private final String name;
    private final int rotationDegree;
    private final DrawPanelController drawController;

    public RotatingLineDriverAdapter(DrawPanelController drawController, ILine line, String name, int rotationDegree) {
        super();
        this.drawController = drawController;
        this.line = line;
        this.name = name;
        this.rotationDegree = rotationDegree;
    }

    @Override
    public void setPosition(int x, int y) {
        if (startX == UNDEFINED_POINT_VALUE && startY == UNDEFINED_POINT_VALUE) {
            startX = x;
            startY = y;
            rotatedX = x;
            rotatedY = y;
            return;
        }

        switch (rotationDegree) {
            case ROTATE_90_CLOCKWISE: {
                rotatedY = startY + (x - startX);
                rotatedX = startX + (startY - y);
                break;
            }
            case ROTATE_90_COUNTERCLOCKWISE: {
                rotatedY = startY + (startX - x);
                rotatedX = startX + (y - startY);
                break;
            }
            case ROTATE_180: {
                rotatedY = startY - (y - startY);
                rotatedX = startX - (x - startX);
                break;
            }
        }
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(rotatedX, rotatedY);
        this.setPosition(x, y);
        line.setEndCoordinates(rotatedX, rotatedY);

        drawController.drawLine(line);
    }

    @Override
    public String toString() {
        return "2d device simulator - " + name;
    }
}
