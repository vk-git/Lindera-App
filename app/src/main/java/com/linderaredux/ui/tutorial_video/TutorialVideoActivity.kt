package com.linderaredux.ui.tutorial_video

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.SurfaceHolder
import android.view.View
import com.devbrackets.android.exomedia.listener.OnPreparedListener
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityTutorialVideoBinding
import javax.inject.Inject

class TutorialVideoActivity : BaseActivity<ActivityTutorialVideoBinding, TutorialVideoViewModel>(), TutorialVideoNavigator, OnPreparedListener {


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, TutorialVideoActivity::class.java)
        }
    }

    @set:Inject
    override var viewModel: TutorialVideoViewModel? = null

    private var mActivityTutorialVideoBinding: ActivityTutorialVideoBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_tutorial_video

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityTutorialVideoBinding = getViewDataBinding()
        viewModel?.setNavigator(this)

        mActivityTutorialVideoBinding!!.toolbar.setBackButton(true)
        mActivityTutorialVideoBinding!!.toolbar.setBackButtonListener(listener = View.OnClickListener {
            finish()
        })

        setUpSurface()
    }

    private fun setUpSurface() {
        mActivityTutorialVideoBinding!!.videoView.setOnPreparedListener(this)
        mActivityTutorialVideoBinding!!.videoView.setVideoURI(Uri.parse("http://lindera.de/wp-content/gallery/linderaDE.mp4"))
    }

    override fun onPrepared() {
        mActivityTutorialVideoBinding!!.videoView.start()
    }
}