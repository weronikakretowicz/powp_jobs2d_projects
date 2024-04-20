package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.command.manager.TransformationVisitor;

public class CommandRotateVisitor extends TransformationVisitor {

    private final double angleInRadians;

    public CommandRotateVisitor(double degrees) {
        super("Rotated(" + degrees + "°)");
        this.angleInRadians = Math.toRadians(degrees);
    }

    @Override
    public void visit(OperateToCommand operateToCommand) {
        operateToCommand.execute(getDriver());
        int x = getDriver().getX();
        int y = getDriver().getY();
        int newX = (int) (x * Math.cos(this.angleInRadians) - y * Math.sin(this.angleInRadians));
        int newY = (int) (x * Math.sin(this.angleInRadians) + y * Math.cos(this.angleInRadians));

        DriverCommand rotatedCommand = new OperateToCommand(newX, newY);
        this.add(rotatedCommand);
    }

    @Override
    public void visit(SetPositionCommand setPositionCommand) {
        setPositionCommand.execute(getDriver());
        int x = getDriver().getX();
        int y = getDriver().getY();
        int newX = (int) (x * Math.cos(this.angleInRadians) - y * Math.sin(this.angleInRadians));
        int newY = (int) (x * Math.sin(this.angleInRadians) + y * Math.cos(this.angleInRadians));

        DriverCommand rotatedCommand = new SetPositionCommand(newX, newY);
        this.add(rotatedCommand);
    }
}
