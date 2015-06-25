package map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * This mapper wraps exiting jackson mappers (or, data binder, or codec) to provides basic functionality for
 * converting between Java objects (instances of JDK provided core classes, beans), and matching
 * constructs (like JSON or XML).
 *
 * @author Karol Krol
 */
public interface ObjectMapping {

    Logger LOGGER = LoggerFactory.getLogger(ObjectMapping.class);

    ObjectMapper getMapper();

    default Optional<String> serialize(Object object) {
        try {
            return Optional.of(this.getMapper().writeValueAsString(object));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    default <V> Optional<V> deserialize(InputStream inputStream, Class<V> clazz) {
        try {
            final V object = this.getMapper().readValue(inputStream, clazz);
            return Optional.of(object);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }
}
