package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class CompoundCommand implements ICompoundCommand {
    private final List<DriverCommand> commands = new ArrayList<>();
    private final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void addCommand(DriverCommand command) {
        commands.add(command);
    }

    public void addCommand(DriverCommand command, int index) {
        try {
            commands.add(index, command);
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Index out of bounds");
        }
    }

    public void removeCommand(DriverCommand command) {
        commands.remove(command);
    }

    public void removeCommand(int index) {
        try {
            commands.remove(index);
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Index out of bounds");
        }
    }

    @Override
    public void execute(Job2dDriver driver) {
        iterator().forEachRemaining((c) -> c.execute(driver));
    }

    @Override
    public Iterator<DriverCommand> iterator() {
        return commands.iterator();
    }
}
