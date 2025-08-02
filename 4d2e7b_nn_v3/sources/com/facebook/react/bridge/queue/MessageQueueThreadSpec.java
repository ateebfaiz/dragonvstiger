package com.facebook.react.bridge.queue;

public class MessageQueueThreadSpec {
    public static final long DEFAULT_STACK_SIZE_BYTES = 0;
    private static final MessageQueueThreadSpec MAIN_UI_SPEC = new MessageQueueThreadSpec(ThreadType.MAIN_UI, "main_ui");
    private final String mName;
    private final long mStackSize;
    private final ThreadType mThreadType;

    protected enum ThreadType {
        MAIN_UI,
        NEW_BACKGROUND
    }

    private MessageQueueThreadSpec(ThreadType threadType, String str) {
        this(threadType, str, 0);
    }

    public static MessageQueueThreadSpec mainThreadSpec() {
        return MAIN_UI_SPEC;
    }

    public static MessageQueueThreadSpec newBackgroundThreadSpec(String str) {
        return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, str);
    }

    public static MessageQueueThreadSpec newUIBackgroundTreadSpec(String str) {
        return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, str);
    }

    public String getName() {
        return this.mName;
    }

    public long getStackSize() {
        return this.mStackSize;
    }

    public ThreadType getThreadType() {
        return this.mThreadType;
    }

    private MessageQueueThreadSpec(ThreadType threadType, String str, long j10) {
        this.mThreadType = threadType;
        this.mName = str;
        this.mStackSize = j10;
    }

    public static MessageQueueThreadSpec newBackgroundThreadSpec(String str, long j10) {
        return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, str, j10);
    }
}
