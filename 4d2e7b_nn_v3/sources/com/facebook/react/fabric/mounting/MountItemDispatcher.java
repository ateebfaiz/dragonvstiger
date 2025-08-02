package com.facebook.react.fabric.mounting;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.react.bridge.ReactIgnorableMountingException;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import z2.a;

public class MountItemDispatcher {
    private static final int FRAME_TIME_MS = 16;
    private static final int MAX_TIME_IN_FRAME_FOR_NON_BATCHED_OPERATIONS_MS = 8;
    private static final String TAG = "MountItemDispatcher";
    private long mBatchedExecutionTime = 0;
    private boolean mInDispatch = false;
    private final ItemDispatchListener mItemDispatchListener;
    @NonNull
    private final ConcurrentLinkedQueue<MountItem> mMountItems = new ConcurrentLinkedQueue<>();
    private final MountingManager mMountingManager;
    @NonNull
    private final ConcurrentLinkedQueue<MountItem> mPreMountItems = new ConcurrentLinkedQueue<>();
    private int mReDispatchCounter = 0;
    private long mRunStartTime = 0;
    @NonNull
    private final ConcurrentLinkedQueue<DispatchCommandMountItem> mViewCommandMountItems = new ConcurrentLinkedQueue<>();

    public interface ItemDispatchListener {
        void didDispatchMountItems();

        void didMountItems(List<MountItem> list);

        void willMountItems(List<MountItem> list);
    }

    public MountItemDispatcher(MountingManager mountingManager, ItemDispatchListener itemDispatchListener) {
        this.mMountingManager = mountingManager;
        this.mItemDispatchListener = itemDispatchListener;
    }

    @Nullable
    private static <E extends MountItem> List<E> drainConcurrentItemQueue(ConcurrentLinkedQueue<E> concurrentLinkedQueue) {
        if (concurrentLinkedQueue.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        do {
            MountItem mountItem = (MountItem) concurrentLinkedQueue.poll();
            if (mountItem != null) {
                arrayList.add(mountItem);
            }
        } while (!concurrentLinkedQueue.isEmpty());
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    private void executeOrEnqueue(MountItem mountItem) {
        if (this.mMountingManager.isWaitingForViewAttach(mountItem.getSurfaceId())) {
            if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                a.l(TAG, "executeOrEnqueue: Item execution delayed, surface %s is not ready yet", Integer.valueOf(mountItem.getSurfaceId()));
            }
            this.mMountingManager.getSurfaceManager(mountItem.getSurfaceId()).scheduleMountItemOnViewAttach(mountItem);
            return;
        }
        mountItem.execute(this.mMountingManager);
    }

    @UiThread
    private List<MountItem> getAndResetMountItems() {
        return drainConcurrentItemQueue(this.mMountItems);
    }

    private Collection<MountItem> getAndResetPreMountItems() {
        return drainConcurrentItemQueue(this.mPreMountItems);
    }

    @UiThread
    private List<DispatchCommandMountItem> getAndResetViewCommandMountItems() {
        return drainConcurrentItemQueue(this.mViewCommandMountItems);
    }

    private static boolean haveExceededNonBatchedFrameTime(long j10) {
        if (16 - ((System.nanoTime() - j10) / 1000000) < 8) {
            return true;
        }
        return false;
    }

    private static void printMountItem(MountItem mountItem, String str) {
        for (String str2 : mountItem.toString().split("\n")) {
            a.j(TAG, str + ": " + str2);
        }
    }

    public void addMountItem(MountItem mountItem) {
        this.mMountItems.add(mountItem);
    }

    public void addPreAllocateMountItem(MountItem mountItem) {
        if (!this.mMountingManager.surfaceIsStopped(mountItem.getSurfaceId())) {
            this.mPreMountItems.add(mountItem);
        }
    }

    public void addViewCommandMountItem(DispatchCommandMountItem dispatchCommandMountItem) {
        this.mViewCommandMountItems.add(dispatchCommandMountItem);
    }

    @UiThread
    public void dispatchMountItems(Queue<MountItem> queue) {
        while (!queue.isEmpty()) {
            MountItem poll = queue.poll();
            try {
                poll.execute(this.mMountingManager);
            } catch (RetryableMountingLayerException e10) {
                if (poll instanceof DispatchCommandMountItem) {
                    DispatchCommandMountItem dispatchCommandMountItem = (DispatchCommandMountItem) poll;
                    if (dispatchCommandMountItem.getRetries() == 0) {
                        dispatchCommandMountItem.incrementRetries();
                        addViewCommandMountItem(dispatchCommandMountItem);
                    }
                } else {
                    printMountItem(poll, "dispatchExternalMountItems: mounting failed with " + e10.getMessage());
                }
            }
        }
    }

    /* JADX INFO: finally extract failed */
    @UiThread
    public void dispatchPreMountItems(long j10) {
        if (!this.mPreMountItems.isEmpty()) {
            c8.a.c(0, "MountItemDispatcher::premountViews");
            this.mInDispatch = true;
            while (true) {
                try {
                    if (haveExceededNonBatchedFrameTime(j10)) {
                        break;
                    }
                    MountItem poll = this.mPreMountItems.poll();
                    if (poll == null) {
                        break;
                    }
                    if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                        printMountItem(poll, "dispatchPreMountItems");
                    }
                    executeOrEnqueue(poll);
                } catch (Throwable th) {
                    this.mInDispatch = false;
                    throw th;
                }
            }
            this.mInDispatch = false;
            c8.a.g(0);
        }
    }

