import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Павел on 20.01.2016.
 */
public class Первое_Задание_Вторая_Подзадача {
    public static void main(String[] args) {
        int brake = 1;
        Integer month = null;
        while (brake == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите номер месяца = ");
            String line = scanner.nextLine();
            try {
                month = Integer.valueOf(line);
                if (month <= 0 || month > 12) {
                    System.out.println("Номер месяца должен быть больше нуля и меньше 13");
                }
                else {
                    brake = 0;
                }

            }
            catch (NumberFormatException e) {
                System.err.println("Пожалуйста введите номер месяца!!!");
            }
        }
        int quantity = 0;
        int friday = 6;
        ArrayList list = new ArrayList();
        for (int i = 1800; i < 2016; i++) {
            Calendar calendar = new GregorianCalendar(i, month - 1, 13);
            int number = calendar.get(Calendar.DAY_OF_WEEK);
            if (friday == number) {
                list.add(calendar.get(Calendar.YEAR));
                quantity = quantity + 1;
            }
        }
        System.out.println("Список годов в которых есть пятница 13 заданного месяца:");
        for (int i = 0; i < quantity; i++) {
            Object value = list.get(i);
            int a = Integer.parseInt(value.toString());
            System.out.println(a);
        }
        System.out.println("Колличество найденных лет = " + quantity);
    }
}
