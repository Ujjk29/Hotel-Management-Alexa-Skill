package com.amazon.hotelManagement.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.SlotConfirmationStatus;
import com.amazon.hotelManagement.constants.IntentName;
import com.amazon.hotelManagement.constants.SlotName;
import com.amazon.hotelManagement.helpers.AssertHelper;
import com.amazon.hotelManagement.helpers.HandlerInputBuilder;
import com.amazon.hotelManagement.helpers.SlotUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public final class InProgressOrderFoodIntentHandlerTest {

    @Getter
    @Setter
    private InProgressOrderFoodIntentHandler inProgressOrderFoodIntentHandler;

    @Getter
    @Setter
    private HandlerInput handlerInput;

    private Map<String, Slot> slotMap;

    @Before
    public void setUp () {
        setInProgressOrderFoodIntentHandler(new InProgressOrderFoodIntentHandler());
        slotMap = new HashMap<>();
        slotMap.put(SlotName.FOOD_SLOT, SlotUtil.makeNewSlot(SlotName.FOOD_SLOT, SlotConfirmationStatus.NONE));
        slotMap.put(SlotName.FOOD_TYPE_SLOT, SlotUtil.makeNewSlot(SlotName.FOOD_TYPE_SLOT, SlotConfirmationStatus.NONE));
        slotMap.put(SlotName.FOOD_SUB_TYPE_SLOT, SlotUtil.makeNewSlot(SlotName.FOOD_SUB_TYPE_SLOT, SlotConfirmationStatus.NONE));
        slotMap.put(SlotName.SCHEDULE_TIME_SLOT, SlotUtil.makeNewSlot(SlotName.SCHEDULE_TIME_SLOT, SlotConfirmationStatus.NONE));
        setHandlerInput(HandlerInputBuilder.buildOrderFoodIntentHandler(IntentName.ORDER_FOOD_INTENT, DialogState.IN_PROGRESS, slotMap));
    }

    @Test
    public void canHandle () {
        Assert.assertTrue(getInProgressOrderFoodIntentHandler().canHandle(getHandlerInput()));
        log.info("canHandle Test passed.");
    }

    @Test
    public void handle () {
        Assert.assertTrue(getInProgressOrderFoodIntentHandler().canHandle(getHandlerInput()));
        Optional<Response> optionalResponse = getInProgressOrderFoodIntentHandler().handle(getHandlerInput());
        Assert.assertTrue(optionalResponse.isPresent());
        Intent intent = Intent.builder()
                .withName(IntentName.ORDER_FOOD_INTENT)
                .withSlots(slotMap)
                .build();
        AssertHelper.validateDelegateDirective(optionalResponse.get(), intent);
        log.info("handle Test passed.");
    }
}
