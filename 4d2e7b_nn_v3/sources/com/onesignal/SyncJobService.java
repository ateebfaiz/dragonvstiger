package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import androidx.annotation.RequiresApi;
import com.onesignal.b3;
import com.onesignal.o3;

@RequiresApi(api = 21)
public class SyncJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        b3.q().b(this, new b3.b(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        boolean l10 = b3.q().l();
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "SyncJobService onStopJob called, system conditions not available reschedule: " + l10);
        return l10;
    }
}
