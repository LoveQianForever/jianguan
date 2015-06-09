package com.ncs.gsyt.core.javapns.feedback;

import java.security.*;

import com.ncs.gsyt.core.javapns.communication.*;
import com.ncs.gsyt.core.javapns.communication.exceptions.*;
import com.ncs.gsyt.core.javapns.notification.*;

/**
 * Class representing a connection to a specific Feedback Server.
 * 
 * @author Sylvain Pedneault
 */
public class ConnectionToFeedbackServer extends ConnectionToAppleServer {

	public ConnectionToFeedbackServer(AppleFeedbackServer feedbackServer) throws KeystoreException {
		super(feedbackServer);
	}


	public ConnectionToFeedbackServer(AppleNotificationServer server, KeyStore keystore) throws KeystoreException {
		super(server, keystore);
	}


	@Override
	public String getServerHost() {
		return ((AppleFeedbackServer) getServer()).getFeedbackServerHost();
	}


	@Override
	public int getServerPort() {
		return ((AppleFeedbackServer) getServer()).getFeedbackServerPort();
	}

}