    public long getBatchedExecutionTime() {
        return this.mBatchedExecutionTime;
    }

    public long getRunStartTime() {
        return this.mRunStartTime;
    }

    @UiThread
    public void tryDispatchMountItems() {
        if (!this.mInDispatch) {
            boolean z10 = true;
            if (o6.a.b()) {
                this.mInDispatch = true;
                while (z10) {
                    try {
                        z10 = dispatchMountItems();
                    } catch (Throwable th) {
                        this.mInDispatch = false;
                        throw th;
                    }
                }
                this.mInDispatch = false;
                return;
            }
            try {
                boolean dispatchMountItems = dispatchMountItems();
                this.mInDispatch = false;
                this.mItemDispatchListener.didDispatchMountItems();
                int i10 = this.mReDispatchCounter;
                if (i10 < 10 && dispatchMountItems) {
                    if (i10 > 2) {
                        ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Re-dispatched " + this.mReDispatchCounter + " times. This indicates setState (?) is likely being called too many times during mounting."));
                    }
                    this.mReDispatchCounter++;
                    tryDispatchMountItems();
                }
                this.mReDispatchCounter = 0;
            } catch (Throwable th2) {
                this.mInDispatch = false;
                throw th2;
            }
        }
    }

    @UiThread
    private boolean dispatchMountItems() {
        SurfaceMountingManager surfaceManager;
        if (this.mReDispatchCounter == 0) {
            this.mBatchedExecutionTime = 0;
        }
        this.mRunStartTime = SystemClock.uptimeMillis();
        List<DispatchCommandMountItem> andResetViewCommandMountItems = getAndResetViewCommandMountItems();
        List<MountItem> andResetMountItems = getAndResetMountItems();
        if (andResetMountItems == null && andResetViewCommandMountItems == null) {
            return false;
        }
        this.mItemDispatchListener.willMountItems(andResetMountItems);
        if (andResetViewCommandMountItems != null) {
            c8.a.c(0, "MountItemDispatcher::mountViews viewCommandMountItems");
            for (DispatchCommandMountItem next : andResetViewCommandMountItems) {
                if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                    printMountItem(next, "dispatchMountItems: Executing viewCommandMountItem");
                }
                try {
                    executeOrEnqueue(next);
                } catch (RetryableMountingLayerException e10) {
                    if (next.getRetries() == 0) {
                        next.incrementRetries();
                        addViewCommandMountItem(next);
                    } else {
                        ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Caught exception executing ViewCommand: " + next.toString(), e10));
                    }
                } catch (Throwable th) {
                    ReactSoftExceptionLogger.logSoftException(TAG, new RuntimeException("Caught exception executing ViewCommand: " + next.toString(), th));
                }
            }
            c8.a.g(0);
        }
        Collection<MountItem> andResetPreMountItems = getAndResetPreMountItems();
        if (andResetPreMountItems != null) {
            c8.a.c(0, "MountItemDispatcher::mountViews preMountItems");
            for (MountItem next2 : andResetPreMountItems) {
                if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                    printMountItem(next2, "dispatchMountItems: Executing preMountItem");
                }
                executeOrEnqueue(next2);
            }
            c8.a.g(0);
        }
        if (andResetMountItems != null) {
            c8.a.c(0, "MountItemDispatcher::mountViews mountItems to execute");
            long uptimeMillis = SystemClock.uptimeMillis();
            for (MountItem next3 : andResetMountItems) {
                if (FabricUIManager.ENABLE_FABRIC_LOGS) {
                    printMountItem(next3, "dispatchMountItems: Executing mountItem");
                }
                try {
                    executeOrEnqueue(next3);
                } catch (Throwable th2) {
                    a.k(TAG, "dispatchMountItems: caught exception, displaying mount state", th2);
                    for (MountItem next4 : andResetMountItems) {
                        if (next4 == next3) {
                            a.j(TAG, "dispatchMountItems: mountItem: next mountItem triggered exception!");
                        }
                        printMountItem(next4, "dispatchMountItems: mountItem");
                    }
                    if (!(next3.getSurfaceId() == -1 || (surfaceManager = this.mMountingManager.getSurfaceManager(next3.getSurfaceId())) == null)) {
                        surfaceManager.printSurfaceState();
                    }
                    if (ReactIgnorableMountingException.isIgnorable(th2)) {
                        ReactSoftExceptionLogger.logSoftException(TAG, th2);
                    } else {
                        throw th2;
                    }
                }
            }
            this.mBatchedExecutionTime += SystemClock.uptimeMillis() - uptimeMillis;
            c8.a.g(0);
        }
        this.mItemDispatchListener.didMountItems(andResetMountItems);
        return true;
    }
}
