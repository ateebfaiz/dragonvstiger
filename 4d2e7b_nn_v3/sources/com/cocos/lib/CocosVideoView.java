package com.cocos.lib;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.alibaba.pdns.f;
import java.io.IOException;
import java.util.Map;

public class CocosVideoView extends SurfaceView {
    private static final String AssetResourceRoot = "@assets/";
    private static final int EVENT_CLICKED = 5;
    private static final int EVENT_COMPLETED = 3;
    private static final int EVENT_META_LOADED = 4;
    private static final int EVENT_PAUSED = 1;
    private static final int EVENT_PLAYING = 0;
    private static final int EVENT_READY_TO_PLAY = 6;
    private static final int EVENT_STOPPED = 2;
    /* access modifiers changed from: private */
    public String TAG = "CocosVideoView";
    protected Activity mActivity;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    /* access modifiers changed from: private */
    public e mCurrentState;
    private int mDuration;
    private MediaPlayer.OnErrorListener mErrorListener;
    protected boolean mFullScreenEnabled;
    private boolean mIsAssetResource;
    private boolean mKeepRatio;
    private MediaPlayer mMediaPlayer;
    /* access modifiers changed from: private */
    public boolean mMetaUpdated;
    private OnVideoEventListener mOnVideoEventListener;
    private int mPosition;
    /* access modifiers changed from: private */
    public int mPositionBeforeRelease;
    MediaPlayer.OnPreparedListener mPreparedListener;
    SurfaceHolder.Callback mSHCallback;
    private int mSeekWhenPrepared;
    /* access modifiers changed from: private */
    public e mStateBeforeRelease;
    /* access modifiers changed from: private */
    public SurfaceHolder mSurfaceHolder;
    private String mVideoFilePath;
    /* access modifiers changed from: private */
    public int mVideoHeight;
    private Uri mVideoUri;
    /* access modifiers changed from: private */
    public int mVideoWidth;
    protected int mViewHeight;
    protected int mViewLeft;
    private int mViewTag;
    protected int mViewTop;
    protected int mViewWidth;
    protected int mVisibleHeight;
    protected int mVisibleLeft;
    protected int mVisibleTop;
    protected int mVisibleWidth;

    public interface OnVideoEventListener {
        void onVideoEvent(int i10, int i11);
    }

