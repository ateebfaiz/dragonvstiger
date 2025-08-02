package com.sensorsdata.analytics.android.sdk.internal.beans;

import android.net.Uri;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.sensorsdata.analytics.android.sdk.SALog;

public class ServerUrl {
    private String baseUrl;
    private String host;
    private String project;
    private String token;
    private String url;

    private ServerUrl() {
    }

    public boolean check(ServerUrl serverUrl) {
        if (serverUrl == null) {
            return false;
        }
        try {
            if (!getHost().equals(serverUrl.getHost()) || !getProject().equals(serverUrl.getProject())) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public String getHost() {
        return this.host;
    }

    public String getProject() {
        return this.project;
    }

    public String getToken() {
        return this.token;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "url=" + this.url + ",baseUrl" + this.baseUrl + ",host=" + this.host + ",project=" + this.project + ",token=" + this.token;
    }

    public ServerUrl(String str) {
        this.url = str;
        if (!TextUtils.isEmpty(str)) {
            this.baseUrl = getBaseUrl(str);
            Uri parse = Uri.parse(str);
            try {
                this.host = parse.getHost();
                this.token = parse.getQueryParameter("token");
                this.project = parse.getQueryParameter("project");
                if (TextUtils.isEmpty(this.host)) {
                    this.host = "";
                }
                if (TextUtils.isEmpty(this.project)) {
                    this.project = "default";
                }
                if (!TextUtils.isEmpty(this.token)) {
                    return;
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
                if (TextUtils.isEmpty(this.host)) {
                    this.host = "";
                }
                if (TextUtils.isEmpty(this.project)) {
                    this.project = "default";
                }
                if (!TextUtils.isEmpty(this.token)) {
                    return;
                }
            } catch (Throwable th) {
                if (TextUtils.isEmpty(this.host)) {
                    this.host = "";
                }
                if (TextUtils.isEmpty(this.project)) {
                    this.project = "default";
                }
                if (TextUtils.isEmpty(this.token)) {
                    this.token = "";
                }
                throw th;
            }
            this.token = "";
        }
    }

    public String getBaseUrl(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(DomExceptionUtils.SEPARATOR)) == -1) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }
}
