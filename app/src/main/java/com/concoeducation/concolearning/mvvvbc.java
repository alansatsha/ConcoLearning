package com.concoeducation.concolearning;

import static com.google.android.exoplayer2.Player.*;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Html;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mvvvbc#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mvvvbc extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    SimpleExoPlayer simpleee;
    private String mParam1;
    private String mParam2;
    private ImageButton miu;
    private ImageButton mmma;

    private Button resetttb;
    private Button fullscb;
    private Button mbbbbc;

    private String mlllis;


    private LinearLayout hhhr;
    private PlayerView mvvvv;
    private int mccca = 0;

    private int mcccccccc;

    private TextView mmmmju;

    private LinearLayout mllla;

    private List<ImageButton> buuta = new ArrayList<>();
    private List<String> msssv = new ArrayList<>();
    private List<String> msssb = new ArrayList<>();

    private Boolean mlppppp;
    private FragmentListener listener;


    ImageView bt_fullscreen;
    boolean isFullScreen = false;
    boolean isLock = false;
    Handler handler;


    private LinearLayout mllllyt;


    public interface FragmentListener {
        void onInputSent(CharSequence input);
    }

    public mvvvbc() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mvvvbc.
     */
    // TODO: Rename and change types and number of parameters
    public static mvvvbc newInstance(String param1, String param2) {
        mvvvbc fragment = new mvvvbc();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mvvvbc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}