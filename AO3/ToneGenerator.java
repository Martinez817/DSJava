import javax.sound.sampled.*;

public class ToneGenerator {
    public enum Note {
        C4(261.63), D4(293.66), E4(329.63), F4(349.23), G4(392.00), A4(440.00), B4(493.88),
        C5(523.25), D5(587.33), E5(659.26), F5(698.46), G5(783.99), A5(880.00), B5(987.77);

        private final double frequency;

        Note(double frequency) {
            this.frequency = frequency;
        }

        public double getFrequency() {
            return this.frequency;
        }
    }

    private static final float SAMPLE_RATE = 8000;

    public static void play(Note note, int durationMillis) {
        try {
            byte[] buf = new byte[(int) SAMPLE_RATE * durationMillis / 1000];
            for (int i = 0; i < buf.length; i++) {
                buf[i] = (byte) (Math.sin(2 * Math.PI * note.getFrequency() * i / SAMPLE_RATE) * 127);
            }

            AudioFormat format = new AudioFormat(SAMPLE_RATE, 8, 1, true, false);
            SourceDataLine line = AudioSystem.getSourceDataLine(format);
            line.open(format, buf.length);
            line.start();
            line.write(buf, 0, buf.length);
            line.drain();
            line.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
