package edu.kis.powp.jobs2d.command;

public class ImporterFactory {
    public CommandImporter getImporter(String fileExtension) throws IllegalArgumentException {
        switch (fileExtension) {
            case "json":
                return new JsonCommandImporter();
            // todo: add support for other file extensions
            default:
                throw new IllegalArgumentException("Invalid file extension: " + fileExtension);
        }
    }
}
