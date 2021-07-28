package com.amazon.hotelManagement.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.hotelManagement.constants.IntentName;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class InProgressOrderFoodIntentHandler implements RequestHandler {

    @Getter
    @Setter
    private IntentRequest intentRequest;

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        setIntentRequest((IntentRequest) handlerInput.getRequestEnvelope().getRequest());
        return getIntentRequest().getIntent().getName().equals(IntentName.ORDER_FOOD_INTENT)
                && getIntentRequest().getDialogState().equals(DialogState.IN_PROGRESS);
    }

    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        log.info("InProgressOrderFoodIntentHandler triggered. Delegate directive used.");
        log.info(getIntentRequest().toString());
        return handlerInput.getResponseBuilder()
                .addDelegateDirective(getIntentRequest().getIntent())
                .build();
    }
}
