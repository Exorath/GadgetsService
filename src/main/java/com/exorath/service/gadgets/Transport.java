package com.exorath.service.gadgets;

import com.exorath.service.commons.portProvider.PortProvider;
import com.exorath.service.gadgets.res.BuyGadgetReq;
import com.google.gson.Gson;
import spark.Route;

import static spark.Spark.*;

/**
 * Created by toonsev on 5/12/2017.
 */
public class Transport {

    private static final Gson GSON = new Gson();

    public static void setup(Service service, PortProvider portProvider) {
        port(portProvider.getPort());

        get("/players/:uuid/gadgets", getGetPlayerGadgetsRoute(service), GSON::toJson);
        get("/gadgets/:uuid", getGetGadgetRoute(service), GSON::toJson);
        post("/players/:uuid/gadgets", getPurchaseGadgetRoute(service), GSON::toJson);
    }

    private static Route getPurchaseGadgetRoute(Service service) {
        return (req, res) -> {
            BuyGadgetReq gadget = GSON.fromJson(req.body(), BuyGadgetReq.class);
            gadget.setOwner(req.params("uuid"));
            return service.buyGadget(gadget);
        };
    }

    private static Route getGetGadgetRoute(Service service) {
        return (req, res) -> {
            return service.getGadget(req.params("uuid"));
        };
    }

    private static Route getGetPlayerGadgetsRoute(Service service) {
        return (req, res) -> {
            return service.getGadgets(req.params("uuid"), req.queryParams("type"));
        };
    }
}
