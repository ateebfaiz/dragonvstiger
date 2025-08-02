package com.facebook.react.fabric;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevToolsReactPerfLogger implements ReactMarker.FabricMarkerListener {
    public static final LongStreamingStats mStreamingBatchExecutionStats = new LongStreamingStats();
    public static final LongStreamingStats mStreamingCommitStats = new LongStreamingStats();
    public static final LongStreamingStats mStreamingDiffStats = new LongStreamingStats();
    public static final LongStreamingStats mStreamingLayoutStats = new LongStreamingStats();
    public static final LongStreamingStats mStreamingTransactionEndStats = new LongStreamingStats();
    private final List<DevToolsReactPerfLoggerListener> mDevToolsReactPerfLoggerListeners = new ArrayList();
    private final Map<Integer, FabricCommitPoint> mFabricCommitMarkers = new HashMap();

    public interface DevToolsReactPerfLoggerListener {
        void onFabricCommitEnd(FabricCommitPoint fabricCommitPoint);
    }

    public static class FabricCommitPoint {
        private final long mCommitNumber;
        private final Map<ReactMarkerConstants, FabricCommitPointData> mPoints;

        /* access modifiers changed from: private */
        public void addPoint(ReactMarkerConstants reactMarkerConstants, FabricCommitPointData fabricCommitPointData) {
            this.mPoints.put(reactMarkerConstants, fabricCommitPointData);
        }

        private int getCounter(ReactMarkerConstants reactMarkerConstants) {
            FabricCommitPointData fabricCommitPointData = this.mPoints.get(reactMarkerConstants);
            if (fabricCommitPointData != null) {
                return fabricCommitPointData.getCounter();
            }
            return 0;
        }

        private long getTimestamp(ReactMarkerConstants reactMarkerConstants) {
            FabricCommitPointData fabricCommitPointData = this.mPoints.get(reactMarkerConstants);
            if (fabricCommitPointData != null) {
                return fabricCommitPointData.getTimeStamp();
            }
            return -1;
        }

        public int getAffectedLayoutNodesCount() {
            return getCounter(ReactMarkerConstants.FABRIC_LAYOUT_AFFECTED_NODES);
        }

        public long getAffectedLayoutNodesCountTime() {
            return getTimestamp(ReactMarkerConstants.FABRIC_LAYOUT_AFFECTED_NODES);
        }

        public long getBatchExecutionDuration() {
            return getBatchExecutionEnd() - getBatchExecutionStart();
        }

        public long getBatchExecutionEnd() {
            return getTimestamp(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END);
        }

        public long getBatchExecutionStart() {
            return getTimestamp(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START);
        }

        public long getCommitDuration() {
            return getCommitEnd() - getCommitStart();
        }

        public long getCommitEnd() {
            return getTimestamp(ReactMarkerConstants.FABRIC_COMMIT_END);
        }

        public long getCommitNumber() {
            return this.mCommitNumber;
        }

        public long getCommitStart() {
            return getTimestamp(ReactMarkerConstants.FABRIC_COMMIT_START);
        }

        public long getDiffDuration() {
            return getDiffEnd() - getDiffStart();
        }

        public long getDiffEnd() {
            return getTimestamp(ReactMarkerConstants.FABRIC_DIFF_END);
        }

        public long getDiffStart() {
            return getTimestamp(ReactMarkerConstants.FABRIC_DIFF_START);
        }

        public long getFinishTransactionEnd() {
            return getTimestamp(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END);
        }

        public long getFinishTransactionStart() {
            return getTimestamp(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START);
        }

        public long getLayoutDuration() {
            return getLayoutEnd() - getLayoutStart();
        }

        public long getLayoutEnd() {
            return getTimestamp(ReactMarkerConstants.FABRIC_LAYOUT_END);
        }

        public long getLayoutStart() {
            return getTimestamp(ReactMarkerConstants.FABRIC_LAYOUT_START);
        }

        public long getTransactionEndDuration() {
            return getFinishTransactionEnd() - getFinishTransactionStart();
        }

        public long getUpdateUIMainThreadEnd() {
            return getTimestamp(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END);
        }

        public long getUpdateUIMainThreadStart() {
            return getTimestamp(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START);
        }

        public String toString() {
            return "FabricCommitPoint{" + "mCommitNumber=" + this.mCommitNumber + ", mPoints=" + this.mPoints + '}';
        }

        private FabricCommitPoint(int i10) {
            this.mPoints = new HashMap();
            this.mCommitNumber = (long) i10;
        }
    }

    public static class FabricCommitPointData {
        private final int mCounter;
        private final long mTimeStamp;

        public FabricCommitPointData(long j10, int i10) {
            this.mTimeStamp = j10;
            this.mCounter = i10;
        }

        public int getCounter() {
            return this.mCounter;
        }

        public long getTimeStamp() {
            return this.mTimeStamp;
        }
    }

    private static boolean isFabricCommitMarker(ReactMarkerConstants reactMarkerConstants) {
        if (reactMarkerConstants == ReactMarkerConstants.FABRIC_COMMIT_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_COMMIT_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_DIFF_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_DIFF_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_LAYOUT_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_LAYOUT_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START || reactMarkerConstants == ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END || reactMarkerConstants == ReactMarkerConstants.FABRIC_LAYOUT_AFFECTED_NODES) {
            return true;
        }
        return false;
    }

    private void onFabricCommitEnd(FabricCommitPoint fabricCommitPoint) {
        for (DevToolsReactPerfLoggerListener onFabricCommitEnd : this.mDevToolsReactPerfLoggerListeners) {
            onFabricCommitEnd.onFabricCommitEnd(fabricCommitPoint);
        }
    }

    public void addDevToolsReactPerfLoggerListener(DevToolsReactPerfLoggerListener devToolsReactPerfLoggerListener) {
        this.mDevToolsReactPerfLoggerListeners.add(devToolsReactPerfLoggerListener);
    }

    public void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i10, long j10) {
        logFabricMarker(reactMarkerConstants, str, i10, j10, 0);
    }

    public void removeDevToolsReactPerfLoggerListener(DevToolsReactPerfLoggerListener devToolsReactPerfLoggerListener) {
        this.mDevToolsReactPerfLoggerListeners.remove(devToolsReactPerfLoggerListener);
    }

    public void logFabricMarker(ReactMarkerConstants reactMarkerConstants, @Nullable String str, int i10, long j10, int i11) {
        if (isFabricCommitMarker(reactMarkerConstants)) {
            FabricCommitPoint fabricCommitPoint = this.mFabricCommitMarkers.get(Integer.valueOf(i10));
            if (fabricCommitPoint == null) {
                fabricCommitPoint = new FabricCommitPoint(i10);
                this.mFabricCommitMarkers.put(Integer.valueOf(i10), fabricCommitPoint);
            }
            fabricCommitPoint.addPoint(reactMarkerConstants, new FabricCommitPointData(j10, i11));
            if (reactMarkerConstants == ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END && j10 > 0) {
                onFabricCommitEnd(fabricCommitPoint);
                this.mFabricCommitMarkers.remove(Integer.valueOf(i10));
            }
        }
    }
}
