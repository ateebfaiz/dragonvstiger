package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.uimanager.d1;
import d6.a;

@a
final class IntBufferBatchMountItem implements BatchMountItem {
    static final int INSTRUCTION_CREATE = 2;
    static final int INSTRUCTION_DELETE = 4;
    static final int INSTRUCTION_FLAG_MULTIPLE = 1;
    static final int INSTRUCTION_INSERT = 8;
    static final int INSTRUCTION_REMOVE = 16;
    static final int INSTRUCTION_REMOVE_DELETE_TREE = 2048;
    static final int INSTRUCTION_UPDATE_EVENT_EMITTER = 256;
    static final int INSTRUCTION_UPDATE_LAYOUT = 128;
    static final int INSTRUCTION_UPDATE_OVERFLOW_INSET = 1024;
    static final int INSTRUCTION_UPDATE_PADDING = 512;
    static final int INSTRUCTION_UPDATE_PROPS = 32;
    static final int INSTRUCTION_UPDATE_STATE = 64;
    static final String TAG = "IntBufferBatchMountItem";
    private final int mCommitNumber;
    private final int[] mIntBuffer;
    private final int mIntBufferLen;
    private final Object[] mObjBuffer;
    private final int mObjBufferLen;
    private final int mSurfaceId;

    IntBufferBatchMountItem(int i10, int[] iArr, Object[] objArr, int i11) {
        this.mSurfaceId = i10;
        this.mCommitNumber = i11;
        this.mIntBuffer = iArr;
        this.mObjBuffer = objArr;
        this.mIntBufferLen = iArr.length;
        this.mObjBufferLen = objArr.length;
    }

    private static String nameForInstructionString(int i10) {
        if (i10 == 2) {
            return "CREATE";
        }
        if (i10 == 4) {
            return "DELETE";
        }
        if (i10 == 8) {
            return "INSERT";
        }
        if (i10 == 16) {
            return "REMOVE";
        }
        if (i10 == 2048) {
            return "REMOVE_DELETE_TREE";
        }
        if (i10 == 32) {
            return "UPDATE_PROPS";
        }
        if (i10 == 64) {
            return "UPDATE_STATE";
        }
        if (i10 == 128) {
            return "UPDATE_LAYOUT";
        }
        if (i10 == 512) {
            return "UPDATE_PADDING";
        }
        if (i10 == 1024) {
            return "UPDATE_OVERFLOW_INSET";
        }
        if (i10 == 256) {
            return "UPDATE_EVENT_EMITTER";
        }
        return "UNKNOWN";
    }

