package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class HttpUrlFetcher implements DataFetcher<InputStream> {
    @VisibleForTesting
    static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    @VisibleForTesting
    static final int INVALID_STATUS_CODE = -1;
    private static final int MAXIMUM_REDIRECTS = 5;
    @VisibleForTesting
    static final String REDIRECT_HEADER_FIELD = "Location";
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private final int timeout;
    private HttpURLConnection urlConnection;

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        DefaultHttpUrlConnectionFactory() {
        }

        public HttpURLConnection build(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl2, int i10) {
        this(glideUrl2, i10, DEFAULT_CONNECTION_FACTORY);
    }

    private HttpURLConnection buildAndConfigureConnection(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection build = this.connectionFactory.build(url);
            for (Map.Entry next : map.entrySet()) {
                build.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            build.setConnectTimeout(this.timeout);
            build.setReadTimeout(this.timeout);
            build.setUseCaches(false);
            build.setDoInput(true);
            build.setInstanceFollowRedirects(false);
            return build;
        } catch (IOException e10) {
            throw new HttpException("URL.openConnection threw", 0, e10);
        }
    }

    private static int getHttpStatusCodeOrInvalid(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e10) {
            if (!Log.isLoggable(TAG, 3)) {
                return -1;
            }
            Log.d(TAG, "Failed to get a response code", e10);
            return -1;
        }
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.stream = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.stream = httpURLConnection.getInputStream();
            }
            return this.stream;
        } catch (IOException e10) {
            throw new HttpException("Failed to obtain InputStream", getHttpStatusCodeOrInvalid(httpURLConnection), e10);
        }
    }

    private static boolean isHttpOk(int i10) {
        if (i10 / 100 == 2) {
            return true;
        }
        return false;
    }

    private static boolean isHttpRedirect(int i10) {
        if (i10 / 100 == 3) {
            return true;
        }
        return false;
    }

    private InputStream loadDataWithRedirects(URL url, int i10, URL url2, Map<String, String> map) throws HttpException {
        if (i10 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection buildAndConfigureConnection = buildAndConfigureConnection(url, map);
            this.urlConnection = buildAndConfigureConnection;
            try {
                buildAndConfigureConnection.connect();
                this.stream = this.urlConnection.getInputStream();
                if (this.isCancelled) {
                    return null;
                }
                int httpStatusCodeOrInvalid = getHttpStatusCodeOrInvalid(this.urlConnection);
                if (isHttpOk(httpStatusCodeOrInvalid)) {
                    return getStreamForSuccessfulRequest(this.urlConnection);
                }
                if (isHttpRedirect(httpStatusCodeOrInvalid)) {
                    String headerField = this.urlConnection.getHeaderField(REDIRECT_HEADER_FIELD);
                    if (!TextUtils.isEmpty(headerField)) {
                        try {
                            URL url3 = new URL(url, headerField);
                            cleanup();
                            return loadDataWithRedirects(url3, i10 + 1, url, map);
                        } catch (MalformedURLException e10) {
                            throw new HttpException("Bad redirect url: " + headerField, httpStatusCodeOrInvalid, e10);
                        }
                    } else {
                        throw new HttpException("Received empty or null redirect url", httpStatusCodeOrInvalid);
                    }
                } else if (httpStatusCodeOrInvalid == -1) {
                    throw new HttpException(httpStatusCodeOrInvalid);
                } else {
                    try {
                        throw new HttpException(this.urlConnection.getResponseMessage(), httpStatusCodeOrInvalid);
                    } catch (IOException e11) {
                        throw new HttpException("Failed to get a response message", httpStatusCodeOrInvalid, e11);
                    }
                }
            } catch (IOException e12) {
                throw new HttpException("Failed to connect or obtain data", getHttpStatusCodeOrInvalid(this.urlConnection), e12);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
    }

    public void cancel() {
        this.isCancelled = true;
    }

    public void cleanup() {
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.urlConnection = null;
    }

    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb2;
        long logTime = LogTime.getLogTime();
        try {
            dataCallback.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, (URL) null, this.glideUrl.getHeaders()));
            if (Log.isLoggable(TAG, 2)) {
                sb2 = new StringBuilder();
                sb2.append("Finished http url fetcher fetch in ");
                sb2.append(LogTime.getElapsedMillis(logTime));
                Log.v(TAG, sb2.toString());
            }
        } catch (IOException e10) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to load data for url", e10);
            }
            dataCallback.onLoadFailed(e10);
            if (Log.isLoggable(TAG, 2)) {
                sb2 = new StringBuilder();
            }
        } catch (Throwable th) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(logTime));
            }
            throw th;
        }
    }

    @VisibleForTesting
    HttpUrlFetcher(GlideUrl glideUrl2, int i10, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl2;
        this.timeout = i10;
        this.connectionFactory = httpUrlConnectionFactory;
    }
}
