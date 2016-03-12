
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Examples\\Company\\Example\\Company.csv"));
        String line;
        List<String> company = new ArrayList<String>();
        List<String> files = new ArrayList<String>();
        int S1 = 0, S2 = 1 ;
        String word = "";
        while ((line = reader.readLine()) != null) {
            while (line.length() != S1) {
                if (line.substring(S1, S2).equals(";")) {
                    company.add(word);
                    word = "";
                }
                else
                    word = word + line.substring(S1, S2);
                S1 = S1 + 1;
                S2 = S2 + 1;
            }
            word = "";
            S1 = 0; S2 = 1;
        }
        File dir = new File("C:\\Examples\\Company\\Example");
        if(dir.isDirectory()) {
            for(File item : dir.listFiles()){
                if (item.getName().equals("Company.csv") || item.getName().equals("Result.csv")) {
                }
                else {
                    files.add(item.getName());
                }
            }
        }

        int kolTr = 0;
        for (int i = 0; i < files.size(); i++) {
            BufferedReader readerTransaction = new BufferedReader(new FileReader("C:\\Examples\\Company\\Example\\" + files.get(i)));
            List<String> transaction = new ArrayList<String>();
            while ((line = readerTransaction.readLine()) != null) {
                while (line.length() != S1) {
                    if (line.substring(S1, S2).equals(";")) {
                        if (word.equals("Имя отправителя") || word.equals("Лицевой счет отправителя")
                                || word.equals("Имя получателя") || word.equals("Лицевой счет получателя") ||
                                word.equals("Сумма")) {}
                        else {
                            transaction.add(word);
                            kolTr = kolTr + 1;
                        }
                        word = "";
                    }
                    else
                        word = word + line.substring(S1, S2);
                    S1 = S1 + 1;
                    S2 = S2 + 1;
                }
                word = "";
                S1 = 0; S2 = 1;
            }

            System.out.println("Транзакция = " + (i+1));
            int kom1 = 0, kom2 = 1, kom3 = 2, kom4 = 3, kom5 = 4;
            while (transaction.size() > kom2) {
                for (int j = 3; j < company.size(); j = j + 3) {
                    if (company.get(j).equals(transaction.get(kom1)) && company.get(j+1).equals(transaction.get(kom2))) {
                        if (Integer.parseInt(company.get(j+2)) > Integer.parseInt(transaction.get(kom5))) {
                            System.out.println("Операция прошла успешно");
                            company.set(j+2, String.valueOf((Integer.parseInt(company.get(j+2))-Integer.parseInt(transaction.get(kom5)))));
                            for (int k = 3; k < company.size(); k = k + 3) {
                                if (company.get(k).equals(transaction.get(kom3)) && company.get(k+1).equals(transaction.get(kom4))) {
                                    company.set(k+2, String.valueOf((Integer.parseInt(company.get(k+2))+Integer.parseInt(transaction.get(kom5)))));
                                }
                            }
                        }
                        else {
                            System.out.println("Операция не прошла");
                            System.out.println("Компании = " + company.get(j) + " не хватает средств для передачи компании = " + Integer.parseInt(transaction.get(kom3)));
                        }
                    }
                }
                kom1 = kom1 + 5;
                kom2 = kom2 + 5;
                kom3 = kom3 + 5;
                kom4 = kom4 + 5;
                kom5 = kom5 + 5;
            }
        }
        File result = new File("C:\\Examples\\Company\\Example\\Result.csv");
        FileWriter wrt = new FileWriter(result);
        for (int k = 0; k < company.size(); k=k+3) {
            wrt.append(company.get(k) + ";" + company.get(k+1) + ";" + company.get(k+2) + ";" + "\n");
            wrt.flush();
        }


    }
}
