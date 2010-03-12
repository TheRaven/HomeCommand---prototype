package com.ravenxq.houseCommand.command;

import java.io.File;

import javax.speech.recognition.FinalRuleResult;

public interface Command {
    public File getGrammarFile();

    public String getRuleName();

    public void execute(FinalRuleResult result);

}
