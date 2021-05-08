package Test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import jsonparsing.Json;

public class jsonparsingTest {
	private String simpleTestCaseJsonSrc = "{\"productName\":\"Testcase Product\",\"price\":22.5,\"quantity\":80,\"date\":\"12/13/2021\",\"status\":[{\"isAvailable\":true,\"warehouse\":\"center\"},{\"isAvailable\":false,\"warehouse\":\"none\"}]}";

	@Test
	public void testParse() {
		try {
			JsonNode node = Json.parse(simpleTestCaseJsonSrc);
			assertEquals(node.get("productName").asText(), "Testcase Product");
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testFromJson() {
		try {
			JsonNode node = Json.parse(simpleTestCaseJsonSrc);
			SimpleTestcaseJsonPOJO pojo = Json.fromJson(node, SimpleTestcaseJsonPOJO.class);
			assertEquals(pojo.getProductName(), "Testcase Product");
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testToJson() {
		SimpleTestcaseJsonPOJO pojo = new SimpleTestcaseJsonPOJO("Testcase Product 2", 21.50, 90);
		JsonNode node = Json.toJson(pojo);
		assertEquals(node.get("productName").asText(),"Testcase Product 2" );
	}
	@Test
	public void testStringify() {
		SimpleTestcaseJsonPOJO pojo = new SimpleTestcaseJsonPOJO("Testcase Product 2", 21.50, 90);
		JsonNode node = Json.toJson(pojo);
		try {
			System.out.println(Json.stringify(node));
			System.out.println(Json.prettyPrint(node));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void dayTest() throws JsonMappingException, JsonProcessingException {
		JsonNode node = Json.parse(simpleTestCaseJsonSrc);
		SimpleTestcaseJsonPOJO pojo = Json.fromJson(node, SimpleTestcaseJsonPOJO.class);
		System.out.println(pojo.getDate());
		assertEquals(pojo.getDate().toString(),"2021-12-13" );

	}
	@Test
	public void listTest() throws JsonMappingException, JsonProcessingException {
		JsonNode node = Json.parse(simpleTestCaseJsonSrc);
		SimpleTestcaseJsonPOJO pojo = Json.fromJson(node, SimpleTestcaseJsonPOJO.class);
		for(SimpleTestcaseStatusPOJO o : pojo.getStatus()) {
			System.out.println("isAvailable : "+ o.isAvailable());
			System.out.println("warehouse : "+ o.getWarehouse());
		}
	}

}
