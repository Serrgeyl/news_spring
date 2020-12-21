package by.it.news.dao.impl;

import by.it.news.dao.NewsDao;
import by.it.news.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDaoImpl implements NewsDao {

    @Autowired
    private SessionFactory mySessionFactory;

    private static final String HQL_SELECT_ALL = "from News";
    private static final String HQL_SELECT_BY_ID = "from News where id =: id";


    @Override
    public void create(News news) {

        Session currentSession = mySessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(news);
    }

    @Override
    public void update(News news) {

        Session currentSession = mySessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(news);
    }

    @Override
    public void delete(int id) {

        Session currentSession = mySessionFactory.getCurrentSession();
        News news = currentSession.load(News.class, id);
        currentSession.delete(news);
    }

    @Override
    public News newsById(int id) {

        Session currentSession = mySessionFactory.getCurrentSession();
        Query<News> theQuery = currentSession.createQuery(HQL_SELECT_BY_ID, News.class);
        theQuery.setParameter("id", id);
        News news = theQuery.uniqueResult();

        return news;
    }

    @Override
    public List<News> allNews() {

        Session currentSession = mySessionFactory.getCurrentSession();
        Query<News> query = currentSession.createQuery(HQL_SELECT_ALL, News.class);
        List<News> news = query.getResultList();

        return news;
    }
}
