package com.amazon.hotelManagement.helpers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.RequestEnvelope;
import com.amazon.ask.model.Session;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.User;

import java.util.Map;

public final class HandlerInputBuilder {

    private static final String DEFAULT_CUSTOMER_ID = "CUSTOMER_ID";

    public static HandlerInput buildLaunchRequestHandlerInput () {
        Request request = LaunchRequest.builder().build();
        Session session = Session.builder().withUser(User.builder().withUserId(DEFAULT_CUSTOMER_ID).build()).build();
        RequestEnvelope requestEnvelope = RequestEnvelope.builder().withRequest(request).withSession(session).build();
        return HandlerInput.builder().withRequestEnvelope(requestEnvelope).build();
    }

    public static HandlerInput buildOrderFoodIntentHandler (String intentName, DialogState dialogState, Map<String, Slot> slotMap) {
        Intent.Builder intentBuilder = Intent.builder()
                .withName(intentName);
        for (Map.Entry<String, Slot> iterator : slotMap.entrySet()) {
            intentBuilder.putSlotsItem(iterator.getKey(), iterator.getValue());
        }
        Intent intent = intentBuilder.build();
        Request request = IntentRequest
                .builder()
                .withIntent(intent)
                .withDialogState(dialogState)
                .build();
        RequestEnvelope requestEnvelope = RequestEnvelope.builder()
                .withRequest(request)
                .build();
        return HandlerInput.builder().withRequestEnvelope(requestEnvelope).build();
    }
}
