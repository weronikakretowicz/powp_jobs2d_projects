package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.CommandRotateVisitor;
import edu.kis.powp.jobs2d.command.manager.CommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandRotateTest implements ActionListener {

    double degrees;
    public CommandRotateTest(double degrees) {
        this.degrees = degrees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CommandManager commandManager = CommandsFeature.getCommandManager();
        CommandRotateVisitor commandRotateVisitor = new CommandRotateVisitor(this.degrees);

        commandManager.getCurrentCommand().accept(commandRotateVisitor);

        commandManager.setCurrentCommand(commandRotateVisitor.getCompoundCommand());
    }
}
