package kjkrol.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * The store that provide set of implemented {@link ObjectMapping}'s
 *
 * @author Karol Krol
 * @see ObjectMapping
 */
public final class ObjectMappers {

    private static final ObjectMapper JSON_OBJECT_MAPPER = new ObjectMapper().registerModule(new ParameterNamesModule());
    private static final ObjectMapper XML_OBJECT_MAPPER = new XmlMapper().registerModule(new ParameterNamesModule());
    private static final ObjectMapper YAML_OBJECT_MAPPER = new YAMLMapper().registerModule(new ParameterNamesModule());

    /**
     * Serialize/deserialize to/from matching JSON constructs
     */
    public static final ObjectMapping JSON_MAPPER = () -> JSON_OBJECT_MAPPER;

    /**
     * Serialize/deserialize to/from matching XML constructs
     */
    public static final ObjectMapping XML_MAPPER = () -> XML_OBJECT_MAPPER;

    /**
     * Serialize/deserialize to/from matching YAML constructs
     */
    public static final ObjectMapping YAML_MAPPER = () -> YAML_OBJECT_MAPPER;


    private ObjectMappers() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

}
