package cz.speedygonzales.designpatterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vondracek
 * @since 25.10.2015 10:15
 */
public class Mp4Player implements AdvancedMediaPlayer {

    private static final Logger LOG = LoggerFactory.getLogger(Mp4Player.class);

    public void playMp4(String fileName) {

        LOG.info("> playing MP4 file {}", fileName);
    }

    public void playVlc(String fileName) {
        //do nothing
    }
}
