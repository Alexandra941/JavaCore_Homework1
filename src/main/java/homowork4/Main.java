package homowork4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        findUniqueWords();

        phonebook();
    }

    private static void findUniqueWords() {
        String[] words = new String[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++)
            words[i] = lastNameDictionary[random.nextInt(lastNameDictionary.length -1)];
        System.out.println("Исходный массив слов: " + Arrays.toString(words));
        String[] uniqueWords = Arrays.stream(words).distinct().toArray(String[]::new);
        System.out.println("Уникальные слова в массиве: " + Arrays.toString(uniqueWords));
    }

    private static void phonebook() {
        Phonebook phonebook = new Phonebook(new ArrayList<Person>());

        Random random = new Random();

        String nonUniquePerson = lastNameDictionary[8];

        for (String lastName : lastNameDictionary) {
            phonebook.add(lastName, phoneNumberDictionary[random.nextInt(phoneNumberDictionary.length - 1)]);
            if (lastName.equalsIgnoreCase(nonUniquePerson)) {
                phonebook.add(lastName, phoneNumberDictionary[random.nextInt(phoneNumberDictionary.length - 1)]);
                phonebook.add(lastName, phoneNumberDictionary[random.nextInt(phoneNumberDictionary.length - 1)]);
                phonebook.add(lastName, phoneNumberDictionary[random.nextInt(phoneNumberDictionary.length - 1)]);
            }
        }

        System.out.println("Номера телефонов для фамилии " + lastNameDictionary[14] + ": "  + phonebook.get(lastNameDictionary[14]));
        System.out.println("Номера телефонов для фамилии " + nonUniquePerson + ": "  + phonebook.get(nonUniquePerson));
    }

    private static String[] lastNameDictionary = new String[] {
            "Смирнов",
            "Иванов",
            "Кузнецов",
            "Соколов",
            "Попов",
            "Петров",
            "Лебедев",
            "Козлов",
            "Новиков",
            "Морозов",
            "Волков",
            "Соловьёв",
            "Васильев",
            "Зайцев",
            "Павлов",
            "Семёнов",
            "Виноградов",
            "Богданов",
            "Воробьёв",
            "Фёдоров",
            "Михайлов",
            "Беляев"
    };

    private static String[] phoneNumberDictionary = new String[] {
            "+7-999-553-34-50",
            "+7-495-545-74-21",
            "+7-985-199-96-03",
            "+7-926-988-62-04",
            "+7-925-211-59-23",
            "+7-495-507-58-17",
            "+7-985-811-15-73",
            "+7-925-922-28-38",
            "+7-915-022-27-95",
            "+7-495-798-62-97",
            "+7-495-922-77-03",
            "+7-967-222-73-53",
            "+7-925-664-62-12",
            "+7-495-798-92-14",
            "+7-495-796-17-89",
            "+7-495-411-22-95",
            "+7-925-769-89-76",
            "+7-495-744-33-52",
            "+7-915-370-60-30",
            "+7-495-211-55-61",
            "+7-495-798-59-84",
            "+7-495-643-68-43",
            "+7-495-504-99-01",
            "+7-495-644-66-72",
            "+7-495-796-63-80",
            "+7-932-000-76-99",
            "+7-968-070-15-55"
    };
}
