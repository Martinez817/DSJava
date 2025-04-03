package animate;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundClip {
    private Clip clip;
    private boolean loop;

    public SoundClip(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File audioFile = new File(filePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
        if (loop) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void play() {
        if (!loop) {
            clip.setFramePosition(0);
        }
        clip.start();
    }

    public void stop() {
        clip.stop();
    }
}

