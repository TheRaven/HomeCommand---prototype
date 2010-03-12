package com.ravenxq.houseCommand.itunes;

import java.io.File;
import java.util.HashMap;

import javax.speech.recognition.FinalRuleResult;

import com.dt.iTunesController.iTunes;
import com.ravenxq.houseCommand.command.Command;
import com.ravenxq.houseCommand.itunes.command.AbstractItunesCommand;
import com.ravenxq.houseCommand.itunes.command.CurrentTrackCommand;
import com.ravenxq.houseCommand.itunes.command.MuteCommand;
import com.ravenxq.houseCommand.itunes.command.PlayArtistCommand;
import com.ravenxq.houseCommand.itunes.command.PlayPauseCommand;
import com.ravenxq.houseCommand.itunes.command.PlayPlaylistCommand;
import com.ravenxq.houseCommand.itunes.command.PlayRandomCommand;
import com.ravenxq.houseCommand.itunes.command.PlayRepeatCommand;
import com.ravenxq.houseCommand.itunes.command.TrackChangeCommand;
import com.ravenxq.houseCommand.itunes.command.VolumeCommand;

public class ItunesCommand implements Command {

    HashMap<String, AbstractItunesCommand> itunesCommands;

    public void execute(final FinalRuleResult result) {
        this.itunesCommands = new HashMap<String, AbstractItunesCommand>();
        final iTunes player = new iTunes();

        this.itunesCommands.put("<itunesCurrentSongCommand>", new CurrentTrackCommand(player));
        this.itunesCommands.put("<itunesTrackChangeCommand>", new TrackChangeCommand(player));
        this.itunesCommands.put("<itunesPlayPauseCommand>", new PlayPauseCommand(player));
        this.itunesCommands.put("<itunesVolumeCommand>", new VolumeCommand(player));
        this.itunesCommands.put("<itunesMuteCommand>", new MuteCommand(player));
        this.itunesCommands.put("<itunesPlayPlaylistCommand>", new PlayPlaylistCommand(player));
        this.itunesCommands.put("<itunesPlayArtistCommand>", new PlayArtistCommand(player));
        this.itunesCommands.put("<itunesPlayRandomCommand>", new PlayRandomCommand(player));
        this.itunesCommands.put("<itunesPlayRepeatCommand>", new PlayRepeatCommand(player));

        final String commandName = result.getRuleName(0);

        if (commandName != null) {

            final AbstractItunesCommand command = this.itunesCommands.get(commandName);
            if (command != null) {
                command.execute(result);
            }

        }

    }

    public File getGrammarFile() {
        return new File("grammars/itunes.txt");
    }

    public String getRuleName() {
        return "com.ravenxq.houseCommand.itunes";
    }

}
