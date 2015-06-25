package kjkrol.mappers;

import kjkrol.mappers.sample.Address;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Test {@link ObjectMappers#XML_MAPPER}.
 * @author Karol Krol
 */
public class XmlMapperTestCase extends ObjectMappingTestCase {

    private static final String PATTERN_XML = "<Address xmlns=\"\"><city>Zabki</city><street>Orla</street><number>8</number></Address>";

    @Test
    public void serializeToXmlTest() {
        final ObjectMapping mapping = ObjectMappers.XML_MAPPER;
        final String xml = mapping.serialize(PATTERN_ADDRESS)
                .orElseThrow(() -> new AssertionError(CAN_NOT_SERIALIZE_TO + "XML"));
        assertEquals(PATTERN_XML, xml);
    }

    @Test
    public void deserializeFromXmlTest() {
        final ObjectMapping mapping = ObjectMappers.XML_MAPPER;
        final InputStream inputStream = convertsStringToInputStream(PATTERN_XML);
        final Address address = mapping.deserialize(inputStream, Address.class)
                .orElseThrow(() -> new AssertionError(CAN_NOT_DESERIALIZE_FROM + "XML"));
        assertEquals(PATTERN_ADDRESS, address);
    }
}
