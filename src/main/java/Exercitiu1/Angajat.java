package Exercitiu1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface Filtru<T>{
    public boolean test(T a);
}

public class Angajat {
    private String nume;
    private String post;
    private LocalDate data_angajarii;
    private float salar;

    public Angajat(String nume, String post, LocalDate data_angajarii, float salar) {
        this.nume = nume;
        this.post = post;
        this.data_angajarii = data_angajarii;
        this.salar = salar;
    }

    public Angajat() {
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", post='" + post + '\'' +
                ", data_angajarii=" + data_angajarii +
                ", salar=" + salar +
                '}';
    }

    public String getNume() {
        return nume;
    }

    public float getSalar() {
        return salar;
    }

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public String getPost() {
        return post;
    }

    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setSalar(float salar) {
        this.salar = salar;
    }

    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file=new File("src/main/resources/angajati.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file=new File("src/main/resources/angajati.json");
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>(){});
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void afisare(List <Angajat> angajati){
        for (Angajat a:angajati) {
            System.out.println(a);
        }
    }
    public static void afisare_filtrata1(List <Angajat> angajati, Filtru<Angajat> f) {
        for (Angajat a : angajati) {
            if (f.test(a))
                System.out.println(a);
        }
    }
    public static void afisare_filtrata2(List <Angajat> angajati, Filtru<Angajat> f) {
        for (Angajat a : angajati) {
            if (f.test(a))
                System.out.println(a.getSalar());

        }
    }

}
