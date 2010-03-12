package com.ravenxq.houseCommand.itunes.command;

import javax.speech.recognition.FinalRuleResult;

import com.dt.iTunesController.ITPlaylist;
import com.dt.iTunesController.ITPlaylistCollection;
import com.dt.iTunesController.ITSource;
import com.dt.iTunesController.iTunes;

public class PlayPlaylistCommand extends AbstractItunesCommand {
    public PlayPlaylistCommand(final iTunes player) {
        super(player);
    }

    @Override
    public void execute(final FinalRuleResult result) {

        final String command = this.getTokenAsString(result.getBestTokens());
        final ITSource source = this.player.getLibrarySource();
        final ITPlaylistCollection playlists = source.getPlaylists();

        for (int i = 1; i <= playlists.getCount(); i++) {
            final ITPlaylist pl = playlists.getItem(i);
            if (command.matches(".*" + pl.getName().toLowerCase() + ".*")) {
                if (result.getTags().length > 0) {
                    if (result.getTags()[0].equals("RANDOM")) {
                        pl.setShuffle(true);
                    }
                }
                pl.playFirstTrack();
                break;
            }
        }

    }

}
