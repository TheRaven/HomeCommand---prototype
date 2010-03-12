package com.ravenxq.houseCommand.itunes.command;

import javax.speech.recognition.FinalRuleResult;

import com.dt.iTunesController.ITPlaylistSearchField;
import com.dt.iTunesController.ITTrackCollection;
import com.dt.iTunesController.iTunes;

public class PlayArtistCommand extends AbstractItunesCommand {
    public PlayArtistCommand(final iTunes player) {
        super(player);
    }

    @Override
    public void execute(final FinalRuleResult result) {
        /*
         * final StringBuffer buff = new StringBuffer(); for (final ResultToken
         * resultToken : tokens) {
         * System.out.println(resultToken.getSpokenText()); if
         * (!resultToken.getWrittenText().equals("play") &&
         * !resultToken.getWrittenText().equals("artist)")) {
         * buff.append(resultToken.getSpokenText()); } }
         */
        final ITTrackCollection tracks = this.player.getLibraryPlaylist().search("alexisonfire", ITPlaylistSearchField.ITPlaylistSearchFieldArtists);

        if (tracks.getCount() > 0) {
            tracks.getItem(1).play();
        }

    }
}
