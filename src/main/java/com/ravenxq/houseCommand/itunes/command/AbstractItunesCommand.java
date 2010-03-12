package com.ravenxq.houseCommand.itunes.command;

import javax.speech.recognition.FinalRuleResult;
import javax.speech.recognition.ResultToken;

import com.dt.iTunesController.iTunes;

public abstract class AbstractItunesCommand {

    protected iTunes player = null;

    public AbstractItunesCommand(final iTunes player) {
        this.player = player;
    }

    public abstract void execute(final FinalRuleResult result);

    protected String getTokenAsString(final ResultToken[] tokens) {
        final StringBuffer tok = new StringBuffer();
        for (final ResultToken token : tokens) {
            tok.append(token.getSpokenText().toLowerCase());
        }
        return tok.toString();
    }
}
