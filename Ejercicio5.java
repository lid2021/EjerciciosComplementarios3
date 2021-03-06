import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ejercicio5 {
    public static void main(String[] args) {
        List<Alumnos> alumnos = List.of(
                new Alumnos("Homero", "Simpson", LocalDate.now().minusYears(30)),
                new Alumnos("Maria", "Perez", LocalDate.of(1956, 5, 12)),
                new Alumnos("Julio", "Smith", LocalDate.of(1990, 2, 10)),
                new Alumnos("Elena", "Barrios", LocalDate.of(2001, 3, 30)),
                new Alumnos("Pedro", "Lobo", LocalDate.of(1954, 2, 5)),
                new Alumnos("Juan", "Martinez", LocalDate.of(1911, 11, 11)));
        Map<String, Integer> alumnosConEdades = alumnos.stream()
                .collect(Collectors
                        .toMap(p-> (p.getName() + " " + p.getSurname()),
                                p -> Ejercicio5.getEdad(p.getBirthday())));
        System.out.println(alumnosConEdades);
    }

    public static Integer getEdad(LocalDate birthDate){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
