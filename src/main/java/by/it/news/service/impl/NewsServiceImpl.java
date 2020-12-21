package by.it.news.service.impl;

import by.it.news.dao.NewsDaoException;
import by.it.news.dao.NewsDao;
import by.it.news.entity.News;
import by.it.news.service.NewsService;
import by.it.news.service.NewsServiceException;
import by.it.news.service.validation.NewsValidator;
import by.it.news.service.validation.NewsValidatorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    //    private static final Logger logger = Logger.getLogger(NewsServiceImpl.class);
    @Autowired
    private NewsDao newsDao;

/*    @Autowired
    public void setNewsDAO(NewsDao newsDao) {
        this.newsDao = newsDao;
    }*/

    @Autowired
    public void setNewsDao(NewsDao newsDao) {
        this.newsDao = newsDao;
    }


    @Override
    @Transactional
    public void createNews(News news) throws NewsServiceException {
        if (!NewsValidator.isCorrect(news)) {
//            logger.info("Data validation error.");
            throw new NewsValidatorException("Data validation error.");
        }
        try {
            newsDao.create(news);
        } catch (NewsDaoException e) {
            //           logger.error(e);
            throw new NewsServiceException(e);
        }
    }

    @Override
    @Transactional
    public void updateNews(News news) throws NewsServiceException {
        if (!NewsValidator.isCorrect(news)) {
//            logger.info("Data validation error.");
            throw new NewsValidatorException("Data validation error.");
        }
        try {
            newsDao.update(news);
        } catch (NewsDaoException e) {
//            logger.error(e);
            throw new NewsServiceException(e);
        }
    }

    @Override
    @Transactional
    public void deleteNews(int id) throws NewsServiceException {
        try {
            newsDao.delete(id);
        } catch (NewsDaoException e) {
            //           logger.error(e);
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
//            logger.error(e);
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
//            logger.error(e);
            throw new NewsServiceException(e);
        }
        return newsList;
    }
}
