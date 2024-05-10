
// Этап-3 = создан пустой класс PhoneBookTest
// Этап-6 = созданы тесты для метода add() с добавлением имени/номеров
// Этап-11 = созданы тесты для метода findByNumber()
// Этап-16 = созданы тесты для метода findByName()

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PhoneBookTest {
    private static PhoneBook phoneBook = null;

    @BeforeAll
    static void setUp() {
        phoneBook = new PhoneBook();
    }

    @ParameterizedTest
    @Order(1)
    @CsvSource(value = {
            "Alex,+79967467991,1",
            "Alex,+79967467991,1",
            "Sophia,+79967467992,2",
            "Jan,+79967467993,3",
            "Alex,+19967467991,3",
            "Jan,+29967467993,3",
            "Peter,+79967467994,4",
            "Alex,+19967467992,4"
    })
    public void add(String name, String phoneNumber, int contactsNumberExpected) {
        int contactsNumber = phoneBook.add(name, phoneNumber);
        Assertions.assertEquals(contactsNumber, contactsNumberExpected);
    }

    @ParameterizedTest
    @Order(2)
    @CsvSource(value = {
            "'',+77777777777",
            "Alex,+79967467991",
            "Sophia,+79967467992",
            "Jan,+79967467993",
            "Alex,+19967467991",
            "Jan,+29967467993",
            "Peter,+79967467994",
            "Alex,+19967467992",
    })
    public void findByNumber(String nameExpected, String phoneNumber) {
        String name = phoneBook.findByNumber(phoneNumber);
        Assertions.assertEquals(name, nameExpected);
    }

    @ParameterizedTest
    @Order(3)
    @CsvSource(value = {
            "Donald,",
            "Alex,'+79967467991,+19967467991,+19967467992'",
            "Sophia,'+79967467992'",
            "Jan,'+79967467993,+29967467993'",
            "Peter,'+79967467994'",
    })
    void findByName(String name, String phones) {
        List<String> phonesExpected = null;
        if (phones != null) {
            phonesExpected = Arrays.stream(phones.split(",")).toList();
        }
        List<String> phonesStored = phoneBook.findByName(name);
        Assertions.assertEquals(phonesStored, phonesExpected);
    }
}
