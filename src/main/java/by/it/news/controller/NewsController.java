package by.it.news.controller;

import by.it.news.entity.News;
import by.it.news.service.NewsService;
import by.it.news.service.NewsServiceException;
import by.it.news.service.validation.NewsValidatorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

import static by.it.news.controller.ConstantValues.*;

@Controller
@RequestMapping("/")
public class NewsController {

    @Autowired
    private NewsService newsService;
    private static final LocalDate DATE = LocalDate.now();
    private static final Logger logger = LogManager.getLogger(NewsController.class);


    @RequestMapping("/main")
    public String mainPage(Model model, HttpSession session) {
        List<News> listOfNews = null;
        String page = MAIN_PAGE;

        try {
            listOfNews = newsService.allNews();
        } catch (NewsServiceException e) {
            logger.error(e);
            page = ERROR_PAGE;
        }

        model.addAttribute("listOfNews", listOfNews);
        session.setAttribute("savedRequest", MAIN_PAGE);
        return page;
    }


    @GetMapping(value = "/createnews")
    public String createNews(HttpServletRequest request, Model model) {
        if (request.getParameter("validationError") != null) {
            model.addAttribute("validationError", VALIDATION_ERROR);
        }
        News news = new News();
        model.addAttribute(news);
        request.getSession().setAttribute("savedRequest", CREATE_PAGE);
        return CREATE_PAGE;
    }


    @PostMapping(value = "/create")
    public String createNews(@ModelAttribute("news") News news) {

        String page = MAIN_PAGE;
        news.setDate(DATE);

        try {
            newsService.createNews(news);
        } catch (NewsValidatorException e) {
            logger.error("Data validation error", e);
            page = CREATE_PAGE_VALIDATION_ERROR;
        } catch (NewsServiceException e) {
            logger.error("News create error", e);
            page = ERROR_PAGE;
        }
        return REDIRECT + page;
    }


    @RequestMapping("/editnews")
    public String editNews(Model model, HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        if (request.getParameter("validationError") != null) {
            model.addAttribute("validationError", VALIDATION_ERROR);
        }
        String page = EDIT_PAGE;
        News news = null;

        try {
            news = newsService.newsById(id);
        } catch (NewsServiceException e) {
            logger.error(e);
            page = ERROR_PAGE;
        }

        model.addAttribute("news", news);
        request.getSession().setAttribute("savedRequest", EDIT_PAGE_CHANGE_LOCALE + id);
        return page;
    }


    @PostMapping(value = "/edit")
    public String editNews(@ModelAttribute("news") News news) {

        String page = MAIN_PAGE;
        try {
            newsService.updateNews(news);
        } catch (NewsValidatorException e) {
            logger.error("Data validation error", e);
            page = EDIT_PAGE_VALIDATION_ERROR + news.getId();
        } catch (NewsServiceException e) {
            logger.error("News create error", e);
            page = ERROR_PAGE;
        }
        return REDIRECT + page;
    }


    @RequestMapping("/viewnews")
    public String viewNews(@RequestParam("id") int id, Model model, HttpSession session) {

        String page = VIEW_PAGE;
        News news = null;

        try {
            news = newsService.newsById(id);
        } catch (NewsServiceException e) {
            logger.error(e);
            page = ERROR_PAGE;
        }

        model.addAttribute("news", news);
        session.setAttribute("savedRequest", VIEW_PAGE_CHANGE_LOCALE + id);
        return page;
    }


    @RequestMapping(value = "/deletenews")
    public String deleteNews(@RequestParam(NEWS_DELETE_ID) String[] deleteList) {

        int id;
        String page = MAIN_PAGE;

        for (String del : deleteList) {
            id = Integer.parseInt(del);
            try {
                newsService.deleteNews(id);
            } catch (NewsServiceException e) {
                logger.error("News delete error", e);
                page = ERROR_PAGE;
            }
        }
        return REDIRECT + page;
    }


    @RequestMapping("/changeLocale")
    public String changeLocale(@RequestParam("locale") String locale, HttpSession session) {
        session.setAttribute("locale", locale);
        String savedRequest = (String) session.getAttribute("savedRequest");
        return REDIRECT + savedRequest;
    }
}