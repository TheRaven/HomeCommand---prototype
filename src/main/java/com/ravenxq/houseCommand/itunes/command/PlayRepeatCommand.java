package com.ravenxq.houseCommand.itunes.command;

import javax.speech.recognition.FinalRuleResult;

import com.dt.iTunesController.ITPlaylistRepeatMode;
import com.dt.iTunesController.iTunes;

public class PlayRepeatCommand extends AbstractItunesCommand {

    public PlayRepeatCommand(final iTunes player) {
        super(player);
    }

    @Override
    public void execute(final FinalRuleResult result) {

        final String repeat = result.getTags()[0];
        if (repeat.equals("REPEAT_ALL")) {
            this.player.getCurrentPlaylist().setSongRepeat(ITPlaylistRepeatMode.ITPlaylistRepeatModeAll);
        } else if (repeat.equals("REPEAT_ONE")) {
            this.player.getCurrentPlaylist().setSongRepeat(ITPlaylistRepeatMode.ITPlaylistRepeatModeOne);
        } else {
            this.player.getCurrentPlaylist().setSongRepeat(ITPlaylistRepeatMode.ITPlaylistRepeatModeOff);
        }

    }
}
