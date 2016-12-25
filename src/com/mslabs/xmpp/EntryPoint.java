package com.mslabs.xmpp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;

import com.mslabs.xmpp.bean.CcsOutMessage;
import com.mslabs.xmpp.server.CcsClient;
import com.mslabs.xmpp.server.MessageHelper;
import com.mslabs.xmpp.util.Util;

/**
 * Entry Point class for the XMPP Server in dev mode for debugging and testing
 * purposes
 */
public class EntryPoint {
	public static void main(String[] args) throws SmackException, IOException {
		final String fcmProjectSenderId = "90420728818";//args[0];
		final String fcmServerKey = "AAAAFQ1-0_I:APA91bGeN0527Vs20_M_-yyqibddvDrlLQUGNc5YbORE9C8I4F5IlJ6lRFI277A3IXJqEAFBxbMUYjqkhdmJEAPsY1wXM7zSeElGeAB5kNo1ovgkjAgZOaI1gJrryQ2HY4SWGaeZcvnqwYqWNSfzxCwzopcLzmDG7Q";//args[1];
		final String toRegId = "/topics/message";//args[2];

		CcsClient ccsClient = CcsClient.prepareClient(fcmProjectSenderId, fcmServerKey, true);

		try {
			ccsClient.connect();
		} catch (XMPPException e) {
			e.printStackTrace();
		}

		// Send a sample downstream message to a device
		String messageId = Util.getUniqueMessageId();
		Map<String, String> dataPayload = new HashMap<String, String>();
		dataPayload.put(Util.PAYLOAD_ATTRIBUTE_MESSAGE, "This is the simple sample message");
		CcsOutMessage message = new CcsOutMessage(toRegId, messageId, dataPayload);
		String jsonRequest = MessageHelper.createJsonOutMessage(message);
		ccsClient.send(jsonRequest);

		while (true) {
			// TODO: Improve this because the app closes itself after the
			// execution of the connect method
		}
	}
}
