package main;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class musicPlaying {
	static File musicFile;
	static MediaView mv;
    static MediaPlayer mediaPlayer;
    static boolean isPlaying = false;

    public static void initializeMediaPlayer() {
    	musicFile = new File("piano.mp3");
        Media media = new Media(musicFile.toURI().toString());
    	mediaPlayer = new MediaPlayer(media);
    	mediaPlayer.setAutoPlay(true);
    	mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(mediaPlayer.getStartTime()));
    	mv = new MediaView(mediaPlayer);
    }
    
    public static boolean Playing(){
    	if(!isPlaying) {
    		isPlaying = true;
    		return true;
    	}
    	return false;
    }
    
    public static void stop() {
        mediaPlayer.stop();
        isPlaying = false;
    }
}
