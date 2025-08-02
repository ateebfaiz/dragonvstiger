package androidx.webkit.internal;

import androidx.webkit.NoVarySearchHeader;
import androidx.webkit.SpeculativeLoadingParameters;
import gc.a;
import java.lang.reflect.InvocationHandler;
import java.util.HashMap;
import java.util.Map;
import org.chromium.support_lib_boundary.SpeculativeLoadingParametersBoundaryInterface;

public class SpeculativeLoadingParametersAdapter implements SpeculativeLoadingParametersBoundaryInterface {
    private final SpeculativeLoadingParameters mSpeculativeLoadingParameters;

    public SpeculativeLoadingParametersAdapter(SpeculativeLoadingParameters speculativeLoadingParameters) {
        this.mSpeculativeLoadingParameters = speculativeLoadingParameters;
    }

    public Map<String, String> getAdditionalHeaders() {
        SpeculativeLoadingParameters speculativeLoadingParameters = this.mSpeculativeLoadingParameters;
        if (speculativeLoadingParameters == null) {
            return new HashMap();
        }
        return speculativeLoadingParameters.getAdditionalHeaders();
    }

    public InvocationHandler getNoVarySearchData() {
        NoVarySearchHeader expectedNoVarySearchData;
        SpeculativeLoadingParameters speculativeLoadingParameters = this.mSpeculativeLoadingParameters;
        if (speculativeLoadingParameters == null || (expectedNoVarySearchData = speculativeLoadingParameters.getExpectedNoVarySearchData()) == null) {
            return null;
        }
        return a.c(new NoVarySearchHeaderAdapter(expectedNoVarySearchData));
    }

    public boolean isJavaScriptEnabled() {
        SpeculativeLoadingParameters speculativeLoadingParameters = this.mSpeculativeLoadingParameters;
        if (speculativeLoadingParameters == null) {
            return false;
        }
        return speculativeLoadingParameters.isJavaScriptEnabled();
    }
}
