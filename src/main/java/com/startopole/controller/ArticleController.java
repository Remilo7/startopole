package com.startopole.controller;

import com.startopole.dao.UserInfoDAO;
import com.startopole.model.Article;
import com.startopole.model.UserInfo;
import com.startopole.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/news")
    public String setupForm(Map<String, Object> map){
        Article article = new Article();
        map.put("article", article);
        map.put("articleList", articleService.getAllArticle());
        return "news";
    }

    @RequestMapping("/articles")
    public String articles(Map<String, Object> map){
        Article article = new Article();
        map.put("article", article);
        map.put("articleList", articleService.getAllArticle());
        return "articles";
    }

    @RequestMapping(value = {"/articles_management"})
    public String articles_management(Map<String, Object> map){
        Article article = new Article();
        map.put("article", article);
        map.put("articleList", articleService.getAllArticle());
        return "articles_management";
    }

    @RequestMapping(value="/editArticle",method = RequestMethod.POST)
    public String editArticle(Model model) {
        model.addAttribute("article", new Article());
        return "articles_management";
    }

    @RequestMapping("/newArticle")
    public String newArticle(Map<String, Object> map){
        Article article = new Article();
        map.put("article", article);
        return "newArticle";
    }

    @RequestMapping(value="/article.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute Article article, BindingResult result, @RequestParam String action, Map<String, Object> map){

        Article articleResult = new Article();

        if ("add".equals(action.toLowerCase())) {
            articleService.add(article);
            articleResult = article;

        } else if ("edit".equals(action.toLowerCase())) {
            articleService.edit(article);
            articleResult = article;

        } else if ("delete".equals(action.toLowerCase())) {
            articleService.delete(article.getId());
            articleResult = new Article();

        } else if ("back".equals(action.toLowerCase())) {
            return "adminPanel";

        } else if ("redirect".equals(action.toLowerCase())) {
            return "newArticle";

        }

        map.put("article", articleResult);
        map.put("articleList", articleService.getAllArticle());
        return "articles_management";
    }
}
