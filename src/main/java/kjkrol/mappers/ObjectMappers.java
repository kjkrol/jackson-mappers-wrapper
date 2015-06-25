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
public class ObjectMappers {

    /**
     * Serialize/deserialize to/from matching JSON constructs
     */
    public static final ObjectMapping JSON_MAPPER = () -> {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new ParameterNamesModule());
        return objectMapper;
    };

    /**
     * Serialize/deserialize to/from matching XML constructs
     */
    public static final ObjectMapping XML_MAPPER = () -> {
        final ObjectMapper objectMapper = new XmlMapper();
        objectMapper.registerModule(new ParameterNamesModule());
        return objectMapper;
    };

    /**
     * Serialize/deserialize to/from matching YAML constructs
     */
    public static final ObjectMapping YAML_MAPPER = () -> {
        final ObjectMapper objectMapper = new YAMLMapper();
        objectMapper.registerModule(new ParameterNamesModule());
        return objectMapper;
    };

}
