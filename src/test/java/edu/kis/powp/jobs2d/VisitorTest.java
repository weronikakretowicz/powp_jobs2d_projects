package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.*;

import java.util.ArrayList;
import java.util.List;

public class VisitorTest {
	public static void main(String[] args) {
		List<DriverCommand> commands = new ArrayList<>();

		commands.add(new SetPositionCommand(-50, -50));
		commands.add(new OperateToCommand(-50, 50));
		commands.add(new OperateToCommand(50, 50));
		commands.add(new OperateToCommand(50, -50));
		commands.add(new OperateToCommand(-50, -50));

		CommandCounter commandCounter = new CommandCounter();

		for(DriverCommand command : commands){
			command.accept(commandCounter);
		}
	}
}
