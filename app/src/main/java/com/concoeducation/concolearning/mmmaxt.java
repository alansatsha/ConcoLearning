package com.concoeducation.concolearning;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.text.Html;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.concoeducation.concolearning.databinding.ActivityMmmaxtBinding;

import java.util.ArrayList;
import java.util.List;

public class mmmaxt extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMmmaxtBinding binding;

    private String mParam1;
    private String mParam2;
    private ImageButton miu;
    private ImageButton mmma;

    private Button resetttb;
    private Button fullscb;
    private Button mbbbbc;



    private RelativeLayout mpppl;

    private String mlllis;


    private LinearLayout hhhr;
    private PlayerView mvvvv;
    private int mccca = 0;

    private LinearLayout sec_mid;
    private LinearLayout sec_bottom;
    private ConstraintLayout llllt;

    private int mcccccccc;

    private TextView mmmmju;

    private LinearLayout mllla;

    private List<ImageButton> buuta = new ArrayList<>();
    private List<String> msssv = new ArrayList<>();
    private List<String> msssb = new ArrayList<>();

    private Boolean mlppppp;


    ExoPlayer exoPlayer;
    ImageView bt_fullscreen;
    boolean isFullScreen = false;
    boolean isLock = false;
    Handler handler;


    private LinearLayout mllllyt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMmmaxtBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int orin = this.getResources().getConfiguration().orientation;


        mpppl = (RelativeLayout)findViewById(R.id.mnnnj);


        sec_mid = findViewById(R.id.sec_controlvid1);
        sec_bottom = findViewById(R.id.sec_controlvid2);

        PlayerView playerView = findViewById(R.id.player);
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        bt_fullscreen = findViewById(R.id.bt_fullscreen);
        ImageView bt_lockscreen = findViewById(R.id.exo_lock);

        llllt = findViewById(R.id.ccccuy);



        bt_fullscreen.setOnClickListener(view1 ->
        {
            if (!isFullScreen) {
                bt_fullscreen.setImageDrawable(
                        ContextCompat
                                .getDrawable(this, R.drawable.ic_baseline_fullscreen_exit));
                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
                isFullScreen = true;

            } else {
                bt_fullscreen.setImageDrawable(ContextCompat
                        .getDrawable(this, R.drawable.ic_baseline_fullscreen));
                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                isFullScreen = false;
            }
        });


        bt_lockscreen.setOnClickListener(view1 ->
        {
            if (!isLock) {
                bt_lockscreen.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_lock));
            } else {
                bt_lockscreen.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_outline_lock_open));
            }
            isLock = !isLock;
            //method for toggle will do next
            lockScreen(isLock);
        });


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int fullwidth = displayMetrics.widthPixels;
        int fullheigh = displayMetrics.heightPixels;

        exoPlayer = new SimpleExoPlayer.Builder(this).setSeekBackIncrementMs(5000).setSeekForwardIncrementMs(5000).build();
        playerView.setPlayer(exoPlayer);
        playerView.setKeepScreenOn(true);

        exoPlayer.addListener(new Player.Listener() {
            @Override
            public void onPlaybackStateChanged(int playbackState) {
                //when data video fetch stream from internet
                if (playbackState == Player.STATE_BUFFERING) {
                    progressBar.setVisibility(View.VISIBLE);

                } else if (playbackState == Player.STATE_READY) {
                    //then if streamed is loaded we hide the progress bar
                    progressBar.setVisibility(View.GONE);
                   // exoPlayer.play();
                }
            }

            @Override
            public void onIsPlayingChanged(boolean isPlaying) {
                if (isPlaying) {
                    ImageButton maaaap = buuta.get(mcccccccc);
                    maaaap.setImageURI(Uri.parse(String.valueOf(msssb.get(mcccccccc))));
                    mlppppp = true;
                } else {
                    for (ImageButton mi : buuta) {
                        mi.setImageURI(Uri.parse(msssv.get(Integer.parseInt(String.valueOf(mi.getTransitionName())))));
                    }
                    mlppppp = false;
                }
            }
        });

        Uri videoUrl = Uri.parse("/storage/emulated/0/Download/Radiohead - Fake Plastic Trees _ guitar lesson.mp4");
        MediaItem media = MediaItem.fromUri(videoUrl);
        exoPlayer.setMediaItem(media);
        exoPlayer.prepare();

        mlppppp = false;
        mbbbbc = findViewById(R.id.lpppo);

        mbbbbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mmmmju = findViewById(R.id.llllft);
        miu = findViewById(R.id.mlo);


        resetttb = findViewById(R.id.button4);
        fullscb = findViewById(R.id.button3);

        mllllyt = findViewById(R.id.mcccty);

        mllla = findViewById(R.id.muuui);

        hhhr = findViewById(R.id.llldf);

        mvvvv = findViewById(R.id.player);


        //simpleee =  new SimpleExoPlayer.Builder(this).setSeekBackIncrementMs(5000).setSeekForwardIncrementMs(5000).build();
        //mvvvv.setPlayer(simpleee);
        //mvvvv.setKeepScreenOn(true);

        //mvvvv.addLis
        //mvvvv.setVideoURI(Uri.parse("/storage/emulated/0/Download/Radiohead - Fake Plastic Trees _ guitar lesson.mp4"));


        MediaController mmdc = new MediaController(this);

        //mvvvv.setMediaController(mmdc);

        /*
        mvvvv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                for (ImageButton mi : buuta) {
                    mi.setImageURI(Uri.parse(msssv.get(Integer.parseInt(String.valueOf(mi.getTransitionName())))));
                }
                mlppppp = false;
            }
        });

         */
        mmdc.setAnchorView(mvvvv);
        //mvvvv.start();


        resetttb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exoPlayer.seekTo(0);
                exoPlayer.play();
            }
        });


        mlllis = "vid¡file:///storage/emulated/0/b.jpgºfile:///storage/emulated/0/c.jpgºPrensentacionº/storage/emulated/0/Download/Radiohead - Fake Plastic Trees _ guitar lesson.mp4¿txt¡<p>asdasdadaasad</p>¿vid¡file:///storage/emulated/0/b.jpgºfile:///storage/emulated/0/c.jpgºPrensentacionº/storage/emulated/0/Download/y2mate.com - VideoView  Android Studio Tutorial_1080p.mp4";
        for (String miiit : mlllis.split("¿")) {
            if (miiit.split("¡")[0].contains("vid")) {
                tocmnbbbb(miiit.split("¡")[1].split("º")[0], miiit.split("¡")[1].split("º")[1], miiit.split("¡")[1].split("º")[2], miiit.split("¡")[1].split("º")[3]);
            } else if (miiit.split("¡")[0].contains("txt")) {
                tnnnb(miiit.split("¡")[1]);
            }
        }


        ViewGroup.LayoutParams ml = miu.getLayoutParams();
        ml.height = 0;
        miu.setLayoutParams(ml);
        mmmmju.setLayoutParams(ml);



        if(orin == Configuration.ORIENTATION_LANDSCAPE)
        {
            LinearLayout.LayoutParams ffft = new LinearLayout.LayoutParams(mllllyt.getLayoutParams());
            LinearLayout.LayoutParams mmmmmfu = new LinearLayout.LayoutParams(llllt.getLayoutParams());

            mmmmmfu.height =(int) Math.round((fullheigh - (ffft.height * 1.7)));

            llllt.setLayoutParams(mmmmmfu);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "asdads", Toast.LENGTH_SHORT).show();
        }

    }


    private void tocmnbbbb(String content, String contentt, String mtt, String urill) {
        LinearLayout.LayoutParams mmmu = new LinearLayout.LayoutParams(miu.getLayoutParams());

        ImageButton llon = new ImageButton(this);
        ViewGroup.LayoutParams mlol = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llon.setImageURI(Uri.parse(content));
        llon.setBackgroundColor(Color.parseColor("#00000000"));
        llon.setScaleType(ImageView.ScaleType.FIT_CENTER);
        llon.setLayoutParams(mmmu);
        llon.setTransitionName(String.valueOf(mccca));


        LinearLayout.LayoutParams mi = (LinearLayout.LayoutParams) resetttb.getLayoutParams();

        mi.setMargins(0, 0, 0, 0);
        Button mmmiu = new Button(this);
        mmmiu.setText(mtt);
        mmmiu.setLayoutParams(mi);
        mmmiu.setTransitionName(String.valueOf(mccca));
        mmmiu.setTextColor(resetttb.getTextColors());
        mmmiu.setBackgroundTintList(resetttb.getBackgroundTintList());
        mmmiu.setTextSize(12);
        mmmiu.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_fast_forward_24, 0, 0, 0);
        mmmiu.setCompoundDrawablePadding(resetttb.getCompoundDrawablePadding());
        mmmiu.setPadding(resetttb.getPaddingLeft(), resetttb.getPaddingTop(), resetttb.getPaddingRight(), resetttb.getPaddingBottom());
        mmmiu.setLetterSpacing(resetttb.getLetterSpacing());
        mmmiu.setAllCaps(false);
        msssv.add(content);
        msssb.add(contentt);

        mmmiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlppppp = true;
                mcccccccc = Integer.parseInt(String.valueOf(mmmiu.getTransitionName()));
                for (ImageButton mi : buuta) {
                    mi.setImageURI(Uri.parse(msssv.get(Integer.parseInt(String.valueOf(mmmiu.getTransitionName())))));
                }
                Uri videoUrl = Uri.parse(urill);
                MediaItem media = MediaItem.fromUri(videoUrl);
                exoPlayer.setMediaItem(media);
                exoPlayer.play();

                ImageButton mllllp = buuta.get(mcccccccc);
                mllllp.setImageURI(Uri.parse(msssb.get(Integer.parseInt(String.valueOf(mcccccccc)))));
                // mvvvv.setVideoURI(Uri.parse(urill));
                //mvvvv.start();
            }
        });
        llon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* ViewGroup.LayoutParams jjjy = hhhr.getLayoutParams();
                jjjy.height = 0;
                hhhr.setLayoutParams(jjjy);
                */
                //Toast.makeText(this, String.valueOf(llon.getTransitionName()), Toast.LENGTH_SHORT).show();
                if (mlppppp == true) {
                    if (mcccccccc == Integer.parseInt(String.valueOf(llon.getTransitionName()))) {
                        // mvvvv.seekTo(0);
                        exoPlayer.pause();
                        llon.setImageURI(Uri.parse(content));
                        mlppppp = false;
                    } else {


                        for (ImageButton mi : buuta) {
                            mi.setImageURI(Uri.parse(msssv.get(Integer.parseInt(String.valueOf(mi.getTransitionName())))));
                        }
                        llon.setImageURI(Uri.parse(contentt));
                        mcccccccc = Integer.parseInt(String.valueOf(llon.getTransitionName()));
                        // mvvvv.setVideoURI(Uri.parse(urill));
                        Uri videoUrl = Uri.parse(urill);
                        MediaItem media = MediaItem.fromUri(videoUrl);
                        exoPlayer.setMediaItem(media);
                        exoPlayer.play();
                    }
                }
                else {
                    if (mcccccccc == Integer.parseInt(String.valueOf(llon.getTransitionName()))) {
                        mlppppp = true;
                        llon.setImageURI(Uri.parse(contentt));
                        mcccccccc = Integer.parseInt(String.valueOf(llon.getTransitionName()));
                        exoPlayer.play();
                    } else {
                        mlppppp = true;
                        llon.setImageURI(Uri.parse(contentt));
                        mcccccccc = Integer.parseInt(String.valueOf(llon.getTransitionName()));
                        //mvvvv.setVideoURI(Uri.parse(urill));
                        Uri videoUrl = Uri.parse(urill);
                        MediaItem media = MediaItem.fromUri(videoUrl);
                        exoPlayer.setMediaItem(media);
                        exoPlayer.play();
                    }
                }
            }
        });

        mllllyt.addView(mmmiu);
        buuta.add(llon);
        mllla.addView(llon);

        mccca++;
    }

    private void tnnnb(String content) {
        LinearLayout.LayoutParams mmmu = (LinearLayout.LayoutParams) miu.getLayoutParams();
        mmmu = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView mmmh = new TextView(this);
        mmmh.setText((Spannable) Html.fromHtml(content));
        mmmu.setMargins(30, 40, 30, 0);
        mmmh.setTextSize(18);
        mmmh.setTextColor(mmmmju.getTextColors());
        mmmh.setLayoutParams(mmmu);
        mllla.addView(mmmh);
    }


    void lockScreen(boolean lock) {
        //just hide the control for lock screen and vise versa
        if (lock) {
            sec_mid.setVisibility(View.INVISIBLE);
            sec_bottom.setVisibility(View.INVISIBLE);
        } else {
            sec_mid.setVisibility(View.VISIBLE);
            sec_bottom.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        //on lock screen back press button not work
        if (isLock) return;

        //if user is in landscape mode we turn to portriat mode first then we can exit the app.
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            bt_fullscreen.performClick();
        } else super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        exoPlayer.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        exoPlayer.release();
    }

    @Override
    protected void onPause() {
        super.onPause();
        exoPlayer.pause();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_mmmaxt);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}