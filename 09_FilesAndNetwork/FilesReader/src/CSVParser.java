import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {

    public static final String CSV_PATH = "C:\\Users\\Андрей\\Desktop\\movementList.csv";

    public static void main(String[] args) {
        try {
            System.out.println("Сумма доходов: " + getIncome(CSV_PATH) + " " + getCurrencyValue(CSV_PATH));
            System.out.println("Сумма расходов: " + getOutcome(CSV_PATH) + " " + getCurrencyValue(CSV_PATH));
            System.out.println("Сумма расходов по организациям:");
            List<String> outcomeList = getOutcomeList(CSV_PATH);
            outcomeList.forEach(s -> System.out.println(s + " руб."));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCurrencyValue(String path) throws Exception {
        List<String> files = Files.readAllLines(Paths.get(path));
        files.remove(0);
        String currency = null;
        for(String data : files) {
            String[] dataString = data.split(",", 3);
            currency = dataString[2].substring(0, dataString[2].indexOf(","));
        }
        return currency;
    }

    public static double getIncome(String path) throws Exception {
        List<String> files = Files.readAllLines(Paths.get(path));
        files.remove(0);
        double income = 0;
        for(String data : files) {
            String[] dataString = data.split(",");
            List<String> dataList = new ArrayList<>();
            for(int i = 0; i < dataString.length; i++) {
                if(i == dataString.length - 1 & !dataString[i].contains("\"")) {
                    dataList.add(dataString[i]);
                    continue;
                }
                if(dataString[i].contains("\"") & dataString[i + 1].contains("\"")) {
                    String str1 = dataString[i] + "." + dataString[i + 1];
                    dataList.add(str1.substring(1, str1.length() - 1));
                    i++;
                } else {
                    dataList.add(dataString[i]);
                }
            }
            if(dataList.size() != 8) {
                throw new Exception("Неверный формат строки");
            } else {
                income = income + Double.parseDouble(dataList.get(6));
            }
        }
        return income;
    }

    public static double getOutcome(String path) throws Exception {
        List<String> files = Files.readAllLines(Paths.get(path));
        files.remove(0);
        double outcome = 0;
        for(String data : files) {
            String[] dataString = data.split(",");
            List<String> dataList = new ArrayList<>();
            for(int i = 0; i < dataString.length; i++) {
                if(i == dataString.length - 1 & !dataString[i].contains("\"")) {
                    dataList.add(dataString[i]);
                    continue;
                }
                if(dataString[i].contains("\"") & dataString[i + 1].contains("\"")) {
                    String str1 = dataString[i] + "." + dataString[i + 1];
                    dataList.add(str1.substring(1, str1.length() - 1));
                    i++;
                } else {
                    dataList.add(dataString[i]);
                }
            }
            if(dataList.size() != 8) {
                throw new Exception("Неверный формат строки");
            } else {
                outcome = outcome + Double.parseDouble(dataList.get(7));
            }
        }
        return outcome;
    }

    public static List<String> getOutcomeList(String path) throws Exception {
        List<String> files = Files.readAllLines(Paths.get(path));
        files.remove(0);
        List<String> dataListOutcome = new ArrayList<>();
        for(String data : files) {
            String[] dataString = data.split(",");
            List<String> dataList = new ArrayList<>();
            for(int i = 0; i < dataString.length; i++) {
                if(i == dataString.length - 1 & !dataString[i].contains("\"")) {
                    dataList.add(dataString[i]);
                    continue;
                }
                if(dataString[i].contains("\"") & dataString[i + 1].contains("\"")) {
                    String str1 = dataString[i] + "." + dataString[i + 1];
                    dataList.add(str1.substring(1, str1.length() - 1));
                    i++;
                } else {
                    dataList.add(dataString[i]);
                }
            }
            if(dataList.size() != 8) {
                throw new Exception("Неверный формат строки");
            } else {
                if(Double.parseDouble(dataList.get(7)) != 0) {
                    String replace = dataList.get(5).replace("/", "\\");
                    String substring = replace.substring(replace.indexOf("\\"));
                    String place = substring.substring(0, substring.indexOf("  ")).trim();
                    String out = dataList.get(7);
                    dataListOutcome.add(place + "\t" + out);
                }
            }
        }
        return dataListOutcome;
    }
}
