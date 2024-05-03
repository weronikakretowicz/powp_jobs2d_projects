package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.command.DeepCopyVisitor;
import edu.kis.powp.jobs2d.command.manager.CommandManager;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class DeepCopyVisitorSaveTest implements ActionListener {
    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Override
    public void actionPerformed(ActionEvent e) {
        CommandManager commandManager = CommandsFeature.getCommandManager();
        if (commandManager.getCurrentCommand() != null)
            commandManager.getCurrentCommand().accept(DeepCopyVisitorTest.getDeepCopy());
        else
            logger.warning("Cannot save deep copy of empty command");
    }
}
