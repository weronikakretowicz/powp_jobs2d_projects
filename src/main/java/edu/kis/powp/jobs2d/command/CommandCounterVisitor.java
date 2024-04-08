package edu.kis.powp.jobs2d.command;

public class CommandCounterVisitor implements CommandVisitor {
	private int operateToCount = 0;

	private int setPositionCount = 0;
	private int iCompoundCommandCount = 0;

	public int getOperateToCount() {
		return operateToCount;
	}

	public int getSetPositionCount() {
		return setPositionCount;
	}

	public int getICompoundCommandCount() {
		return iCompoundCommandCount;
	}

	@Override
	public void visit(OperateToCommand operateToCommand) {
		if (operateToCount == 0) {
			operateToCount = 1;
			setPositionCount = 0;
		}
	}

	@Override
	public void visit(SetPositionCommand setPositionCommand) {
		if (setPositionCount == 0) {
			setPositionCount = 1;
			operateToCount = 0;
		}
	}

	@Override
	public void visit(ICompoundCommand compoundCommand) {
		iCompoundCommandCount++;
	}
}
