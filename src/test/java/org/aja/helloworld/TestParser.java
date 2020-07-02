package org.aja.helloworld;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TestParser {

    protected static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String fixture(String filename) {
        try {
            return Resources.toString(Resources.getResource(filename), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }



    @Test
    public void testObjects() throws Exception {


       /* Map<String, Object> jsonMap = MAPPER.readValue(fixture("options.json"),
                new TypeReference<Map<String,Object>>(){});

        List<Map<String, String>> options = (List<Map<String, String>>) jsonMap.get("options");


        String jsonNode = jsonMap.get("document").toString();

        Map<String, String> jm = MAPPER.readValue(jsonNode,
                new TypeReference<Map<String,String>>(){});

*/

        Map<String, Object> variableData = MAPPER.readValue(fixture("options.json"),
                new TypeReference<Map<String,Object>>(){});


        List<Map<String, Object>> options = (List<Map<String, Object>>) variableData.get("options");
        options.forEach(x -> {
            final Integer partId = (Integer)x.get("partId");
            System.out.println(Integer.valueOf(partId));
            System.out.println(x.get("orgnbr"));
        });



        Map<String, Object> cc = (Map<String, Object>) variableData.get("document");
        Map<String, String> type = (Map<String, String>) cc.get("type");
        String value = type.get("name");

        System.out.println(value);


       /* List<Map<String, Object>> options = (List<Map<String, Object>>) variableData.get("notes");
        options.forEach(x -> {
            System.out.println(x.get("author"));
            System.out.println(x.get("author"));
            System.out.println(LocalDateTime.parse((String) x.get("createdTime"), formatter));
            Long a = (Long) x.get("timeStamp");

            System.out.println(a.intValue());
            System.out.println(x.get("text"));

        });



        System.out.println(options.size());*/
    }
}
