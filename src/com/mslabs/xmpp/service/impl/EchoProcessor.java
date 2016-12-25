package com.mslabs.xmpp.service.impl;

import com.mslabs.xmpp.bean.CcsInMessage;
import com.mslabs.xmpp.bean.CcsOutMessage;
import com.mslabs.xmpp.server.CcsClient;
import com.mslabs.xmpp.server.MessageHelper;
import com.mslabs.xmpp.service.PayloadProcessor;
import com.mslabs.xmpp.util.Util;

/**
 * Handles an echo request
 */
public class EchoProcessor implements PayloadProcessor {

	@Override
	public void handleMessage(CcsInMessage inMessage) {
		CcsClient client = CcsClient.getInstance();
		String messageId = Util.getUniqueMessageId();
		String to = inMessage.getFrom();

		// Send the incoming message to the the device that made the request
		CcsOutMessage outMessage = new CcsOutMessage(to, messageId, inMessage.getDataPayload());
		String jsonRequest = MessageHelper.createJsonOutMessage(outMessage);
		client.send(jsonRequest);
	}

}