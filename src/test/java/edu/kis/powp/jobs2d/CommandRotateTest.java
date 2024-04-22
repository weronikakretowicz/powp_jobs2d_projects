package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.CommandRotateVisitor;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.CommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandRotateTest implements ActionListener {

    private final double degrees;
    public CommandRotateTest(double degrees) {
        this.degrees = degrees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandManager commandManager = CommandsFeature.getCommandManager();
        DriverCommand currentCommand = commandManager.getCurrentCommand();
        CommandRotateVisitor commandRotateVisitor = new CommandRotateVisitor(currentCommand.toString(), this.degrees);

        currentCommand.accept(commandRotateVisitor);
        commandManager.setCurrentCommand(commandRotateVisitor.getTransformedCommand());
    }
}
