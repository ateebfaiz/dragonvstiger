package androidx.webkit.internal;

import androidx.webkit.UserAgentMetadata;
import androidx.webkit.WebViewMediaIntegrityApiStatusConfig;
import java.util.Collections;
import java.util.Set;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

public class WebSettingsNoOpAdapter extends WebSettingsAdapter {
    public WebSettingsNoOpAdapter() {
        super((WebSettingsBoundaryInterface) null);
    }

    public int getAttributionRegistrationBehavior() {
        return 1;
    }

    public boolean getBackForwardCacheEnabled() {
        return false;
    }

    public int getDisabledActionModeMenuItems() {
        return 0;
    }

    public boolean getEnterpriseAuthenticationAppLinkPolicyEnabled() {
        return false;
    }

    public int getForceDark() {
        return 1;
    }

    public int getForceDarkStrategy() {
        return 2;
    }

    public boolean getOffscreenPreRaster() {
        return false;
    }

    public Set<String> getRequestedWithHeaderOriginAllowList() {
        return Collections.emptySet();
    }

    public boolean getSafeBrowsingEnabled() {
        return true;
    }

    public int getSpeculativeLoadingStatus() {
        return 0;
    }

    public UserAgentMetadata getUserAgentMetadata() {
        return UserAgentMetadataInternal.getUserAgentMetadataFromMap(Collections.emptyMap());
    }

    public int getWebAuthenticationSupport() {
        return 0;
    }

    public WebViewMediaIntegrityApiStatusConfig getWebViewMediaIntegrityApiStatus() {
        return new WebViewMediaIntegrityApiStatusConfig.Builder(2).build();
    }

    public boolean isAlgorithmicDarkeningAllowed() {
        return false;
    }

    public void setAlgorithmicDarkeningAllowed(boolean z10) {
    }

    public void setAttributionRegistrationBehavior(int i10) {
    }

    public void setBackForwardCacheEnabled(boolean z10) {
    }

    public void setDisabledActionModeMenuItems(int i10) {
    }

    public void setEnterpriseAuthenticationAppLinkPolicyEnabled(boolean z10) {
    }

    public void setForceDark(int i10) {
    }

    public void setForceDarkStrategy(int i10) {
    }

    public void setOffscreenPreRaster(boolean z10) {
    }

    public void setRequestedWithHeaderOriginAllowList(Set<String> set) {
    }

    public void setSafeBrowsingEnabled(boolean z10) {
    }

    public void setSpeculativeLoadingStatus(int i10) {
    }

    public void setUserAgentMetadata(UserAgentMetadata userAgentMetadata) {
    }

    public void setWebAuthenticationSupport(int i10) {
    }

    public void setWebViewMediaIntegrityApiStatus(WebViewMediaIntegrityApiStatusConfig webViewMediaIntegrityApiStatusConfig) {
    }
}
