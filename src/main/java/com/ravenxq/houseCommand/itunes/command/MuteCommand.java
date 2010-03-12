package com.ravenxq.houseCommand.itunes.command;

import javax.speech.recognition.FinalRuleResult;

import com.dt.iTunesController.iTunes;

public class MuteCommand extends AbstractItunesCommand {
    public MuteCommand(final iTunes player) {
        super(player);
    }

    @Override
    public void execute(final FinalRuleResult result) {
        this.player.setMute(!this.player.getMute());
    }

}
