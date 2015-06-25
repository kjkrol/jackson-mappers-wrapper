package map;

import map.sample.Address;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

/**
 * @author Karol Krol
 */
public class ObjectMappingTestCase {

    private static final String PATTERN_JSON = "{\"city\":\"Zabki\",\"street\":\"Orla\",\"number\":8}";
    private static final String PATTERN_XML = "<Address xmlns=\"\"><city>Zabki</city><street>Orla</street><number>8</number></Address>";
    private static final Address PATTERN_ADDRESS = new Address("Zabki", "Orla", 8);

    private static final String CAN_NOT_SERIALIZE_TO = "Can not serialize object to ";
    private static final String CAN_NOT_DESERIALIZE_FROM = "Can not deserialize object from ";


    @Test
    public void serializeToJsonTest() {
        final ObjectMapping mapping = ObjectMappers.JSON_MAPPING;
        final String json = mapping.serialize(PATTERN_ADDRESS)
                .orElseThrow(() -> new AssertionError(CAN_NOT_SERIALIZE_TO + "JSON"));
        assertEquals(PATTERN_JSON, json);
    }

    @Test
    public void deserializeFromJsonTest() {
        final ObjectMapping mapping = ObjectMappers.JSON_MAPPING;
        final InputStream inputStream = convertsStringToInputStream(PATTERN_JSON);
        final Address address = mapping.deserialize(inputStream, Address.class)
                .orElseThrow(() -> new AssertionError(CAN_NOT_DESERIALIZE_FROM +  "JSON"));
        assertEquals(PATTERN_ADDRESS, address);
    }

    @Test
    public void serializeToXmlTest() {
        final ObjectMapping mapping = ObjectMappers.XML_MAPPING;
        final String xml = mapping.serialize(PATTERN_ADDRESS)
                .orElseThrow(() -> new AssertionError(CAN_NOT_SERIALIZE_TO + "XML"));
        System.out.println("#####" + xml);
        assertEquals(PATTERN_XML, xml);
    }

    @Test
    public void deserializeFromXmlTest() {
        final ObjectMapping mapping = ObjectMappers.XML_MAPPING;
        final InputStream inputStream = convertsStringToInputStream(PATTERN_XML);
        final Address address = mapping.deserialize(inputStream, Address.class)
                .orElseThrow(() -> new AssertionError(CAN_NOT_DESERIALIZE_FROM + "XML"));
        assertEquals(PATTERN_ADDRESS, address);
    }

    private static InputStream convertsStringToInputStream(final String str) {
        final byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return new ByteArrayInputStream(bytes);
    }

}
