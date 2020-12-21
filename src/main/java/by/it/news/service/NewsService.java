package by.it.news.service;

import by.it.news.entity.News;

import java.util.List;

public interface NewsService {
    void createNews(News news) throws NewsServiceException;
    void updateNews(News news) throws NewsServiceException;
    void deleteNews(int id) throws NewsServiceException;
    News newsById(int id) throws NewsServiceException;
    List<News> allNews() throws NewsServiceException;
}
