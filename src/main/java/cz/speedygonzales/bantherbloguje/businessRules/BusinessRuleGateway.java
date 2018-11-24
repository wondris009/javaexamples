package cz.speedygonzales.bantherbloguje.businessRules;

import cz.speedygonzales.bantherbloguje.entities.Something;

/**
 * @author vondracek
 * @since 15.8.2016 16:02
 */
public interface BusinessRuleGateway {

    Something getSomething(String id);

    void startTransaction();

    void saveSomething(Something thing);

    void endTransaction();

}
