package edu.temple.audibleon;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoActivity extends YouTubeBaseActivity{

    String api_key = "AIzaSyCZUF7ePDwPtEdHcYmlB6j2EkiUetqM5co";

    List<String> videos = Arrays.asList("KGu9rPfrptw", "ICEmPhu6vbo", "pxyi6YW8gOE");
    private static Map<String, String> words;

    static {
        words = new HashMap<String, String>();
        words.put("abbreviate", "value1");
        words.put("abortion", "value2");
        words.put("about", "value2");
        words.put("above", "value2");
        words.put("abuse", "value2");
        words.put("academic", "value2");
        words.put("accept", "value2");
        words.put("accent", "value2");
        words.put("accident", "value2");
        words.put("accomplice", "value2");
        words.put("accomplish", "value2");
        words.put("accountant", "value2");
        words.put("acquaintance", "value2");
        words.put("abortion", "value2");
        words.put("abortion", "value2");

    }
    private static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        // Get reference to the view of Video player
        YouTubePlayerView ytPlayer = (YouTubePlayerView)findViewById(R.id.video);
        //int counter = 0;

        ytPlayer.initialize(
                api_key,
                new YouTubePlayer.OnInitializedListener() {

                    @Override
                    public void onInitializationSuccess(
                            YouTubePlayer.Provider provider,
                            YouTubePlayer youTubePlayer, boolean b)
                    {
                        //int counter = 0;
                        if(!b){
                            youTubePlayer.loadVideo(videos.get(counter));
                            youTubePlayer.play();
                        }
                        youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                            @Override
                            public void onAdStarted() { }

                            @Override
                            public void onError(YouTubePlayer.ErrorReason arg0) { }

                            @Override
                            public void onLoaded(String arg0) { }

                            @Override
                            public void onLoading() { }

                            @Override
                            public void onVideoEnded() {
                                counter++;
                                if(counter < videos.size()) {
                                    youTubePlayer.loadVideo(videos.get(counter));
                                    youTubePlayer.play();
                                }else{
                                    counter = 0;
                                    youTubePlayer.release();
                                }

                            }
                            @Override
                            public void onVideoStarted() { }
                        });
                   }

                   @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult
                                                                youTubeInitializationResult)
                    {
                        Toast.makeText(getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}