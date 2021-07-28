package com.amazon.hotelManagement.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.hotelManagement.constants.IntentName;
import com.amazon.hotelManagement.constants.SpeechText;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        return handlerInput.getRequest().getType().equals(IntentName.LAUNCH_REQUEST);
    }

    @Override
    public Optional<Response> handle (HandlerInput input) {
        log.info("Launch request triggered.");
        String speech = SpeechText.WELCOME_SPEECH;
        return input.getResponseBuilder()
                .withSpeech(speech)
                .withReprompt(speech)
                .withShouldEndSession(false)
                .build();
    }
}
