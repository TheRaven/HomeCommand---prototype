package com.ravenxq.houseCommand.command;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.speech.recognition.FinalRuleResult;

import com.ravenxq.houseCommand.CommandAnswer;

public class TimeCommand implements Command {

    public void execute(final FinalRuleResult result) {

        final Calendar calendar = new GregorianCalendar();

        final String time = "Its <sayas class=\"time:hm\">" + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + "</sayas>";
        CommandAnswer.say(time);
    }

    public File getGrammarFile() {
        return new File("grammars/time.txt");
    }

    public String getRuleName() {
        return "com.ravenxq.houseCommand.time";
    }
}
