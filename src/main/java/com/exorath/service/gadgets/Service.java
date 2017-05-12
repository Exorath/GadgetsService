package com.exorath.service.gadgets;

import com.exorath.service.gadgets.res.BuyGadgetReq;
import com.exorath.service.gadgets.res.BuyGadgetSuccess;
import com.exorath.service.gadgets.res.GadgetLong;
import com.exorath.service.gadgets.res.GetGadgetsRes;

/**
 * Created by toonsev on 5/12/2017.
 */
public interface Service {
    GetGadgetsRes getGadgets(String playerUuid, String typeFilter);

    GadgetLong getGadget(String gadgetUuid);

    BuyGadgetSuccess buyGadget(BuyGadgetReq req);
}
