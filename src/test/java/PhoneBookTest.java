
// Этап-2 = создан пустой класс PhoneBookTest
// Этап-3+ = созданы тесты для добавления имени/номера

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PhoneBookTest {
    private static PhoneBook phoneBook = null;

    @BeforeAll
    static void setUp() {
        phoneBook = new PhoneBook();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Alex, 89967467999",
            "Sophia, 79967467999",
            "Jan, +79967467999",
            "Alex, +19967467999",
            "Jan, +29967467999",
            "Alex, false"
    })

    public void add(String name, String phoneNumber) {
        int contactsNumber = phoneBook.add(name, phoneNumber);
        Assertions.assertEquals(contactsNumber, phoneBook.getContactsNumber());
    }
}
