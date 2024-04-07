package edu.kis.powp.jobs2d.command;

public class CommandCounterVisitor implements CommandVisitor {
	private int operateToCount = 0;

	private int setPositionCount = 0;
	private int iCompoundCommand = 0;

	public int getOperateToCount() {
		return operateToCount;
	}

	public int getSetPositionCount() {
		return setPositionCount;
	}

	public int getICompoundCommand() {
		return iCompoundCommand;
	}

	@Override
	public void visit(OperateToCommand operateToCommand) {
		operateToCount++;
	}

	@Override
	public void visit(SetPositionCommand setPositionCommand) {
		setPositionCount++;
	}

	@Override
	public void visit(ICompoundCommand compoundCommand) {
		iCompoundCommand++;
	}
}
