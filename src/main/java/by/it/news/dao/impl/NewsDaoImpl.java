package by.it.news.dao.impl;


import by.it.news.dao.NewsDaoException;
import by.it.news.dao.NewsDao;
import by.it.news.entity.News;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDaoImpl implements NewsDao {


//    private static final Logger logger = LogManager.getLogger(String.valueOf(NewsDaoImpl.class));


    private static final String HQL_SELECT_ALL = "from News";
    private static final String HQL_SELECT_BY_ID = "from News where id =:newsId";

    @Autowired
    private SessionFactory mySessionFactory;


    @Override
    public void create(News news) throws NewsDaoException {

        Session currentSession = mySessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(news);
    }

    @Override
    public void update(News news) throws NewsDaoException {

        Session currentSession = mySessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(news);
    }

    @Override
    public void delete(int id) throws NewsDaoException {
        try {
            Session currentSession = mySessionFactory.getCurrentSession();

            News news = currentSession.load(News.class, id);

            if (null != news) {
                currentSession.delete(news);
            }
        } catch (HibernateException e) {
//            logger.error("Error deleting News /" + e);
            throw new NewsDaoException("Error deleting News /" + e);
        }
    }

    @Override
    public News newsById(int id) throws NewsDaoException {
        Session currentSession = mySessionFactory.getCurrentSession();

        Query<News> theQuery = currentSession.createQuery(HQL_SELECT_BY_ID, News.class);
        theQuery.setParameter("newsId", id);
        News news = theQuery.uniqueResult();

        return news;
    }

    @Override
    public List<News> allNews() throws NewsDaoException {

        Session currentSession = mySessionFactory.getCurrentSession();
        Query<News> query = currentSession.createQuery(HQL_SELECT_ALL, News.class);
        List<News> news = query.getResultList();
        return news;
    }
}
