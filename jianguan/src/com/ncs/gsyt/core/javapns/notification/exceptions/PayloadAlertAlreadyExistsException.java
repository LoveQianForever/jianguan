package com.ncs.gsyt.core.javapns.notification.exceptions;

import com.ncs.gsyt.core.org.json.*;

/**
 * Thrown when a payload exceeds the maximum size allowed.
 * @author Sylvain Pedneault
 *
 */
@SuppressWarnings("serial")
public class PayloadAlertAlreadyExistsException extends JSONException {

	/**
	 * Default constructor
	 */
	public PayloadAlertAlreadyExistsException() {
		super("Payload alert already exists");
	}


	/**
	 * Constructor with custom message
	 * @param message
	 */
	public PayloadAlertAlreadyExistsException(String message) {
		super(message);
	}

}
