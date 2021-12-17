package util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {

    // Object that stores the audio stream
    Clip clip;

    // File path for the audio file
    String audioFilePath;

    // AudioPlayer constructor
    public AudioPlayer(String audioFilePath) {
        this.audioFilePath = System.getProperty("user.dir") + "/" + audioFilePath;
    }

    // Method to play a given audio file
    public void playAudio()  {
        try {
            // Create audio stream from the file
            AudioInputStream audioInputStream;
            audioInputStream = AudioSystem.getAudioInputStream(new File(audioFilePath));

            // Generate a clip object
            clip = AudioSystem.getClip();

            // Pass stream to clip object
            clip.open(audioInputStream);

            // Set clip to loop the audio file on repeat
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Start the clip
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}
