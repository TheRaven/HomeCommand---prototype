package com.ravenxq.houseCommand.command;

import java.io.File;

import javax.speech.recognition.FinalRuleResult;
import javax.speech.recognition.ResultToken;

import com.ravenxq.houseCommand.CommandAnswer;

public class DefaultCommand implements Command {

    public void execute(final FinalRuleResult result) {

        final StringBuffer buffer = new StringBuffer();

        for (final ResultToken token : result.getBestTokens()) {
            System.out.println(token.getWrittenText());
            buffer.append(token.getSpokenText().toLowerCase());
        }
        System.out.println(buffer.toString());
        if (buffer.toString().equals("thankyou")) {
            CommandAnswer.say("no problem");
        } else if (buffer.toString().equals("stopprogram")) {

            System.exit(0);
        } else {
            CommandAnswer.say("Yes?");
        }
    }

    public File getGrammarFile() {
        return new File("timeGrammar.txt");
    }

    public String getRuleName() {
        return "com.ravenxq.houseCommand.main";
    }
}
