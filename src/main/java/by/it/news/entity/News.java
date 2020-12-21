package by.it.news.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "news")
public class News implements Serializable {

    private static final long serialVersionUID = 3001009793991920032L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "brief")
    private String brief;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private LocalDate date;

    public News() {
    }

    public News(int id, String title, String brief, String content, LocalDate date) {
        this.id = id;
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.date = date;
    }

    public News(String title, String brief, String content, LocalDate date) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (!title.equals(news.title)) return false;
        if (!brief.equals(news.brief)) return false;
        if (!content.equals(news.content)) return false;
        return date.equals(news.date);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + brief.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
