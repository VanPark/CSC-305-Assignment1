package news.parser;


import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class main {
    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(ArticleParser.class.getName());
        FileHandler fh = new FileHandler("MyLogFile.log");
        log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        log.info("Logger Initialized");

        ArticleParser ap = new ArticleParser();
        ArrayList<Article> goodArticles = ap.createArticle("example.JSON", log);
        ArrayList<Article> badArticles = ap.createArticle("bad.JSON", log);
        System.out.println(goodArticles);
        System.out.println(badArticles);
    }
}
