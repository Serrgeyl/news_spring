package by.it.news.service.impl;

import by.it.news.dao.NewsDaoException;
import by.it.news.dao.NewsDao;
import by.it.news.entity.News;
import by.it.news.service.NewsService;
import by.it.news.service.NewsServiceException;
import by.it.news.service.validation.NewsValidator;
import by.it.news.service.validation.NewsValidatorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;
    private static final Logger logger = LogManager.getLogger(NewsServiceImpl.class);


    @Override
    @Transactional
    public void createNews(News news) throws NewsServiceException {
        if (!NewsValidator.isCorrect(news)) {
            logger.warn("Data validation error.");
            throw new NewsValidatorException("Data validation error.");
        }
        try {
            newsDao.create(news);
        } catch (NewsDaoException e) {
            logger.error(e);
            throw new NewsServiceException(e);
        }
    }

    @Override
    @Transactional
    public void updateNews(News news) throws NewsServiceException {
        if (!NewsValidator.isCorrect(news)) {
            logger.warn("Data validation error.");
            throw new NewsValidatorException("Data validation error.");
        }
        try {
            newsDao.update(news);
        } catch (NewsDaoException e) {
            logger.error(e);
            throw new NewsServiceException(e);
        }
    }

    @Override
    @Transactional
    public void deleteNews(int id) throws NewsServiceException {
        try {
            newsDao.delete(id);
        } catch (NewsDaoException e) {
            logger.error(e);
            throw new NewsServiceException(e);
        }
    }

    @Override
    @Transactional
    public News newsById(int id) throws NewsServiceException {
        News news;
        try {
            news = newsDao.newsById(id);
        } catch (NewsDaoException e) {
            logger.error(e);
            throw new NewsServiceException(e);
        }
        return news;
    }

    @Override
    @Transactional
    public List<News> allNews() throws NewsServiceException {
        List<News> newsList;
        try {
            newsList = newsDao.allNews();
        } catch (NewsDaoException e) {
            logger.error(e);
            throw new NewsServiceException(e);
        }
        return newsList;
    }
}