    class a implements MediaPlayer.OnPreparedListener {
        a() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            CocosVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
            CocosVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
            if (!(CocosVideoView.this.mVideoWidth == 0 || CocosVideoView.this.mVideoHeight == 0)) {
                CocosVideoView.this.fixSize();
            }
            if (!CocosVideoView.this.mMetaUpdated) {
                CocosVideoView.this.sendEvent(4);
                CocosVideoView.this.sendEvent(6);
                CocosVideoView.this.mMetaUpdated = true;
            }
            CocosVideoView.this.mCurrentState = e.PREPARED;
            if (CocosVideoView.this.mStateBeforeRelease == e.STARTED) {
                CocosVideoView.this.start();
            }
            if (CocosVideoView.this.mPositionBeforeRelease > 0) {
                CocosVideoView cocosVideoView = CocosVideoView.this;
                cocosVideoView.seekTo(cocosVideoView.mPositionBeforeRelease);
            }
            CocosVideoView.this.mStateBeforeRelease = e.IDLE;
            CocosVideoView.this.mPositionBeforeRelease = 0;
        }
    }

    class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            CocosVideoView.this.mCurrentState = e.PLAYBACK_COMPLETED;
            CocosVideoView.this.sendEvent(3);
            CocosVideoView.this.showFirstFrame();
        }
    }

    class c implements MediaPlayer.OnErrorListener {

        class a implements DialogInterface.OnClickListener {
            a() {
            }

            public void onClick(DialogInterface dialogInterface, int i10) {
                CocosVideoView.this.sendEvent(3);
            }
        }

        c() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            int i12;
            String a10 = CocosVideoView.this.TAG;
            Log.d(a10, "Error: " + i10 + "," + i11);
            CocosVideoView.this.mCurrentState = e.ERROR;
            if (CocosVideoView.this.getWindowToken() == null) {
                return true;
            }
            Resources resources = CocosVideoView.this.mActivity.getResources();
            if (i10 == 200) {
                i12 = resources.getIdentifier("VideoView_error_text_invalid_progressive_playback", "string", f.f17924q);
            } else {
                i12 = resources.getIdentifier("VideoView_error_text_unknown", "string", f.f17924q);
            }
            new AlertDialog.Builder(CocosVideoView.this.mActivity).setTitle(resources.getString(resources.getIdentifier("VideoView_error_title", "string", f.f17924q))).setMessage(i12).setPositiveButton(resources.getString(resources.getIdentifier("VideoView_error_button", "string", f.f17924q)), new a()).setCancelable(false).show();
            return true;
        }
    }

    class d implements SurfaceHolder.Callback {
        d() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CocosVideoView.this.mSurfaceHolder = surfaceHolder;
            CocosVideoView.this.openVideo();
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CocosVideoView.this.mSurfaceHolder = null;
            CocosVideoView cocosVideoView = CocosVideoView.this;
            cocosVideoView.mPositionBeforeRelease = cocosVideoView.getCurrentPosition();
            CocosVideoView cocosVideoView2 = CocosVideoView.this;
            cocosVideoView2.mStateBeforeRelease = cocosVideoView2.mCurrentState;
            CocosVideoView.this.release();
        }
    }

    private enum e {
        IDLE,
        ERROR,
        INITIALIZED,
        PREPARING,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        PLAYBACK_COMPLETED
    }

    public CocosVideoView(Activity activity, int i10) {
        super(activity);
        e eVar = e.IDLE;
        this.mCurrentState = eVar;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mSeekWhenPrepared = 0;
        this.mActivity = null;
        this.mViewLeft = 0;
        this.mViewTop = 0;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mVisibleLeft = 0;
        this.mVisibleTop = 0;
        this.mVisibleWidth = 0;
        this.mVisibleHeight = 0;
        this.mFullScreenEnabled = false;
        this.mIsAssetResource = false;
        this.mVideoFilePath = null;
        this.mViewTag = 0;
        this.mKeepRatio = false;
        this.mMetaUpdated = false;
        this.mPositionBeforeRelease = 0;
        this.mStateBeforeRelease = eVar;
        this.mPreparedListener = new a();
        this.mCompletionListener = new b();
        this.mErrorListener = new c();
        this.mSHCallback = new d();
        this.mViewTag = i10;
        this.mActivity = activity;
        initVideoView();
    }

    private void initVideoView() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.mSHCallback);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.mCurrentState = e.IDLE;
    }

    private void loadDataSource() throws IOException {
        if (this.mIsAssetResource) {
            AssetFileDescriptor openFd = this.mActivity.getAssets().openFd(this.mVideoFilePath);
            this.mMediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            return;
        }
        this.mMediaPlayer.setDataSource(this.mVideoUri.toString());
    }

    /* access modifiers changed from: private */
    public void openVideo() {
        if (this.mSurfaceHolder != null) {
            if (this.mIsAssetResource) {
                if (this.mVideoFilePath == null) {
                    return;
                }
            } else if (this.mVideoUri == null) {
                return;
            }
            pausePlaybackService();
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.mMediaPlayer = mediaPlayer;
                mediaPlayer.setOnPreparedListener(this.mPreparedListener);
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                loadDataSource();
                this.mCurrentState = e.INITIALIZED;
                this.mMediaPlayer.prepare();
                showFirstFrame();
            } catch (IOException e10) {
                String str = this.TAG;
                Log.w(str, "Unable to open content: " + this.mVideoUri, e10);
                this.mCurrentState = e.ERROR;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            } catch (IllegalArgumentException e11) {
                String str2 = this.TAG;
                Log.w(str2, "Unable to open content: " + this.mVideoUri, e11);
                this.mCurrentState = e.ERROR;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    private void pausePlaybackService() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        this.mActivity.sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    public void release() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.mMediaPlayer = null;
            this.mCurrentState = e.IDLE;
        }
    }

    /* access modifiers changed from: private */
    public void sendEvent(int i10) {
        OnVideoEventListener onVideoEventListener = this.mOnVideoEventListener;
        if (onVideoEventListener != null) {
            onVideoEventListener.onVideoEvent(this.mViewTag, i10);
        }
    }

    private void setVideoURI(Uri uri, Map<String, String> map) {
        this.mVideoUri = uri;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    /* access modifiers changed from: private */
    public void showFirstFrame() {
        this.mMediaPlayer.seekTo(1);
    }

    public void fixSize() {
        if (this.mFullScreenEnabled) {
            Point point = new Point();
            this.mActivity.getWindowManager().getDefaultDisplay().getSize(point);
            fixSize(0, 0, point.x, point.y);
            return;
        }
        fixSize(this.mViewLeft, this.mViewTop, this.mViewWidth, this.mViewHeight);
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer;
        e eVar = this.mCurrentState;
        if (!(eVar == e.IDLE || eVar == e.ERROR || eVar == e.INITIALIZED || eVar == e.STOPPED || (mediaPlayer = this.mMediaPlayer) == null)) {
            this.mPosition = mediaPlayer.getCurrentPosition();
        }
        return this.mPosition;
    }

    public int getDuration() {
        MediaPlayer mediaPlayer;
        e eVar = this.mCurrentState;
        if (!(eVar == e.IDLE || eVar == e.ERROR || eVar == e.INITIALIZED || eVar == e.STOPPED || (mediaPlayer = this.mMediaPlayer) == null)) {
            this.mDuration = mediaPlayer.getDuration();
        }
        return this.mDuration;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(this.mVisibleWidth, this.mVisibleHeight);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 1) {
            sendEvent(5);
        }
        return true;
    }

    public void pause() {
        MediaPlayer mediaPlayer;
        e eVar = this.mCurrentState;
        if ((eVar == e.STARTED || eVar == e.PLAYBACK_COMPLETED) && (mediaPlayer = this.mMediaPlayer) != null) {
            this.mCurrentState = e.PAUSED;
            mediaPlayer.pause();
            sendEvent(1);
        }
    }

    public void playbackRate(float f10) {
        if (this.mMediaPlayer != null) {
            PlaybackParams playbackParams = new PlaybackParams();
            playbackParams.setSpeed(f10);
            this.mMediaPlayer.setPlaybackParams(playbackParams);
        }
    }

    public int resolveAdjustedSize(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i10, size);
        }
        if (mode != 1073741824) {
            return i10;
        }
        return size;
    }

    public void seekTo(int i10) {
        MediaPlayer mediaPlayer;
        e eVar = this.mCurrentState;
        if (eVar != e.IDLE && eVar != e.INITIALIZED && eVar != e.STOPPED && eVar != e.ERROR && (mediaPlayer = this.mMediaPlayer) != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    mediaPlayer.getClass().getMethod("seekTo", new Class[]{Long.TYPE, Integer.TYPE}).invoke(this.mMediaPlayer, new Object[]{Integer.valueOf(i10), 3});
                } catch (Exception unused) {
                    this.mMediaPlayer.seekTo(i10);
                }
            } else {
                mediaPlayer.seekTo(i10);
            }
        }
    }

    public void setFullScreenEnabled(boolean z10) {
        if (this.mFullScreenEnabled != z10) {
            this.mFullScreenEnabled = z10;
            fixSize();
        }
    }

    public void setKeepRatio(boolean z10) {
        this.mKeepRatio = z10;
        fixSize();
    }

    public void setLoop(boolean z10) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z10);
        }
    }

    public void setMute(boolean z10) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (z10) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    public void setVideoFileName(String str) {
        if (str.startsWith(AssetResourceRoot)) {
            str = str.substring(8);
        }
        if (str.startsWith(DomExceptionUtils.SEPARATOR)) {
            this.mIsAssetResource = false;
            setVideoURI(Uri.parse(str), (Map<String, String>) null);
            return;
        }
        this.mVideoFilePath = str;
        this.mIsAssetResource = true;
        setVideoURI(Uri.parse(str), (Map<String, String>) null);
    }

    public void setVideoRect(int i10, int i11, int i12, int i13) {
        if (this.mViewLeft != i10 || this.mViewTop != i11 || this.mViewWidth != i12 || this.mViewHeight != i13) {
            this.mViewLeft = i10;
            this.mViewTop = i11;
            this.mViewWidth = i12;
            this.mViewHeight = i13;
            fixSize(i10, i11, i12, i13);
        }
    }

    public void setVideoURL(String str) {
        this.mIsAssetResource = false;
        setVideoURI(Uri.parse(str), (Map<String, String>) null);
    }

    public void setVideoViewEventListener(OnVideoEventListener onVideoEventListener) {
        this.mOnVideoEventListener = onVideoEventListener;
    }

    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public void setVolume(float f10) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f10, f10);
        }
    }

    public void start() {
        MediaPlayer mediaPlayer;
        e eVar = this.mCurrentState;
        if ((eVar == e.PREPARED || eVar == e.PAUSED || eVar == e.PLAYBACK_COMPLETED) && (mediaPlayer = this.mMediaPlayer) != null) {
            this.mCurrentState = e.STARTED;
            mediaPlayer.start();
            sendEvent(0);
        }
    }

    public void stop() {
        e eVar;
        MediaPlayer mediaPlayer;
        e eVar2 = this.mCurrentState;
        if (eVar2 != e.IDLE && eVar2 != e.INITIALIZED && eVar2 != e.ERROR && eVar2 != (eVar = e.STOPPED) && (mediaPlayer = this.mMediaPlayer) != null) {
            this.mCurrentState = eVar;
            mediaPlayer.stop();
            sendEvent(2);
            try {
                this.mMediaPlayer.reset();
                loadDataSource();
                this.mMediaPlayer.prepare();
                showFirstFrame();
            } catch (Exception unused) {
            }
        }
    }

    public void stopPlayback() {
        release();
    }

    public void fixSize(int i10, int i11, int i12, int i13) {
        int i14;
        int i15 = this.mVideoWidth;
        if (i15 == 0 || (i14 = this.mVideoHeight) == 0) {
            this.mVisibleLeft = i10;
            this.mVisibleTop = i11;
            this.mVisibleWidth = i12;
            this.mVisibleHeight = i13;
        } else if (i12 == 0 || i13 == 0) {
            this.mVisibleLeft = i10;
            this.mVisibleTop = i11;
            this.mVisibleWidth = i15;
            this.mVisibleHeight = i14;
        } else if (!this.mKeepRatio || this.mFullScreenEnabled) {
            this.mVisibleLeft = i10;
            this.mVisibleTop = i11;
            this.mVisibleWidth = i12;
            this.mVisibleHeight = i13;
        } else {
            if (i15 * i13 > i12 * i14) {
                this.mVisibleWidth = i12;
                this.mVisibleHeight = (i14 * i12) / i15;
            } else if (i15 * i13 < i12 * i14) {
                this.mVisibleWidth = (i15 * i13) / i14;
                this.mVisibleHeight = i13;
            }
            this.mVisibleLeft = i10 + ((i12 - this.mVisibleWidth) / 2);
            this.mVisibleTop = i11 + ((i13 - this.mVisibleHeight) / 2);
        }
        getHolder().setFixedSize(this.mVisibleWidth, this.mVisibleHeight);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = this.mVisibleLeft;
        layoutParams.topMargin = this.mVisibleTop;
        setLayoutParams(layoutParams);
    }
}
