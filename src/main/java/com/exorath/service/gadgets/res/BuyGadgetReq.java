package com.exorath.service.gadgets.res;

import com.google.gson.JsonObject;

import java.util.Map;

/**
 * Created by toonsev on 5/12/2017.
 */
public class BuyGadgetReq extends GadgetLong{
    private Map<String, Integer> costs;

    public Map<String, Integer> getCosts() {
        return costs;
    }

}
