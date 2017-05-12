package com.exorath.service.gadgets.api;

import com.exorath.service.gadgets.Service;
import com.exorath.service.gadgets.res.BuyGadgetReq;
import com.exorath.service.gadgets.res.BuyGadgetSuccess;
import com.exorath.service.gadgets.res.GadgetLong;
import com.exorath.service.gadgets.res.GetGadgetsRes;
import com.google.gson.Gson;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.body.RequestBodyEntity;

/**
 * Created by toonsev on 5/12/2017.
 */
public class GadgetsServiceAPI implements Service {
    private static final Gson GSON = new Gson();
    private String address;

    public GadgetsServiceAPI(String address) {
        this.address = address;
    }

    @Override
    public GetGadgetsRes getGadgets(String playerUuid, String typeFilter) {
        try {
            GetRequest getRequest = Unirest.get(url("/players/{uuid}/gadgets"))
                    .routeParam("uuid", playerUuid);
            if (typeFilter != null)
                getRequest.queryString("type", typeFilter);
            return GSON.fromJson(getRequest.asString().getBody(), GetGadgetsRes.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public GadgetLong getGadget(String gadgetUuid) {
        try {
            GetRequest getRequest = Unirest.get(url("/gadgets/{uuid}"))
                    .routeParam("uuid", gadgetUuid);
            return GSON.fromJson(getRequest.asString().getBody(), GadgetLong.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public BuyGadgetSuccess buyGadget(BuyGadgetReq req) {

        try {
            RequestBodyEntity postReq = Unirest.post(url("/players/{uuid}/gadgets"))
                    .routeParam("uuid", req.getOwner())
                    .body(GSON.toJson(req));
            return GSON.fromJson(postReq.asString().getBody(), BuyGadgetSuccess.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String url(String endpoint) {
        return address + endpoint;
    }
}
