package cz.speedygonzales.swing;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class PlaySoundDemo extends JFrame {

    // Constructor
    public PlaySoundDemo() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Play Sound Demo");
        this.setSize(300, 200);
        this.setVisible(true);

        try {
            URL url = this.getClass().getClassLoader().getResource("cartoon001.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PlaySoundDemo();
    }
}
