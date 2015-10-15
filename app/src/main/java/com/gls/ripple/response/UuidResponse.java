package com.gls.ripple.response;

/**
 * Created by Santosh on 09-Oct-15.
 */
public class UuidResponse {
    String uuid;
    boolean success;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
