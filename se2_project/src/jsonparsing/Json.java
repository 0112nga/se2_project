package jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class Json {
	private static ObjectMapper objectMapper = getDefaultObjectMapper();
	
	private static ObjectMapper getDefaultObjectMapper(){
		if(objectMapper == null) {
			objectMapper = new ObjectMapper();
			objectMapper.registerModule(new JavaTimeModule());
			objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		}
		return objectMapper;
	}
	// parse string to JsonNode
	public static JsonNode parse(String src) throws JsonMappingException, JsonProcessingException {
		return objectMapper.readTree(src);
	}
	
	//convert JsonNode to java Obj
	public static <T> T fromJson(JsonNode node, Class<T> clazz) throws JsonProcessingException, IllegalArgumentException {
		return objectMapper.treeToValue(node, clazz);
	}
	//parse java obj to JsonNode
	public static JsonNode toJson(Object o) {
		return objectMapper.valueToTree(o);
	}
	//parse JsonNode to String
	public static String stringify(JsonNode node) throws JsonProcessingException {
		return generateString(node, false);
	}
	public static String prettyPrint(JsonNode node) throws JsonProcessingException {
		return generateString(node, true);
	}
	private static String generateString(JsonNode node, boolean pretty) throws JsonProcessingException {
		ObjectWriter objectWriter = objectMapper.writer();
		if(pretty) {
			objectWriter = objectWriter.with(SerializationFeature.INDENT_OUTPUT);
		}
		return objectWriter.writeValueAsString(node);
	}

}
