package com.exorath.service.gadgets.res;

import java.util.Map;

/**
 * Created by toonsev on 5/12/2017.
 */
public class GetGadgetsRes {
    private Map<String, GadgetShort> gadgets;

    public GetGadgetsRes() {}

    public GetGadgetsRes(Map<String, GadgetShort> gadgets) {
        this.gadgets = gadgets;
    }

    public Map<String, GadgetShort> getGadgets() {
        return gadgets;
    }
}
