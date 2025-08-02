package com.zing.zalo.zalosdk.oauth;

import java.util.Map;

public class FeedData {
    private String appName = "";
    private String link;
    private String linkDesc = "";
    private String linkSource = "";
    private String[] linkThumb;
    private String linkTitle = "";
    private String msg = "";
    private Map<String, String> params;

    public String getAppName() {
        return this.appName;
    }

    public String getLink() {
        return this.link;
    }

    public String getLinkDesc() {
        return this.linkDesc;
    }

    public String getLinkSource() {
        return this.linkSource;
    }

    public String[] getLinkThumb() {
        return this.linkThumb;
    }

    public String getLinkTitle() {
        return this.linkTitle;
    }

    public String getMsg() {
        return this.msg;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setLinkDesc(String str) {
        this.linkDesc = str;
    }

    public void setLinkSource(String str) {
        this.linkSource = str;
    }

    public void setLinkThumb(String[] strArr) {
        this.linkThumb = strArr;
    }

    public void setLinkTitle(String str) {
        this.linkTitle = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }
}
