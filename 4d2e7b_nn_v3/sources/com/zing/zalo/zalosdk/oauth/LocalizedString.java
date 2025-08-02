package com.zing.zalo.zalosdk.oauth;

public class LocalizedString {
    protected String cancelMessage;
    protected String errorWebViewMessage = "";
    protected String installMessage;
    protected String loadingMessage;
    protected String noNetworkMessage;
    protected String updateMessage;
    protected String zaloNotInstalledMessage;
    protected String zaloOauthOfDateMessage;

    public LocalizedString() {
        setDefault();
        customizeString();
    }

    private void setDefault() {
        this.loadingMessage = "Đang tải...";
        this.noNetworkMessage = "Mạng không ổn định, vui lòng thử lại sau";
        this.zaloOauthOfDateMessage = "Bản Zalo hiện tại không tương thích!";
        this.zaloNotInstalledMessage = "Bạn chưa cài Zalo!";
        this.updateMessage = "Cập nhật";
        this.cancelMessage = "Bỏ qua";
        this.installMessage = "Cài đặt";
        this.errorWebViewMessage = "Lỗi WebView. Vui lòng cài đặt Zalo để đăng nhập.";
    }

    /* access modifiers changed from: protected */
    public void customizeString() {
    }

    public String getCancelMessage() {
        return this.cancelMessage;
    }

    public String getErrorWebViewMessage() {
        return this.errorWebViewMessage;
    }

    public String getInstallMessage() {
        return this.installMessage;
    }

    public String getLoadingMessage() {
        return this.loadingMessage;
    }

    public String getNoNetworkMessage() {
        return this.noNetworkMessage;
    }

    public String getUpdateMessage() {
        return this.updateMessage;
    }

    public String getZaloNotInstalledMessage() {
        return this.zaloNotInstalledMessage;
    }

    public String getZaloOauthOfDateMessage() {
        return this.zaloOauthOfDateMessage;
    }
}
