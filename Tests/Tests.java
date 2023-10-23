import news.parser.Article;
import news.parser.ArticleParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Tests {
    private static Logger log;

    @Test
    public void testEmptyFile() throws IOException {
        ArticleParser ap = new ArticleParser();
        ArrayList<Article> articles = ap.createArticle("empty.JSON", log);
        Assert.assertEquals(null, articles);
    }

    @Test
    public void testSingleInput() throws IOException {
        ArticleParser ap = new ArticleParser();
        ArrayList<Article> articles = ap.createArticle("single.JSON", log);
        ArrayList<Article> expected = new ArrayList<>();
        expected.add(new Article("The latest on the coronavirus pandemic and vaccines: Live updates - CNN",
                "The coronavirus pandemic has brought countries to a standstill. Meanwhile, " +
                        "vaccinations have already started in some countries as cases continue to rise. " +
                        "Follow here for the latest.", "2021-03-24T22:32:00Z",
                "https://www.cnn.com/world/live-news/coronavirus-pandemic-vaccine-updates-03-24-21/index.html"));
        Assert.assertEquals(expected, articles);
    }

    @Test
    public void testMultipleInput() throws IOException {
        ArticleParser ap = new ArticleParser();
        ArrayList<Article> articles = ap.createArticle("multiple.JSON", log);
        ArrayList<Article> expected = new ArrayList<>();
        expected.add(new Article("People line the streets of Boulder to honor slain police Officer Eric Talley " +
                "- CNN", "Boulder, Colorado, continued to mourn fallen Officer Eric Talley on Wednesday.",
                "2021-03-24T22:20:12Z", "https://www.cnn.com/2021/03/24/us/officer-talley-" +
                        "procession/index.html"));
        expected.add(new Article("It’s been 20 years since the launch of Mac OS X - Ars Technica",
                "It's macOS 11 now, but the DNA is the same.", "2021-03-24T21:44:01Z",
                "https://arstechnica.com/gadgets/2021/03/its-been-20-years-since-the-launch-of-mac-os-x/"));
        Assert.assertEquals(expected, articles);
    }

    @Test
    public void testBadInput() throws IOException {
        log = Logger.getLogger(ArticleParser.class.getName());
        FileHandler fh = new FileHandler("TestLogFile.log");
        log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        log.info("Logger Initialized");

        ArticleParser ap = new ArticleParser();
        ArrayList<Article> articles = ap.createArticle("bad2.JSON", log);
        Assert.assertEquals(new ArrayList<Article>(), articles);
    }

    @Test
    public void testMixedInput() throws IOException {
        log = Logger.getLogger(ArticleParser.class.getName());
        FileHandler fh = new FileHandler("TestLogFile.log");
        log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        log.info("Logger Initialized");

        ArticleParser ap = new ArticleParser();
        ArrayList<Article> articles = ap.createArticle("mixed.JSON", log);
        ArrayList<Article> expected = new ArrayList<>();
        expected.add(new Article("It’s been 20 years since the launch of Mac OS X - Ars Technica",
                "It's macOS 11 now, but the DNA is the same.", "2021-03-24T21:44:01Z",
                "https://arstechnica.com/gadgets/2021/03/its-been-20-years-since-the-launch-of-mac-os-x/"));
        Assert.assertEquals(expected, articles);

    }
}
