package cz.speedygonzales.bantherbloguje.businessRules;

import cz.speedygonzales.bantherbloguje.entities.Something;

/**
 * @author vondracek
 * @since 15.8.2016 16:01
 */
public class BusinessRule {

    private BusinessRuleGateway gateway;

    public BusinessRule(BusinessRuleGateway gateway) {

        this.gateway = gateway;

    }


    public void execute(String id) {

        gateway.startTransaction();

        Something thing = gateway.getSomething(id);

        thing.makeChanges();

        gateway.saveSomething(thing);

        gateway.endTransaction();

    }
}
