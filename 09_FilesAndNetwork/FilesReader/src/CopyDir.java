import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopyDir {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь до папки, которую копируем:");
        String originPath = scanner.nextLine();

        System.out.println("Введите путь до папки, куда копируем:");
        String copyPath = scanner.nextLine();

        File originFile = new File(originPath);
        File copyFile = new File(copyPath);

        if(!originFile.exists()) {
            System.out.println("Каталог по указанному пути не существует.");
        } else {
            try {
                copyDir(originFile, copyFile);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Копирование завершено успешно.");
    }

    public static void copyDir(File src, File dest) throws IOException {
        if(src.isDirectory()) {
            if(!dest.exists()) {
                dest.mkdir();
            }
            String[] files = src.list();
            if(files != null) {
                for(String file : files) {
                    File srcFile = new File(src, file);
                    File destFile = new File(dest, file);
                    copyDir(srcFile, destFile);
                }
            }
        } else {
            Files.copy(src.toPath(), dest.toPath(), REPLACE_EXISTING);
        }
    }
}
