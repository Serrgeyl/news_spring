package by.it.news.service.validation;

import by.it.news.entity.News;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsValidator {
    private final static String FILE_NAME = "validator.txt";
    private final static String DEFAULT_SPLITTER = " ";
    private static final Logger logger = LogManager.getLogger(NewsValidator.class);

    public static boolean isCorrect(News news) {
        String file = null;
        boolean res = true;

        String input = news.getTitle() + news.getBrief() + news.getContent();

        try {
            file = NewsValidator.getFile(FILE_NAME);
        } catch (URISyntaxException | IOException e) {
            logger.error(e);
        }
        String[] words = file.split(DEFAULT_SPLITTER);

        for (String word : words) {
            Pattern pattern = Pattern.compile(word);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                res = false;
            }
        }
        return res;
    }

    private static String getFile(String fileName) throws URISyntaxException, IOException {
        URL resource = NewsValidator.class.getResource(String.format("/%s", fileName));
        Path path = Paths.get(resource.toURI());
        String str = Files.readString(path);

        return str;
    }
}




