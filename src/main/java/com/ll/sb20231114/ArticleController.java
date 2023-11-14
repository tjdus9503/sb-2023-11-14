package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArticleController {
    private List<Article> articles = new ArrayList<>();

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @GetMapping("/article/doWrite")
    @ResponseBody
    RsData doWrite(
            String title,
            String body
    ) {
        Article article = new Article(articles.size() + 1, title, body);
        articles.add(article);

        RsData rs = new RsData(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),
                article
        );

        String resultCode = rs.getResultCode();
        String msg = rs.getMsg();
        Article _article = (Article) rs.getData(); // 과거의 Object 방식은 수동형변환이 필요하다.

        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articles.getLast();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articles;
    }
}

@AllArgsConstructor
@Getter
class RsData {
    private String resultCode;
    private String msg;
    private Object data;
}

@AllArgsConstructor
@Getter
class Article {
    private long id;
    private String title;
    private String body;
}