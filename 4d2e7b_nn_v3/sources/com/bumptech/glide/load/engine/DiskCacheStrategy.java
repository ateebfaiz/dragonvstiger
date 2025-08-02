package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy ALL = new DiskCacheStrategy() {
        public boolean decodeCachedData() {
            return true;
        }

        public boolean decodeCachedResource() {
            return true;
        }

        public boolean isDataCacheable(DataSource dataSource) {
            if (dataSource == DataSource.REMOTE) {
                return true;
            }
            return false;
        }

        public boolean isResourceCacheable(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            if (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) {
                return false;
            }
            return true;
        }
    };
    public static final DiskCacheStrategy AUTOMATIC = new DiskCacheStrategy() {
        public boolean decodeCachedData() {
            return true;
        }

        public boolean decodeCachedResource() {
            return true;
        }

        public boolean isDataCacheable(DataSource dataSource) {
            if (dataSource == DataSource.REMOTE) {
                return true;
            }
            return false;
        }

        public boolean isResourceCacheable(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            if (((!z10 || dataSource != DataSource.DATA_DISK_CACHE) && dataSource != DataSource.LOCAL) || encodeStrategy != EncodeStrategy.TRANSFORMED) {
                return false;
            }
            return true;
        }
    };
    public static final DiskCacheStrategy DATA = new DiskCacheStrategy() {
        public boolean decodeCachedData() {
            return true;
        }

        public boolean decodeCachedResource() {
            return false;
        }

        public boolean isDataCacheable(DataSource dataSource) {
            if (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) {
                return false;
            }
            return true;
        }

        public boolean isResourceCacheable(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    };
    public static final DiskCacheStrategy NONE = new DiskCacheStrategy() {
        public boolean decodeCachedData() {
            return false;
        }

        public boolean decodeCachedResource() {
            return false;
        }

        public boolean isDataCacheable(DataSource dataSource) {
            return false;
        }

        public boolean isResourceCacheable(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    };
    public static final DiskCacheStrategy RESOURCE = new DiskCacheStrategy() {
        public boolean decodeCachedData() {
            return false;
        }

        public boolean decodeCachedResource() {
            return true;
        }

        public boolean isDataCacheable(DataSource dataSource) {
            return false;
        }

        public boolean isResourceCacheable(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            if (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) {
                return false;
            }
            return true;
        }
    };

    public abstract boolean decodeCachedData();

    public abstract boolean decodeCachedResource();

    public abstract boolean isDataCacheable(DataSource dataSource);

    public abstract boolean isResourceCacheable(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy);
}
