package kjkrol.mappers;

import kjkrol.mappers.sample.Address;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Test {@link ObjectMappers#JSON_MAPPER}.
 *
 * @author Karol Krol
 */
public class JsonMapperTestCase extends ObjectMappingTestCase {

    private static final String PATTERN_JSON = "{\"city\":\"Zabki\",\"street\":\"Orla\",\"number\":8}";


    @Test
    public void serializeToJsonTest() {
        final ObjectMapping mapping = ObjectMappers.JSON_MAPPER;
        final String json = mapping.serialize(PATTERN_ADDRESS)
                .orElseThrow(() -> new AssertionError(CAN_NOT_SERIALIZE_TO + "JSON"));
        assertEquals(PATTERN_JSON, json);
    }

    @Test
    public void deserializeFromJsonTest() {
        final ObjectMapping mapping = ObjectMappers.JSON_MAPPER;
        final InputStream inputStream = convertsStringToInputStream(PATTERN_JSON);
        final Address address = mapping.deserialize(inputStream, Address.class)
                .orElseThrow(() -> new AssertionError(CAN_NOT_DESERIALIZE_FROM + "JSON"));
        assertEquals(PATTERN_ADDRESS, address);
    }
}
