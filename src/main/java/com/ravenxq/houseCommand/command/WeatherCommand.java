package com.ravenxq.houseCommand.command;

import java.io.File;
import java.net.URL;

import javax.speech.recognition.FinalRuleResult;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.ravenxq.houseCommand.CommandAnswer;

public class WeatherCommand implements Command {

    public void execute(final FinalRuleResult result) {
        try {

            final URL feedUrl = new URL("http://weather.yahooapis.com/forecastrss?w=3534&u=c");

            this.parse(feedUrl);

        } catch (final Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR: " + ex.getMessage());
        }

    }

    public File getGrammarFile() {
        return new File("grammars/time.txt");
    }

    public String getRuleName() {
        return "com.ravenxq.houseCommand.weather";
    }

    private void parse(final URL url) throws Exception {

        final SAXReader xmlReader = this.createXmlReader();

        final Document doc = xmlReader.read(url);
        // System.out.println(doc.asXML());

        final Node node = doc.selectSingleNode("//yweather:condition/@temp");
        final Node nodeCondition = doc.selectSingleNode("//yweather:condition/@text");

        int temperature = Integer.parseInt(node.getStringValue());

        String modifier = "";
        if (temperature < 0) {
            modifier = "minus";
        }
        temperature = Math.abs(temperature);

        CommandAnswer.say("Condition is<break size=\"small\"/> " + nodeCondition.getStringValue() + " with a current temperature of<break size=\"small\"/> " + modifier + " " + temperature + " selsius");

    }

    private SAXReader createXmlReader() {

        final SAXReader xmlReader = new SAXReader();
        return xmlReader;
    }

}
