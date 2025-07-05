package com.github.instagram4j.instagram4j.requests.media;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.instagram4j.instagram4j.IGClient;
import com.github.instagram4j.instagram4j.IGConstants;
import com.github.instagram4j.instagram4j.models.IGPayload;
import com.github.instagram4j.instagram4j.requests.IGPostRequest;
import com.github.instagram4j.instagram4j.responses.media.MediaCommentResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class MediaCommentRequest extends IGPostRequest<MediaCommentResponse> {
    @NonNull
    private String id, _comment_text;
    private String _replied_to_comment_id;

    @Override
    protected IGPayload getPayload(IGClient client) {
        return new MediaCommentPayload();
    }

    @Override
    public String baseApiUrl() {
        return IGConstants.BASE_GRAPH_URL;
    }

    @Override
    public String apiPath() {
        return "";
    }

    @Override
    protected boolean isSigned() {
        return false;
    }

    @Override
    public String path() {
        return id + "/comments";
    }

    @Override
    public String getQueryString(IGClient client) {
        return mapQueryString("message", _comment_text);
    }

    @Override
    public Class<MediaCommentResponse> getResponseType() {
        return MediaCommentResponse.class;
    }

    @Data
    @JsonInclude(Include.NON_NULL)
    private class MediaCommentPayload extends IGPayload {
        private String message = _comment_text;
        private String replied_to_comment_id = _replied_to_comment_id;
    }

}
