

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.olegivanov.PhoneBook;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PhoneBookTest {
    PhoneBook book;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void beforeEach() {
        book = new PhoneBook();
        System.out.println("Book example unit created");
    }

    @AfterEach
    public void afterEach() {
        book = null;
        System.out.println("Book example unit terminated");
    }

    @ParameterizedTest
    @MethodSource("parametersForAdd")
    public void testAdd(String name, int number) {
        int expected = 1;
        int actual = book.add(name, number);
        // then:
        Assertions.assertEquals(expected, actual);

    }

    @ParameterizedTest
    @MethodSource("parametersForAdd")
    public void testFindByNumber(String name, int number) {
        book.add(name, number);
        String actual = book.findByNumber(number);
        Assertions.assertEquals(name, actual);
    }

    @ParameterizedTest
    @MethodSource("parametersForAdd")
    public void testFindByName(String name, int number) {
        book.add(name, number);
        int actual = book.findByName(name);
        Assertions.assertEquals(number, actual);
    }

    @ParameterizedTest
    @MethodSource("parametersForAdd")
    public void testPrintAllNames(String name, int number) {
        System.setOut(new PrintStream(outputStreamCaptor));
        book.add(name, number);
        book.printAllNames();
        String expected = "Name: - Anton, Phone: - 9877737";
        Assertions.assertEquals(expected, outputStreamCaptor.toString()
                .trim());
        System.setOut(standardOut);
    }

    static Stream<Arguments> parametersForAdd() {
        return Stream.of(
                arguments("Anton", 9877737)
        );
    }
}
