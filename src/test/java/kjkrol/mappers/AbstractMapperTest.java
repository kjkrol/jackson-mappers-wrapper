package kjkrol.mappers;

import lombok.Value;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;


/**
 * Abstract test case that could be use by specific {@link ObjectMapping}.
 *
 * @author Karol Krol
 */
public abstract class AbstractMapperTest {

    private static final Address TESTED_OBJECT = new Address("Zabki", "Orla", 8);
    private static final String CAN_NOT_SERIALIZE_TO = "Can not serialize object to ";
    private static final String CAN_NOT_DESERIALIZE_FROM = "Can not deserialize object from ";

    protected abstract ObjectMapping getObjectMapping();

    protected abstract String getExpectedPatternMessage();

    protected abstract String getMessageType();

    @Test
    public void serialize1Test() {
        final String message = this.getObjectMapping().serialize(TESTED_OBJECT)
                .orElseThrow(() -> new AssertionError(CAN_NOT_SERIALIZE_TO + this.getMessageType()));
        assertEquals(this.getExpectedPatternMessage(), message);
    }

    @Test
    public void serialize2Test() {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if (this.getObjectMapping().serialize(outputStream, TESTED_OBJECT)) {
            final String message = new String(outputStream.toByteArray(), StandardCharsets.UTF_8).intern();
            assertEquals(this.getExpectedPatternMessage(), message);
        } else {
            throw new AssertionError(CAN_NOT_SERIALIZE_TO + this.getMessageType());
        }
    }

    @Test
    public void deserializeTest() {
        final InputStream inputStream = this.convertsStringToInputStream(this.getExpectedPatternMessage());
        final Address address = this.getObjectMapping().deserialize(inputStream, Address.class)
                .orElseThrow(() -> new AssertionError(CAN_NOT_DESERIALIZE_FROM + this.getMessageType()));
        assertEquals(TESTED_OBJECT, address);
    }

    private InputStream convertsStringToInputStream(final String str) {
        final byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return new ByteArrayInputStream(bytes);
    }

}

@Value
class Address {

    final private String city;

    final private String street;

    final private int number;

}
