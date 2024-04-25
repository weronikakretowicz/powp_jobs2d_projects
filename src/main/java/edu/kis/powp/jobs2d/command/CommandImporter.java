package edu.kis.powp.jobs2d.command;

import java.io.IOException;

public interface CommandImporter {
    DriverCommand importCommands(String filePath);
}