package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.command.manager.TransformationVisitor;

public class CommandFlipVisitor extends TransformationVisitor {

    public CommandFlipVisitor() {
        super("Flipped");
    }

    @Override
    public void visit(OperateToCommand operateToCommand) {
        operateToCommand.execute(getDriver());
        int x = getDriver().getX();
        int y = getDriver().getY();
        DriverCommand flippedCommand = new OperateToCommand(-x, y);
        this.add(flippedCommand);
    }

    @Override
    public void visit(SetPositionCommand setPositionCommand) {
        setPositionCommand.execute(getDriver());
        int x = getDriver().getX();
        int y = getDriver().getY();
        DriverCommand flippedCommand = new SetPositionCommand(-x, y);
        this.add(flippedCommand);
    }
}