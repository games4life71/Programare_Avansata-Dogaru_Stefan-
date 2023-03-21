import java.io.Serializable;

public class Article extends  Document implements Serializable
{
    private String author;
    private String publisher;
    private String datePublished;

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public String getDatePublished()
    {
        return datePublished;
    }

    public void setDatePublished(String datePublished)
    {
        this.datePublished = datePublished;
    }

    public Article(String id, String Name , String author, String publisher, String datePublished)
    {
        super(id, Name);
        this.author = author;
        this.publisher = publisher;
        this.datePublished = datePublished;

    }
    public Article()
    {
        super();
    }
    public String toString()
    {
        return "Article{" +
                "id" + super.id + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", datePublished='" + datePublished + '\'' +
                '}';
    }

}
