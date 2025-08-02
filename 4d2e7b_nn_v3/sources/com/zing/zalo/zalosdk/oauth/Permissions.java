package com.zing.zalo.zalosdk.oauth;

public enum Permissions {
    ZOP_GetProfile("ZOP_GetProfile"),
    ZOP_GetFriendsList("ZOP_GetFriendsList"),
    ZOP_PushFeed("ZOP_PushFeed"),
    ZOP_SendMessage("ZOP_SendMessage");
    
    private final String text;

    private Permissions(String str) {
        this.text = str;
    }

    public String toString() {
        return this.text;
    }
}
