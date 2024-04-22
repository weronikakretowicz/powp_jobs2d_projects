package edu.kis.powp.jobs2d.command;

import java.awt.Point;

public abstract class TransformationVisitor implements CommandVisitor {

    private final CompoundCommand transformedCommands;

    public CompoundCommand getTransformedCommand() {
        return transformedCommands;
    }

    public TransformationVisitor(String name) {
        this.transformedCommands = new CompoundCommand(name);
    }

    @Override
    public void visit(OperateToCommand operateToCommand){
        Point point = new Point(operateToCommand.getX(), operateToCommand.getY());
        applyTransformation(point, OperateToCommand::new);
    }

    @Override
    public void visit(SetPositionCommand setPositionCommand){
        Point point = new Point(setPositionCommand.getX(), setPositionCommand.getY());
        applyTransformation(point, SetPositionCommand::new);
    }

    @Override
    public void visit(ICompoundCommand compoundCommand) {
        compoundCommand.iterator().forEachRemaining(command -> command.accept(this));
    }

    protected abstract Point transform(Point point);

    protected void applyTransformation(Point point, CommandCreator commandCreator) {
        Point transformedPoint = transform(point);
        add(commandCreator.create(transformedPoint.x, transformedPoint.y));
    }

    private void add(DriverCommand command) {
        this.transformedCommands.addCommand(command);
    }

    @Override
    public String toString() {
        return transformedCommands.toString();
    }

    /**
     * Functional interface for OperationToCommand and SetPositionCommand constructors.
     */
    @FunctionalInterface
    protected interface CommandCreator {
        DriverCommand create(int x, int y);
    }
}
