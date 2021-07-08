package Serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pojo.PetPojo;

import java.io.File;
import java.io.IOException;

public class SerializationIntrp {

    @Test
    public void test1() throws IOException {
        PetPojo pojo = new PetPojo();

        pojo.setId(711);
        pojo.setName("hatiko");
        pojo.setStatus("waiting");


        File file = new File("pet.json");
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(file,pojo);
    }
}
