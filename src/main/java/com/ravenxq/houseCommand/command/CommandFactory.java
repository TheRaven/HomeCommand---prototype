package com.ravenxq.houseCommand.command;

import java.util.HashMap;

import com.ravenxq.houseCommand.itunes.ItunesCommand;

public class CommandFactory {

    static HashMap<String, Command> commands = new HashMap<String, Command>();

    public static Command getCommand(final String commandName) {
        if (commands.containsKey(commandName)) {
            return commands.get(commandName);
        }

        Command command = null;

        System.out.println(commandName);
        if (commandName.equals("com.ravenxq.houseCommand.time")) {
            command = new TimeCommand();
        } else if (commandName.equals("com.ravenxq.houseCommand.weather")) {
            command = new WeatherCommand();
        } else if (commandName.equals("com.ravenxq.houseCommand.itunes")) {
            command = new ItunesCommand();
        }

        commands.put(commandName, command);

        return command;
    }
}
