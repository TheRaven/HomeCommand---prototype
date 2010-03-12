package com.ravenxq.houseCommand.itunes.command;

import java.util.HashMap;

import javax.speech.recognition.FinalRuleResult;
import javax.speech.recognition.ResultToken;

import com.dt.iTunesController.iTunes;

public class VolumeCommand extends AbstractItunesCommand {
    public VolumeCommand(final iTunes player) {
        super(player);
    }

    @Override
    public void execute(final FinalRuleResult result) {

        // we should get only one tag
        final String[] tags = result.getTags();

        if (tags[0].equals("UP")) {
            this.player.setSoundVolume(this.player.getSoundVolume() + 10);
        } else if (tags[0].equals("DOWN")) {
            this.player.setSoundVolume(this.player.getSoundVolume() - 10);
        } else if (tags[0].equals("VOLUME")) {
            final ResultToken[] tokens = result.getBestTokens();
            this.player.setSoundVolume(this.parseVolumeString(tokens[tokens.length - 1].getSpokenText()));
        }
    }

    private Integer parseVolumeString(final String volume) {
        final HashMap<String, Integer> numbers = new HashMap<String, Integer>();
        numbers.put("ten", 10);
        numbers.put("twenty", 20);
        numbers.put("thirty", 30);
        numbers.put("forty", 40);
        numbers.put("fifty", 50);
        numbers.put("sixty", 60);
        numbers.put("seventy", 70);
        numbers.put("eighty", 80);
        numbers.put("ninety", 90);
        numbers.put("hundred", 100);

        Integer vol = numbers.get(volume);

        if (vol == null) {
            vol = 50;
        }

        return vol;
    }

}
