package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.CommandFlipVisitor;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.manager.CommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandFlipTest implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CommandManager commandManager = CommandsFeature.getCommandManager();
        DriverCommand currentCommand = commandManager.getCurrentCommand();
        CommandFlipVisitor commandFlipVisitor = new CommandFlipVisitor(currentCommand.toString());

        currentCommand.accept(commandFlipVisitor);
        commandManager.setCurrentCommand(commandFlipVisitor.getTransformedCommand());
    }
}
