package com.exorath.service.gadgets;

import com.exorath.service.commons.mongoProvider.MongoProvider;
import com.exorath.service.commons.portProvider.PortProvider;
import com.exorath.service.commons.tableNameProvider.TableNameProvider;
import com.exorath.service.gadgets.service.MongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by toonsev on 5/12/2017.
 */
public class Main {
    private Service service;
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public Main() {
        this.service = new MongoService(MongoProvider.getEnvironmentMongoProvider().getClient(), TableNameProvider.getEnvironmentTableNameProvider("DB_NAME").getTableName());
        LOG.info("Service " + this.service.getClass() + " instantiated");
        Transport.setup(service, PortProvider.getEnvironmentPortProvider());
        LOG.info("HTTP Transport initiated");
    }

    public static void main(String[] args) {
        new Main();
    }
}
