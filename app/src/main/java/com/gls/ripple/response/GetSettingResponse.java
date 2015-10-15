package com.gls.ripple.response;

/**
 * Created by Santosh on 06-Oct-15.
 */
public class GetSettingResponse {
   boolean success;
   String error_type;
   String message;
   String error;
   AccountSetting settings;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_type() {
        return error_type;
    }

    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public AccountSetting getSettings() {
        return settings;
    }

    public void setSettings(AccountSetting settings) {
        this.settings = settings;
    }
}
