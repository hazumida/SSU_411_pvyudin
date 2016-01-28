import java.util.*;

/**
 * Created by Павел on 20.01.2016.
 */
public class Первое_Задание_Первая_Подзадача
{
    public static void main(String[] args)
    {
        int tormoz=1;
        Integer year = null;
        while (tormoz == 1)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите год = ");
            String stroka = scanner.nextLine();
            try
            {
                year = Integer.valueOf(stroka);
                if (year<=0 || year>2016)
                {
                    System.out.println("Год должен быть больше нуля и меньше 2017 года");
                }
                else
                {
                    tormoz = 0;
                }

            }
            catch (NumberFormatException e)
            {
                System.err.println("Пожалуйста введите год!!!");
            }
        }
        int kolvo = 0;
        int fri = 6;
        ArrayList list = new ArrayList();
        for (int i=0; i<12; i++)
        {
            Calendar c2 = new GregorianCalendar(year, i, 13);
            int chislo = c2.get(Calendar.DAY_OF_WEEK);
            if (fri == chislo)
            {
                list.add(c2.get(Calendar.MONTH));
                kolvo = kolvo + 1;
            }
        }
        String [] month = new String[13];
        month[1] = "Январь";
        month[2] = "Февраль";
        month[3] = "Март";
        month[4] = "Апрель";
        month[5] = "Май";
        month[6] = "Июнь";
        month[7] = "Июль";
        month[8] = "Август";
        month[9] = "Сентябрь";
        month[10] = "Октябрь";
        month[11] = "Ноябрь";
        month[12] = "Декабрь";
        System.out.println("Колличество пятниц 13 в " + year + " = " + kolvo);
        System.out.println("Список месяцев в которых есть пятница 13:");
        for (int i=0; i<kolvo; i++)
        {
            Object value = list.get(i);
            int a = Integer.parseInt(value.toString());
            System.out.println(month[a + 1]);
        }
    }
}
