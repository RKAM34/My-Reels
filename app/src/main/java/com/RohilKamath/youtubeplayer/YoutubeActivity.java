package com.RohilKamath.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity
             implements YouTubePlayer.OnInitializedListener {
    private static final String TAG = "YoutubeActivity";
                  static final String GOOGLE_API_KEY ="AIzaSyDvTdkP_RioSA9u6karSbP4xcMMo1Q8ga8";
                  static final String YOUTUBE_VIDEO_ID ="nDWvy5pT_rQ";
                  static final String YOUTUBE_PLAYLIST ="PLKWDesYRFIYva0c5Ocf0kKbwRU6HKN2Dx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_youtube);
        ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_youtube , null);
              setContentView(layout);

       // Button button1 = new Button(this);
       // button1.setLayoutParams(new ConstraintLayout.LayoutParams(300,80));
       // button1.setText("Button Added");
       // layout.addView(button1);

        YouTubePlayerView playerView = new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(playerView);
        playerView.initialize(GOOGLE_API_KEY,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG,"onInitializationSuccess : provider is" + provider.getClass().toString());
        Toast.makeText(this,"Initialized MyReels Successfully",Toast.LENGTH_LONG).show();

 if(!wasRestored){
     youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
 }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
    final int REQUEST_CODE=1;

    if(youTubeInitializationResult.isUserRecoverableError()){
        youTubeInitializationResult.getErrorDialog(this,REQUEST_CODE).show();
    } else{
        String errorMessage = String.format("Oops , There wan an error initializing the app (1$s)",youTubeInitializationResult.toString());
        Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
    }
    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener= new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    } ;
}