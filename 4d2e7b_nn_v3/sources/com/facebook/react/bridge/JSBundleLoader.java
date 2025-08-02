package com.facebook.react.bridge;

import android.content.Context;
import e6.c;
import java.util.Objects;

public abstract class JSBundleLoader {
    public static JSBundleLoader createAssetLoader(final Context context, final String str, final boolean z10) {
        return new JSBundleLoader() {
            public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                jSBundleLoaderDelegate.loadScriptFromAssets(context.getAssets(), str, z10);
                return str;
            }
        };
    }

    public static JSBundleLoader createCachedBundleFromNetworkLoader(final String str, final String str2) {
        return new JSBundleLoader() {
            public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                try {
                    jSBundleLoaderDelegate.loadScriptFromFile(str2, str, false);
                    return str;
                } catch (Exception e10) {
                    throw c.b(str, Objects.toString(e10.getMessage(), ""), e10);
                }
            }
        };
    }

    public static JSBundleLoader createCachedSplitBundleFromNetworkLoader(final String str, final String str2) {
        return new JSBundleLoader() {
            public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                try {
                    jSBundleLoaderDelegate.loadSplitBundleFromFile(str2, str);
                    return str;
                } catch (Exception e10) {
                    throw c.b(str, Objects.toString(e10.getMessage(), ""), e10);
                }
            }
        };
    }

    public static JSBundleLoader createFileLoader(String str) {
        return createFileLoader(str, str, false);
    }

    public static JSBundleLoader createRemoteDebuggerBundleLoader(final String str, final String str2) {
        return new JSBundleLoader() {
            public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                jSBundleLoaderDelegate.setSourceURLs(str2, str);
                return str2;
            }
        };
    }

    public abstract String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate);

    public static JSBundleLoader createFileLoader(final String str, final String str2, final boolean z10) {
        return new JSBundleLoader() {
            public String loadScript(JSBundleLoaderDelegate jSBundleLoaderDelegate) {
                jSBundleLoaderDelegate.loadScriptFromFile(str, str2, z10);
                return str;
            }
        };
    }
}
