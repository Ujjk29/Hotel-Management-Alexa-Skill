package com.amazon.hotelManagement.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.hotelManagement.constants.IntentName;
import com.amazon.hotelManagement.constants.SpeechText;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class CancelandStopIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle (HandlerInput input) {
        return input.matches(intentName(IntentName.AMAZON_STOP_INTENT).or(intentName(IntentName.AMAZON_CANCEL_INTENT)));
    }

    @Override
    public Optional<Response> handle (HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(SpeechText.GOOD_BYE)
                .withShouldEndSession(true)
                .build();
    }
}