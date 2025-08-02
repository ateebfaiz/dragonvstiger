package com.cocos.lib;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.widget.FrameLayout;
import com.cocos.lib.CocosVideoView;
import java.lang.ref.WeakReference;

public class CocosVideoHelper {
    static final int KeyEventBack = 1000;
    private static final int VideoTaskCreate = 0;
    private static final int VideoTaskFullScreen = 12;
    private static final int VideoTaskKeepRatio = 11;
    private static final int VideoTaskPause = 5;
    private static final int VideoTaskRemove = 1;
    private static final int VideoTaskRestart = 10;
    private static final int VideoTaskResume = 6;
    private static final int VideoTaskSeek = 8;
    private static final int VideoTaskSetLoop = 16;
    private static final int VideoTaskSetMute = 15;
    private static final int VideoTaskSetPlaybackRate = 14;
    private static final int VideoTaskSetRect = 3;
    private static final int VideoTaskSetSource = 2;
    private static final int VideoTaskSetVisible = 9;
    private static final int VideoTaskSetVolume = 13;
    private static final int VideoTaskStart = 4;
    private static final int VideoTaskStop = 7;
    static c mVideoHandler;
    private static Handler sHandler;
    private static SparseArray<CocosVideoView> sVideoViews;
    private static int videoTag;
    private Activity mActivity = null;
    private FrameLayout mLayout = null;
    CocosVideoView.OnVideoEventListener videoEventListener = new a();

    class a implements CocosVideoView.OnVideoEventListener {

        /* renamed from: com.cocos.lib.CocosVideoHelper$a$a  reason: collision with other inner class name */
        class C0243a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f19319a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f19320b;

            C0243a(int i10, int i11) {
                this.f19319a = i10;
                this.f19320b = i11;
            }

            public void run() {
                CocosVideoHelper.nativeExecuteVideoCallback(this.f19319a, this.f19320b);
            }
        }

        a() {
        }

        public void onVideoEvent(int i10, int i11) {
            CocosHelper.runOnGameThreadAtForeground(new C0243a(i10, i11));
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f19322a;

        b(int i10) {
            this.f19322a = i10;
        }

        public void run() {
            CocosVideoHelper.nativeExecuteVideoCallback(this.f19322a, 1000);
        }
    }

    static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        WeakReference f19324a;

        c(CocosVideoHelper cocosVideoHelper) {
            this.f19324a = new WeakReference(cocosVideoHelper);
        }

