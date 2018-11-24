package cz.speedygonzales.map;

import java.util.Map;

public interface MapInterface extends Map {


    Map getInnerMap();

    void setInnerMap(Map innerMap);

    String getInnerAttribute();

    void setInnerAttribute(String innerAttribute);

}
