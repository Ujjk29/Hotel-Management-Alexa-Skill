package com.amazon.hotelManagement.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.hotelManagement.constants.IntentName;
import com.amazon.hotelManagement.constants.SpeechText;
import com.amazon.hotelManagement.helpers.AssertHelper;
import com.amazon.hotelManagement.helpers.HandlerInputBuilder;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class CompletedOrderFoodIntentHandlerTest {

    @Getter
    @Setter
    private CompletedOrderFoodIntentHandler completedOrderFoodIntentHandler;

    @Getter
    @Setter
    private HandlerInput handlerInput;

    @Before
    public void setUp () {
        setCompletedOrderFoodIntentHandler(new CompletedOrderFoodIntentHandler());
        Map<String, Slot> slotMap = new HashMap<>();
        setHandlerInput(HandlerInputBuilder.buildOrderFoodIntentHandler(IntentName.ORDER_FOOD_INTENT, DialogState.COMPLETED, slotMap));
    }

    @Test
    public void canHandle () {
        Assert.assertTrue(getCompletedOrderFoodIntentHandler().canHandle(getHandlerInput()));
    }

    @Test
    public void handle () {
        Optional<Response> response = getCompletedOrderFoodIntentHandler().handle(getHandlerInput());
        AssertHelper.validateIntentHandleResponse(response.get(), SpeechText.ORDER_RECORDED, true);
    }
}
