package edu.kis.powp.jobs2d.command;

import java.awt.Point;

public class CommandScaleVisitor extends TransformationVisitor {

    private final double scale;

    public CommandScaleVisitor(String name, double scale) {
        super(name + "_scaled("+scale+"x)");
        this.scale = scale;
    }

    @Override
    protected Point transform(Point point) {
        int newX = (int) (this.scale * point.x);
        int newY = (int) (this.scale * point.y);
        return new Point(newX, newY);
    }
}