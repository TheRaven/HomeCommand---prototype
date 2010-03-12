package com.ravenxq.houseCommand.itunes.command;

import javax.speech.recognition.FinalRuleResult;

import com.dt.iTunesController.ITTrack;
import com.dt.iTunesController.iTunes;
import com.ravenxq.houseCommand.CommandAnswer;

public class CurrentTrackCommand extends AbstractItunesCommand {
    public CurrentTrackCommand(final iTunes player) {
        super(player);
    }

    @Override
    public void execute(final FinalRuleResult result) {
        final int currentVolume = this.player.getSoundVolume();
        if (currentVolume > 25) {
            this.player.setSoundVolume(25);
        }
        final ITTrack track = this.player.getCurrentTrack();
        final String songName = track.getName();
        final String artist = track.getArtist();
        CommandAnswer.say("Currently playing is<break size=\"small\"/> " + songName + " by " + artist);
        this.player.setSoundVolume(currentVolume);
    }
}
