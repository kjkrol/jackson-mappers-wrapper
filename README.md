# Overview
---

Projects provides two wrappers on jackson mappers for converting between 
Java objects (instances of JDK provided core classes, beans), and matching constructs (like JSON or XML). <br/>
Those wrappers limit the set of functionality to two main methods:

  - serialize
  - deserialize
 
## Building
---

Project building process is configured and managed by Maven 3.x.

## Example of usage
---

To serialize/deserialize object:

```java

final Address address = new Address("City", "street", 1);

```

to JSon format use ***ObjectMappers.JSON_MAPPER***

```java

final ObjectMapping mapping = ObjectMappers.JSON_MAPPER;  
final String json = mapping.serialize(address)
                            .orElseThrow(() -> new AssertionError("Can not serialize object to JSON"));
                            
// and deserialize using a given InputStream
final Address address2 = mapping.deserialize(inputStream, Address.class)
                .orElseThrow(() -> new AssertionError("Can not deserialize object from JSON"));
                                  
```

to XML format use ***ObjectMappers.XML_MAPPER***

```java

final ObjectMapping mapping = ObjectMappers.XML_MAPPER;  
final String json = mapping.serialize(address)
                            .orElseThrow(() -> new AssertionError("Can not serialize object to XML"));   
                                                     
```

## References
---

https://github.com/FasterXML/jackson-dataformat-xml
