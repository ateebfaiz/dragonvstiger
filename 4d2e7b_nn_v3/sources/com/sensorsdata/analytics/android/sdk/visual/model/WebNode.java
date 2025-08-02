package com.sensorsdata.analytics.android.sdk.visual.model;

public class WebNode extends CommonNode {
    private static final long serialVersionUID = -5865016149609340219L;
    private String $element_selector;
    private String $title;
    private String $url;
    private String list_selector;
    private String tagName;
    private int zIndex;

    public String get$element_selector() {
        return this.$element_selector;
    }

    public String get$title() {
        return this.$title;
    }

    public String get$url() {
        return this.$url;
    }

    public String getList_selector() {
        return this.list_selector;
    }

    public String getTagName() {
        return this.tagName;
    }

    public int getzIndex() {
        return this.zIndex;
    }

    public void set$element_selector(String str) {
        this.$element_selector = str;
    }

    public void set$title(String str) {
        this.$title = str;
    }

    public void set$url(String str) {
        this.$url = str;
    }

    public void setList_selector(String str) {
        this.list_selector = str;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public void setzIndex(int i10) {
        this.zIndex = i10;
    }
}
