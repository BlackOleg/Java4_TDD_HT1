

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.olegivanov.PhoneBook;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PhoneBookTest {
    PhoneBook book;

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

    static Stream<Arguments> parametersForAdd() {
        return Stream.of(
                arguments("Anton", 9877737)
        );
    }
}
