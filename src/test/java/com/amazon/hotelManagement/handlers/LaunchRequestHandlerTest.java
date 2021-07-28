package com.amazon.hotelManagement.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.hotelManagement.constants.SpeechText;
import com.amazon.hotelManagement.helpers.AssertHelper;
import com.amazon.hotelManagement.helpers.HandlerInputBuilder;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public final class LaunchRequestHandlerTest {

    @Getter
    @Setter
    private LaunchRequestHandler launchRequestHandler;

    @Getter
    @Setter
    private HandlerInput handlerInput;

    @Before
    public void setUp () {
        setHandlerInput(HandlerInputBuilder.buildLaunchRequestHandlerInput());
        setLaunchRequestHandler(new LaunchRequestHandler());
    }

    @Test
    public void canHandle () {
        Assert.assertTrue(getLaunchRequestHandler().canHandle(getHandlerInput()));
    }

    @Test
    public void handle () {
        Optional<Response> response = getLaunchRequestHandler().handle(getHandlerInput());
        AssertHelper.validateIntentHandleResponse(response.get(), SpeechText.WELCOME_SPEECH, false);
    }
}
