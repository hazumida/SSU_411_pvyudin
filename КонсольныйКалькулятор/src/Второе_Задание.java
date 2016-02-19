import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Павел on 21.01.2016.
 */
public class Второе_Задание {
    public static double multiplication(Object a, Object b) {
        double Result;
        Result = Double.parseDouble((String) a) * Double.parseDouble((String) b);
        return Result;
    }

    public static double division(Object a, Object b) {
        double Result;
        Result = Double.parseDouble((String) a) / Double.parseDouble((String) b);
        return Result;
    }

    public static double addition(Object a, Object b) {
        double Result;
        Result = Double.parseDouble((String) a) + Double.parseDouble((String) b);
        return Result;
    }

    public static double minus(Object a, Object b) {
        double Result;
        Result = Double.parseDouble((String) a) - Double.parseDouble((String) b);
        return Result;
    }

    public static double power(Object a, Object b) {
        double Result = 1;
        int n = Integer.parseInt((String) b);
        for (int i = 1; i <= n; i++) {
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
            } else {
                String tolerance[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "(", "-", "^", "/", "+", "*", ")"};
                int intLine = line.length();
                int n = 0;
                String newLine = "";
                //Убираем символы которые не входят в допущенные
                while (n != intLine) {
                    for (int i = 0; i <= 16; i++) {
                        if (line.substring(n, n + 1).equals(tolerance[i])) {
                            newLine = newLine + tolerance[i];
                            i = 17;
                        }
                    }
                    n = n + 1;
                }
                if (newLine.length() != 0) {
                    int error = 0;
                    n = 0;
                    for (int i = 0; i <= 10; i++) {
                        if (newLine.substring(0, 1).equals(tolerance[i])) {
                            error = 0;
                            i = 12;
                            int block = 0;
                            int blockOperation = 0;
                            String number = "";
                            String BracketBegin = "";
                            String BracketEnd = "";
                            ArrayList CorrectExpression = new ArrayList();
                            int IntNewLine = newLine.length();
                            //Проверка на ошибки
                            while (IntNewLine != n) {
                                if (BracketBegin.length() > 0) {
                                    if (newLine.substring(n, n + 1).equals(tolerance[11])) {
                                        number = number + tolerance[11];
                                    } else {
                                        block = 0;
                                        blockOperation = 1;
                                        CorrectExpression.add(BracketBegin);
                                        BracketBegin = "";
                                    }
                                }

                                if (block == 0) {
                                    for (int t = 0; t <= 9; t++) {
                                        if (newLine.substring(n, n + 1).equals(tolerance[t])) {
                                            number = number + tolerance[t];
                                            blockOperation = 0;
                                        }
                                    }
                                }

                                if (newLine.substring(n, n + 1).equals(tolerance[10])) {
                                    BracketBegin = BracketBegin + tolerance[10];
                                    CorrectExpression.add(number);
                                    if (n - 1 != -1) {
                                        if (newLine.substring(n - 1, n).equals(tolerance[10]) || newLine.substring(n - 1, n).equals(tolerance[11]) || newLine.substring(n - 1, n).equals(tolerance[12]) || newLine.substring(n - 1, n).equals(tolerance[13]) || newLine.substring(n - 1, n).equals(tolerance[14]) || newLine.substring(n - 1, n).equals(tolerance[15])) {
                                        } else {
                                            CorrectExpression.add("*");
                                        }

                                    }
                                    number = "";
                                    block = 1;
                                    blockOperation = 1;
                                }

                                if (newLine.substring(n, n + 1).equals(tolerance[16])) {
                                    BracketEnd = BracketEnd + tolerance[16];
                                    block = 0;
                                    blockOperation = 0;
                                    CorrectExpression.add(number);
                                    number = "";
                                    CorrectExpression.add(BracketEnd);
                                    BracketEnd = "";
                                }

                                if (blockOperation == 0) {
                                    for (int t = 11; t <= 15; t++) {
                                        if (newLine.substring(n, n + 1).equals(tolerance[t])) {
                                            CorrectExpression.add(number);
                                            number = "";
                                            if (n + 1 == IntNewLine) {

                                            } else {
                                                CorrectExpression.add(tolerance[t]);
                                            }
                                            blockOperation = 1;
                                            block = 0;
                                        }
                                    }
                                }
                                n = n + 1;
                            }
                            CorrectExpression.add(number);
                            ArrayList newCorrectExpression = new ArrayList();
                            for (int k = 0; k < CorrectExpression.size(); k++) {
                                if (CorrectExpression.get(k).equals("")) {

                                } else {
                                    newCorrectExpression.add(CorrectExpression.get(k).toString());
                                }
                            }

                            ArrayList LastNewCorrectExpression = new ArrayList();
                            int flag = 0;
                            for (int k = 0; k < newCorrectExpression.size(); k++) {
                                if ((k + 1) != newCorrectExpression.size()) {
                                    for (int l = 0; l <=9; l++) {
                                        if (newCorrectExpression.get(k).equals(")") && newCorrectExpression.get(k + 1).toString().substring(newCorrectExpression.get(k).toString().length()-1, newCorrectExpression.get(k).toString().length()).equals(tolerance[l])) {
                                            LastNewCorrectExpression.add(newCorrectExpression.get(k));
                                            LastNewCorrectExpression.add("*");
                                            flag = 1;
                                        }
                                    }

                                    if (newCorrectExpression.get(k+1).equals(")")) {
                                        for (int l = 0; l <=9; l++) {
                                            if (newCorrectExpression.get(k).toString().substring(newCorrectExpression.get(k).toString().length()-1, newCorrectExpression.get(k).toString().length()).equals(tolerance[l]) || newCorrectExpression.get(k).equals(tolerance[16])) {
                                                flag = 0;
                                                l = 10;
                                            }
                                            else {
                                                flag = 1;
                                            }
                                        }
                                    }
                                }

                                if (k == newCorrectExpression.size() - 1) {
                                    for (int l = 0; l <= 9; l++) {
                                        if (newCorrectExpression.get(k).toString().substring(newCorrectExpression.get(k).toString().length()-1, newCorrectExpression.get(k).toString().length()).equals(tolerance[l])) {
                                            flag = 0;
                                            l = 10;
                                        } else {
                                            flag = 1;
                                        }
                                    }
                                }

                                if (flag != 1) {
                                    LastNewCorrectExpression.add(newCorrectExpression.get(k));
                                }
                                flag = 0;
                            }

                            int QuantityBracket = 0;
                            for (int k = 0; k < LastNewCorrectExpression.size(); k++) {
                                if (LastNewCorrectExpression.get(k).equals("(")) {
                                    QuantityBracket = QuantityBracket + 1;
                                }
                            }
                            QuantityBracket = QuantityBracket + 1;

                            int QuantityBracket1 = 0;
                            for (int k = 0; k < LastNewCorrectExpression.size(); k++) {
                                if (LastNewCorrectExpression.get(k).equals(")")) {
                                    QuantityBracket1 = QuantityBracket1 + 1;
                                }
                            }

                            while (QuantityBracket - 1 != QuantityBracket1) {
                                QuantityBracket1 = QuantityBracket1 + 1;
                                LastNewCorrectExpression.add(")");
                            }

                            while (QuantityBracket != 0) {
                                int[] begin = new int[QuantityBracket];
                                int[] end = new int[QuantityBracket];
                                int variable1 = 0, variable2 = 0;
                                int open = 0;
                                for (int q = 0; q <= QuantityBracket - 1; q++) {
                                    end[q] = -1;
                                    begin[q] = 0;
                                }
                                for (int k = 0; k < LastNewCorrectExpression.size(); k++) {
                                    if (LastNewCorrectExpression.get(k).equals("(")) {
                                        begin[variable1] = k;
                                        open = open + 1;
                                        variable2 = variable1;
                                        variable1 = variable1 + 1;
                                    }
                                    if (open > 0) {
                                        if (LastNewCorrectExpression.get(k).equals(")")) {
                                            while (end[variable2] != -1) {
                                                variable2 = variable2 - 1;
                                            }
                                            end[variable2] = k;
                                            open = open - 1;
                                            variable2 = variable2 - 1;
                                        }
                                    }
                                }
                                for (int q = 0; q <= QuantityBracket - 1; q++) {
                                    if (end[q] == -1) {
                                        end[q] = LastNewCorrectExpression.size() - 1;
                                    }
                                }

                                int BeginSegment = 0, EndSegment = 0;
                                int min = 100;
                                for (int q = 0; q <= QuantityBracket - 1; q++) {
                                    if (min > end[q] - begin[q]) {
                                        min = end[q] - begin[q];
                                        BeginSegment = begin[q];
                                        EndSegment = end[q];
                                    }
                                }

                                for (int p = BeginSegment; p <= EndSegment; p++) {
                                    if (LastNewCorrectExpression.get(p).equals("^")) {
                                        Object obj2 = LastNewCorrectExpression.get(p + 1);
                                        Object obj1 = LastNewCorrectExpression.get(p - 1);
                                        double result = power(obj1, obj2);
                                        String result1 = String.valueOf(result);
                                        LastNewCorrectExpression.remove(p + 1);
                                        LastNewCorrectExpression.set(p, result1);
                                        LastNewCorrectExpression.remove(p - 1);
                                        p = BeginSegment;
                                        EndSegment = EndSegment - 2;
                                    }
                                }

                                for (int p = BeginSegment; p <= EndSegment; p++) {
                                    if (LastNewCorrectExpression.get(p).equals("*")) {
                                        Object obj2 = LastNewCorrectExpression.get(p + 1);
                                        Object obj1 = LastNewCorrectExpression.get(p - 1);
                                        double result = multiplication(obj1, obj2);
                                        String result1 = String.valueOf(result);
                                        LastNewCorrectExpression.remove(p + 1);
                                        LastNewCorrectExpression.set(p, result1);
                                        LastNewCorrectExpression.remove(p - 1);
                                        p = BeginSegment;
                                        EndSegment = EndSegment - 2;
                                    }
                                    if (LastNewCorrectExpression.get(p).equals("/")) {
                                        Object obj2 = LastNewCorrectExpression.get(p + 1);
                                        Object obj1 = LastNewCorrectExpression.get(p - 1);
                                        double result = division(obj1, obj2);
                                        LastNewCorrectExpression.remove(p + 1);
                                        String result1 = String.valueOf(result);
                                        LastNewCorrectExpression.set(p, result1);
                                        LastNewCorrectExpression.remove(p - 1);
                                        p = BeginSegment;
                                        EndSegment = EndSegment - 2;
                                    }
                                }

                                for (int p = BeginSegment; p <= EndSegment; p++) {
                                    if (LastNewCorrectExpression.get(p).equals("+")) {
                                        Object obj2 = LastNewCorrectExpression.get(p + 1);
                                        Object obj1 = LastNewCorrectExpression.get(p - 1);
                                        double result = addition(obj1, obj2);
                                        String result1 = String.valueOf(result);
                                        LastNewCorrectExpression.remove(p + 1);
                                        LastNewCorrectExpression.set(p, result1);
                                        LastNewCorrectExpression.remove(p - 1);
                                        p = BeginSegment;
                                        EndSegment = EndSegment - 2;
                                    }
                                    if (LastNewCorrectExpression.get(p).equals("-")) {
                                        Object obj2 = LastNewCorrectExpression.get(p + 1);
                                        Object obj1 = LastNewCorrectExpression.get(p - 1);
                                        double result = minus(obj1, obj2);
                                        String result1 = String.valueOf(result);
                                        LastNewCorrectExpression.remove(p + 1);
                                        LastNewCorrectExpression.set(p, result1);
                                        LastNewCorrectExpression.remove(p - 1);
                                        p = BeginSegment;
                                        EndSegment = EndSegment - 2;
                                    }
                                }

                                if ((EndSegment - BeginSegment) == 2) {
                                    LastNewCorrectExpression.remove(EndSegment);
                                    LastNewCorrectExpression.remove(BeginSegment);
                                }

                                QuantityBracket = QuantityBracket - 1;

                            }
                            for (int z = 0; z < LastNewCorrectExpression.size(); z++) {
                                System.out.println("Ответ = " + LastNewCorrectExpression.get(z));
                            }

                        } else {
                            error = 1;
                        }
                    }
                    if (error == 1) {
                        System.out.println("Ошибка в написание арифметического выражения!!!");
                    }
                } else {
                    System.out.println("Ошибка в написание арифметического выражения!!!");
                }

            }
        }
    }
}
