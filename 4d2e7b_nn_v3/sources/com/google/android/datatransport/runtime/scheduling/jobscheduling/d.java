package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JobInfoSchedulerService f6510a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JobParameters f6511b;

    public /* synthetic */ d(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f6510a = jobInfoSchedulerService;
        this.f6511b = jobParameters;
    }

    public final void run() {
        this.f6510a.lambda$onStartJob$0(this.f6511b);
    }
}
