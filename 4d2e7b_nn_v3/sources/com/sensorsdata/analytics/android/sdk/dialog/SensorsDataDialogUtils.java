package com.sensorsdata.analytics.android.sdk.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.sensorsdata.analytics.android.sdk.R;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.tasks.ThreadNameConstants;
import com.sensorsdata.analytics.android.sdk.dialog.DebugModeSelectDialog;
import com.sensorsdata.analytics.android.sdk.util.ReflectUtil;
import com.sensorsdata.analytics.android.sdk.util.SADisplayUtil;
import com.sensorsdata.analytics.android.sdk.util.ToastUtil;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;

public class SensorsDataDialogUtils {
    private static final String TAG = "SA.SensorsDataDialogUtils";
    /* access modifiers changed from: private */
    public static boolean isShowHttpErrorDialog = true;
    /* access modifiers changed from: private */
    public static Dialog sDialog;

    private static class SendDebugIdThread extends Thread {
        private String distinctId;
        private String infoId;
        private String serverUrl;

        SendDebugIdThread(String str, String str2, String str3, String str4) {
            super(str4);
            this.distinctId = str2;
            this.infoId = str3;
            this.serverUrl = str;
        }

        private void closeStream(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream, BufferedOutputStream bufferedOutputStream, HttpURLConnection httpURLConnection) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e11) {
                    SALog.printStackTrace(e11);
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e12) {
                    SALog.printStackTrace(e12);
                }
            }
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e13) {
                    SALog.printStackTrace(e13);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v27, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v29, resolved type: java.io.BufferedOutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: java.io.BufferedOutputStream} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void sendHttpRequest(java.lang.String r14, boolean r15) {
            /*
                r13 = this;
                r0 = 0
                r1 = 1
                java.lang.String r2 = "SA.SensorsDataDialogUtils"
                r3 = 0
                java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                r5.<init>()     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                r5.append(r14)     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                java.lang.String r6 = "&info_id=%s"
                r5.append(r6)     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                java.lang.String r6 = r13.infoId     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                r7[r0] = r6     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                java.lang.String r5 = java.lang.String.format(r5, r7)     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                r4.<init>(r5)     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                java.lang.String r5 = "DebugMode URL:%s"
                java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                r6[r0] = r4     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                com.sensorsdata.analytics.android.sdk.SALog.info(r2, r5, r3)     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                java.net.URLConnection r5 = r4.openConnection()     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0126, all -> 0x0121 }
                if (r5 != 0) goto L_0x0059
                java.lang.String r14 = "can not connect %s,shouldn't happen"
                java.lang.String r15 = r4.toString()     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                r1[r0] = r15     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                java.lang.String r14 = java.lang.String.format(r14, r1)     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                com.sensorsdata.analytics.android.sdk.SALog.info(r2, r14, r3)     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                r13.closeStream(r3, r3, r3, r5)
                return
            L_0x004f:
                r14 = move-exception
                r6 = r3
            L_0x0051:
                r7 = r6
                goto L_0x0133
            L_0x0054:
                r14 = move-exception
                r6 = r3
            L_0x0056:
                r7 = r6
                goto L_0x012b
            L_0x0059:
                com.sensorsdata.analytics.android.sdk.SAConfigOptions r4 = com.sensorsdata.analytics.android.sdk.AbstractSensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                if (r4 == 0) goto L_0x0073
                javax.net.ssl.SSLSocketFactory r6 = r4.getSSLSocketFactory()     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                if (r6 == 0) goto L_0x0073
                boolean r6 = r5 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                if (r6 == 0) goto L_0x0073
                r6 = r5
                javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                javax.net.ssl.SSLSocketFactory r4 = r4.getSSLSocketFactory()     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                r6.setSSLSocketFactory(r4)     // Catch:{ Exception -> 0x0054, all -> 0x004f }
            L_0x0073:
                r5.setInstanceFollowRedirects(r0)     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                r4.<init>()     // Catch:{ Exception -> 0x0054, all -> 0x004f }
                java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                r6.<init>(r4)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                r7.<init>()     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.lang.String r8 = "{\"distinct_id\": \""
                r7.append(r8)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.lang.String r8 = r13.distinctId     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                r7.append(r8)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.lang.String r8 = "\"}"
                r7.append(r8)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                r6.write(r7)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                r6.flush()     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.lang.String r6 = "DebugMode request body : %s"
                java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                r8[r0] = r7     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.lang.String r6 = java.lang.String.format(r6, r8)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                com.sensorsdata.analytics.android.sdk.SALog.info(r2, r6, r3)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                r5.setDoOutput(r1)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                r5.setUseCaches(r0)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.lang.String r6 = "POST"
                r5.setRequestMethod(r6)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.lang.String r6 = "Content-type"
                java.lang.String r7 = "text/plain"
                r5.setRequestProperty(r6, r7)     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.io.OutputStream r6 = r5.getOutputStream()     // Catch:{ Exception -> 0x011d, all -> 0x0119 }
                java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0116, all -> 0x0113 }
                r7.<init>(r6)     // Catch:{ Exception -> 0x0116, all -> 0x0113 }
                java.lang.String r8 = r4.toString()     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                java.lang.String r9 = "UTF-8"
                byte[] r8 = r8.getBytes(r9)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                r7.write(r8)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                r7.flush()     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                r4.close()     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                int r8 = r5.getResponseCode()     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                java.util.Locale r9 = com.sensorsdata.analytics.android.sdk.util.TimeUtils.SDK_LOCALE     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                java.lang.String r10 = "DebugMode ResponseCode: %d"
                java.lang.Integer r11 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                r12[r0] = r11     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                java.lang.String r0 = java.lang.String.format(r9, r10, r12)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                com.sensorsdata.analytics.android.sdk.SALog.info(r2, r0, r3)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                if (r15 != 0) goto L_0x010f
                boolean r15 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.needRedirects(r8)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                if (r15 == 0) goto L_0x010f
                java.lang.String r14 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getLocation(r5, r14)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                boolean r15 = android.text.TextUtils.isEmpty(r14)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                if (r15 != 0) goto L_0x010f
                r13.closeStream(r4, r6, r7, r5)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                r13.sendHttpRequest(r14, r1)     // Catch:{ Exception -> 0x010c, all -> 0x0109 }
                goto L_0x010f
            L_0x0109:
                r14 = move-exception
            L_0x010a:
                r3 = r4
                goto L_0x0133
            L_0x010c:
                r14 = move-exception
            L_0x010d:
                r3 = r4
                goto L_0x012b
            L_0x010f:
                r13.closeStream(r4, r6, r7, r5)
                goto L_0x0131
            L_0x0113:
                r14 = move-exception
                r7 = r3
                goto L_0x010a
            L_0x0116:
                r14 = move-exception
                r7 = r3
                goto L_0x010d
            L_0x0119:
                r14 = move-exception
                r6 = r3
                r7 = r6
                goto L_0x010a
            L_0x011d:
                r14 = move-exception
                r6 = r3
                r7 = r6
                goto L_0x010d
            L_0x0121:
                r14 = move-exception
                r5 = r3
                r6 = r5
                goto L_0x0051
            L_0x0126:
                r14 = move-exception
                r5 = r3
                r6 = r5
                goto L_0x0056
            L_0x012b:
                com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r14)     // Catch:{ all -> 0x0132 }
                r13.closeStream(r3, r6, r7, r5)
            L_0x0131:
                return
            L_0x0132:
                r14 = move-exception
            L_0x0133:
                r13.closeStream(r3, r6, r7, r5)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.SendDebugIdThread.sendHttpRequest(java.lang.String, boolean):void");
        }

        public void run() {
            super.run();
            sendHttpRequest(this.serverUrl, false);
        }
    }

    public static void dialogShowDismissOld(Dialog dialog) {
        try {
            Dialog dialog2 = sDialog;
            if (dialog2 != null && dialog2.isShowing()) {
                try {
                    sDialog.dismiss();
                    SALog.i(TAG, "Dialog dismiss");
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
            sDialog = dialog;
            if (dialog != null) {
                dialog.show();
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        Dialog unused = SensorsDataDialogUtils.sDialog = null;
                    }
                });
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static StateListDrawable getDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#dddddd"));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(-1);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842908}, gradientDrawable);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        return stateListDrawable;
    }

    public static boolean isSchemeActivity(Context context) {
        if (context == null) {
            return false;
        }
        String name = context.getClass().getName();
        if (!TextUtils.isEmpty(name) && name.endsWith(SchemeActivity.class.getSimpleName())) {
            Object findFieldRecur = ReflectUtil.findFieldRecur(context, "SCHEME_ACTIVITY_SIGN");
            if (findFieldRecur instanceof String) {
                return TextUtils.equals((String) findFieldRecur, SchemeActivity.SCHEME_ACTIVITY_SIGN);
            }
        }
        return false;
    }

    public static void showDebugModeSelectDialog(final Activity activity, final String str, final String str2, final String str3) {
        try {
            DebugModeSelectDialog debugModeSelectDialog = new DebugModeSelectDialog(activity, SensorsDataAPI.sharedInstance().getDebugMode());
            debugModeSelectDialog.setCanceledOnTouchOutside(false);
            debugModeSelectDialog.setOnDebugModeDialogClickListener(new DebugModeSelectDialog.OnDebugModeViewClickListener() {
                public void onCancel(Dialog dialog) {
                    dialog.cancel();
                }

                public void setDebugMode(Dialog dialog, SensorsDataAPI.DebugMode debugMode) {
                    SensorsDataAPI.sharedInstance().setDebugMode(debugMode);
                    dialog.cancel();
                }
            });
            debugModeSelectDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    String str;
                    String serverUrl = SensorsDataAPI.sharedInstance().getServerUrl();
                    SensorsDataAPI.DebugMode debugMode = SensorsDataAPI.sharedInstance().getDebugMode();
                    if (SensorsDataAPI.sharedInstance().isNetworkRequestEnable() && !TextUtils.isEmpty(serverUrl) && !TextUtils.isEmpty(str) && debugMode != SensorsDataAPI.DebugMode.DEBUG_OFF) {
                        if (TextUtils.isEmpty(str2)) {
                            new SendDebugIdThread(serverUrl, SensorsDataAPI.sharedInstance().getDistinctId(), str, ThreadNameConstants.THREAD_SEND_DISTINCT_ID).start();
                        } else {
                            try {
                                if (!TextUtils.isEmpty(str3)) {
                                    String str2 = str2 + "?project=" + str3;
                                    SALog.i(SensorsDataDialogUtils.TAG, "sf url:" + str2);
                                    new SendDebugIdThread(str2, SensorsDataAPI.sharedInstance().getDistinctId(), str, ThreadNameConstants.THREAD_SEND_DISTINCT_ID).start();
                                }
                            } catch (Exception e10) {
                                SALog.printStackTrace(e10);
                            }
                        }
                    }
                    if (debugMode == SensorsDataAPI.DebugMode.DEBUG_OFF) {
                        str = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_debug_tip_off);
                    } else if (debugMode == SensorsDataAPI.DebugMode.DEBUG_ONLY) {
                        str = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_debug_tip_only);
                    } else if (debugMode == SensorsDataAPI.DebugMode.DEBUG_AND_TRACK) {
                        str = SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_debug_tip_track);
                    } else {
                        str = "";
                    }
                    ToastUtil.showLong(activity, str);
                    SALog.info(SensorsDataDialogUtils.TAG, "The App current DebugMode is ：" + debugMode, (Throwable) null);
                    SensorsDataDialogUtils.startLaunchActivity(activity);
                }
            });
            dialogShowDismissOld(debugModeSelectDialog);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void showDialog(Activity activity, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener, String str4, DialogInterface.OnClickListener onClickListener2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        builder.setCancelable(false);
        builder.setNegativeButton(str4, onClickListener2);
        builder.setPositiveButton(str3, onClickListener);
        AlertDialog create = builder.create();
        dialogShowDismissOld(create);
        create.getButton(-2).setAllCaps(false);
        create.getButton(-1).setAllCaps(false);
    }

    public static void showHttpErrorDialog(Activity activity, String str) {
        try {
            if (!TextUtils.isEmpty(str) && isShowHttpErrorDialog) {
                if (activity != null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setTitle(SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_common_title));
                    builder.setMessage(str);
                    builder.setCancelable(false);
                    builder.setNegativeButton(SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_common_ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i10) {
                        }
                    });
                    builder.setPositiveButton(SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_common_no), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i10) {
                            boolean unused = SensorsDataDialogUtils.isShowHttpErrorDialog = false;
                        }
                    });
                    AlertDialog create = builder.create();
                    dialogShowDismissOld(create);
                    try {
                        create.getButton(-2).setTextColor(ViewCompat.MEASURED_STATE_MASK);
                        create.getButton(-2).setBackgroundColor(-1);
                        create.getButton(-2).setAllCaps(false);
                        create.getButton(-1).setTextColor(SupportMenu.CATEGORY_MASK);
                        create.getButton(-1).setBackgroundColor(-1);
                        create.getButton(-1).setAllCaps(false);
                        create.getButton(-2).setBackground(getDrawable());
                        create.getButton(-1).setBackground(getDrawable());
                    } catch (Exception e10) {
                        SALog.printStackTrace(e10);
                    }
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public static void showPopupWindowDialog(final Activity activity, Uri uri) {
        boolean z10;
        AnonymousClass1 r52;
        try {
            Class<?> cls = Class.forName("com.sensorsdata.sf.ui.utils.PreviewUtil");
            String queryParameter = uri.getQueryParameter("sf_popup_test");
            String queryParameter2 = uri.getQueryParameter("popup_window_id");
            if (!TextUtils.isEmpty(queryParameter)) {
                z10 = Boolean.parseBoolean(queryParameter);
            } else {
                z10 = false;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            int length = declaredMethods.length;
            int i10 = 0;
            Method method = null;
            while (true) {
                if (i10 >= length) {
                    r52 = null;
                    break;
                }
                Method method2 = declaredMethods[i10];
                if (method2.getName().equals("showPreview")) {
                    if (method2.getParameterTypes().length == 4) {
                        r52 = new Runnable() {
                            public void run() {
                                Activity activity = activity;
                                if (activity != null) {
                                    activity.runOnUiThread(new Runnable() {
                                        public void run() {
                                            Activity activity = activity;
                                            SensorsDataDialogUtils.showDialog(activity, SADisplayUtil.getStringResource(activity, R.string.sensors_analytics_popwindow_fail));
                                        }
                                    });
                                }
                            }
                        };
                        method = method2;
                        break;
                    }
                    method = method2;
                }
                i10++;
            }
            if (method != null) {
                if (r52 != null) {
                    method.invoke((Object) null, new Object[]{activity, Boolean.valueOf(z10), queryParameter2, r52});
                } else {
                    method.invoke((Object) null, new Object[]{activity, Boolean.valueOf(z10), queryParameter2});
                }
                SchemeActivity.isPopWindow = true;
                return;
            }
            startLaunchActivity(activity);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            startLaunchActivity(activity);
        }
    }

    public static void startLaunchActivity(Context context) {
        try {
            if (isSchemeActivity(context)) {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()));
                ((SchemeActivity) context).finish();
                SALog.i(TAG, "startLaunchActivity");
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static void showDialog(final Context context, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(SADisplayUtil.getStringResource(context, R.string.sensors_analytics_common_title)).setMessage(str).setCancelable(false).setPositiveButton(SADisplayUtil.getStringResource(context, R.string.sensors_analytics_common_ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i10) {
                SensorsDataDialogUtils.startLaunchActivity(context);
            }
        });
        AlertDialog create = builder.create();
        dialogShowDismissOld(create);
        try {
            create.getButton(-1).setTextColor(SupportMenu.CATEGORY_MASK);
            create.getButton(-1).setBackgroundColor(-1);
            create.getButton(-1).setAllCaps(false);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
