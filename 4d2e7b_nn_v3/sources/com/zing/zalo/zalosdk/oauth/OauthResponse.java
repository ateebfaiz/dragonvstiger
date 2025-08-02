package com.zing.zalo.zalosdk.oauth;

public class OauthResponse {
    private LoginChannel channel;
    private int errorCode;
    private String errorMessage;
    private long expireTime;
    private String facebookAccessToken;
    private long facebookExpireTime;
    private boolean isRegister;
    private String oauthCode;
    public String raw;
    private String refreshToken;
    private String socialId;
    private long uId;
    private int zcert;

    public OauthResponse() {
        this.uId = 0;
        this.errorCode = 0;
        this.channel = LoginChannel.ZALO;
    }

    public LoginChannel getChannel() {
        return this.channel;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getFacebookAccessToken() {
        return this.facebookAccessToken;
    }

    public long getFacebookExpireTime() {
        return this.facebookExpireTime;
    }

    public String getOauthCode() {
        return this.oauthCode;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getSocialId() {
        return this.socialId;
    }

    public int getZcert() {
        return this.zcert;
    }

    public long getuId() {
        return this.uId;
    }

    public boolean isRegister() {
        return this.isRegister;
    }

    public OauthResponse setChannel(LoginChannel loginChannel) {
        this.channel = loginChannel;
        return this;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public OauthResponse setExpireTime(long j10) {
        this.expireTime = j10;
        return this;
    }

    public void setFacebookAccessToken(String str) {
        this.facebookAccessToken = str;
    }

    public void setFacebookExpireTime(long j10) {
        this.facebookExpireTime = j10;
    }

    public OauthResponse setOauthCode(String str) {
        this.oauthCode = str;
        return this;
    }

    public OauthResponse setRefreshToken(String str) {
        this.refreshToken = str;
        return this;
    }

    public void setRegister(boolean z10) {
        this.isRegister = z10;
    }

    public void setSocialId(String str) {
        this.socialId = str;
    }

    public OauthResponse setZcert(int i10) {
        this.zcert = i10;
        return this;
    }

    public void setuId(long j10) {
        this.uId = j10;
    }

    public OauthResponse(long j10, String str, LoginChannel loginChannel) {
        this.uId = j10;
        this.oauthCode = str;
        this.channel = loginChannel;
    }

    public OauthResponse(long j10, String str, LoginChannel loginChannel, String str2, long j11) {
        this.uId = j10;
        this.oauthCode = str;
        this.channel = loginChannel;
        this.facebookAccessToken = str2;
        this.facebookExpireTime = j11;
    }

    public OauthResponse(String str, long j10, LoginChannel loginChannel, String str2, long j11) {
        this.uId = j10;
        this.refreshToken = str;
        this.channel = loginChannel;
        this.facebookAccessToken = str2;
        this.facebookExpireTime = j11;
    }
}
