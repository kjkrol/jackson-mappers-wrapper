package kjkrol.mappers;

/**
 * Test {@link ObjectMappers#YAML_MAPPER}.
 *
 * @author Karol Krol
 */
public class YamlMapperTestCase extends AbstractMapperTestCase {

    private static final String YAML_MSG = "---\n" +
            "city: \"Zabki\"\n" +
            "street: \"Orla\"\n" +
            "number: 8\n";

    private static final String YAML = "YAML";

    @Override
    public ObjectMapping getObjectMapping() {
        return ObjectMappers.YAML_MAPPER;
    }

    @Override
    public String getExpectedPatternMessage() {
        return YAML_MSG;
    }


    @Override
    public String getMessageType() {
        return YAML;
    }

}
