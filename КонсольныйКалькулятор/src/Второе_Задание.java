import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Павел on 21.01.2016.
 */
public class Второе_Задание
{
    public static double proizvedenie (Object a, Object b)
    {
        double Result;
        Result = Double.parseDouble((String) a) * Double.parseDouble((String) b);
        return Result;
    }

    public static double delenie (Object a, Object b)
    {
        double Result;
        Result = Double.parseDouble((String) a) / Double.parseDouble((String) b);
        return Result;
    }

    public static double slojenie (Object a, Object b)
    {
        double Result;
        Result = Double.parseDouble((String) a) + Double.parseDouble((String) b);
        return Result;
    }

    public static double minus (Object a, Object b)
    {
        double Result;
        Result = Double.parseDouble((String) a) - Double.parseDouble((String) b);
        return Result;
    }

    public static double stepen (Object a, Object b)
    {
        double Result = 1;
        int n = Integer.parseInt((String) b);
        for (int i=1; i<=n; i++)
        {
            Result = Result * (Double.parseDouble((String) a));
        }
        return Result;
    }

    public static void main(String[] args)
    {
        int tormoz = 1;
        while (tormoz == 1)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите арифметическое выражение = ");
            String stroka = scanner.nextLine();
            if (stroka.toLowerCase().equals("close"))
            {
                tormoz = 0;
                System.out.println("Спасибо что использовали консольный калькулятор!!!");
            }
            else
            {
                String dopusk[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "(", "-", "^", "/", "+", "*", ")" };
                int intstroka = stroka.length();
                int n = 0;
                String newstroka = "";
                //Убираем символы которые не входят в допущенные
                while (n != intstroka)
                {
                    for (int i = 0; i<=16; i++)
                    {
                        if (stroka.substring(n, n+1).equals(dopusk[i]))
                        {
                            newstroka = newstroka + dopusk[i];
                            i = 17;
                        }
                    }
                    n = n + 1;
                }
                if (newstroka.length() != 0)
                {
                    int oshibka = 0;
                    n = 0;
                    for (int i = 0; i<=10; i++)
                    {
                        if (newstroka.substring(0,1).equals(dopusk[i]))
                        {
                            oshibka = 0;
                            i=12;
                            int block = 0;
                            int blockoperation = 0;
                            String chislo = "";
                            String skobkanachalo = "";
                            String skobkakonec = "";
                            ArrayList pravilnoe_virajenie = new ArrayList();
                            int intnewstroka = newstroka.length();
                            //Проверка на ошибки
                            while (intnewstroka != n)
                            {
                                if (skobkanachalo.length()>0)
                                {
                                    if (newstroka.substring(n, n+1).equals(dopusk[11]))
                                    {
                                        chislo = chislo + dopusk[11];
                                    }
                                    else
                                    {
                                        block = 0;
                                        blockoperation = 1;
                                        pravilnoe_virajenie.add(skobkanachalo);
                                        skobkanachalo = "";
                                    }
                                }

                                if (block == 0)
                                {
                                    for (int t = 0; t <=9; t++)
                                    {
                                        if (newstroka.substring(n, n+1).equals(dopusk[t]))
                                        {
                                            chislo = chislo + dopusk[t];
                                            blockoperation = 0;
                                        }
                                    }
                                }

                                if (newstroka.substring(n, n+1).equals(dopusk[10]))
                                {
                                    skobkanachalo = skobkanachalo + dopusk[10];
                                    pravilnoe_virajenie.add(chislo);
                                    chislo = "";
                                    block = 1;
                                    blockoperation = 1;
                                }

                                if (newstroka.substring(n, n+1).equals(dopusk[16]))
                                {
                                    skobkakonec = skobkakonec + dopusk[16];
                                    block = 1;
                                    blockoperation = 0;
                                    pravilnoe_virajenie.add(chislo);
                                    chislo = "";
                                    pravilnoe_virajenie.add(skobkakonec);
                                    skobkakonec = "";
                                }

                                if (blockoperation == 0)
                                {
                                    for (int t = 11; t <=15; t++)
                                    {
                                        if (newstroka.substring(n, n+1).equals(dopusk[t]))
                                        {
                                            pravilnoe_virajenie.add(chislo);
                                            chislo = "";
                                            if (n + 1 == intnewstroka)
                                            {

                                            }
                                            else
                                            {
                                                pravilnoe_virajenie.add(dopusk[t]);
                                            }
                                            blockoperation = 1;
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

                            //for (int k = 0; k<newpravilnoe_virajenie.size(); k ++)
                            //{
                            //    System.out.println(newpravilnoe_virajenie.get(k));
                            //}

                            ////////////////////////////////////
                            int kolvoscobok = 0;
                            for (int k = 0; k<newpravilnoe_virajenie.size(); k ++)
                            {
                                if (newpravilnoe_virajenie.get(k).equals("("))
                                {
                                    kolvoscobok = kolvoscobok + 1;
                                }
                            }
                            kolvoscobok = kolvoscobok + 1;

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

                                //System.out.println("///////////////////////");
                                //for (int q = 0; q<=kolvoscobok - 1; q ++)
                                //{
                                //    System.out.println(nachalo[q] + " " + konec[q]);
                                //}

                                //System.out.println("///////////////////////");
                                //System.out.println(min);
                                //System.out.println("Go on =" + nachalootrezka + " " + konecotrezka);
                                //System.out.println("Here");
                                for (int p = nachalootrezka; p<=konecotrezka; p++)
                                {
                                    if (newpravilnoe_virajenie.get(p).equals("^"))
                                    {
                                        Object obj2 = newpravilnoe_virajenie.get(p + 1);
                                        Object obj1 = newpravilnoe_virajenie.get(p - 1);
                                        //System.out.println(obj2);
                                        //System.out.println(obj1);
                                        double result = stepen(obj1, obj2);
                                        String result1 = String.valueOf(result);
                                        //System.out.println(result);
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
                                        double result = proizvedenie(obj1, obj2);
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
                                        double result = delenie(obj1, obj2);
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
                                        double result = slojenie(obj1, obj2);
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
                            oshibka = 1;
                        }
                    }
                    if (oshibka ==1)
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
