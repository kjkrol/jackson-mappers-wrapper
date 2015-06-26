package kjkrol.mappers;

/**
 * Test {@link ObjectMappers#XML_MAPPER}.
 *
 * @author Karol Krol
 */
public class XmlMapperTest extends AbstractMapperTest {

    private static final String XML_MSG = "<Address xmlns=\"\"><city>Zabki</city><street>Orla</street><number>8</number></Address>";

    private static final String XML = "XML";

    @Override
    public ObjectMapping getObjectMapping() {
        return ObjectMappers.XML_MAPPER;
    }

    @Override
    public String getExpectedPatternMessage() {
        return XML_MSG;
    }

    @Override
    public String getMessageType() {
        return XML;
    }
}
