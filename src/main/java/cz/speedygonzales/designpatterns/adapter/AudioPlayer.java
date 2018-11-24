package cz.speedygonzales.designpatterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vondracek
 * @since 25.10.2015 10:08
 */
public class AudioPlayer implements MediaPlayer {

    private static final Logger LOG = LoggerFactory.getLogger(AudioPlayer.class);

    private MediaAdapter mediaAdapter;

    public void play(String audioType, String fileName) {

        //inbuilt support to play mp3 music files
        if (audioType.equalsIgnoreCase("mp3")) {
            LOG.info("> playing mp3 file {}", fileName);
        }

        //mediaAdapter is providing support to play other file formats
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            LOG.error("> invalid media {}, format not supported", audioType);
        }

    }
}
