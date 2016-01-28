import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Павел on 20.01.2016.
 */
public class Первое_Задание_Вторая_Подзадача
{
    public static void main(String[] args)
    {
        int tormoz = 1;
        Integer month = null;
        while (tormoz == 1)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите номер месяца = ");
            String stroka = scanner.nextLine();
            try
            {
                month = Integer.valueOf(stroka);
                if (month <= 0 || month > 12)
                {
                    System.out.println("Номер месяца должен быть больше нуля и меньше 13");
                }
                else
                {
                    tormoz = 0;
                }

            } catch (NumberFormatException e)
            {
                System.err.println("Пожалуйста введите номер месяца!!!");
            }
        }
        int kolvo = 0;
        int fri = 6;
        //
        ArrayList list = new ArrayList();
        for (int i = 1800; i < 2016; i++)
        {
            Calendar c2 = new GregorianCalendar(i, month-1, 13);
            int chislo = c2.get(Calendar.DAY_OF_WEEK);
            if (fri == chislo)
            {
                list.add(c2.get(Calendar.YEAR));
                kolvo = kolvo + 1;
            }
        }
        System.out.println("Список годов в которых есть пятница 13 заданного месяца:");
        for (int i=0; i<kolvo; i++)
        {
            Object value = list.get(i);
            int a = Integer.parseInt(value.toString());
            System.out.println(a);
        }
        System.out.println("Колличество найденных лет = " + kolvo);
    }
}
