package homework7;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя города: ");
            String city = scanner.nextLine();

            System.out.println("Введите 1 для получения погоды на сегодня; " +
                    "Введите 5 для прогноза на 5 дней; " +
                    "Введите 7 для получения данных из базы; " +
                    "Введите 8 для получения данных из базы для города; " + "Для выхода введите \"выход\"");

            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("выход")) break;

            if (!command.equals("1") && !command.equals("5") &&
                !command.equals("7") && !command.equals("8") ) {
                System.out.println("Введен неподдерживаемый код получения погоды.");
                continue;
            }
            try {
                controller.getWeather(command.trim(), city.trim());
            } catch (IOException | IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }
}
