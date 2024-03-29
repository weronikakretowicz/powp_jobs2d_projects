package edu.kis.powp.jobs2d.command;

public class CommandCounter implements CommandVisitor {

	@Override
	public void visit(OperateToCommand operateToCommand) {
		System.out.println("Visited OperateToCommand");
		System.out.println("X: " + operateToCommand.getPosX());
		System.out.println("Y: " + operateToCommand.getPosY());
	}

	@Override
	public void visit(SetPositionCommand setPositionCommand) {
		System.out.println("Visited SetPositionCommand");
		System.out.println("X: " + setPositionCommand.getPosX());
		System.out.println("Y: " + setPositionCommand.getPosY());
	}

	@Override
	public void visit(ICompoundCommand compoundCommand) {
		System.out.println("Visited ICompoundCommand");
	}
}
