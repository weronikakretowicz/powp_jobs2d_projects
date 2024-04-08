package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.*;
import edu.kis.powp.jobs2d.command.gui.CommandManagerWindow;
import edu.kis.powp.jobs2d.command.manager.CommandManager;
import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VisitorTest implements ActionListener {
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Override
	public void actionPerformed(ActionEvent e) {
		List<DriverCommand> commands = new ArrayList<>();

		commands.add(new SetPositionCommand(-50, -50));
		commands.add(new OperateToCommand(-50, 50));
		commands.add(new OperateToCommand(50, 50));
		commands.add(new OperateToCommand(50, -50));
		commands.add(new OperateToCommand(-50, -50));

		CommandCounterVisitor commandCounter = new CommandCounterVisitor();

		for(DriverCommand command : commands){
			command.accept(commandCounter);
		}

		logger.info("OperateTo commands: " + commandCounter.getOperateToCount());
		logger.info("SetPosition commands: " + commandCounter.getSetPositionCount());
	}
}
