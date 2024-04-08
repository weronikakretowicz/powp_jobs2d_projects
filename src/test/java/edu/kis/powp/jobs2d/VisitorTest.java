package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.logging.Logger;

public class VisitorTest implements ActionListener {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Override
	public void actionPerformed(ActionEvent e) {
		CompoundCommand compoundCommand = new CompoundCommand("Rectangle");
		compoundCommand.addCommand(new SetPositionCommand(-50, -50));
		compoundCommand.addCommand(new OperateToCommand(-50, 50));
		compoundCommand.addCommand(new OperateToCommand(50, 50));
		compoundCommand.addCommand(new OperateToCommand(50, -50));
		compoundCommand.addCommand(new OperateToCommand(-50, -50));

		CommandCounterVisitor commandCounter = new CommandCounterVisitor();

		Iterator<DriverCommand> iterator = compoundCommand.iterator();
		while (iterator.hasNext()) {
			DriverCommand command = iterator.next();
			command.accept(commandCounter);

			logger.info("OperateTo commands: " + commandCounter.getOperateToCount());
			logger.info("SetPosition commands: " + commandCounter.getSetPositionCount());
		}
	}
}
