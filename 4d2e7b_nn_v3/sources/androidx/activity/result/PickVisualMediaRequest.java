package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.jvm.internal.m;

public final class PickVisualMediaRequest {
    private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;

    public static final class Builder {
        private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;

        public final PickVisualMediaRequest build() {
            PickVisualMediaRequest pickVisualMediaRequest = new PickVisualMediaRequest();
            pickVisualMediaRequest.setMediaType$activity_release(this.mediaType);
            return pickVisualMediaRequest;
        }

        public final Builder setMediaType(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
            m.f(visualMediaType, "mediaType");
            this.mediaType = visualMediaType;
            return this;
        }
    }

    public final ActivityResultContracts.PickVisualMedia.VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final void setMediaType$activity_release(ActivityResultContracts.PickVisualMedia.VisualMediaType visualMediaType) {
        m.f(visualMediaType, "<set-?>");
        this.mediaType = visualMediaType;
    }
}
