package com.fitsetappium.serenity.cucumber.features.teststripeapi;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Customer;
import net.thucydides.core.pages.PageObject;


import java.util.HashMap;
import java.util.Map;

public class StripeUtils extends PageObject {

    static HashMap<String, Object> defaultCardParams = new HashMap<String, Object>();



    public Map<String , String> getActiveCoupleForHold() throws CardException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException {
        defaultCardParams.put("email", "fitset02trial@fitset.ca");
        String subscriptionId=null;
        Stripe.apiKey = "sk_test_paH0IlAOuBxzAdx28P3Pap3s"; // stripe public

        String percentage= Customer.list(defaultCardParams).getData().get(0).getDiscount().getCoupon().getPercentOff().toString();
        String duration=Customer.list(defaultCardParams).getData().get(0).getDiscount().getCoupon().getDurationInMonths().toString();
        Map<String, String> coupanParams= new HashMap<String, String>();
        coupanParams.put("percentage",percentage);
        coupanParams.put("month",duration);
        return coupanParams;



    }




}

