package cz.speedygonzales.designpatterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author vondracek
 * @since 25.10.2015 10:13
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    private static final Logger LOG = LoggerFactory.getLogger(VlcPlayer.class);

    public void playMp4(String fileName) {
        //do nothing
    }

    public void playVlc(String fileName) {

        LOG.info("> playing VLC file {}", fileName);
    }
}
