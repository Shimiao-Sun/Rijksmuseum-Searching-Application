package au.edu.sydney.soft3202.project.view;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;

public class MediaBuilder {

    /**
     * mp3 media builder for BGM.
     * @return a MediaPlayer object
     */
    public MediaPlayer mediaBuilder() {
        URL mediaURL = getClass().getResource("/FlowerDance.mp3");
        String mediaString = mediaURL.toExternalForm();
        Media music = new Media(mediaString);
        MediaPlayer mediaPlayer = new MediaPlayer(music);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        return mediaPlayer;
    }


}
