package cz.speedygonzales.designpatterns.adapter;

/**
 * @author vondracek
 * @since 25.10.2015 10:22
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}