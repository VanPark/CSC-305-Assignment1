package news.parser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {
    private final String title;
    private final String description;
    private final String published;
    private final String url;

    public Article(String title, String description, String published, String url) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.url = url;
    }

    /**
     *
     * @return the string that represents the object
     */
    public String toString(){
        return String.format("Title: %s%nDescription: %s%nDate Published: %s%nURL: %s%n%n",
                title, description, published, url);
    }
}
