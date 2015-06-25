package kjkrol.mappers;

import kjkrol.mappers.sample.Address;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

/**
 * @author Karol Krol
 */
public class ObjectMappingTestCase {

    protected static final Address PATTERN_ADDRESS = new Address("Zabki", "Orla", 8);
    protected static final String CAN_NOT_SERIALIZE_TO = "Can not serialize object to ";
    protected static final String CAN_NOT_DESERIALIZE_FROM = "Can not deserialize object from ";

    protected static InputStream convertsStringToInputStream(final String str) {
        final byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return new ByteArrayInputStream(bytes);
    }

}
