package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("--------");

        // Text JSON -> Object
        // Object -> Text JSON

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        // object가 text로 바뀔 때는 object mapper가 get method를 활용한다
        // 그러므로 object 내 getter가 없으면 값을 얻어올 수 없다
        var user = new User("steve", 10, "010-1234-1234");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> object
        // text가 object로 바뀌려면 해당 object에 default 생성자가 있어야 한다(object mapper가 default 생성자를 필요로 함)
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
