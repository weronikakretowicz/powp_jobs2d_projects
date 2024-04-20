package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.CommandManager;
import edu.kis.powp.jobs2d.command.CommandScaleVisitor;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandScaleTest implements ActionListener {

    double scale;
    public CommandScaleTest(double scale) {
        this.scale = scale;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandManager commandManager = CommandsFeature.getCommandManager();
        CommandScaleVisitor commandScaleVisitor = new CommandScaleVisitor(this.scale);

        DriverCommand command = commandManager.getCurrentCommand();

        command.accept(commandScaleVisitor);

        commandManager.setCurrentCommand(commandScaleVisitor.getCompoundCommand());
    }
}
