package edu.kis.powp.jobs2d.command;

import java.awt.Point;

public class CommandRotateVisitor extends TransformationVisitor {

    private final double angleInRadians;

    public CommandRotateVisitor(String name, double degrees) {
        super(name + "_rotated(" + degrees + "°)");
        this.angleInRadians = Math.toRadians(degrees);
    }

    @Override
    protected Point transform(Point point) {
        int newX = (int) (point.x * Math.cos(this.angleInRadians) - point.y * Math.sin(this.angleInRadians));
        int newY = (int) (point.x * Math.sin(this.angleInRadians) + point.y * Math.cos(this.angleInRadians));
        return new Point(newX, newY);
    }
}
