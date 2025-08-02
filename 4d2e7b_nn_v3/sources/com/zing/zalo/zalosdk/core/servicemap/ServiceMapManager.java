package com.zing.zalo.zalosdk.core.servicemap;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.zing.zalo.zalosdk.Constant;
import com.zing.zalo.zalosdk.core.http.HttpClientFactory;
import com.zing.zalo.zalosdk.core.http.HttpClientRequest;
import com.zing.zalo.zalosdk.core.log.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ServiceMapManager {
    public static final String KEY_URL_CENTRALIZED = "centralized_http_s";
    public static final String KEY_URL_GRAPH = "graph_http_s";
    public static final String KEY_URL_OAUTH = "oauth_http_s";
    private static final long ONE_DATE_DURATION = 86400000;
    public static final String[] SERVICE_MAP_URLS = {"https://mp3.zing.vn/zdl/service_map_all.bin", "https://zaloapp.com/zdl/service_map_all.bin", "https://news.zing.vn/zdl/service_map_all.bin", "https://n.zing.vn/zdl/service_map_all.bin", "https://srv.mp3.zing.vn/zdl/service_map_all.bin"};
    private static final String URL_CENTRALIZED = "https://ztevents.zaloapp.com";
    private static final String URL_DEV_CENTRALIZED = "https://ztevents.zaloapp.com";
    private static final String URL_DEV_GRAPH = "https://graph.zaloapp.com";
    private static final String URL_DEV_OAUTH = "https://dev-oauth.zaloapp.com";
    private static final String URL_GRAPH = "https://graph.zaloapp.com";
    private static final String URL_OAUTH = "https://oauth.zaloapp.com";
    private static ServiceMapManager instance;
    private long expireTime = -1;
    private HttpClientFactory httpClientFactory = new HttpClientFactory();
    private ServiceMapStorage storage;
    private Map<String, String> urls = new HashMap();

    public static class DownloadServiceMapFilesAsyncTask extends AsyncTask<Integer, Void, JSONObject> {
        private final HttpClientFactory httpClientFactory;
        private ServiceMapListener listener;

        DownloadServiceMapFilesAsyncTask(HttpClientFactory httpClientFactory2, ServiceMapListener serviceMapListener) {
            this.httpClientFactory = httpClientFactory2;
            this.listener = serviceMapListener;
        }

        /* access modifiers changed from: protected */
        public JSONObject doInBackground(Integer... numArr) {
            String[] strArr = ServiceMapManager.SERVICE_MAP_URLS;
            int length = strArr.length;
            int i10 = 0;
            while (i10 < length) {
                try {
                    return new JSONObject(ServiceMapTools.decryptString(this.httpClientFactory.newRequest(HttpClientRequest.Type.GET, strArr[i10]).getText()));
                } catch (Exception e10) {
                    Log.e("DownloadServiceMapFilesAsyncTask", e10.getMessage());
                    i10++;
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(JSONObject jSONObject) {
            this.listener.receiveJSONObject(jSONObject);
        }
    }

    private ServiceMapManager() {
        if (Constant.IS_DEV.booleanValue()) {
            this.urls.put(KEY_URL_OAUTH, URL_DEV_OAUTH);
            this.urls.put(KEY_URL_GRAPH, "https://graph.zaloapp.com");
            this.urls.put(KEY_URL_CENTRALIZED, "https://ztevents.zaloapp.com");
            return;
        }
        this.urls.put(KEY_URL_OAUTH, URL_OAUTH);
        this.urls.put(KEY_URL_GRAPH, "https://graph.zaloapp.com");
        this.urls.put(KEY_URL_CENTRALIZED, "https://ztevents.zaloapp.com");
    }

    public static synchronized void destroyInstance() {
        synchronized (ServiceMapManager.class) {
            if (instance != null) {
                instance = null;
            }
        }
    }

    public static synchronized ServiceMapManager getInstance() {
        ServiceMapManager serviceMapManager;
        synchronized (ServiceMapManager.class) {
            try {
                if (instance == null) {
                    instance = new ServiceMapManager();
                }
                serviceMapManager = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return serviceMapManager;
    }

    /* access modifiers changed from: private */
    public void updateMapUrls(String str, String str2, String str3, Context context) {
        ServiceMapStorage storage2 = getStorage(context);
        storage2.setKeyUrlCentralized(str3);
        storage2.setKeyUrlGraph(str2);
        storage2.setKeyUrlOauth(str);
        this.urls.put(KEY_URL_OAUTH, str);
        this.urls.put(KEY_URL_GRAPH, str2);
        this.urls.put(KEY_URL_CENTRALIZED, str3);
        long currentTimeMillis = System.currentTimeMillis() + ONE_DATE_DURATION;
        this.expireTime = currentTimeMillis;
        storage2.setExpireTime(currentTimeMillis);
    }

    private void updateMapUrlsFromPreference(Context context) {
        ServiceMapStorage storage2 = getStorage(context);
        String keyUrlOauth = storage2.getKeyUrlOauth();
        String keyUrlGraph = storage2.getKeyUrlGraph();
        String keyUrlCentralized = storage2.getKeyUrlCentralized();
        if (!TextUtils.isEmpty(keyUrlOauth) && !TextUtils.isEmpty(keyUrlGraph) && !TextUtils.isEmpty(keyUrlCentralized)) {
            this.urls.put(KEY_URL_OAUTH, keyUrlOauth);
            this.urls.put(KEY_URL_GRAPH, keyUrlGraph);
            this.urls.put(KEY_URL_CENTRALIZED, keyUrlCentralized);
        }
    }

    public ServiceMapStorage getStorage(Context context) {
        if (this.storage == null) {
            this.storage = new ServiceMapStorage(context);
        }
        return this.storage;
    }

    public boolean isExpiredTime(Context context) {
        long j10;
        long currentTimeMillis = System.currentTimeMillis();
        ServiceMapStorage storage2 = getStorage(context);
        if (this.expireTime == -1) {
            if (storage2.getExpireTime() != 0) {
                j10 = storage2.getExpireTime();
            } else {
                j10 = currentTimeMillis;
            }
            this.expireTime = j10;
        }
        if (currentTimeMillis >= this.expireTime) {
            return true;
        }
        return false;
    }

    public void load(final Context context) {
        updateMapUrlsFromPreference(context);
        if (isExpiredTime(context) && !Constant.IS_DEV.booleanValue()) {
            new DownloadServiceMapFilesAsyncTask(this.httpClientFactory, new ServiceMapListener() {
                public void receiveJSONObject(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        Log.v("Service map not found!");
                        return;
                    }
                    try {
                        String string = jSONObject.getJSONArray(ServiceMapManager.KEY_URL_OAUTH).getString(0);
                        String string2 = jSONObject.getJSONArray(ServiceMapManager.KEY_URL_GRAPH).getString(0);
                        String string3 = jSONObject.getJSONArray(ServiceMapManager.KEY_URL_CENTRALIZED).getString(0);
                        Log.v("Got service map: ");
                        Log.v("oath: " + string);
                        Log.v("graph: " + string2);
                        Log.v("centralized: " + string3);
                        ServiceMapManager.this.updateMapUrls(string, string2, string3, context);
                    } catch (Exception e10) {
                        Log.v(e10.getMessage());
                    }
                }
            }).execute(new Integer[0]);
        }
    }

    public void setHttpClientFactory(HttpClientFactory httpClientFactory2) {
        this.httpClientFactory = httpClientFactory2;
    }

    public void setStorage(ServiceMapStorage serviceMapStorage) {
        this.storage = serviceMapStorage;
    }

    public String urlFor(String str, String str2) {
        String str3 = this.urls.get(str);
        if (str3 == null) {
            Log.v("Url for" + str + "not found");
            return str2;
        } else if (str3.endsWith(DomExceptionUtils.SEPARATOR) || str2.startsWith(DomExceptionUtils.SEPARATOR)) {
            return str3 + str2;
        } else {
            return str3 + DomExceptionUtils.SEPARATOR + str2;
        }
    }
}
