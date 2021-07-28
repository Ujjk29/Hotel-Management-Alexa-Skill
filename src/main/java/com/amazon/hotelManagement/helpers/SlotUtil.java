package com.amazon.hotelManagement.helpers;

import com.amazon.ask.model.Slot;
import com.amazon.ask.model.SlotConfirmationStatus;

public final class SlotUtil {
    public static Slot makeNewSlot (String slotName, String slotValue, SlotConfirmationStatus slotConfirmationStatus) {
        return Slot.builder().withName(slotName).withValue(slotValue).withConfirmationStatus(slotConfirmationStatus).build();
    }

    public static Slot makeNewSlot (String slotName, SlotConfirmationStatus slotConfirmationStatus) {
        return Slot.builder().withName(slotName).withConfirmationStatus(slotConfirmationStatus).build();
    }
}
