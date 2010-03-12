package com.ravenxq.houseCommand.itunes.command;

import javax.speech.recognition.FinalRuleResult;

import com.dt.iTunesController.iTunes;

public class PlayPauseCommand extends AbstractItunesCommand {
    public PlayPauseCommand(final iTunes player) {
        super(player);
    }

    @Override
    public void execute(final FinalRuleResult result) {

        // we should get only one tag
        final String[] tags = result.getTags();

        if (tags[0].equals("PLAY")) {
            this.player.playPause();
        } else if (tags[0].equals("PAUSE")) {
            this.player.pause();
        }

    }
}
