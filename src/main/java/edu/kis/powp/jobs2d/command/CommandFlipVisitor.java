package edu.kis.powp.jobs2d.command;

import java.awt.Point;

public class CommandFlipVisitor extends TransformationVisitor {

    public CommandFlipVisitor(String name) {
        super(name + "_flipped");
    }

    @Override
    protected Point transform(Point point) {
        int newX = point.x * -1;
        int newY = point.y;
        return new Point(newX, newY);
    }
}