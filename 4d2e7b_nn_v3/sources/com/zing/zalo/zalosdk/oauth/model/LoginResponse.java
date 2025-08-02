package com.zing.zalo.zalosdk.oauth.model;

public class LoginResponse {
    int error;
    String errorDescription;
    String errorMsg;
    String errorReason;
    String extInfo;
    String fromSource;
    boolean isRegister;
    String name;
    String oauth;
    String state;
    long uid;
    String viewer;
    int zprotect;

    public int getError() {
        return this.error;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public String getFromSource() {
        return this.fromSource;
    }

    public String getName() {
        return this.name;
    }

    public String getOauth() {
        return this.oauth;
    }

    public String getState() {
        return this.state;
    }

    public long getUid() {
        return this.uid;
    }

    public String getViewer() {
        return this.viewer;
    }

    public int getZprotect() {
        return this.zprotect;
    }

    public boolean isRegister() {
        return this.isRegister;
    }

    public LoginResponse setError(int i10) {
        this.error = i10;
        return this;
    }

    public LoginResponse setErrorDescription(String str) {
        this.errorDescription = str;
        return this;
    }

    public LoginResponse setErrorMsg(String str) {
        this.errorMsg = str;
        return this;
    }

    public LoginResponse setErrorReason(String str) {
        this.errorReason = str;
        return this;
    }

    public LoginResponse setExtInfo(String str) {
        this.extInfo = str;
        return this;
    }

    public LoginResponse setFromSource(String str) {
        this.fromSource = str;
        return this;
    }

    public LoginResponse setName(String str) {
        this.name = str;
        return this;
    }

    public LoginResponse setOauth(String str) {
        this.oauth = str;
        return this;
    }

    public LoginResponse setRegister(boolean z10) {
        this.isRegister = z10;
        return this;
    }

    public LoginResponse setState(String str) {
        this.state = str;
        return this;
    }

    public LoginResponse setUid(long j10) {
        this.uid = j10;
        return this;
    }

    public LoginResponse setViewer(String str) {
        this.viewer = str;
        return this;
    }

    public LoginResponse setZprotect(int i10) {
        this.zprotect = i10;
        return this;
    }
}
