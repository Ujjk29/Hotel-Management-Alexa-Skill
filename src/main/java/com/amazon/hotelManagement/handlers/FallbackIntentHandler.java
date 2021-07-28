package com.amazon.hotelManagement.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.hotelManagement.constants.IntentName;
import com.amazon.hotelManagement.constants.SpeechText;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class FallbackIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle (HandlerInput input) {
        return input.matches(intentName(IntentName.AMAZON_FALLBACK_INTENT));
    }

    @Override
    public Optional<Response> handle (HandlerInput input) {
        String speech = SpeechText.ASK_HELP;
        return input.getResponseBuilder()
                .withSpeech(speech)
                .withReprompt(speech)
                .build();
    }
}
