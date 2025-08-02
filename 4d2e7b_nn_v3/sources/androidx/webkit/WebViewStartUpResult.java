package androidx.webkit;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import androidx.webkit.WebViewCompat;
import java.util.List;

@WebViewCompat.ExperimentalAsyncStartUp
public interface WebViewStartUpResult {
    @SuppressLint({"NullableCollection"})
    @Nullable
    List<BlockingStartUpLocation> getBlockingStartUpLocations();

    @SuppressLint({"AutoBoxing"})
    @Nullable
    Long getMaxTimePerTaskInUiThreadMillis();

    @SuppressLint({"AutoBoxing"})
    @Nullable
    Long getTotalTimeInUiThreadMillis();
}
