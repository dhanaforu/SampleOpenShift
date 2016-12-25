package com.mslabs.xmpp.util;

import java.util.UUID;

/**
 * Util class for constants and generic methods
 */

public class Util {

	public static final String FCM_SENDER_ID = "90420728818";
	public static final String FCM_SERVER_KEY = "AAAAFQ1-0_I:APA91bGeN0527Vs20_M_-yyqibddvDrlLQUGNc5YbORE9C8I4F5IlJ6lRFI277A3IXJqEAFBxbMUYjqkhdmJEAPsY1wXM7zSeElGeAB5kNo1ovgkjAgZOaI1gJrryQ2HY4SWGaeZcvnqwYqWNSfzxCwzopcLzmDG7Q";
	public static final String toRegId = "\\topics\\message";

	// For the GCM connection
	public static final String FCM_SERVER = "fcm-xmpp.googleapis.com";
	public static final int FCM_PORT = 5236;
	public static final String FCM_ELEMENT_NAME = "gcm";
	public static final String FCM_NAMESPACE = "google:mobile:data";
	public static final String FCM_SERVER_CONNECTION = "gcm.googleapis.com";

	// For the processor factory
	public static final String PACKAGE = "com.mslabs.xmpp";
	public static final String BACKEND_ACTION_REGISTER = PACKAGE + ".REGISTER";
	public static final String BACKEND_ACTION_ECHO = PACKAGE + ".ECHO";
	public static final String BACKEND_ACTION_MESSAGE = PACKAGE + ".MESSAGE";

	// For the app common payload message attributes (android - xmpp server)
	public static final String PAYLOAD_ATTRIBUTE_MESSAGE = "message";
	public static final String PAYLOAD_ATTRIBUTE_ACTION = "action";
	public static final String PAYLOAD_ATTRIBUTE_RECIPIENT = "recipient";
	public static final String PAYLOAD_ATTRIBUTE_ACCOUNT = "account";

	/**
	 * Returns a random message id to uniquely identify a message
	 */
	public static String getUniqueMessageId() {
		// TODO: replace for your own random message ID that the DB generates
		return "m-" + UUID.randomUUID().toString();
	}

}
