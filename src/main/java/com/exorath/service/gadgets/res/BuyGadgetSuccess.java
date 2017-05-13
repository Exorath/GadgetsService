package com.exorath.service.gadgets.res;

/**
 * Created by toonsev on 5/12/2017.
 */
public class BuyGadgetSuccess extends Success{
    private String uuid;

    public BuyGadgetSuccess(String uuid) {
        super(true);
        this.uuid = uuid;
    }

    public BuyGadgetSuccess(Integer code, String error) {
        super(code, error);
    }

    public String getUuid() {
        return uuid;
    }
}
