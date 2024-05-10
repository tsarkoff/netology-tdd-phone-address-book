
// Этап-1 = создан пустой Мавен проект
// Этап-2 = создан пустой класс PhoneBook
// Этап-5 = создан пустой метод-заглушка add()
// Этап-8 = реализован метод add() = проходят тесты добавления Контакта без дубликатов и Номеров для Контакта без дубликатов

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, List<String>> contacts = new HashMap<>();

    public int getContactsNumber() {
        return contacts.size();
    }

    public int add(String name, String phoneNumber) {
        // Проверяем, если Контакта в Адресной Книге нет - добавляем:
        if (!contacts.containsKey(name)) {
            List<String> phones = new ArrayList<>();
            phones.add(phoneNumber);
            contacts.put(name, phones);
            // если Контакт есть, добавляем новый номер телефона, исключая дублирование
        } else if (!contacts.get(name).contains(phoneNumber)) {
            contacts.get(name).add(phoneNumber);
        }

        return getContactsNumber();
    }
}
