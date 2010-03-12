package com.ravenxq.houseCommand.itunes.command;

import javax.speech.recognition.FinalRuleResult;

import com.dt.iTunesController.iTunes;

public class PlayRandomCommand extends AbstractItunesCommand {

    public PlayRandomCommand(final iTunes player) {
        super(player);
    }

    @Override
    public void execute(final FinalRuleResult result) {
        boolean shuffle = true;
        if (result.getTags().length > 0) {
            if (result.getTags()[0].equals("NOT")) {
                shuffle = false;
            }
        }
        this.player.getCurrentPlaylist().setShuffle(shuffle);

    }
}
