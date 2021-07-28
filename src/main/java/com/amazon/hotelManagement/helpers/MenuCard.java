package com.amazon.hotelManagement.helpers;

import com.amazon.hotelManagement.constants.FoodSubTypeValues;
import com.amazon.hotelManagement.constants.FoodTypeValues;
import com.amazon.hotelManagement.constants.FoodValues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MenuCard {
    private final static Map<String, List<String>> menuCardMap;

    static {
        menuCardMap = new HashMap<>();

        menuCardMap.put(FoodValues.TAWA_ROTI, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.BREADS));
        menuCardMap.put(FoodValues.MISSI_ROTI, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.BREADS));
        menuCardMap.put(FoodValues.KULCHE, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.BREADS));
        menuCardMap.put(FoodValues.NAAN, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.BREADS));

        menuCardMap.put(FoodValues.SUNDAE, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.ACCOMPANIMENT));
        menuCardMap.put(FoodValues.BROWNIE, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.ACCOMPANIMENT));
        menuCardMap.put(FoodValues.CHOCOLATE_CUP, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.ACCOMPANIMENT));
        menuCardMap.put(FoodValues.CURD, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.ACCOMPANIMENT));
        menuCardMap.put(FoodValues.RAITA, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.ACCOMPANIMENT));

        menuCardMap.put(FoodValues.CHOLE_PULAO, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.ENTREE));
        menuCardMap.put(FoodValues.BHINDI_TWO_WAYS, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.ENTREE));
        menuCardMap.put(FoodValues.PANEER_TIKKA, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.ENTREE));

        menuCardMap.put(FoodValues.DRUMSTICK_LEAF_SOUP, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.SOUP));
        menuCardMap.put(FoodValues.NIMBU_KA_RASSA, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.SOUP));

        menuCardMap.put(FoodValues.MUSHROOM_MIRCH_MALAI, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.APPETIZER));
        menuCardMap.put(FoodValues.CORN_KEBAB, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.APPETIZER));
        menuCardMap.put(FoodValues.MASALA_CHAT, Arrays.asList(FoodTypeValues.VEGETARIAN, FoodSubTypeValues.APPETIZER));

        menuCardMap.put(FoodValues.LAMB_BIRYANI, Arrays.asList(FoodTypeValues.NON_VEGETARIAN, FoodSubTypeValues.ENTREE));
        menuCardMap.put(FoodValues.CHICKEN_BAMBOO, Arrays.asList(FoodTypeValues.NON_VEGETARIAN, FoodSubTypeValues.ENTREE));
        menuCardMap.put(FoodValues.PEPPER_PRAWN, Arrays.asList(FoodTypeValues.NON_VEGETARIAN, FoodSubTypeValues.ENTREE));

        menuCardMap.put(FoodValues.LAMB_AASH, Arrays.asList(FoodTypeValues.NON_VEGETARIAN, FoodSubTypeValues.SOUP));
        menuCardMap.put(FoodValues.CHICKEN_BROTH, Arrays.asList(FoodTypeValues.NON_VEGETARIAN, FoodSubTypeValues.SOUP));

        menuCardMap.put(FoodValues.MURGH_SOUFFLE, Arrays.asList(FoodTypeValues.NON_VEGETARIAN, FoodSubTypeValues.APPETIZER));
        menuCardMap.put(FoodValues.FISH_TIKKA, Arrays.asList(FoodTypeValues.NON_VEGETARIAN, FoodSubTypeValues.APPETIZER));
        menuCardMap.put(FoodValues.CHICKEN_GALAWAT, Arrays.asList(FoodTypeValues.NON_VEGETARIAN, FoodSubTypeValues.APPETIZER));
    }

    public static String getFoodType (String food) {
        return menuCardMap.get(food).get(0);
    }

    public static String getFoodSubType (String food) {
        return menuCardMap.get(food).get(1);
    }
}
