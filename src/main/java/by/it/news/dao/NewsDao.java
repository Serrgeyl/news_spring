package by.it.news.dao;

import by.it.news.entity.News;

import java.util.List;

public interface NewsDao {
    void create(News news) throws NewsDaoException;
    void update(News news) throws NewsDaoException;
    void delete(int id) throws NewsDaoException;
    News newsById(int id) throws NewsDaoException;
    List<News> allNews() throws NewsDaoException;
}
