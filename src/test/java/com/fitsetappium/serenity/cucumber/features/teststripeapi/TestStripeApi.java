package com.fitsetappium.serenity.cucumber.features.teststripeapi;


import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;
import net.thucydides.core.pages.PageObject;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestStripeApi extends PageObject {
    static HashMap<String, Object> defaultCardParams = new HashMap<String, Object>();
    static HashMap<String, Object> trialSubscriptionParam = new HashMap<String, Object>();
    @Test
    public void cancelAllubscriptionAndStartNewSubscriptionTrailforUser () throws CardException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException, ParseException {

        cancelAllexistingSubscriptionAndStartNewTrialSubscription("fitset01trial@fitset.ca","3","Three","4500","prod_CydzbL8llxNqf9");


    }
    @Test
    public void cancelAllSubscriptionAndStartNewSubscriptionWithThreePlanForRegularUser () throws CardException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException, ParseException {

        cancelAllexistingSubscriptionAndStartNewSubscription("fitset01regular@fitset.ca","3","Three","4500","prod_CydzbL8llxNqf9");
    }
    public void cancelAllexistingSubscriptionAndStartNewSubscription (String email, String plan, String planName, String planAmt, String prodcutName) throws CardException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException ,ParseException {
        //defaultCardParams.put("source","tok_1CwvaTDGCu9ImtApZSL7dMwh");
        defaultCardParams.put("email", email);
        String subscriptionId =null;

        Stripe.apiKey = "sk_test_paH0IlAOuBxzAdx28P3Pap3s"; // stripe public
        if(Customer.list(defaultCardParams).getData().get(0).getSubscriptions().getData().size()>0) {
            int countAllSubscriptions=Customer.list(defaultCardParams).getData().get(0).getSubscriptions().getData().size();
            for(int i=0;i<countAllSubscriptions;i++) {
                subscriptionId = Customer.list(defaultCardParams).getData().get(0).getSubscriptions().getData().get(i).getId();
                Subscription subscription = Subscription.retrieve(subscriptionId);
                System.out.println(subscription.toString());



                Subscription.retrieve(subscriptionId).cancel(null);
            }
        }

        Map<String, Object> productParams = new HashMap<String, Object>();
        productParams.put("name", planName);

        Map<String, Object> planParams = new HashMap<String, Object>();
        planParams.put("amount", planAmt);
        // planParams.put("interval", "daily");

        planParams.put("product", prodcutName);
        planParams.put("currency", "cad");

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("plan", plan);

        Map<String, Object> items = new HashMap<String, Object>();
        items.put("0", item);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("customer", Customer.list(defaultCardParams).getData().get(0).getId());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date today = new Date();
        String date = sdf.format(new Date(today.getTime() + (1000 * 60 * 60 * 24)));
        Date date2 = sdf.parse(date);


        System.out.println(date2.getTime()/1000);
        params.put("billing_cycle_anchor", date2.getTime()/1000);

        // params.put("billing_cycle_anchor", date2.getTime()/1000);
        //params.put("current_period_end", "1533782437");
        params.put("items", items);


        Subscription.create(params);


    }


    public void cancelAllexistingSubscriptionAndStartNewTrialSubscription (String email, String plan, String planName, String planAmt, String prodcutName) throws CardException, APIException, AuthenticationException, InvalidRequestException, APIConnectionException ,ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date today = new Date();
        String date = sdf.format(new Date(today.getTime() + (1000 * 60 * 60 * 24)));
        Date date2 = sdf.parse(date);
        String endDate = sdf.format(new Date(today.getTime() + (1000 * 60 * 60 * 48)));
        Date date3 = sdf.parse(endDate);

        System.out.println(date2.getTime()/1000);

        //defaultCardParams.put("source","tok_1CwvaTDGCu9ImtApZSL7dMwh");
        defaultCardParams.put("email", email);
        String subscriptionId =null;

        Stripe.apiKey = "sk_test_paH0IlAOuBxzAdx28P3Pap3s"; // stripe public
        if(Customer.list(defaultCardParams).getData().get(0).getSubscriptions().getData().size()>0) {
            int countAllSubscriptions=Customer.list(defaultCardParams).getData().get(0).getSubscriptions().getData().size();
            for(int i=0;i<countAllSubscriptions;i++) {
                subscriptionId = Customer.list(defaultCardParams).getData().get(0).getSubscriptions().getData().get(i).getId();
                Subscription subscription = Subscription.retrieve(subscriptionId);
                System.out.println(subscription.toString());



                Subscription.retrieve(subscriptionId).cancel(null);
            }
        }

        Map<String, Object> productParams = new HashMap<String, Object>();
        productParams.put("plan", 3);
        // productParams.put("tax_percent", 5);

        Map<String, Object> planParams = new HashMap<String, Object>();
        planParams.put("amount", planAmt);
        // planParams.put("interval", "daily");

        planParams.put("product", prodcutName);
        planParams.put("currency", "cad");

        Map<String, Object> item = new HashMap<String, Object>();
        item.put("plan", plan);

        Map<String, Object> items = new HashMap<String, Object>();
        items.put("0", productParams);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("customer", Customer.list(defaultCardParams).getData().get(0).getId());

        params.put("trial_end", date3.getTime()/1000);
        params.put("items", items);


        Subscription.create(params);


    }


}
