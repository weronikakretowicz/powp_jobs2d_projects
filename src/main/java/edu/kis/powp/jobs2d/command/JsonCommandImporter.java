package edu.kis.powp.jobs2d.command;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class JsonCommandImporter implements CommandImporter {

    private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Override
    public DriverCommand importCommands(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            JSONObject jsonObject = new JSONObject(content);

            String name = jsonObject.getString("name");
            JSONArray commandsArray = jsonObject.getJSONArray("commands");

            List<DriverCommand> commands = new ArrayList<>();
            for (int i = 0; i < commandsArray.length(); i++) {
                JSONObject commandObject = commandsArray.getJSONObject(i);
                DriverCommand command = createCommandFromJson(commandObject);
                commands.add(command);
            }

            return new CompoundCommand(commands, name);

        } catch (Exception e) {
            logger.warning("Error while reading file: " + e.getMessage());
            return null;
        }
    }

    private DriverCommand createCommandFromJson(JSONObject jsonObject) throws JSONException {
        String commandType = jsonObject.getString("command");
        int x = jsonObject.getInt("x");
        int y = jsonObject.getInt("y");

        switch (commandType) {
            case "setPosition":
                return new SetPositionCommand(x, y);
            case "operateTo":
                return new OperateToCommand(x, y);
            default:
                throw new IllegalArgumentException("Invalid command type: " + commandType);
        }
    }
}