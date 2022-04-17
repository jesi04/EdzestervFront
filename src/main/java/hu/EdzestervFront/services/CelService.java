package hu.EdzestervFront.services;

import hu.EdzestervFront.domain.Cel;
import hu.EdzestervFront.domain.Felhasznalo;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CelService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:9099";

    public List<Cel> getCelok() {
        String url = API_URL+"/celok";
        Cel[] cel = restTemplate.getForObject(url, Cel[].class);
        return Arrays.asList(cel);
    }

    public Cel getCel(int id) {
        String url = API_URL+"/celok/{id}";
        Cel cel = restTemplate.getForObject(url, Cel.class, id);
        return cel;
    }

    public int addCel(int id, int elerendoSuly, String megjegyzes) {
        String url = API_URL+"/celok";
        Cel cel = new Cel(id, elerendoSuly, megjegyzes);
        HttpEntity<Cel> requestEntity = new HttpEntity<>(cel);
        try {
            ResponseEntity<Cel> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Cel.class);
            return responseEntity.getStatusCodeValue();
        } catch(HttpClientErrorException ex){
            return ex.getStatusCode().value(); // conflict ( létező start number)
        }

    }

    public int updateCel(int id, int elerendoSuly) {
        String url = API_URL+"/celok/{id}";
        Cel cel = new Cel(id, elerendoSuly);

        // az alábbi két sorral állítjuk be a restTemplate példányt arra, hogy tudja kezelni a patch kérést
        // ezért kellett a httpclient dependency a pom.xml-be
        CloseableHttpClient client = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));

        HttpEntity<Cel> requestEntity = new HttpEntity<>(cel);
        ResponseEntity<Cel> responseEntity = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, Cel.class, id);
        return responseEntity.getStatusCodeValue();
    }

    public int deleteCel(int id) {
        System.out.println("Service: "+(id-1));
        String url = API_URL+"/celok/{id}";
        restTemplate.delete(url, id);
        System.out.println("return 100");
        return 100;
    }
}
