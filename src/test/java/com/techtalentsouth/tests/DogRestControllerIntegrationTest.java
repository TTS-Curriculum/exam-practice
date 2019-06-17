package com.techtalentsouth.tests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techtalentsouth.com.techtalentsouth.data.DogService;
import com.techtalentsouth.com.techtalentsouth.models.Dog;
import com.techtalentsouth.controllers.DogRestController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ExtendWith(SpringExtension.class)
@WebMvcTest(DogRestController.class)
public class DogRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DogService service;

    /**
     * This is a helper method that converts an object to JSON.
     * Feel free to use it throughout this test file.
     */
    static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    @AfterEach
    public void resetDogService() {
        reset(service);
    }

    @Test
    public void postToCreateDogsShouldCreateADog() throws Exception {
        Dog cujo = new Dog("Cujo");
        mvc.perform(post("/dogs").contentType(MediaType.APPLICATION_JSON).content(toJson(cujo)));

        /**
         * If this looks new to you, we're using the Mockito verification assertions instead of the JUnit versions.
         * This is useful since we have a mock MVC controller -- we also get a mock repository within the same context.
         */

        verify(service, VerificationModeFactory.times(1)).createDog(Mockito.any());
    }

    // TODO: Write comprehensive test cases here
}


