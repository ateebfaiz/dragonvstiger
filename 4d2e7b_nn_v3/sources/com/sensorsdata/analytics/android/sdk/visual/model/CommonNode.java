package com.sensorsdata.analytics.android.sdk.visual.model;

import java.io.Serializable;
import java.util.List;

public class CommonNode implements Serializable {
    private static final long serialVersionUID = -5865016149609340219L;
    private String $element_content;
    private String $element_path;
    private String $element_position;
    private boolean enable_click;
    private float height;

    /* renamed from: id  reason: collision with root package name */
    private String f11345id;
    private boolean isRootView;
    private boolean is_list_view;
    private float left;
    private int level;
    private String lib_version;
    private float originLeft;
    private float originTop;
    private float scale;
    private float scrollX;
    private float scrollY;
    private List<String> subelements;
    private float top;
    private boolean visibility;
    private float width;

    public String get$element_content() {
        return this.$element_content;
    }

    public String get$element_path() {
        return this.$element_path;
    }

    public String get$element_position() {
        return this.$element_position;
    }

    public float getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f11345id;
    }

    public float getLeft() {
        return this.left;
    }

    public int getLevel() {
        return this.level;
    }

    public String getLib_version() {
        return this.lib_version;
    }

    public float getOriginLeft() {
        return this.originLeft;
    }

    public float getOriginTop() {
        return this.originTop;
    }

    public float getScale() {
        return this.scale;
    }

    public float getScrollX() {
        return this.scrollX;
    }

    public float getScrollY() {
        return this.scrollY;
    }

    public List<String> getSubelements() {
        return this.subelements;
    }

    public float getTop() {
        return this.top;
    }

    public float getWidth() {
        return this.width;
    }

    public boolean isEnable_click() {
        return this.enable_click;
    }

    public boolean isIs_list_view() {
        return this.is_list_view;
    }

    public boolean isRootView() {
        return this.isRootView;
    }

    public boolean isVisibility() {
        return this.visibility;
    }

    public void set$element_content(String str) {
        this.$element_content = str;
    }

    public void set$element_path(String str) {
        this.$element_path = str;
    }

    public void set$element_position(String str) {
        this.$element_position = str;
    }

    public void setEnable_click(boolean z10) {
        this.enable_click = z10;
    }

    public void setHeight(float f10) {
        this.height = f10;
    }

    public void setId(String str) {
        this.f11345id = str;
    }

    public void setIs_list_view(boolean z10) {
        this.is_list_view = z10;
    }

    public void setLeft(float f10) {
        this.left = f10;
    }

    public void setLevel(int i10) {
        this.level = i10;
    }

    public void setLib_version(String str) {
        this.lib_version = str;
    }

    public void setOriginLeft(float f10) {
        this.originLeft = f10;
    }

    public void setOriginTop(float f10) {
        this.originTop = f10;
    }

    public void setRootView(boolean z10) {
        this.isRootView = z10;
    }

    public void setScale(float f10) {
        this.scale = f10;
    }

    public void setScrollX(float f10) {
        this.scrollX = f10;
    }

    public void setScrollY(float f10) {
        this.scrollY = f10;
    }

    public void setSubelements(List<String> list) {
        this.subelements = list;
    }

    public void setTop(float f10) {
        this.top = f10;
    }

    public void setVisibility(boolean z10) {
        this.visibility = z10;
    }

    public void setWidth(float f10) {
        this.width = f10;
    }
}