    public void execute(MountingManager mountingManager) {
        int i10;
        int i11;
        long j10;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z10;
        int i17 = 0;
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this.mSurfaceId);
        if (surfaceManager == null) {
            z2.a.l(TAG, "Skipping batch of MountItems; no SurfaceMountingManager found for [%d].", Integer.valueOf(this.mSurfaceId));
        } else if (surfaceManager.isStopped()) {
            z2.a.l(TAG, "Skipping batch of MountItems; was stopped [%d].", Integer.valueOf(this.mSurfaceId));
        } else {
            if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                z2.a.c(TAG, "Executing IntBufferBatchMountItem on surface [%d]", Integer.valueOf(this.mSurfaceId));
            }
            int i18 = 0;
            int i19 = 0;
            while (i18 < this.mIntBufferLen) {
                int[] iArr = this.mIntBuffer;
                int i20 = i18 + 1;
                int i21 = iArr[i18];
                int i22 = i21 & -2;
                if ((i21 & 1) != 0) {
                    int i23 = iArr[i20];
                    i20 = i18 + 2;
                    i10 = i23;
                } else {
                    i10 = 1;
                }
                long j11 = 0;
                c8.a.c(0, "IntBufferBatchMountItem::mountInstructions::" + nameForInstructionString(i22));
                int i24 = i17;
                int i25 = i19;
                i18 = i20;
                while (i24 < i10) {
                    if (i22 == 2) {
                        String fabricComponentName = FabricNameComponentMapping.getFabricComponentName((String) this.mObjBuffer[i25]);
                        int[] iArr2 = this.mIntBuffer;
                        int i26 = iArr2[i18];
                        Object[] objArr = this.mObjBuffer;
                        ReadableMap readableMap = (ReadableMap) objArr[i25 + 1];
                        int i27 = i25 + 3;
                        d1 d1Var = (d1) objArr[i25 + 2];
                        i25 += 4;
                        EventEmitterWrapper eventEmitterWrapper = (EventEmitterWrapper) objArr[i27];
                        int i28 = i18 + 2;
                        if (iArr2[i18 + 1] == 1) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        i12 = i24;
                        d1 d1Var2 = d1Var;
                        j10 = j11;
                        surfaceManager.createView(fabricComponentName, i26, readableMap, d1Var2, eventEmitterWrapper, z10);
                        i11 = i10;
                        i13 = i22;
                        i18 = i28;
                    } else {
                        i12 = i24;
                        j10 = j11;
                        if (i22 == 4) {
                            surfaceManager.deleteView(this.mIntBuffer[i18]);
                            i18++;
                        } else if (i22 == 8) {
                            int[] iArr3 = this.mIntBuffer;
                            int i29 = iArr3[i18];
                            int i30 = i18 + 2;
                            i18 += 3;
                            surfaceManager.addViewAt(iArr3[i18 + 1], i29, iArr3[i30]);
                        } else if (i22 == 16) {
                            int[] iArr4 = this.mIntBuffer;
                            int i31 = i18 + 2;
                            i18 += 3;
                            surfaceManager.removeViewAt(iArr4[i18], iArr4[i18 + 1], iArr4[i31]);
                        } else if (i22 == 2048) {
                            int[] iArr5 = this.mIntBuffer;
                            int i32 = i18 + 2;
                            i18 += 3;
                            surfaceManager.removeDeleteTreeAt(iArr5[i18], iArr5[i18 + 1], iArr5[i32]);
                        } else {
                            if (i22 == 32) {
                                i15 = i18 + 1;
                                i16 = i25 + 1;
                                surfaceManager.updateProps(this.mIntBuffer[i18], (ReadableMap) this.mObjBuffer[i25]);
                            } else if (i22 == 64) {
                                i15 = i18 + 1;
                                i16 = i25 + 1;
                                surfaceManager.updateState(this.mIntBuffer[i18], (d1) this.mObjBuffer[i25]);
                            } else if (i22 == 128) {
                                int[] iArr6 = this.mIntBuffer;
                                int i33 = iArr6[i18];
                                int i34 = iArr6[i18 + 1];
                                int i35 = iArr6[i18 + 2];
                                int i36 = iArr6[i18 + 3];
                                int i37 = iArr6[i18 + 4];
                                int i38 = iArr6[i18 + 5];
                                int i39 = i18 + 7;
                                int i40 = iArr6[i18 + 6];
                                if (o6.a.d()) {
                                    i11 = i10;
                                    int i41 = i40;
                                    i13 = i22;
                                    surfaceManager.updateLayout(i33, i34, i35, i36, i37, i38, i41, this.mIntBuffer[i39]);
                                    i39 = i18 + 8;
                                } else {
                                    i11 = i10;
                                    int i42 = i40;
                                    i13 = i22;
                                    surfaceManager.updateLayout(i33, i34, i35, i36, i37, i38, i42, 0);
                                }
                                i18 = i39;
                            } else {
                                i11 = i10;
                                i13 = i22;
                                if (i13 == 512) {
                                    int[] iArr7 = this.mIntBuffer;
                                    i14 = i18 + 5;
                                    surfaceManager.updatePadding(iArr7[i18], iArr7[i18 + 1], iArr7[i18 + 2], iArr7[i18 + 3], iArr7[i18 + 4]);
                                } else if (i13 == 1024) {
                                    int[] iArr8 = this.mIntBuffer;
                                    i14 = i18 + 5;
                                    surfaceManager.updateOverflowInset(iArr8[i18], iArr8[i18 + 1], iArr8[i18 + 2], iArr8[i18 + 3], iArr8[i18 + 4]);
                                } else if (i13 == 256) {
                                    surfaceManager.updateEventEmitter(this.mIntBuffer[i18], (EventEmitterWrapper) this.mObjBuffer[i25]);
                                    i18++;
                                    i25++;
                                } else {
                                    throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i13 + " at index: " + i18);
                                }
                                i18 = i14;
                            }
                            i18 = i15;
                            i25 = i16;
                        }
                        i11 = i10;
                        i13 = i22;
                    }
                    i24 = i12 + 1;
                    i22 = i13;
                    j11 = j10;
                    i10 = i11;
                }
                c8.a.g(j11);
                i19 = i25;
                i17 = 0;
            }
        }
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    public boolean isBatchEmpty() {
        if (this.mIntBufferLen == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x033f A[LOOP:2: B:66:0x033b->B:68:0x033f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x035d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r24 = this;
            r1 = r24
            r4 = 4
            r5 = 3
            r6 = 0
            r7 = 2
            r8 = 1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0035 }
            r9.<init>()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r10 = "IntBufferBatchMountItem [surface:%d]:\n"
            int r11 = r1.mSurfaceId     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object[] r12 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0035 }
            r12[r6] = r11     // Catch:{ Exception -> 0x0035 }
            java.lang.String r10 = java.lang.String.format(r10, r12)     // Catch:{ Exception -> 0x0035 }
            r9.append(r10)     // Catch:{ Exception -> 0x0035 }
            r10 = r6
            r11 = r10
        L_0x0021:
            int r12 = r1.mIntBufferLen     // Catch:{ Exception -> 0x0035 }
            if (r10 >= r12) goto L_0x0326
            int[] r12 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r13 = r10 + 1
            r14 = r12[r10]     // Catch:{ Exception -> 0x0035 }
            r15 = r14 & -2
            r14 = r14 & r8
            if (r14 == 0) goto L_0x003a
            int r10 = r10 + r7
            r12 = r12[r13]     // Catch:{ Exception -> 0x0035 }
            r13 = r10
            goto L_0x003b
        L_0x0035:
            r0 = move-exception
            r23 = r6
            goto L_0x032d
        L_0x003a:
            r12 = r8
        L_0x003b:
            r10 = r13
            r13 = r6
        L_0x003d:
            if (r13 >= r12) goto L_0x0321
            if (r15 != r7) goto L_0x007a
            java.lang.Object[] r14 = r1.mObjBuffer     // Catch:{ Exception -> 0x0035 }
            r14 = r14[r11]     // Catch:{ Exception -> 0x0035 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ Exception -> 0x0035 }
            java.lang.String r14 = com.facebook.react.fabric.mounting.mountitems.FabricNameComponentMapping.getFabricComponentName(r14)     // Catch:{ Exception -> 0x0035 }
            int r11 = r11 + r4
            java.lang.String r0 = "CREATE [%d] - layoutable:%d - %s\n"
            int[] r2 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r18 = r10 + 1
            r2 = r2[r10]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0035 }
            int[] r3 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r10 = r10 + r7
            r3 = r3[r18]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0035 }
            r4[r6] = r2     // Catch:{ Exception -> 0x0035 }
            r4[r8] = r3     // Catch:{ Exception -> 0x0035 }
            r4[r7] = r14     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = java.lang.String.format(r0, r4)     // Catch:{ Exception -> 0x0035 }
            r9.append(r0)     // Catch:{ Exception -> 0x0035 }
        L_0x0070:
            r3 = r5
            r23 = r6
            r2 = r7
            r5 = r8
            r4 = 4
            r6 = 7
        L_0x0077:
            r8 = 5
            goto L_0x02dc
        L_0x007a:
            r0 = r4
            if (r15 != r0) goto L_0x0096
            java.lang.String r0 = "DELETE [%d]\n"
            int[] r2 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r3 = r10 + 1
            r2 = r2[r10]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object[] r4 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0035 }
            r4[r6] = r2     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = java.lang.String.format(r0, r4)     // Catch:{ Exception -> 0x0035 }
            r9.append(r0)     // Catch:{ Exception -> 0x0035 }
            r10 = r3
            goto L_0x0070
        L_0x0096:
            r0 = 8
            if (r15 != r0) goto L_0x00c9
            java.lang.String r0 = "INSERT [%d]->[%d] @%d\n"
            int[] r2 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r3 = r10 + 1
            r2 = r2[r10]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0035 }
            int[] r4 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r14 = r10 + 2
            r3 = r4[r3]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0035 }
            int[] r4 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r10 = r10 + r5
            r4 = r4[r14]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object[] r14 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0035 }
            r14[r6] = r2     // Catch:{ Exception -> 0x0035 }
            r14[r8] = r3     // Catch:{ Exception -> 0x0035 }
            r14[r7] = r4     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = java.lang.String.format(r0, r14)     // Catch:{ Exception -> 0x0035 }
            r9.append(r0)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0070
        L_0x00c9:
            r0 = 16
            if (r15 != r0) goto L_0x00fd
            java.lang.String r0 = "REMOVE [%d]->[%d] @%d\n"
            int[] r2 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r3 = r10 + 1
            r2 = r2[r10]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0035 }
            int[] r4 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r14 = r10 + 2
            r3 = r4[r3]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0035 }
            int[] r4 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r10 = r10 + r5
            r4 = r4[r14]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object[] r14 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0035 }
            r14[r6] = r2     // Catch:{ Exception -> 0x0035 }
            r14[r8] = r3     // Catch:{ Exception -> 0x0035 }
            r14[r7] = r4     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = java.lang.String.format(r0, r14)     // Catch:{ Exception -> 0x0035 }
            r9.append(r0)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0070
        L_0x00fd:
            r0 = 2048(0x800, float:2.87E-42)
            if (r15 != r0) goto L_0x0131
            java.lang.String r0 = "REMOVE+DELETE TREE [%d]->[%d] @%d\n"
            int[] r2 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r3 = r10 + 1
            r2 = r2[r10]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0035 }
            int[] r4 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r14 = r10 + 2
            r3 = r4[r3]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0035 }
            int[] r4 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r10 = r10 + r5
            r4 = r4[r14]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object[] r14 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0035 }
            r14[r6] = r2     // Catch:{ Exception -> 0x0035 }
            r14[r8] = r3     // Catch:{ Exception -> 0x0035 }
            r14[r7] = r4     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = java.lang.String.format(r0, r14)     // Catch:{ Exception -> 0x0035 }
            r9.append(r0)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0070
        L_0x0131:
            r0 = 32
            java.lang.String r2 = "<hidden>"
            if (r15 != r0) goto L_0x0161
            java.lang.Object[] r0 = r1.mObjBuffer     // Catch:{ Exception -> 0x0035 }
            int r3 = r11 + 1
            r0 = r0[r11]     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = "UPDATE PROPS [%d]: %s\n"
            int[] r4 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r11 = r10 + 1
            r4 = r4[r10]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0035 }
            r10[r6] = r4     // Catch:{ Exception -> 0x0035 }
            r10[r8] = r2     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = java.lang.String.format(r0, r10)     // Catch:{ Exception -> 0x0035 }
            r9.append(r0)     // Catch:{ Exception -> 0x0035 }
        L_0x0156:
            r23 = r6
            r2 = r7
            r10 = r11
            r4 = 4
            r6 = 7
            r11 = r3
            r3 = r5
            r5 = r8
            goto L_0x0077
        L_0x0161:
            r0 = 64
            if (r15 != r0) goto L_0x0187
            java.lang.Object[] r0 = r1.mObjBuffer     // Catch:{ Exception -> 0x0035 }
            int r3 = r11 + 1
            r0 = r0[r11]     // Catch:{ Exception -> 0x0035 }
            com.facebook.react.uimanager.d1 r0 = (com.facebook.react.uimanager.d1) r0     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = "UPDATE STATE [%d]: %s\n"
            int[] r4 = r1.mIntBuffer     // Catch:{ Exception -> 0x0035 }
            int r11 = r10 + 1
            r4 = r4[r10]     // Catch:{ Exception -> 0x0035 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0035 }
            r10[r6] = r4     // Catch:{ Exception -> 0x0035 }
            r10[r8] = r2     // Catch:{ Exception -> 0x0035 }
            java.lang.String r0 = java.lang.String.format(r0, r10)     // Catch:{ Exception -> 0x0035 }
            r9.append(r0)     // Catch:{ Exception -> 0x0035 }
            goto L_0x0156
        L_0x0187:
            r0 = 128(0x80, float:1.794E-43)
            if (r15 != r0) goto L_0x0209
            int[] r0 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            int r2 = r10 + 1
            r3 = r0[r10]     // Catch:{ Exception -> 0x0204 }
            int r4 = r10 + 2
            r0 = r0[r2]     // Catch:{ Exception -> 0x0204 }
            java.lang.String r2 = "UPDATE LAYOUT [%d]->[%d]: x:%d y:%d w:%d h:%d displayType:%d\n"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0204 }
            int[] r14 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            int r20 = r10 + 3
            r4 = r14[r4]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0204 }
            int[] r14 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r18 = 4
            int r21 = r10 + 4
            r14 = r14[r20]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0204 }
            int[] r5 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r19 = 5
            int r22 = r10 + 5
            r5 = r5[r21]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0204 }
            int[] r7 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r17 = 6
            int r23 = r10 + 6
            r7 = r7[r22]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0204 }
            int[] r8 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r6 = 7
            int r10 = r10 + r6
            r8 = r8[r23]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0204 }
            r16 = r10
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0204 }
            r23 = 0
            r10[r23] = r0     // Catch:{ Exception -> 0x0204 }
            r22 = 1
            r10[r22] = r3     // Catch:{ Exception -> 0x0204 }
            r0 = 2
            r10[r0] = r4     // Catch:{ Exception -> 0x0204 }
            r0 = 3
            r10[r0] = r14     // Catch:{ Exception -> 0x0204 }
            r0 = 4
            r10[r0] = r5     // Catch:{ Exception -> 0x0204 }
            r0 = 5
            r10[r0] = r7     // Catch:{ Exception -> 0x0204 }
            r0 = 6
            r10[r0] = r8     // Catch:{ Exception -> 0x0204 }
            java.lang.String r2 = java.lang.String.format(r2, r10)     // Catch:{ Exception -> 0x0204 }
            r9.append(r2)     // Catch:{ Exception -> 0x0204 }
            r10 = r16
        L_0x01fb:
            r2 = 2
            r3 = 3
            r4 = 4
            r5 = 1
            r8 = 5
        L_0x0200:
            r23 = 0
            goto L_0x02dc
        L_0x0204:
            r0 = move-exception
            r23 = 0
            goto L_0x032d
        L_0x0209:
            r0 = 6
            r6 = 7
            r2 = 512(0x200, float:7.175E-43)
            if (r15 != r2) goto L_0x0260
            java.lang.String r2 = "UPDATE PADDING [%d]: top:%d right:%d bottom:%d left:%d\n"
            int[] r3 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r4 = 1
            int r8 = r10 + 1
            r3 = r3[r10]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0204 }
            int[] r4 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r5 = 2
            int r7 = r10 + 2
            r4 = r4[r8]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0204 }
            int[] r5 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r8 = 3
            int r14 = r10 + 3
            r5 = r5[r7]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0204 }
            int[] r7 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r8 = 4
            int r16 = r10 + 4
            r7 = r7[r14]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0204 }
            int[] r8 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r14 = 5
            int r10 = r10 + r14
            r8 = r8[r16]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0204 }
            java.lang.Object[] r0 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x0204 }
            r14 = 0
            r0[r14] = r3     // Catch:{ Exception -> 0x0204 }
            r3 = 1
            r0[r3] = r4     // Catch:{ Exception -> 0x0204 }
            r3 = 2
            r0[r3] = r5     // Catch:{ Exception -> 0x0204 }
            r3 = 3
            r0[r3] = r7     // Catch:{ Exception -> 0x0204 }
            r3 = 4
            r0[r3] = r8     // Catch:{ Exception -> 0x0204 }
            java.lang.String r0 = java.lang.String.format(r2, r0)     // Catch:{ Exception -> 0x0204 }
            r9.append(r0)     // Catch:{ Exception -> 0x0204 }
            goto L_0x01fb
        L_0x0260:
            r0 = 1024(0x400, float:1.435E-42)
            if (r15 != r0) goto L_0x02b8
            java.lang.String r0 = "UPDATE OVERFLOWINSET [%d]: left:%d top:%d right:%d bottom:%d\n"
            int[] r2 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r3 = 1
            int r8 = r10 + 1
            r2 = r2[r10]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x0204 }
            int[] r3 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r4 = 2
            int r7 = r10 + 2
            r3 = r3[r8]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0204 }
            int[] r4 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r5 = 3
            int r8 = r10 + 3
            r4 = r4[r7]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0204 }
            int[] r5 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r7 = 4
            int r14 = r10 + 4
            r5 = r5[r8]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0204 }
            int[] r7 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            r8 = 5
            int r10 = r10 + r8
            r7 = r7[r14]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0204 }
            java.lang.Object[] r14 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x0204 }
            r16 = 0
            r14[r16] = r2     // Catch:{ Exception -> 0x0204 }
            r2 = 1
            r14[r2] = r3     // Catch:{ Exception -> 0x0204 }
            r2 = 2
            r14[r2] = r4     // Catch:{ Exception -> 0x0204 }
            r3 = 3
            r14[r3] = r5     // Catch:{ Exception -> 0x0204 }
            r4 = 4
            r14[r4] = r7     // Catch:{ Exception -> 0x0204 }
            java.lang.String r0 = java.lang.String.format(r0, r14)     // Catch:{ Exception -> 0x0204 }
            r9.append(r0)     // Catch:{ Exception -> 0x0204 }
            r5 = 1
            goto L_0x0200
        L_0x02b8:
            r2 = 2
            r3 = 3
            r4 = 4
            r8 = 5
            r0 = 256(0x100, float:3.59E-43)
            if (r15 != r0) goto L_0x02e6
            r5 = 1
            int r11 = r11 + r5
            java.lang.String r0 = "UPDATE EVENTEMITTER [%d]\n"
            int[] r7 = r1.mIntBuffer     // Catch:{ Exception -> 0x0204 }
            int r14 = r10 + 1
            r7 = r7[r10]     // Catch:{ Exception -> 0x0204 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ Exception -> 0x0204 }
            java.lang.Object[] r10 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0204 }
            r23 = 0
            r10[r23] = r7     // Catch:{ Exception -> 0x02e4 }
            java.lang.String r0 = java.lang.String.format(r0, r10)     // Catch:{ Exception -> 0x02e4 }
            r9.append(r0)     // Catch:{ Exception -> 0x02e4 }
            r10 = r14
        L_0x02dc:
            int r13 = r13 + r5
            r7 = r2
            r8 = r5
            r6 = r23
            r5 = r3
            goto L_0x003d
        L_0x02e4:
            r0 = move-exception
            goto L_0x032d
        L_0x02e6:
            r23 = 0
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x02e4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02e4 }
            r2.<init>()     // Catch:{ Exception -> 0x02e4 }
            java.lang.String r3 = "String so far: "
            r2.append(r3)     // Catch:{ Exception -> 0x02e4 }
            java.lang.String r3 = r9.toString()     // Catch:{ Exception -> 0x02e4 }
            r2.append(r3)     // Catch:{ Exception -> 0x02e4 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02e4 }
            z2.a.j(r0, r2)     // Catch:{ Exception -> 0x02e4 }
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x02e4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02e4 }
            r2.<init>()     // Catch:{ Exception -> 0x02e4 }
            java.lang.String r3 = "Invalid type argument to IntBufferBatchMountItem: "
            r2.append(r3)     // Catch:{ Exception -> 0x02e4 }
            r2.append(r15)     // Catch:{ Exception -> 0x02e4 }
            java.lang.String r3 = " at index: "
            r2.append(r3)     // Catch:{ Exception -> 0x02e4 }
            r2.append(r10)     // Catch:{ Exception -> 0x02e4 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x02e4 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x02e4 }
            throw r0     // Catch:{ Exception -> 0x02e4 }
        L_0x0321:
            r23 = r6
            r8 = 1
            goto L_0x0021
        L_0x0326:
            r23 = r6
            java.lang.String r0 = r9.toString()     // Catch:{ Exception -> 0x02e4 }
            return r0
        L_0x032d:
            java.lang.String r2 = TAG
            java.lang.String r3 = "Caught exception trying to print"
            z2.a.k(r2, r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = r23
        L_0x033b:
            int r3 = r1.mIntBufferLen
            if (r2 >= r3) goto L_0x034e
            int[] r3 = r1.mIntBuffer
            r3 = r3[r2]
            r0.append(r3)
            java.lang.String r3 = ", "
            r0.append(r3)
            r3 = 1
            int r2 = r2 + r3
            goto L_0x033b
        L_0x034e:
            java.lang.String r2 = TAG
            java.lang.String r0 = r0.toString()
            z2.a.j(r2, r0)
            r6 = r23
        L_0x0359:
            int r0 = r1.mObjBufferLen
            if (r6 >= r0) goto L_0x0372
            java.lang.String r0 = TAG
            java.lang.Object[] r2 = r1.mObjBuffer
            r2 = r2[r6]
            if (r2 == 0) goto L_0x036a
            java.lang.String r2 = r2.toString()
            goto L_0x036c
        L_0x036a:
            java.lang.String r2 = "null"
        L_0x036c:
            z2.a.j(r0, r2)
            r2 = 1
            int r6 = r6 + r2
            goto L_0x0359
        L_0x0372:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem.toString():java.lang.String");
    }
}
