package cz.speedygonzales.bantherbloguje.database;

import cz.speedygonzales.bantherbloguje.businessRules.BusinessRuleGateway;
import cz.speedygonzales.bantherbloguje.entities.Something;

/**
 * @author vondracek
 * @since 15.8.2016 16:03
 */
public class MySqlBusinessRuleGateway implements BusinessRuleGateway {

    public Something getSomething(String id) {

        // use MySql to get a thing.
        return null;
    }


    public void startTransaction() {

        // start MySql transaction

    }


    public void saveSomething(Something thing) {

        // save thing in MySql

    }


    public void endTransaction() {

        // end MySql transaction

    }
}
