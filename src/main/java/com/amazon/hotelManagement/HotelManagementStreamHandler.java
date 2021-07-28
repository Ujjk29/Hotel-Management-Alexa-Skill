package com.amazon.hotelManagement;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import com.amazon.hotelManagement.handlers.CancelandStopIntentHandler;
import com.amazon.hotelManagement.handlers.CompletedOrderFoodIntentHandler;
import com.amazon.hotelManagement.handlers.FallbackIntentHandler;
import com.amazon.hotelManagement.handlers.HelpIntentHandler;
import com.amazon.hotelManagement.handlers.InProgressOrderFoodIntentHandler;
import com.amazon.hotelManagement.handlers.InProgressOrderFoodIntentHandlerGetFoodSubTypeValue;
import com.amazon.hotelManagement.handlers.LaunchRequestHandler;
import com.amazon.hotelManagement.handlers.SessionEndedRequestHandler;
import com.amazon.hotelManagement.handlers.StartedOrderFoodIntentHandler;

public class HotelManagementStreamHandler extends SkillStreamHandler {

    public HotelManagementStreamHandler () {
        super(getSkill());
    }

    private static Skill getSkill () {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new FallbackIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new StartedOrderFoodIntentHandler(),
                        new InProgressOrderFoodIntentHandlerGetFoodSubTypeValue(),
                        new InProgressOrderFoodIntentHandler(),
                        new CompletedOrderFoodIntentHandler())
                .build();
    }

}