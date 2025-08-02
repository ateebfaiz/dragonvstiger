package org.cocos2dx.javascript;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import com.alibaba.pdns.f;
import com.cocos.lib.CocosHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CopySubGameAsyncTask extends AsyncTask<String, Float, Integer> {
    private static final int CORRECT = 0;
    private static final int ERROR = 1;
    private static String TAG = "CopySubGameAsyncTask";
    private Activity mActivity;
    private CopyListener mCopyListener;

    public interface CopyListener {
        void onCopyComplete();

        void onCopyError(String str);

        void onCopying(float f10);
    }

    /* access modifiers changed from: package-private */
    public void log(String str) {
        Log.d(TAG, str);
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void setListener(CopyListener copyListener) {
        this.mCopyListener = copyListener;
    }

    /* access modifiers changed from: package-private */
    public void unzipFile(String str) throws Exception {
        String substring = str.substring(0, str.lastIndexOf(File.separator));
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    String substring2 = name.substring(0, name.length() - 1);
                    new File(substring + File.separator + substring2).mkdirs();
                } else {
                    File file = new File(substring + File.separator + name);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            } else {
                zipInputStream.close();
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Integer doInBackground(String... strArr) {
        try {
            String str = strArr[0];
            String substring = str.substring(0, str.lastIndexOf(f.G));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CocosHelper.getWritablePath());
            String str2 = File.separator;
            sb2.append(str2);
            sb2.append("update");
            sb2.append(str2);
            sb2.append(substring);
            String sb3 = sb2.toString();
            File file = new File(sb3);
            if (file.exists()) {
                if (substring == "icons") {
                    log(sb3 + " exist already, skip!");
                    return 0;
                }
                if (new File(sb3 + str2 + "import").exists()) {
                    log(sb3 + " exist already, skip!");
                    return 0;
                }
            }
            file.mkdirs();
            String str3 = sb3 + str2 + str;
            log("new file: " + str3);
            File file2 = new File(str3);
            if (!file2.exists() || file2.length() == 0) {
                InputStream open = this.mActivity.getAssets().open("subGames" + str2 + str);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                unzipFile(str3);
                file2.delete();
            }
            return 0;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 1;
        } finally {
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        if (this.mCopyListener != null) {
            int intValue = num.intValue();
            if (intValue == 0) {
                this.mCopyListener.onCopyComplete();
            } else if (intValue == 1) {
                this.mCopyListener.onCopyError("copy fail");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Float... fArr) {
        super.onProgressUpdate(fArr);
        CopyListener copyListener = this.mCopyListener;
        if (copyListener != null) {
            copyListener.onCopying(fArr[0].floatValue());
        }
    }
}
