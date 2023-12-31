package news.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticleParser {

    /**
     * This method takes in a JSON file and parses the information into article objects
     * @param fileName the given filePath
     * @param log the logger that is meant to handle exceptions
     * @return a list of Articles parsed form the
     * @throws IOException
     */
    public ArrayList<Article> createArticles(String fileName, Logger log)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode jn = mapper.readTree(new File(fileName));
        JsonNode articles = jn.get("articles");
        if (articles == null){
            return new ArrayList<>();
        }
        ArrayList<Article> aList = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++){
            try {
                String title = articles.get(i).get("title").asText();
                String description = articles.get(i).get("description").asText();
                String date = articles.get(i).get("publishedAt").asText();
                String url = articles.get(i).get("url").asText();
                aList.add(new Article(title, description, date, url));
            }
            catch(NullPointerException ex){
                log.log(Level.WARNING, String.format("Null field encountered at index %d", i), ex.getCause());
            }
        }
        return aList;
    }
}
