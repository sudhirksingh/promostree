package com.promostree.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


//import javax.ws.rs.ext.ContextResolver;
//import javax.ws.rs.ext.Provider;
//
//
//
//
//import com.fasterxml.jackson.databind.AnnotationIntrospector.Pair;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.promostree.domain.entities.Venue;
//
//@Provider
//public class MyObjectMapperProvider implements ContextResolver<ObjectMapper> {
//
//    final ObjectMapper defaultObjectMapper;
//    final ObjectMapper combinedObjectMapper;
//
//    public MyObjectMapperProvider() {
//        defaultObjectMapper = createDefaultMapper();
//        combinedObjectMapper = createCombinedObjectMapper();
//    }
//
//    @Override
//    public ObjectMapper getContext(Class<?> type) {
//
//        if (type==ObjectMapper.class) {
//            return combinedObjectMapper;
//        } else {
//            return defaultObjectMapper;
//        }
//    }
//
//    private static ObjectMapper createCombinedObjectMapper() {
//
//        Pair combinedIntrospector = createJaxbJacksonAnnotationIntrospector();
//        ObjectMapper result = new ObjectMapper();
//        result.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
//        result.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
//        result.setDeserializationConfig(result.getDeserializationConfig().withAnnotationIntrospector(combinedIntrospector));
//        result.setSerializationConfig(result.getSerializationConfig().withAnnotationIntrospector(combinedIntrospector));
//
//        return result;
//    }
//
//    private static ObjectMapper createDefaultMapper() {
//
//        ObjectMapper result = new ObjectMapper();
//        result.configure(Feature.INDENT_OUTPUT, true);
//        result.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.AUTO_DETECT_FIELDS, true);
//
//        return result;
//    }
//
//    private static Pair createJaxbJacksonAnnotationIntrospector() {
//
//        AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
//        AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
//
//        return new AnnotationIntrospector.Pair(jacksonIntrospector, jaxbIntrospector);
//    }
//}


@Provider
@Produces(MediaType.APPLICATION_JSON)
public class MyObjectMapperProvider implements ContextResolver<ObjectMapper> {


    private final ObjectMapper mapper;

    public MyObjectMapperProvider() {
        System.out.println("new ObjectMapperResolver()");
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        System.out.println("ObjectMapperResolver.getContext(...)");
        return mapper;
   
}

}


