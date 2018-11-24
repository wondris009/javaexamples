package cz.speedygonzales.designpatterns.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author vondracek
 * @since 25.10.2015 10:16
 */
@Slf4j
public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String mediaType) {

        if (mediaType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (mediaType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }

    }

    public void play(String audioType, String fileName) {

        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else {
            log.error("> undefined audiotype {}", audioType);
        }
    }
}
