package com.amazon.hotelManagement.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.SlotConfirmationStatus;
import com.amazon.ask.response.ResponseBuilder;
import com.amazon.hotelManagement.constants.IntentName;
import com.amazon.hotelManagement.constants.SlotName;
import com.amazon.hotelManagement.helpers.MenuCard;
import com.amazon.hotelManagement.helpers.SlotUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
public class StartedOrderFoodIntentHandler implements RequestHandler {

    @Getter
    @Setter
    private IntentRequest intentRequest;

    @Override
    public boolean canHandle (HandlerInput handlerInput) {
        setIntentRequest((IntentRequest) handlerInput.getRequestEnvelope().getRequest());
        return getIntentRequest().getIntent().getName().equals(IntentName.ORDER_FOOD_INTENT)
                && getIntentRequest().getDialogState().equals(DialogState.STARTED);
    }

    @Override
    public Optional<Response> handle (HandlerInput handlerInput) {
        log.info("StartedOrderFoodIntentHandler triggered.");
        Map<String, Slot> slotValues = getIntentRequest().getIntent().getSlots();
        String FoodValue = slotValues.get(SlotName.FOOD_SLOT).getValue();
        ResponseBuilder responseBuilder = handlerInput.getResponseBuilder();
        if (null == FoodValue) {
            log.info("Food Value is not present. Triggering delegate directive.");
            responseBuilder.addDelegateDirective(getIntentRequest().getIntent());
        } else {
            log.info("Food value is present. Filling up FoodType and FoodSubType slots based on the food value.");
            slotValues.put(SlotName.FOOD_TYPE_SLOT, SlotUtil.makeNewSlot(SlotName.FOOD_TYPE_SLOT, MenuCard.getFoodType(FoodValue), SlotConfirmationStatus.CONFIRMED));
            slotValues.put(SlotName.FOOD_SUB_TYPE_SLOT, SlotUtil.makeNewSlot(SlotName.FOOD_SUB_TYPE_SLOT, MenuCard.getFoodSubType(FoodValue), SlotConfirmationStatus.CONFIRMED));
            Intent updatedIntent = Intent.builder().withName(getIntentRequest().getIntent().getName()).withConfirmationStatus(getIntentRequest().getIntent().getConfirmationStatus()).withSlots(slotValues).build();
            log.info("Updated FoodType and FoodSubType. Triggering delegate directive with updated intent.");
            responseBuilder.addDelegateDirective(updatedIntent);
        }
        return responseBuilder.build();
    }
}
