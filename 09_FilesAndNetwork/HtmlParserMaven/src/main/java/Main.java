import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://lenta.ru/").get();
            Elements imgList = doc.select("img");
            List<String> srcList = new ArrayList<>();
            imgList.forEach(img -> srcList.add(img.attr("abs:src")));
            for(String src : srcList) {
                if(src.endsWith(".jpg") || src.endsWith(".png")) {
                    URL url = new URL(src);
                    BufferedImage img = ImageIO.read(url);
                    int slashIndex = src.lastIndexOf("/");
                    String fileName = src.substring(slashIndex + 1);
                    ImageIO.write(img, "jpg", ImageIO.createImageOutputStream(new File("src\\main\\resources\\images\\" + fileName)));
                    System.out.println(fileName);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
