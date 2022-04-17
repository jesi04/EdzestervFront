package hu.EdzestervFront.services;

import hu.EdzestervFront.domain.Felhasznalo;
import hu.EdzestervFront.domain.JavasoltEdzes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class JavasoltEdzesService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:9099";


    public List<JavasoltEdzes> getJavasoltak() {
        String url = API_URL+"/javasoltak";
        JavasoltEdzes[] javasolt = restTemplate.getForObject(url, JavasoltEdzes[].class);
        return Arrays.asList(javasolt);
    }
}
