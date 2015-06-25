package kjkrol.mappers;

import com.fasterxml.jackson.xml.XmlMapper;
import org.codehaus.jackson.map.ObjectMapper;

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
    public static final ObjectMapping JSON_MAPPER = () -> new ObjectMapper();

    /**
     * Serialize/deserialize to/from matching XML constructs
     */
    public static final ObjectMapping XML_MAPPER = () -> new XmlMapper();
}