        public void handleMessage(Message message) {
            CocosVideoHelper cocosVideoHelper = (CocosVideoHelper) this.f19324a.get();
            int i10 = message.what;
            if (i10 == 0) {
                cocosVideoHelper._createVideoView(message.arg1);
            } else if (i10 == 1) {
                cocosVideoHelper._removeVideoView(message.arg1);
            } else if (i10 == 2) {
                cocosVideoHelper._setVideoURL(message.arg1, message.arg2, (String) message.obj);
            } else if (i10 == 3) {
                Rect rect = (Rect) message.obj;
                cocosVideoHelper._setVideoRect(message.arg1, rect.left, rect.top, rect.right, rect.bottom);
            } else if (i10 == 4) {
                cocosVideoHelper._startVideo(message.arg1);
            } else if (i10 == 5) {
                cocosVideoHelper._pauseVideo(message.arg1);
            } else if (i10 == 7) {
                cocosVideoHelper._stopVideo(message.arg1);
            } else if (i10 == 8) {
                cocosVideoHelper._seekVideoTo(message.arg1, message.arg2);
            } else if (i10 != 9) {
                if (i10 != 1000) {
                    switch (i10) {
                        case 11:
                            if (message.arg2 != 1) {
                                cocosVideoHelper._setVideoKeepRatio(message.arg1, false);
                                break;
                            } else {
                                cocosVideoHelper._setVideoKeepRatio(message.arg1, true);
                                break;
                            }
                        case 12:
                            if (message.arg2 != 1) {
                                cocosVideoHelper._setFullScreenEnabled(message.arg1, false);
                                break;
                            } else {
                                cocosVideoHelper._setFullScreenEnabled(message.arg1, true);
                                break;
                            }
                        case 13:
                            cocosVideoHelper._setVolume(message.arg1, ((float) message.arg2) / 10.0f);
                            break;
                        case 14:
                            cocosVideoHelper._setPlaybackRate(message.arg1, ((float) message.arg2) / 10.0f);
                            break;
                        case 15:
                            if (message.arg2 != 1) {
                                cocosVideoHelper._setMute(message.arg1, false);
                                break;
                            } else {
                                cocosVideoHelper._setMute(message.arg1, true);
                                break;
                            }
                        case 16:
                            if (message.arg2 != 1) {
                                cocosVideoHelper._setLoop(message.arg1, false);
                                break;
                            } else {
                                cocosVideoHelper._setLoop(message.arg1, true);
                                break;
                            }
                    }
                } else {
                    cocosVideoHelper.onBackKeyEvent();
                }
            } else if (message.arg2 == 1) {
                cocosVideoHelper._setVideoVisible(message.arg1, true);
            } else {
                cocosVideoHelper._setVideoVisible(message.arg1, false);
            }
            super.handleMessage(message);
        }
    }

    CocosVideoHelper(Activity activity, FrameLayout frameLayout) {
        this.mActivity = activity;
        this.mLayout = frameLayout;
        mVideoHandler = new c(this);
        sVideoViews = new SparseArray<>();
        sHandler = new Handler(Looper.myLooper());
    }

    /* access modifiers changed from: private */
    public void _createVideoView(int i10) {
        CocosVideoView cocosVideoView = new CocosVideoView(this.mActivity, i10);
        sVideoViews.put(i10, cocosVideoView);
        this.mLayout.addView(cocosVideoView, new FrameLayout.LayoutParams(-2, -2));
        cocosVideoView.setZOrderOnTop(true);
        cocosVideoView.setVideoViewEventListener(this.videoEventListener);
    }

    /* access modifiers changed from: private */
    public void _pauseVideo(int i10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.pause();
        }
    }

    /* access modifiers changed from: private */
    public void _removeVideoView(int i10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.stopPlayback();
            sVideoViews.remove(i10);
            this.mLayout.removeView(cocosVideoView);
        }
    }

    /* access modifiers changed from: private */
    public void _seekVideoTo(int i10, int i11) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.seekTo(i11);
        }
    }

    /* access modifiers changed from: private */
    public void _setFullScreenEnabled(int i10, boolean z10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.setFullScreenEnabled(z10);
        }
    }

    /* access modifiers changed from: private */
    public void _setLoop(int i10, boolean z10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.setLoop(z10);
        }
    }

    /* access modifiers changed from: private */
    public void _setMute(int i10, boolean z10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.setMute(z10);
        }
    }

    /* access modifiers changed from: private */
    public void _setPlaybackRate(int i10, float f10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.playbackRate(f10);
        }
    }

    /* access modifiers changed from: private */
    public void _setVideoKeepRatio(int i10, boolean z10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.setKeepRatio(z10);
        }
    }

    /* access modifiers changed from: private */
    public void _setVideoRect(int i10, int i11, int i12, int i13, int i14) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.setVideoRect(i11, i12, i13, i14);
        }
    }

    /* access modifiers changed from: private */
    public void _setVideoURL(int i10, int i11, String str) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView == null) {
            return;
        }
        if (i11 == 0) {
            cocosVideoView.setVideoFileName(str);
        } else if (i11 == 1) {
            cocosVideoView.setVideoURL(str);
        }
    }

    /* access modifiers changed from: private */
    public void _setVideoVisible(int i10, boolean z10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView == null) {
            return;
        }
        if (z10) {
            cocosVideoView.fixSize();
            cocosVideoView.setVisibility(0);
            return;
        }
        cocosVideoView.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void _setVolume(int i10, float f10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.setVolume(f10);
        }
    }

    /* access modifiers changed from: private */
    public void _startVideo(int i10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.start();
        }
    }

    /* access modifiers changed from: private */
    public void _stopVideo(int i10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            cocosVideoView.stop();
        }
    }

    public static int createVideoWidget() {
        Message message = new Message();
        message.what = 0;
        message.arg1 = videoTag;
        mVideoHandler.sendMessage(message);
        int i10 = videoTag;
        videoTag = i10 + 1;
        return i10;
    }

    public static float getCurrentTime(int i10) {
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            return ((float) cocosVideoView.getCurrentPosition()) / 1000.0f;
        }
        return -1.0f;
    }

    public static float getDuration(int i10) {
        float f10;
        CocosVideoView cocosVideoView = sVideoViews.get(i10);
        if (cocosVideoView != null) {
            f10 = ((float) cocosVideoView.getDuration()) / 1000.0f;
        } else {
            f10 = -1.0f;
        }
        if (f10 <= 0.0f) {
            Log.w("CocosVideoHelper", "Video player's duration is not ready to get now!");
        }
        return f10;
    }

    public static native void nativeExecuteVideoCallback(int i10, int i11);

    /* access modifiers changed from: private */
    public void onBackKeyEvent() {
        int size = sVideoViews.size();
        for (int i10 = 0; i10 < size; i10++) {
            int keyAt = sVideoViews.keyAt(i10);
            CocosVideoView cocosVideoView = sVideoViews.get(keyAt);
            if (cocosVideoView != null) {
                cocosVideoView.setFullScreenEnabled(false);
                CocosHelper.runOnGameThreadAtForeground(new b(keyAt));
            }
        }
    }

    public static void pauseVideo(int i10) {
        Message message = new Message();
        message.what = 5;
        message.arg1 = i10;
        mVideoHandler.sendMessage(message);
    }

    public static void removeVideoWidget(int i10) {
        Message message = new Message();
        message.what = 1;
        message.arg1 = i10;
        mVideoHandler.sendMessage(message);
    }

    public static void seekVideoTo(int i10, int i11) {
        Message message = new Message();
        message.what = 8;
        message.arg1 = i10;
        message.arg2 = i11;
        mVideoHandler.sendMessage(message);
    }

    public static void setFullScreenEnabled(int i10, boolean z10) {
        Message message = new Message();
        message.what = 12;
        message.arg1 = i10;
        if (z10) {
            message.arg2 = 1;
        } else {
            message.arg2 = 0;
        }
        mVideoHandler.sendMessage(message);
    }

    public static void setLoop(int i10, boolean z10) {
        Message message = new Message();
        message.what = 16;
        message.arg1 = i10;
        if (z10) {
            message.arg2 = 1;
        } else {
            message.arg2 = 0;
        }
        mVideoHandler.sendMessage(message);
    }

    public static void setMute(int i10, boolean z10) {
        Message message = new Message();
        message.what = 15;
        message.arg1 = i10;
        if (z10) {
            message.arg2 = 1;
        } else {
            message.arg2 = 0;
        }
        mVideoHandler.sendMessage(message);
    }

    public static void setPlaybackRate(int i10, float f10) {
        Message message = new Message();
        message.what = 14;
        message.arg1 = i10;
        message.arg2 = (int) (f10 * 10.0f);
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoKeepRatioEnabled(int i10, boolean z10) {
        Message message = new Message();
        message.what = 11;
        message.arg1 = i10;
        if (z10) {
            message.arg2 = 1;
        } else {
            message.arg2 = 0;
        }
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoRect(int i10, int i11, int i12, int i13, int i14) {
        Message message = new Message();
        message.what = 3;
        message.arg1 = i10;
        message.obj = new Rect(i11, i12, i13, i14);
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoUrl(int i10, int i11, String str) {
        Message message = new Message();
        message.what = 2;
        message.arg1 = i10;
        message.arg2 = i11;
        message.obj = str;
        mVideoHandler.sendMessage(message);
    }

    public static void setVideoVisible(int i10, boolean z10) {
        Message message = new Message();
        message.what = 9;
        message.arg1 = i10;
        if (z10) {
            message.arg2 = 1;
        } else {
            message.arg2 = 0;
        }
        mVideoHandler.sendMessage(message);
    }

    public static void setVolume(int i10, float f10) {
        Message message = new Message();
        message.what = 13;
        message.arg1 = i10;
        message.arg2 = (int) (f10 * 10.0f);
        mVideoHandler.sendMessage(message);
    }

    public static void startVideo(int i10) {
        Message message = new Message();
        message.what = 4;
        message.arg1 = i10;
        mVideoHandler.sendMessage(message);
    }

    public static void stopVideo(int i10) {
        Message message = new Message();
        message.what = 7;
        message.arg1 = i10;
        mVideoHandler.sendMessage(message);
    }
}
