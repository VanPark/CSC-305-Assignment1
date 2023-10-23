package news.parser;


import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Driver {

    /**
     *This is a simple main class that parses the two example files and prints to the console the results of each parse.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(ArticleParser.class.getName());
        FileHandler fh = new FileHandler("MyLogFile.log");
        log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        log.info("Logger Initialized");

        ArticleParser ap = new ArticleParser();
        ArrayList<Article> goodArticles = ap.createArticles("example.JSON", log);
        ArrayList<Article> badArticles = ap.createArticles("bad.JSON", log);
        System.out.println(goodArticles);
        System.out.println(badArticles);
    }
}
