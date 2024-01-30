import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, which animal do you want?");
        Optional<String> animal;

        do {
            animal = thisIsMyUseCase(scanner);
            animal.ifPresentOrElse(
                    a -> System.out.println("We found: " + a),
                    () -> System.out.println("No animal found")
            );

        } while (animal.isEmpty());
    }

    private static Optional<String> thisIsMyUseCase(Scanner scanner) {
        Optional<String> animal;
        String userInput = scanner.nextLine();
        animal = animals().stream()
                .filter(s -> s.equals(userInput))
                .findFirst();

        return animal;
    }

    private static List<String> animals() {
        return List.of("Bobby", "Jean-Claude", "Jean-Bon", "Chick Norris", "Jean-Neymar");
    }
}
