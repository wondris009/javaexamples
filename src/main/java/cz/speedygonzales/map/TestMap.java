package cz.speedygonzales.map;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Collection;
import java.util.Map;
import java.util.Set;


@JsonSerialize(as = MapInterface.class)
@JsonDeserialize(as = MapInterface.class)
public class TestMap implements MapInterface {

    private Map innerMap;

    private String innerAttribute;

    public TestMap() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return innerMap.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return innerMap.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return innerMap.remove(key);
    }

    @Override
    public void putAll(Map m) {
        innerMap.putAll(m);
    }


    @Override
    public void clear() {

    }

    //
    @Override
    public Set keySet() {
        return innerMap.keySet();
    }

    @Override
    public Collection values() {
        return innerMap.values();
    }

    @Override
    public Set<Entry> entrySet() {
        return innerMap.entrySet();
    }

    public Map getInnerMap() {
        return innerMap;
    }

    public void setInnerMap(Map innerMap) {
        this.innerMap = innerMap;
    }

    public String getInnerAttribute() {
        return innerAttribute;
    }

    public void setInnerAttribute(String innerAttribute) {
        this.innerAttribute = innerAttribute;
    }
}
