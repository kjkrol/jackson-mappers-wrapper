package kjkrol.mappers;

/**
 * Test {@link ObjectMappers#JSON_MAPPER}.
 *
 * @author Karol Krol
 */
public class JsonMapperTest extends AbstractMapperTest {

    private static final String JSON_MSG = "{\"city\":\"Zabki\",\"street\":\"Orla\",\"number\":8}";

    private static final String JSON = "JSON";

    @Override
    public ObjectMapping getObjectMapping() {
        return ObjectMappers.JSON_MAPPER;
    }

    @Override
    public String getExpectedPatternMessage() {
        return JSON_MSG;
    }

    @Override
    public String getMessageType() {
        return JSON;
    }

}
