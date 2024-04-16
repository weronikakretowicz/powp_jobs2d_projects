package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;

public class FlippingLineDriverAdapter implements Job2dDriver {
    private final int UNDEFINED_POINT_VALUE = -10000;
    public static final int FLIP_VERTICALLY = 0;
    public static final int FLIP_HORIZONTALLY = 1;
    public static final int FLIP_BOTH_SIDES = 2;

    private final ILine line;
    private int flippedX = 0, flippedY = 0;
    private int startX = UNDEFINED_POINT_VALUE, startY = UNDEFINED_POINT_VALUE;
    private final String name;
    private final int flippingDirection;
    private final DrawPanelController drawController;

    public FlippingLineDriverAdapter(DrawPanelController drawController, ILine line, String name, int flippingDirection) {
        super();
        this.drawController = drawController;
        this.line = line;
        this.name = name;
        this.flippingDirection = flippingDirection;
    }

    @Override
    public void setPosition(int x, int y) {
        if (startX == UNDEFINED_POINT_VALUE && startY == UNDEFINED_POINT_VALUE) {
            startX = x;
            startY = y;
            flippedX = x;
            flippedY = y;
            return;
        }

        switch (flippingDirection) {
            case FLIP_BOTH_SIDES: {
                int verticalDistance = y - startY;
                int horizontalDistance = x - startX;
                flippedY = startY - verticalDistance;
                flippedX = startX - horizontalDistance;
                break;
            }
            case FLIP_VERTICALLY: {
                int verticalDistance = y - startY;
                flippedY = startY - verticalDistance;
                flippedX = x;
                break;
            }
            case FLIP_HORIZONTALLY: {
                int horizontalDistance = x - startX;
                flippedX = startX - horizontalDistance;
                flippedY = y;
                break;
            }
        }
    }

    @Override
    public void operateTo(int x, int y) {
        line.setStartCoordinates(flippedX, flippedY);
        this.setPosition(x, y);
        line.setEndCoordinates(flippedX, flippedY);

        drawController.drawLine(line);
    }

    @Override
    public String toString() {
        return "2d device simulator - " + name;
    }
}
