package androidx.webkit.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.StartupApiFeature;
import java.util.Collection;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebViewFeatureInternal {
    public static final ApiFeature.T ALGORITHMIC_DARKENING = new a(WebViewFeature.ALGORITHMIC_DARKENING, WebViewFeature.ALGORITHMIC_DARKENING);
    public static final ApiFeature.NoFramework ASYNC_WEBVIEW_STARTUP = new ApiFeature.NoFramework("IMPLEMENTATION_ONLY_FEATURE", "ASYNC_WEBVIEW_STARTUP");
    public static final ApiFeature.NoFramework ATTRIBUTION_REGISTRATION_BEHAVIOR = new ApiFeature.NoFramework(WebViewFeature.ATTRIBUTION_REGISTRATION_BEHAVIOR, "ATTRIBUTION_BEHAVIOR");
    public static final ApiFeature.NoFramework BACK_FORWARD_CACHE = new ApiFeature.NoFramework(WebViewFeature.BACK_FORWARD_CACHE, WebViewFeature.BACK_FORWARD_CACHE);
    public static final ApiFeature.M CREATE_WEB_MESSAGE_CHANNEL = new ApiFeature.M(WebViewFeature.CREATE_WEB_MESSAGE_CHANNEL, WebViewFeature.CREATE_WEB_MESSAGE_CHANNEL);
    public static final ApiFeature.NoFramework DEFAULT_TRAFFICSTATS_TAGGING = new ApiFeature.NoFramework(WebViewFeature.DEFAULT_TRAFFICSTATS_TAGGING, WebViewFeature.DEFAULT_TRAFFICSTATS_TAGGING);
    public static final ApiFeature.NoFramework DELETE_BROWSING_DATA = new ApiFeature.NoFramework(WebViewFeature.DELETE_BROWSING_DATA, "WEB_STORAGE_DELETE_BROWSING_DATA");
    public static final ApiFeature.N DISABLED_ACTION_MODE_MENU_ITEMS = new ApiFeature.N(WebViewFeature.DISABLED_ACTION_MODE_MENU_ITEMS, WebViewFeature.DISABLED_ACTION_MODE_MENU_ITEMS);
    public static final ApiFeature.NoFramework DOCUMENT_START_SCRIPT = new ApiFeature.NoFramework(WebViewFeature.DOCUMENT_START_SCRIPT, "DOCUMENT_START_SCRIPT:1");
    public static final ApiFeature.NoFramework ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY = new ApiFeature.NoFramework(WebViewFeature.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY, WebViewFeature.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY);
    public static final ApiFeature.Q FORCE_DARK = new ApiFeature.Q(WebViewFeature.FORCE_DARK, WebViewFeature.FORCE_DARK);
    public static final ApiFeature.NoFramework FORCE_DARK_STRATEGY = new ApiFeature.NoFramework(WebViewFeature.FORCE_DARK_STRATEGY, "FORCE_DARK_BEHAVIOR");
    public static final ApiFeature.NoFramework GET_COOKIE_INFO = new ApiFeature.NoFramework(WebViewFeature.GET_COOKIE_INFO, WebViewFeature.GET_COOKIE_INFO);
    public static final ApiFeature.NoFramework GET_VARIATIONS_HEADER = new ApiFeature.NoFramework(WebViewFeature.GET_VARIATIONS_HEADER, WebViewFeature.GET_VARIATIONS_HEADER);
    public static final ApiFeature.O GET_WEB_CHROME_CLIENT = new ApiFeature.O(WebViewFeature.GET_WEB_CHROME_CLIENT, WebViewFeature.GET_WEB_CHROME_CLIENT);
    public static final ApiFeature.O GET_WEB_VIEW_CLIENT = new ApiFeature.O(WebViewFeature.GET_WEB_VIEW_CLIENT, WebViewFeature.GET_WEB_VIEW_CLIENT);
    public static final ApiFeature.Q GET_WEB_VIEW_RENDERER = new ApiFeature.Q(WebViewFeature.GET_WEB_VIEW_RENDERER, WebViewFeature.GET_WEB_VIEW_RENDERER);
    public static final ApiFeature.NoFramework MULTI_PROCESS = new ApiFeature.NoFramework(WebViewFeature.MULTI_PROCESS, "MULTI_PROCESS_QUERY");
    public static final ApiFeature.NoFramework MULTI_PROFILE = new b(WebViewFeature.MULTI_PROFILE, WebViewFeature.MULTI_PROFILE);
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final ApiFeature.NoFramework MUTE_AUDIO = new ApiFeature.NoFramework(WebViewFeature.MUTE_AUDIO, WebViewFeature.MUTE_AUDIO);
    public static final ApiFeature.M OFF_SCREEN_PRERASTER = new ApiFeature.M(WebViewFeature.OFF_SCREEN_PRERASTER, WebViewFeature.OFF_SCREEN_PRERASTER);
    public static final ApiFeature.M POST_WEB_MESSAGE = new ApiFeature.M(WebViewFeature.POST_WEB_MESSAGE, WebViewFeature.POST_WEB_MESSAGE);
    public static final ApiFeature.NoFramework PRERENDER_WITH_URL = new ApiFeature.NoFramework(WebViewFeature.PRERENDER_WITH_URL, WebViewFeature.PRERENDER_WITH_URL);
    public static final ApiFeature.NoFramework PROFILE_URL_PREFETCH = new c(WebViewFeature.PROFILE_URL_PREFETCH, WebViewFeature.PROFILE_URL_PREFETCH);
    public static final ApiFeature.NoFramework PROXY_OVERRIDE = new ApiFeature.NoFramework(WebViewFeature.PROXY_OVERRIDE, "PROXY_OVERRIDE:3");
    public static final ApiFeature.NoFramework PROXY_OVERRIDE_REVERSE_BYPASS = new ApiFeature.NoFramework(WebViewFeature.PROXY_OVERRIDE_REVERSE_BYPASS, WebViewFeature.PROXY_OVERRIDE_REVERSE_BYPASS);
    public static final ApiFeature.M RECEIVE_HTTP_ERROR = new ApiFeature.M(WebViewFeature.RECEIVE_HTTP_ERROR, WebViewFeature.RECEIVE_HTTP_ERROR);
    public static final ApiFeature.M RECEIVE_WEB_RESOURCE_ERROR = new ApiFeature.M(WebViewFeature.RECEIVE_WEB_RESOURCE_ERROR, WebViewFeature.RECEIVE_WEB_RESOURCE_ERROR);
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final ApiFeature.NoFramework REQUESTED_WITH_HEADER_ALLOW_LIST = new ApiFeature.NoFramework(WebViewFeature.REQUESTED_WITH_HEADER_ALLOW_LIST, WebViewFeature.REQUESTED_WITH_HEADER_ALLOW_LIST);
    @Deprecated
    public static final ApiFeature.O_MR1 SAFE_BROWSING_ALLOWLIST_DEPRECATED_TO_DEPRECATED = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_WHITELIST, WebViewFeature.SAFE_BROWSING_WHITELIST);
    @Deprecated
    public static final ApiFeature.O_MR1 SAFE_BROWSING_ALLOWLIST_DEPRECATED_TO_PREFERRED = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_WHITELIST, WebViewFeature.SAFE_BROWSING_ALLOWLIST);
    public static final ApiFeature.O_MR1 SAFE_BROWSING_ALLOWLIST_PREFERRED_TO_DEPRECATED = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_ALLOWLIST, WebViewFeature.SAFE_BROWSING_WHITELIST);
    public static final ApiFeature.O_MR1 SAFE_BROWSING_ALLOWLIST_PREFERRED_TO_PREFERRED = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_ALLOWLIST, WebViewFeature.SAFE_BROWSING_ALLOWLIST);
    public static final ApiFeature.O SAFE_BROWSING_ENABLE = new ApiFeature.O(WebViewFeature.SAFE_BROWSING_ENABLE, WebViewFeature.SAFE_BROWSING_ENABLE);
    public static final ApiFeature.O_MR1 SAFE_BROWSING_HIT = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_HIT, WebViewFeature.SAFE_BROWSING_HIT);
    public static final ApiFeature.O_MR1 SAFE_BROWSING_PRIVACY_POLICY_URL = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_PRIVACY_POLICY_URL, WebViewFeature.SAFE_BROWSING_PRIVACY_POLICY_URL);
    public static final ApiFeature.O_MR1 SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY, WebViewFeature.SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY);
    public static final ApiFeature.O_MR1 SAFE_BROWSING_RESPONSE_PROCEED = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_RESPONSE_PROCEED, WebViewFeature.SAFE_BROWSING_RESPONSE_PROCEED);
    public static final ApiFeature.O_MR1 SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL = new ApiFeature.O_MR1(WebViewFeature.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL, WebViewFeature.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL);
    public static final ApiFeature.N SERVICE_WORKER_BASIC_USAGE = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_BASIC_USAGE, WebViewFeature.SERVICE_WORKER_BASIC_USAGE);
    public static final ApiFeature.N SERVICE_WORKER_BLOCK_NETWORK_LOADS = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_BLOCK_NETWORK_LOADS, WebViewFeature.SERVICE_WORKER_BLOCK_NETWORK_LOADS);
    public static final ApiFeature.N SERVICE_WORKER_CACHE_MODE = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_CACHE_MODE, WebViewFeature.SERVICE_WORKER_CACHE_MODE);
    public static final ApiFeature.N SERVICE_WORKER_CONTENT_ACCESS = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_CONTENT_ACCESS, WebViewFeature.SERVICE_WORKER_CONTENT_ACCESS);
    public static final ApiFeature.N SERVICE_WORKER_FILE_ACCESS = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_FILE_ACCESS, WebViewFeature.SERVICE_WORKER_FILE_ACCESS);
    public static final ApiFeature.N SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST = new ApiFeature.N(WebViewFeature.SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST, WebViewFeature.SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST);
    public static final ApiFeature.N SHOULD_OVERRIDE_WITH_REDIRECTS = new ApiFeature.N(WebViewFeature.SHOULD_OVERRIDE_WITH_REDIRECTS, WebViewFeature.SHOULD_OVERRIDE_WITH_REDIRECTS);
    public static final ApiFeature.NoFramework SPECULATIVE_LOADING = new ApiFeature.NoFramework(WebViewFeature.SPECULATIVE_LOADING, "SPECULATIVE_LOADING");
    public static final ApiFeature.NoFramework SPECULATIVE_LOADING_CONFIG = new ApiFeature.NoFramework(WebViewFeature.SPECULATIVE_LOADING_CONFIG, "SPECULATIVE_LOADING_CONFIG_V2");
    public static final StartupApiFeature.NoFramework STARTUP_FEATURE_CONFIGURE_PARTITIONED_COOKIES = new StartupApiFeature.NoFramework("STARTUP_FEATURE_CONFIGURE_PARTITIONED_COOKIES", "STARTUP_FEATURE_CONFIGURE_PARTITIONED_COOKIES");
    public static final StartupApiFeature.P STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX = new StartupApiFeature.P("STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX", "STARTUP_FEATURE_SET_DATA_DIRECTORY_SUFFIX");
    public static final StartupApiFeature.NoFramework STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH = new StartupApiFeature.NoFramework(WebViewFeature.STARTUP_FEATURE_SET_DIRECTORY_BASE_PATHS, StartupFeatures.STARTUP_FEATURE_SET_DIRECTORY_BASE_PATH);
    public static final ApiFeature.O_MR1 START_SAFE_BROWSING = new ApiFeature.O_MR1(WebViewFeature.START_SAFE_BROWSING, WebViewFeature.START_SAFE_BROWSING);
    public static final ApiFeature.P TRACING_CONTROLLER_BASIC_USAGE = new ApiFeature.P(WebViewFeature.TRACING_CONTROLLER_BASIC_USAGE, WebViewFeature.TRACING_CONTROLLER_BASIC_USAGE);
    public static final ApiFeature.NoFramework USER_AGENT_METADATA = new ApiFeature.NoFramework(WebViewFeature.USER_AGENT_METADATA, WebViewFeature.USER_AGENT_METADATA);
    public static final ApiFeature.M VISUAL_STATE_CALLBACK = new ApiFeature.M(WebViewFeature.VISUAL_STATE_CALLBACK, WebViewFeature.VISUAL_STATE_CALLBACK);
    public static final ApiFeature.NoFramework WEBVIEW_MEDIA_INTEGRITY_API_STATUS = new ApiFeature.NoFramework(WebViewFeature.WEBVIEW_MEDIA_INTEGRITY_API_STATUS, "WEBVIEW_INTEGRITY_API_STATUS");
    public static final ApiFeature.NoFramework WEB_AUTHENTICATION = new ApiFeature.NoFramework(WebViewFeature.WEB_AUTHENTICATION, WebViewFeature.WEB_AUTHENTICATION);
    public static final ApiFeature.NoFramework WEB_MESSAGE_ARRAY_BUFFER = new ApiFeature.NoFramework(WebViewFeature.WEB_MESSAGE_ARRAY_BUFFER, WebViewFeature.WEB_MESSAGE_ARRAY_BUFFER);
    public static final ApiFeature.M WEB_MESSAGE_CALLBACK_ON_MESSAGE = new ApiFeature.M(WebViewFeature.WEB_MESSAGE_CALLBACK_ON_MESSAGE, WebViewFeature.WEB_MESSAGE_CALLBACK_ON_MESSAGE);
    public static final ApiFeature.NoFramework WEB_MESSAGE_LISTENER = new ApiFeature.NoFramework(WebViewFeature.WEB_MESSAGE_LISTENER, WebViewFeature.WEB_MESSAGE_LISTENER);
    public static final ApiFeature.M WEB_MESSAGE_PORT_CLOSE = new ApiFeature.M(WebViewFeature.WEB_MESSAGE_PORT_CLOSE, WebViewFeature.WEB_MESSAGE_PORT_CLOSE);
    public static final ApiFeature.M WEB_MESSAGE_PORT_POST_MESSAGE = new ApiFeature.M(WebViewFeature.WEB_MESSAGE_PORT_POST_MESSAGE, WebViewFeature.WEB_MESSAGE_PORT_POST_MESSAGE);
    public static final ApiFeature.M WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK = new ApiFeature.M(WebViewFeature.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK, WebViewFeature.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK);
    public static final ApiFeature.M WEB_RESOURCE_ERROR_GET_CODE = new ApiFeature.M(WebViewFeature.WEB_RESOURCE_ERROR_GET_CODE, WebViewFeature.WEB_RESOURCE_ERROR_GET_CODE);
    public static final ApiFeature.M WEB_RESOURCE_ERROR_GET_DESCRIPTION = new ApiFeature.M(WebViewFeature.WEB_RESOURCE_ERROR_GET_DESCRIPTION, WebViewFeature.WEB_RESOURCE_ERROR_GET_DESCRIPTION);
    public static final ApiFeature.N WEB_RESOURCE_REQUEST_IS_REDIRECT = new ApiFeature.N(WebViewFeature.WEB_RESOURCE_REQUEST_IS_REDIRECT, WebViewFeature.WEB_RESOURCE_REQUEST_IS_REDIRECT);
    public static final ApiFeature.Q WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE = new ApiFeature.Q(WebViewFeature.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE, WebViewFeature.WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE);
    public static final ApiFeature.Q WEB_VIEW_RENDERER_TERMINATE = new ApiFeature.Q(WebViewFeature.WEB_VIEW_RENDERER_TERMINATE, WebViewFeature.WEB_VIEW_RENDERER_TERMINATE);

    class a extends ApiFeature.T {

        /* renamed from: a  reason: collision with root package name */
        private final Pattern f16938a = Pattern.compile("\\A\\d+");

        a(String str, String str2) {
            super(str, str2);
        }

        public boolean isSupportedByWebView() {
            boolean isSupportedByWebView = super.isSupportedByWebView();
            if (!isSupportedByWebView || Build.VERSION.SDK_INT >= 29) {
                return isSupportedByWebView;
            }
            PackageInfo currentLoadedWebViewPackage = WebViewCompat.getCurrentLoadedWebViewPackage();
            if (currentLoadedWebViewPackage == null) {
                return false;
            }
            Matcher matcher = this.f16938a.matcher(currentLoadedWebViewPackage.versionName);
            if (!matcher.find() || Integer.parseInt(currentLoadedWebViewPackage.versionName.substring(matcher.start(), matcher.end())) < 105) {
                return false;
            }
            return true;
        }
    }

    class b extends ApiFeature.NoFramework {
        b(String str, String str2) {
            super(str, str2);
        }

        public boolean isSupportedByWebView() {
            if (super.isSupportedByWebView() && WebViewFeature.isFeatureSupported(WebViewFeature.MULTI_PROCESS)) {
                return WebViewCompat.isMultiProcessEnabled();
            }
            return false;
        }
    }

    class c extends ApiFeature.NoFramework {
        c(String str, String str2) {
            super(str, str2);
        }

        public boolean isSupportedByWebView() {
            if (!WebViewFeature.isFeatureSupported(WebViewFeature.MULTI_PROFILE)) {
                return false;
            }
            return super.isSupportedByWebView();
        }
    }

    private WebViewFeatureInternal() {
    }

    public static UnsupportedOperationException getUnsupportedOperationException() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public static boolean isStartupFeatureSupported(String str, Context context) {
        return isStartupFeatureSupported(str, StartupApiFeature.values(), context);
    }

    public static boolean isSupported(String str) {
        return isSupported(str, ApiFeature.values());
    }

    @VisibleForTesting
    public static boolean isStartupFeatureSupported(String str, Collection<StartupApiFeature> collection, Context context) {
        HashSet<StartupApiFeature> hashSet = new HashSet<>();
        for (StartupApiFeature next : collection) {
            if (next.getPublicFeatureName().equals(str)) {
                hashSet.add(next);
            }
        }
        if (!hashSet.isEmpty()) {
            for (StartupApiFeature isSupported : hashSet) {
                if (isSupported.isSupported(context)) {
                    return true;
                }
            }
            return false;
        }
        throw new RuntimeException("Unknown feature " + str);
    }

    @VisibleForTesting
    public static <T extends ConditionallySupportedFeature> boolean isSupported(String str, Collection<T> collection) {
        HashSet<ConditionallySupportedFeature> hashSet = new HashSet<>();
        for (T t10 : collection) {
            if (t10.getPublicFeatureName().equals(str)) {
                hashSet.add(t10);
            }
        }
        if (!hashSet.isEmpty()) {
            for (ConditionallySupportedFeature isSupported : hashSet) {
                if (isSupported.isSupported()) {
                    return true;
                }
            }
            return false;
        }
        throw new RuntimeException("Unknown feature " + str);
    }
}
