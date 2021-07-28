package com.amazon.hotelManagement.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.hotelManagement.constants.IntentName;
import com.amazon.hotelManagement.constants.SpeechText;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class CompletedOrderFoodIntentHandler implements RequestHandler {

    @Getter
    @Setter
    private IntentRequest intentRequest;

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        setIntentRequest((IntentRequest) handlerInput.getRequestEnvelope().getRequest());
        return getIntentRequest().getIntent().getName().equals(IntentName.ORDER_FOOD_INTENT)
                && getIntentRequest().getDialogState().equals(DialogState.COMPLETED);
    }

    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        log.info("CompletedOrderFoodIntentHandler triggered.");
        String speech = SpeechText.ORDER_RECORDED;
        return handlerInput.getResponseBuilder()
                .withSpeech(speech)
                .withShouldEndSession(true)
                .build();
    }
}
