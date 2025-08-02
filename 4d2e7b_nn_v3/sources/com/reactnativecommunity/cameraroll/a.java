package com.reactnativecommunity.cameraroll;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.reactnativecommunity.cameraroll.CameraRollModule;

public final /* synthetic */ class a implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraRollModule.d f11237a;

    public /* synthetic */ a(CameraRollModule.d dVar) {
        this.f11237a = dVar;
    }

    public final void onScanCompleted(String str, Uri uri) {
        this.f11237a.d(str, uri);
    }
}
