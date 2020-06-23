import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки:");
        String path = scanner.nextLine();

        File file = new File(path);
        List<File> files = getFiles(file);

        long lengthFileBytes = 0;
        for(File item : files) {
            lengthFileBytes = lengthFileBytes + item.length();
        }

        System.out.println("Размер папки: " + getFileSizeToString(lengthFileBytes));
    }

    //метод возвращает лист со всеми вложенными в папку файлами
    public static List<File> getFiles(File file) {
        List<File> fileList = new ArrayList<>();
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null) {
                for(File item : files) {
                    fileList.addAll(getFiles(item));
                }
            }
        } else {
            fileList.add(file);
            return fileList;
        }
        return fileList;
    }

    //возвращает полученный размер файла в читаемом формате
    private static String getFileSizeToString(Long length) {
        if(length < Math.pow(1024, 2)) {
            return new DecimalFormat("#0.00").format((double) length / 1024) + " Кб.";
        }
        if(length < Math.pow(1024, 3)) {
            return new DecimalFormat("#0.00").format((double) length / Math.pow(1024, 2)) + " Мб.";
        }
        if(length >= Math.pow(1024, 3)) {
            return new DecimalFormat("#0.00").format((double) length / Math.pow(1024, 3)) + " Гб.";
        }
        return length + " байт.";
    }
}


