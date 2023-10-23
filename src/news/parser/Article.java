package news.parser;

import java.util.Objects;

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
     * Override of the toString method to better represent the object
     * @return the string that represents the object
     */
    @Override
    public String toString(){
        return String.format("Title: %s%nDescription: %s%nDate Published: %s%nURL: %s%n%n",
                title, description, published, url);
    }

    /**
     * Override of the equals to be more substantial
     * @param o the object being compared
     * @return whether the objects are equivalent
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) && Objects.equals(description, article.description)
                && Objects.equals(published, article.published) && Objects.equals(url, article.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, published, url);
    }
}
