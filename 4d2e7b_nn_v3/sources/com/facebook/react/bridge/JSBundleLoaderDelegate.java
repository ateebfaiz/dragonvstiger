package com.facebook.react.bridge;

import android.content.res.AssetManager;

public interface JSBundleLoaderDelegate {
    void loadScriptFromAssets(AssetManager assetManager, String str, boolean z10);

    void loadScriptFromFile(String str, String str2, boolean z10);

    void loadSplitBundleFromFile(String str, String str2);

    void setSourceURLs(String str, String str2);
}
