
package com.intuit.demo.model.login;
/**
 * Class to represent the returned data object after performing login api 
 */
public class LoginResultObject {

    public static final String LOGIN_SUCCESS = "login.success";
    public static final String BAD_CREDENTIALS = "login.fail";

    private String message;
    private long authId;

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

    public LoginResultObject(String message) {
        this.message = message;
    }

    public LoginResultObject() {
    }

	public long getAuthId() {
		return authId;
	}

	public void setAuthId(long authId) {
		this.authId = authId;
	}

}
