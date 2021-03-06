package io.bootique.config.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JsonNodeYamlParserTest {

	@Test
	public void testApply() {

		InputStream in = new ByteArrayInputStream("a: b\nb: c".getBytes());
		ObjectMapper mapper = new ObjectMapper();

		Optional<JsonNode> node = new JsonNodeYamlParser(mapper).apply(in);
		assertTrue(node.isPresent());

		assertEquals("b", node.get().get("a").asText());
		assertEquals("c", node.get().get("b").asText());
	}

}
