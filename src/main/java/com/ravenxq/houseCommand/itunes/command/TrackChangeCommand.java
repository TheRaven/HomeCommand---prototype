package com.ravenxq.houseCommand.itunes.command;

import javax.speech.recognition.FinalRuleResult;

import com.dt.iTunesController.iTunes;

public class TrackChangeCommand extends AbstractItunesCommand {
    public TrackChangeCommand(final iTunes player) {
        super(player);
    }

    @Override
    public void execute(final FinalRuleResult result) {

        // we should get only one tag
        final String[] tags = result.getTags();

        if (tags[0].equals("PREVIOUS")) {
            this.player.previousTrack();
        } else if (tags[0].equals("NEXT")) {
            this.player.nextTrack();
        }

    }

}
