package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.webkit.WebViewCompat;

@WebViewCompat.ExperimentalAsyncStartUp
public interface BlockingStartUpLocation {
    @NonNull
    String getStackInformation();
}
