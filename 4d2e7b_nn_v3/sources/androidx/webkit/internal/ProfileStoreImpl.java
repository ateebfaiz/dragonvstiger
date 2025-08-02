package androidx.webkit.internal;

import androidx.webkit.Profile;
import androidx.webkit.ProfileStore;
import gc.a;
import java.lang.reflect.InvocationHandler;
import java.util.List;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;

public class ProfileStoreImpl implements ProfileStore {
    private static ProfileStore sInstance;
    private final ProfileStoreBoundaryInterface mProfileStoreImpl;

    private ProfileStoreImpl(ProfileStoreBoundaryInterface profileStoreBoundaryInterface) {
        this.mProfileStoreImpl = profileStoreBoundaryInterface;
    }

    public static ProfileStore getInstance() {
        if (sInstance == null) {
            sInstance = new ProfileStoreImpl(WebViewGlueCommunicator.getFactory().getProfileStore());
        }
        return sInstance;
    }

    public boolean deleteProfile(String str) throws IllegalStateException {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileStoreImpl.deleteProfile(str);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public List<String> getAllProfileNames() {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileStoreImpl.getAllProfileNames();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public Profile getOrCreateProfile(String str) {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return new ProfileImpl((ProfileBoundaryInterface) a.a(ProfileBoundaryInterface.class, this.mProfileStoreImpl.getOrCreateProfile(str)));
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public Profile getProfile(String str) {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            InvocationHandler profile = this.mProfileStoreImpl.getProfile(str);
            if (profile != null) {
                return new ProfileImpl((ProfileBoundaryInterface) a.a(ProfileBoundaryInterface.class, profile));
            }
            return null;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    private ProfileStoreImpl() {
        this.mProfileStoreImpl = null;
    }
}
