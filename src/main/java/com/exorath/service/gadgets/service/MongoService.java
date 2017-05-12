package com.exorath.service.gadgets.service;

import com.exorath.service.gadgets.Service;
import com.exorath.service.gadgets.res.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by toonsev on 5/12/2017.
 */
public class MongoService implements Service {
    private final Gson GSON = new Gson();
    private MongoCollection<Document> gadgetsCollection;

    public MongoService(MongoClient client, String databaseName) {
        this.gadgetsCollection = client.getDatabase(databaseName).getCollection("gadgets");
    }

    @Override
    public GetGadgetsRes getGadgets(String playerUuid, String typeFilter) {
        Map<String, GadgetShort> gadgets = new HashMap<>();
        Document filter = new Document("owner", playerUuid);
        if (typeFilter != null)
            filter.append("type", typeFilter);
        for (Document document : gadgetsCollection.find(filter))
            gadgets.put(document.getString("_id"), getGadgetShort(document));
        return new GetGadgetsRes(gadgets);
    }

    private GadgetShort getGadgetShort(Document document) {
        String type = document.getString("type");
        String id = document.getString("id");
        return new GadgetShort(type, id);
    }

    @Override
    public GadgetLong getGadget(String gadgetUuid) {
        Document response = gadgetsCollection.find(new Document("_id", gadgetUuid)).first();
        if (response == null)
            return null;
        String type = response.getString("type");
        String id = response.getString("id");
        long created = response.getLong("created");
        String owner = response.getString("owner");
        JsonObject meta = response.containsKey("meta") ? GSON.fromJson(response.getString("meta"), JsonObject.class) : null;
        return new GadgetLong(type, id, created, owner, meta);
    }

    @Override
    public BuyGadgetSuccess buyGadget(BuyGadgetReq req) {
        try {
            if (req.getCosts() != null)
                return new BuyGadgetSuccess(501, "Gadgets can't be bought yet.");
            String uuid = UUID.randomUUID().toString();
            Document document = new Document("_id", uuid)
                    .append("type", req.getType())
                    .append("id", req.getId())
                    .append("created", req.getCreated())
                    .append("owner", req.getOwner());
            if (req.getMeta() != null)
                document.append("meta", req.getMeta().toString());
            gadgetsCollection.insertOne(document);
            return new BuyGadgetSuccess(uuid);
        }catch (Exception e){
            e.printStackTrace();
            return new BuyGadgetSuccess(-1, e.getMessage());
        }
    }
}
