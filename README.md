# Overview

This project is kind of proof of concept wich shows that Java beans in Java8 could be serialized (transformed to XML/JSON/YAML etc.) as easily as case classes in Scala.
Projects provides wrappers over jackson mappers for converting between 
Java objects (instances of JDK provided core classes, beans), and matching constructs like: JSON, XML or YAML. <br/>
Those wrappers limit the set of functionality to two main methods:

  - serialize
  - deserialize

If Java 8 compiler "-parameters" option is turn on there is not need to use annotations for 
Jackson Data Processor to enable deserialization to POJO.
 
## Building

Project building process is configured and managed by Maven 3.x.

## Code & dependencies

Lombok additions for the Java programming language is used.

## Example of usage

Let consider the class:

```java
@lombok.Value
class Address {

    final private String city;

    final private String street;

    final private int number;
}
```

Initialize the `Address` object:

```java
final Address address = new Address("City", "street", 1);
```

- To ***`serialize`*** this object to JSON format:

```java
final String json = ObjectMappers.JSON_MAPPER.serialize(address)
                            .orElseThrow(() -> new Exception("Can not serialize object to JSON"));
```

The result of serialization is a String object:

```json
{"city":"Zabki","street":"Orla","number":8}
```

It is also option to serialize Java object to the specific OutputStream:

```
this.getObjectMapping().serialize(outputStream, address);
```

- To ***`deserialize`*** it back to Java object:


```java
final Address address2 = ObjectMappers.JSON_MAPPER.deserialize(inputStream, Address.class)
                .orElseThrow(() -> new Exception("Can not deserialize object from JSON"));                                        
```

The same options are available for XML and YAML mappers.

## Limitations

It is impossible to deserialize (from XML or Json) immutable non annotated POJO.
Jackson could deserialize object only if it provides:

- a default constructor, or
- one of its constructors, have to be annotated using @JsonCreator

It is because JVM bytecode does not contain names of method or constructor arguments, so this is the special case where actual name is required. 


***To broke that limitation*** code must be compiled with Java 8 compliant compiler with option to store formal 
parameter names turned on (-parameters option).

Compilation setup example:

```xml

    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.3</version>
        <configuration>
            <source>${java.version}</source>
            <target>${java.version}</target>
            <showDeprecation>true</showDeprecation>
            <showWarnings>true</showWarnings>
            <optimize>true</optimize>
            <compilerArgs>
                <!-- new Java 8 option to store formal parameter names of methods and constructors -->
                <arg>-parameters</arg>
            </compilerArgs>
        </configuration>
    </plugin>

```

## References

* [Extension for Jackson JSON processor that adds support for serializing POJOs as XML](https://github.com/FasterXML/jackson-dataformat-xml)  
* [Jackson module to add YAML backend](https://github.com/FasterXML/jackson-dataformat-yaml)  
* [Extension module that adds support for JDK8 datatypes before core Jackson can support them](https://github.com/FasterXML/jackson-module-parameter-names)
* [Lombok](https://github.com/rzwitserloot/lombok)

