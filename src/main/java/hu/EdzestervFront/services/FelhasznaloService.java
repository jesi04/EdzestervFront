package hu.EdzestervFront.services;

import hu.EdzestervFront.domain.Edzesterv;
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
public class FelhasznaloService {

    @Autowired
    private RestTemplate restTemplate;
    private final String API_URL = "http://localhost:9099";


    public List<Felhasznalo> getFelhasznalok() {
        String url = API_URL+"/felhasznalok";
        Felhasznalo[] felhasznalo = restTemplate.getForObject(url, Felhasznalo[].class);
        return Arrays.asList(felhasznalo);
    }

    public Felhasznalo getFelhasznalo(int id) {
        String url = API_URL+"/felhasznalok/{id}";
        Felhasznalo felhasznalo = restTemplate.getForObject(url, Felhasznalo.class, id);
        return felhasznalo;
    }

    public int addFelhasznalo(int id, String nev, String email) {
        String url = API_URL+"/felhasznalok";
        Felhasznalo felhasznalo = new Felhasznalo(id, nev, email);
        HttpEntity<Felhasznalo> requestEntity = new HttpEntity<>(felhasznalo);
        try {
            ResponseEntity<Felhasznalo> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Felhasznalo.class);
            return responseEntity.getStatusCodeValue();
        } catch(HttpClientErrorException ex){
            return ex.getStatusCode().value(); // conflict ( létező start number)
        }

    }

    public int updateFelhasznalo(int id, String email) {
        String url = API_URL+"/felhasznalok/{id}";
        Felhasznalo felhasznalo = new Felhasznalo(id, email);

        // az alábbi két sorral állítjuk be a restTemplate példányt arra, hogy tudja kezelni a patch kérést
        // ezért kellett a httpclient dependency a pom.xml-be
        CloseableHttpClient client = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));

        HttpEntity<Felhasznalo> requestEntity = new HttpEntity<>(felhasznalo);
        ResponseEntity<Felhasznalo> responseEntity = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, Felhasznalo.class, id);
        return responseEntity.getStatusCodeValue();
    }

    public int deleteFelhasznalo(int id) {
        System.out.println("Service: "+(id-1));
        String url = API_URL+"/felhasznalok/{id}";
        restTemplate.delete(url, id);
        System.out.println("return 100");
        return 100;
    }

    public List<Edzesterv> getEdzestervek() {
        String url = API_URL+"/edzestervek";
        Edzesterv[] edzesterv = restTemplate.getForObject(url, Edzesterv[].class);
        return Arrays.asList(edzesterv);
    }





}
