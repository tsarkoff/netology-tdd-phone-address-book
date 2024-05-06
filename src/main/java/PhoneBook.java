
// Этап-1 = создан пустой класс PhoneBook
// Этап-3 = добавлены параметры в метод add() + книга, хранящая уникальную мапу контактов с несколькими телефонными номерами + vметод получения количества контактов

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private int contactsNumber = -1;

    public int getContactsNumber() {
        return contactsNumber;
    }

    public Map<String, List<String>> contacts = new HashMap<>();

    public int add(String name, String phoneNumber) {
        contactsNumber++;
        return 0;
    }
}
