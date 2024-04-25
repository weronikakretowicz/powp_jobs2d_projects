package edu.kis.powp.jobs2d.command;

import java.util.HashMap;
import java.util.Map;

public class ImporterFactory {
    private static final Map<String, CommandImporter> importers = new HashMap<>();
    static {
        importers.put("json", new JsonCommandImporter());
    }

    public static CommandImporter getImporter(String fileExtension) {
        CommandImporter importer = importers.get(fileExtension);
        if (importer == null) {
            throw new IllegalArgumentException("No importer found for file");
        }
        return importer;
    }
}
