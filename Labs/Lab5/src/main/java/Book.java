import java.io.Serializable;

public class Book extends Document implements Serializable
{
    private String author;

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    private String genre;

    public Book(String id, String Name , String author, String publisher, String datePublished)
    {
        super(id, Name);
        this.author = author;
        this.genre = genre;


    }
    public Book()
    {
        super();
        this.author = "NoAuthor";
        this.genre = "NoGenre";
    }

    public String toString()
    {
        return "Book{" +
                "id" + super.id + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }


}
