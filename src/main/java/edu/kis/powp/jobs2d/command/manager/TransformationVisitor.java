package edu.kis.powp.jobs2d.command.manager;

import edu.kis.powp.jobs2d.command.*;
import edu.kis.powp.jobs2d.drivers.TransformationDriver;

import java.util.ArrayList;
import java.util.List;

public abstract class TransformationVisitor implements CommandVisitor {

    private final List<DriverCommand> transformedCommands = new ArrayList<>();
    private final TransformationDriver driver = new TransformationDriver();
    private final String name;

    public TransformationVisitor(String name) {
        this.name = name;
    }

    public CompoundCommand getCompoundCommand() {
        return new CompoundCommand(transformedCommands, toString());
    }

    public TransformationDriver getDriver() {
        return driver;
    }

    @Override
    public abstract void visit(OperateToCommand operateToCommand);

    @Override
    public abstract void visit(SetPositionCommand setPositionCommand);

    @Override
    public void visit(ICompoundCommand compoundCommand) {
        compoundCommand.iterator().forEachRemaining(command -> command.accept(this));
    }

    protected void add(DriverCommand scaledCommand) {
        this.transformedCommands.add(scaledCommand);
    }

    @Override
    public String toString() {
        return name;
    }
}
