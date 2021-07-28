package com.amazon.hotelManagement.helpers;

import com.amazon.ask.model.Directive;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.dialog.DelegateDirective;
import com.amazon.ask.model.ui.SsmlOutputSpeech;
import com.amazon.hotelManagement.constants.DialogConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

@Slf4j
public final class AssertHelper {
    public static void validateIntentHandleResponse (Response response, String speechConstant, Boolean shouldEndSession) {
        Assert.assertTrue(((SsmlOutputSpeech) response.getOutputSpeech()).getSsml().contains(speechConstant));
        assertEquals(shouldEndSession, response.getShouldEndSession());
    }

    public static void validateDelegateDirective (Response response, Intent intent) {
        Directive directive = response.getDirectives().get(0);
        assertEquals(directive.getType(), DialogConstant.DIALOG_DELEGATE);
        DelegateDirective delegateDirective = (DelegateDirective) response.getDirectives().get(0);
        assertEquals(delegateDirective.getUpdatedIntent(), intent);
    }
}
