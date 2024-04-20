package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.command.manager.TransformationVisitor;

public class CommandScaleVisitor extends TransformationVisitor {

    private final double scale;

    public CommandScaleVisitor(double scale) {
        super("Scaled("+scale+"x)");
        this.scale = scale;
    }

    @Override
    public void visit(OperateToCommand operateToCommand) {
        operateToCommand.execute(getDriver());
        int x = getDriver().getX();
        int y = getDriver().getY();
        DriverCommand scaledCommand = new OperateToCommand((int) (this.scale * x), (int) (this.scale * y));
        this.add(scaledCommand);
    }

    @Override
    public void visit(SetPositionCommand setPositionCommand) {
        setPositionCommand.execute(getDriver());
        int x = getDriver().getX();
        int y = getDriver().getY();
        DriverCommand scaledCommand = new SetPositionCommand((int) (this.scale * x), (int) (this.scale * y));
        this.add(scaledCommand);
    }
}