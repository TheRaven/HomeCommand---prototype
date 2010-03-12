package com.ravenxq.houseCommand;

import java.io.FileReader;
import java.util.Locale;

import javax.speech.Central;
import javax.speech.EngineModeDesc;
import javax.speech.recognition.FinalRuleResult;
import javax.speech.recognition.Recognizer;
import javax.speech.recognition.ResultAdapter;
import javax.speech.recognition.ResultEvent;
import javax.speech.recognition.ResultToken;

import com.ravenxq.houseCommand.command.Command;
import com.ravenxq.houseCommand.command.CommandFactory;
import com.ravenxq.houseCommand.command.DefaultCommand;

public class CommandListener extends ResultAdapter {
    static Recognizer rec;

    private boolean listenToSubcommand = false;

    public CommandListener() {
        try {
            rec = Central.createRecognizer(new EngineModeDesc(Locale.ENGLISH));

            // Start up the recognizer
            rec.allocate();

            // Load the grammar from a file, and enable it
            final FileReader reader = new FileReader("grammars/main.txt");
            rec.loadJSGF(reader).setEnabled(true);
            rec.loadJSGF(new FileReader("grammars/numbers.txt")).setEnabled(true);

            rec.loadJSGF(new FileReader("grammars/time.txt")).setEnabled(true);
            rec.loadJSGF(new FileReader("grammars/weather.txt")).setEnabled(true);
            rec.loadJSGF(new FileReader("grammars/itunes.txt")).setEnabled(true);
            // Add the listener to get results
            rec.addResultListener(this);

            // Commit the grammar
            rec.commitChanges();

            // Request focus and start listening
            rec.requestFocus();
            rec.resume();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resultAccepted(final ResultEvent e) {
        final FinalRuleResult r = (FinalRuleResult) (e.getSource());
        if (r.getGrammar().getName().equals("com.ravenxq.houseCommand.main")) {
            this.listenToSubcommand = true;
            (new DefaultCommand()).execute(r);
        } else if (this.listenToSubcommand) {
            final Command command = CommandFactory.getCommand(r.getGrammar().getName());
            if (command != null) {
                command.execute(r);
            }
            this.listenToSubcommand = false;
        }

    }

    @Override
    public void resultRejected(final ResultEvent e) {

        System.out.println("Rejected");

        final FinalRuleResult r = (FinalRuleResult) (e.getSource());

        final StringBuffer buffer = new StringBuffer();
        for (final ResultToken token : r.getBestTokens()) {
            System.out.println(token.getWrittenText());
            buffer.append(token.getSpokenText().toLowerCase());
        }
        this.listenToSubcommand = false;
    }

}
