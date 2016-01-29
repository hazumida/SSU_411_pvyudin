import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Павел on 21.01.2016.
 */
public class Второе_Задание {
    public static double multiplication (Object a, Object b) {
        double Result;
        Result = Double.parseDouble((String) a) * Double.parseDouble((String) b);
        return Result;
    }

    public static double division (Object a, Object b) {
        double Result;
        Result = Double.parseDouble((String) a) / Double.parseDouble((String) b);
        return Result;
    }

    public static double addition (Object a, Object b) {
        double Result;
        Result = Double.parseDouble((String) a) + Double.parseDouble((String) b);
        return Result;
    }

    public static double minus (Object a, Object b) {
        double Result;
        Result = Double.parseDouble((String) a) - Double.parseDouble((String) b);
        return Result;
    }

    public static double power (Object a, Object b) {
        double Result = 1;
        int n = Integer.parseInt((String) b);
        for (int i=1; i<=n; i++)
        {
            Result = Result * (Double.parseDouble((String) a));
        }
        return Result;
    }

    public static void main(String[] args) {
        int brake = 1;
        while (brake == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите арифметическое выражение = ");
            String line = scanner.nextLine();
            if (line.toLowerCase().equals("close")) {
                brake = 0;
                System.out.println("Спасибо что использовали консольный калькулятор!!!");
            }
            else {
                String tolerance[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "(", "-", "^", "/", "+", "*", ")" };
                int intLine = line.length();
                int n = 0;
                String newLine = "";
                //Убираем символы которые не входят в допущенные
                while (n != intLine) {
                    for (int i = 0; i <= 16; i++) {
                        if (line.substring(n, n+1).equals(tolerance[i])) {
                            newLine = newLine + tolerance[i];
                            i = 17;
                        }
                    }
                    n = n + 1;
                }
                if (newLine.length() != 0) {
                    int error = 0;
                    n = 0;
                    for (int i = 0; i<=10; i++) {
                        if (newLine.substring(0,1).equals(tolerance[i])) {
                            error = 0;
                            i=12;
                            int block = 0;
                            int blockOperation = 0;
                            String chislo = "";
                            String skobkanachalo = "";
                            String skobkakonec = "";
                            ArrayList pravilnoe_virajenie = new ArrayList();
                            int intnewstroka = newLine.length();
                            //Проверка на ошибки
                            while (intnewstroka != n) {
                                if (skobkanachalo.length()>0) {
                                    if (newLine.substring(n, n+1).equals(tolerance[11])) {
                                        chislo = chislo + tolerance[11];
                                    }
                                    else {
                                        block = 0;
                                        blockOperation = 1;
                                        pravilnoe_virajenie.add(skobkanachalo);
                                        skobkanachalo = "";
                                    }
                                }

                                if (block == 0) {
                                    for (int t = 0; t <=9; t++) {
                                        if (newLine.substring(n, n+1).equals(tolerance[t])) {
                                            chislo = chislo + tolerance[t];
                                            blockOperation = 0;
                                        }
                                    }
                                }

                                if (newLine.substring(n, n+1).equals(tolerance[10]))
                                {
                                    skobkanachalo = skobkanachalo + tolerance[10];
                                    pravilnoe_virajenie.add(chislo);
                                    if (n-1 != -1) {
                                        if (newLine.substring(n-1, n).equals(tolerance[10]) || newLine.substring(n-1, n).equals(tolerance[11]) || newLine.substring(n-1, n).equals(tolerance[12]) || newLine.substring(n-1, n).equals(tolerance[13]) || newLine.substring(n-1, n).equals(tolerance[14]) || newLine.substring(n-1, n).equals(tolerance[15])) {
                                        }
                                        else {
                                            pravilnoe_virajenie.add("*");
                                        }

                                    }
                                    chislo = "";
                                    block = 1;
                                    blockOperation = 1;
                                }

                                if (newLine.substring(n, n+1).equals(tolerance[16]))
                                {
                                    skobkakonec = skobkakonec + tolerance[16];
                                    block = 1;
                                    blockOperation = 0;
                                    pravilnoe_virajenie.add(chislo);
                                    chislo = "";
                                    pravilnoe_virajenie.add(skobkakonec);
                                    skobkakonec = "";
                                }

                                if (blockOperation == 0)
                                {
                                    for (int t = 11; t <=15; t++)
                                    {
                                        if (newLine.substring(n, n+1).equals(tolerance[t]))
                                        {
                                            pravilnoe_virajenie.add(chislo);
                                            chislo = "";
                                            if (n + 1 == intnewstroka)
                                            {

                                            }
                                            else
                                            {
                                                pravilnoe_virajenie.add(tolerance[t]);
                                            }
                                            blockOperation = 1;
                                            block = 0;
                                        }
                                    }
                                }
                                n = n+1;
                            }
                            pravilnoe_virajenie.add(chislo);
                            ArrayList newpravilnoe_virajenie = new ArrayList();
                            for (int k = 0; k<pravilnoe_virajenie.size(); k ++)
                            {
                                if (pravilnoe_virajenie.get(k).equals(""))
                                {

                                }
                                else
                                {
                                    newpravilnoe_virajenie.add(pravilnoe_virajenie.get(k).toString());
                                }
                            }


                            /////|||||||\\\\\\\\
                            int kolvoscobok = 0;
                            for (int k = 0; k<newpravilnoe_virajenie.size(); k ++)
                            {
                                if (newpravilnoe_virajenie.get(k).equals("("))
                                {
                                    kolvoscobok = kolvoscobok + 1;
                                }
                            }
                            kolvoscobok = kolvoscobok + 1;

                            int kolvoscobok1 = 0;
                            for (int k = 0; k<newpravilnoe_virajenie.size(); k ++)
                            {
                                if (newpravilnoe_virajenie.get(k).equals(")"))
                                {
                                    kolvoscobok1 = kolvoscobok1 + 1;
                                }
                            }

                            while (kolvoscobok - 1 != kolvoscobok1)
                            {
                                kolvoscobok1 = kolvoscobok1 + 1;
                                newpravilnoe_virajenie.add(")");
                            }

                            while (kolvoscobok != 0)
                            {
                                int[] nachalo = new int [kolvoscobok];
                                int[] konec = new int [kolvoscobok];
                                int peremenaya1 = 0, peremenaya2 = 0;
                                int open = 0;
                                for (int q = 0; q<=kolvoscobok - 1; q ++)
                                {
                                    konec[q] = -1;
                                    nachalo[q] = 0;
                                }
                                for (int k = 0; k<newpravilnoe_virajenie.size(); k ++)
                                {
                                    if (newpravilnoe_virajenie.get(k).equals("("))
                                    {
                                        nachalo[peremenaya1] = k;
                                        open = open + 1;
                                        peremenaya2 = peremenaya1;
                                        peremenaya1 = peremenaya1 + 1;
                                    }
                                    if (open > 0)
                                    {
                                        if (newpravilnoe_virajenie.get(k).equals(")"))
                                        {
                                            while (konec[peremenaya2] != -1)
                                            {
                                                peremenaya2 = peremenaya2 - 1;
                                            }
                                            konec[peremenaya2] = k;
                                            open = open - 1;
                                            peremenaya2 = peremenaya2 - 1;
                                        }
                                    }
                                }
                                for (int q = 0; q<=kolvoscobok - 1; q ++)
                                {
                                    if (konec[q] == -1)
                                    {
                                        konec[q] = newpravilnoe_virajenie.size()-1;
                                    }
                                }

                                //////////////////////////
                                int nachalootrezka = 0, konecotrezka = 0;
                                int min = 100;
                                for (int q = 0; q<=kolvoscobok - 1; q ++)
                                {
                                    if (min > konec[q] - nachalo[q])
                                    {
                                        min = konec[q] - nachalo[q];
                                        nachalootrezka = nachalo[q];
                                        konecotrezka = konec[q];
                                    }
                                }

                                for (int p = nachalootrezka; p<=konecotrezka; p++)
                                {
                                    if (newpravilnoe_virajenie.get(p).equals("^"))
                                    {
                                        Object obj2 = newpravilnoe_virajenie.get(p + 1);
                                        Object obj1 = newpravilnoe_virajenie.get(p - 1);
                                        double result = power(obj1, obj2);
                                        String result1 = String.valueOf(result);
                                        newpravilnoe_virajenie.remove(p + 1);
                                        newpravilnoe_virajenie.set(p, result1);
                                        newpravilnoe_virajenie.remove(p - 1);
                                        p = nachalootrezka;
                                        konecotrezka = konecotrezka - 2;
                                    }
                                }

                                for (int p = nachalootrezka; p<=konecotrezka; p++)
                                {
                                    if (newpravilnoe_virajenie.get(p).equals("*"))
                                    {
                                        Object obj2 = newpravilnoe_virajenie.get(p + 1);
                                        Object obj1 = newpravilnoe_virajenie.get(p - 1);
                                        double result = multiplication(obj1, obj2);
                                        String result1 = String.valueOf(result);
                                        newpravilnoe_virajenie.remove(p + 1);
                                        newpravilnoe_virajenie.set(p, result1);
                                        newpravilnoe_virajenie.remove(p - 1);
                                        p = nachalootrezka;
                                        konecotrezka = konecotrezka - 2;
                                    }
                                    if (newpravilnoe_virajenie.get(p).equals("/"))
                                    {
                                        Object obj2 = newpravilnoe_virajenie.get(p + 1);
                                        Object obj1 = newpravilnoe_virajenie.get(p - 1);
                                        double result = division(obj1, obj2);
                                        newpravilnoe_virajenie.remove(p + 1);
                                        String result1 = String.valueOf(result);
                                        newpravilnoe_virajenie.set(p, result1);
                                        newpravilnoe_virajenie.remove(p - 1);
                                        p = nachalootrezka;
                                        konecotrezka = konecotrezka - 2;
                                    }
                                }

                                for (int p = nachalootrezka; p<=konecotrezka; p++)
                                {
                                    if (newpravilnoe_virajenie.get(p).equals("+"))
                                    {
                                        Object obj2 = newpravilnoe_virajenie.get(p + 1);
                                        Object obj1 = newpravilnoe_virajenie.get(p - 1);
                                        double result = addition(obj1, obj2);
                                        String result1 = String.valueOf(result);
                                        newpravilnoe_virajenie.remove(p + 1);
                                        newpravilnoe_virajenie.set(p, result1);
                                        newpravilnoe_virajenie.remove(p - 1);
                                        p = nachalootrezka;
                                        konecotrezka = konecotrezka - 2;
                                    }
                                    if (newpravilnoe_virajenie.get(p).equals("-"))
                                    {
                                        Object obj2 = newpravilnoe_virajenie.get(p + 1);
                                        Object obj1 = newpravilnoe_virajenie.get(p - 1);
                                        double result = minus(obj1, obj2);
                                        String result1 = String.valueOf(result);
                                        newpravilnoe_virajenie.remove(p + 1);
                                        newpravilnoe_virajenie.set(p, result1);
                                        newpravilnoe_virajenie.remove(p - 1);
                                        p = nachalootrezka;
                                        konecotrezka = konecotrezka - 2;
                                    }
                                }

                                if ((konecotrezka-nachalootrezka)==2)
                                {
                                    newpravilnoe_virajenie.remove(konecotrezka);
                                    newpravilnoe_virajenie.remove(nachalootrezka);
                                }
                                for (int z =0; z<newpravilnoe_virajenie.size(); z ++)
                                {
                                    System.out.println(newpravilnoe_virajenie.get(z));
                                }

                                kolvoscobok = kolvoscobok - 1;

                            }

                            ////////////////////////////////////
                        }
                        else
                        {
                            error = 1;
                        }
                    }
                    if (error ==1)
                    {
                        System.out.println("Ошибка в написание арифметического выражения!!!");
                    }
                }
                else
                {
                    System.out.println("Ошибка в написание арифметического выражения!!!");
                }

            }
        }
    }
}
