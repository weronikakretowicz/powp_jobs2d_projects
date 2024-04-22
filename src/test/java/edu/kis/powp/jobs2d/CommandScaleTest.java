package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.CommandManager;
import edu.kis.powp.jobs2d.command.CommandScaleVisitor;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandScaleTest implements ActionListener {

    private final double scale;
    public CommandScaleTest(double scale) {
        this.scale = scale;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandManager commandManager = CommandsFeature.getCommandManager();
        DriverCommand currentCommand = commandManager.getCurrentCommand();
        CommandScaleVisitor commandScaleVisitor = new CommandScaleVisitor(currentCommand.toString(), this.scale);

        currentCommand.accept(commandScaleVisitor);
        commandManager.setCurrentCommand(commandScaleVisitor.getTransformedCommand());
    }
}
