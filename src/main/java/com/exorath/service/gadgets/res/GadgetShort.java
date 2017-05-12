package com.exorath.service.gadgets.res;

/**
 * Created by toonsev on 5/12/2017.
 */
public class GadgetShort {
    private String type;
    private String id;

    public GadgetShort() {
    }

    public GadgetShort(String type, String id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
