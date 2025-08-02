package com.facebook.react.uimanager.events;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.WritableMap;
import e6.k;

public abstract class d {
    private static int sUniqueID;
    @Nullable
    private b mEventAnimationDriverMatchSpec;
    private boolean mInitialized;
    private int mSurfaceId;
    private long mTimestampMs;
    private int mUniqueID;
    private int mViewTag;

    class a implements b {
        a() {
        }

        public boolean a(int i10, String str) {
            if (i10 != d.this.getViewTag() || !str.equals(d.this.getEventName())) {
                return false;
            }
            return true;
        }
    }

    public interface b {
        boolean a(int i10, String str);
    }

    protected d() {
        int i10 = sUniqueID;
        sUniqueID = i10 + 1;
        this.mUniqueID = i10;
    }

    public boolean canCoalesce() {
        return true;
    }

    public d coalesce(d dVar) {
        if (getTimestampMs() >= dVar.getTimestampMs()) {
            return this;
        }
        return dVar;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), getEventData());
    }

    public void dispatchModern(RCTModernEventEmitter rCTModernEventEmitter) {
        if (getSurfaceId() != -1) {
            rCTModernEventEmitter.receiveEvent(getSurfaceId(), getViewTag(), getEventName(), canCoalesce(), getCoalescingKey(), getEventData(), getEventCategory());
            return;
        }
        dispatch(rCTModernEventEmitter);
    }

    /* access modifiers changed from: package-private */
    public final void dispose() {
        this.mInitialized = false;
        onDispose();
    }

    /* access modifiers changed from: protected */
    public boolean experimental_isSynchronous() {
        return false;
    }

    public short getCoalescingKey() {
        return 0;
    }

    public b getEventAnimationDriverMatchSpec() {
        if (this.mEventAnimationDriverMatchSpec == null) {
            this.mEventAnimationDriverMatchSpec = new a();
        }
        return this.mEventAnimationDriverMatchSpec;
    }

    /* access modifiers changed from: protected */
    public int getEventCategory() {
        return 2;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return null;
    }

    public abstract String getEventName();

    public final int getSurfaceId() {
        return this.mSurfaceId;
    }

    public final long getTimestampMs() {
        return this.mTimestampMs;
    }

    public int getUniqueID() {
        return this.mUniqueID;
    }

    public final int getViewTag() {
        return this.mViewTag;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void init(int i10) {
        init(-1, i10);
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void onDispose() {
    }

    /* access modifiers changed from: protected */
    public void init(int i10, int i11) {
        init(i10, i11, k.c());
    }

    protected d(int i10) {
        int i11 = sUniqueID;
        sUniqueID = i11 + 1;
        this.mUniqueID = i11;
        init(i10);
    }

    /* access modifiers changed from: protected */
    public void init(int i10, int i11, long j10) {
        this.mSurfaceId = i10;
        this.mViewTag = i11;
        this.mTimestampMs = j10;
        this.mInitialized = true;
    }

    protected d(int i10, int i11) {
        int i12 = sUniqueID;
        sUniqueID = i12 + 1;
        this.mUniqueID = i12;
        init(i10, i11);
    }
}
