package cz.speedygonzales.designpatterns.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author vondracek
 * @since 25.10.2015 10:15
 */
@Slf4j
public class Mp4Player implements AdvancedMediaPlayer {

    public void playMp4(String fileName) {

        log.info("> playing MP4 file {}", fileName);
    }

    public void playVlc(String fileName) {
        //do nothing
    }
}
