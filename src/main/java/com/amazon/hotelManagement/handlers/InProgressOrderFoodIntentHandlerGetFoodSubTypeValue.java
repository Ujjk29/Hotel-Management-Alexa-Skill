package com.amazon.hotelManagement.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SlotConfirmationStatus;
import com.amazon.hotelManagement.constants.FoodTypeValues;
import com.amazon.hotelManagement.constants.IntentName;
import com.amazon.hotelManagement.constants.SlotName;
import com.amazon.hotelManagement.constants.SpeechText;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class InProgressOrderFoodIntentHandlerGetFoodSubTypeValue implements RequestHandler {

    @Getter
    @Setter
    private IntentRequest intentRequest;

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        setIntentRequest((IntentRequest) handlerInput.getRequest());
        return getIntentRequest().getIntent().getName().equals(IntentName.ORDER_FOOD_INTENT)
                && getIntentRequest().getDialogState().equals(DialogState.IN_PROGRESS)
                && getIntentRequest().getIntent().getSlots().get(SlotName.FOOD_TYPE_SLOT).getConfirmationStatus().equals(SlotConfirmationStatus.CONFIRMED)
                && null == getIntentRequest().getIntent().getSlots().get(SlotName.FOOD_SUB_TYPE_SLOT).getValue();
    }

    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        log.info("InProgressOrderFoodIntentHandlerGetFoodSubTypeValue triggered.");
        String speech;
        if (getIntentRequest().getIntent().getSlots().get(SlotName.FOOD_TYPE_SLOT).getValue().equals(FoodTypeValues.VEGETARIAN)
                || getIntentRequest().getIntent().getSlots().get(SlotName.FOOD_TYPE_SLOT).getValue().equals(FoodTypeValues.VEG)) {
            log.info("User selected Vegetarian food. Providing only vegetarian options.");
            speech = SpeechText.VEG_SUB_TYPE;
        } else if (getIntentRequest().getIntent().getSlots().get(SlotName.FOOD_TYPE_SLOT).getValue().equals(FoodTypeValues.NON_VEGETARIAN)
                || getIntentRequest().getIntent().getSlots().get(SlotName.FOOD_TYPE_SLOT).getValue().equals(FoodTypeValues.NON_VEG)) {
            log.info("User selected Non-Vegetarian food. Providing only non-vegetarian option.");
            speech = SpeechText.NON_VEG_SUB_TYPE;
        } else {
            log.info("User selected non valid option.");
            speech = SpeechText.DID_NOT_GET_IT;
        }
        return handlerInput.getResponseBuilder()
                .withSpeech(speech)
                .addElicitSlotDirective(SlotName.FOOD_SUB_TYPE_SLOT, getIntentRequest().getIntent())
                .build();
    }
}
