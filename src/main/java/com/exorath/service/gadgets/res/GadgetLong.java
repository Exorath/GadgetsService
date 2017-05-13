package com.exorath.service.gadgets.res;

import com.google.gson.JsonObject;

/**
 * Created by toonsev on 5/12/2017.
 */
public class GadgetLong {
    private String type;
    private String id;
    private long created;
    private String owner;
    private JsonObject meta;

    public GadgetLong() {
    }

    public GadgetLong(String type, String id, long created, String owner, JsonObject meta) {
        this.type = type;
        this.id = id;
        this.created = created;
        this.owner = owner;
        this.meta = meta;
    }

    public GadgetLong(String type, String id, String owner, JsonObject meta) {
        this.type = type;
        this.id = id;
        this.owner = owner;
        this.meta = meta;
        setCreated(System.currentTimeMillis());
    }

    public GadgetLong setCreated(long created) {
        this.created = created;
        return this;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public long getCreated() {
        return created;
    }

    public String getOwner() {
        return owner;
    }

    public JsonObject getMeta() {
        return meta;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
