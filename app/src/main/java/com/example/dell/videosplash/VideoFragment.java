package com.example.dell.videosplash;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dell on 2016/11/29.
 */

public class VideoFragment extends Fragment{

    private CustomVideoView cvv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        cvv = new CustomVideoView(getContext());

        int index = getArguments().getInt("index");

        Uri uri = null;
        if(index == 1){
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_1);
        }

        if(index == 2){
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_2);
        }

        if(index == 3){
            uri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide_3);
        }

        cvv.playVideo(uri);
        return cvv;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(cvv != null){
            cvv.stopPlayback();
        }
    }
}
