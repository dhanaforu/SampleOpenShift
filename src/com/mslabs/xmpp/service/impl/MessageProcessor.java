package com.mslabs.xmpp.service.impl;

import com.mslabs.xmpp.bean.CcsInMessage;
import com.mslabs.xmpp.bean.CcsOutMessage;
import com.mslabs.xmpp.server.CcsClient;
import com.mslabs.xmpp.server.MessageHelper;
import com.mslabs.xmpp.service.PayloadProcessor;
import com.mslabs.xmpp.util.Util;

/**
 * Handles an upstream message request
 */
public class MessageProcessor implements PayloadProcessor {

	@Override
	public void handleMessage(CcsInMessage inMessage) {
		CcsClient client = CcsClient.getInstance();
		String messageId = Util.getUniqueMessageId();
		String to = inMessage.getDataPayload().get(Util.PAYLOAD_ATTRIBUTE_RECIPIENT);

		// TODO: handle the data payload sent to the client device. Here, I just
		// resend the incoming message.
		CcsOutMessage outMessage = new CcsOutMessage(to, messageId, inMessage.getDataPayload());
		String jsonRequest = MessageHelper.createJsonOutMessage(outMessage);
		client.send(jsonRequest);
	}

}