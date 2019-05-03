package com.startopole.controller;

import com.startopole.model.entity.Article;
import com.startopole.model.viewModel.ArticlesViewModel;
import com.startopole.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    private Article articleToEdit;
    private static final String UPLOAD_DIRECTORY ="/resources/uploaded";

    @RequestMapping("/articles")
    public String articles(Map<String, Object> map){

        ArticlesViewModel articlesViewModel = new ArticlesViewModel();
        map.put("article",articlesViewModel);
        map.put("articleList",articlesViewModel.getAllArticle(articleService.getAllArticle()));
        return "articles";
    }

    @RequestMapping(value = {"/articles_management"})
    public String articles_management(Map<String, Object> map){

        Article article = new Article();
        article.setId(((Article)(articleService.getAllArticle().get(0))).getId());
        map.put("article", article);
        map.put("articleList", articleService.getAllArticle());
        return "articles_management";
    }

    @RequestMapping("/editArticle")
    public String editArticle(Map<String, Object> map, HttpSession session){

        Article article = new Article();
        article.setContent(articleToEdit.getContent());
        article.setId(articleToEdit.getId());
        article.setAdded_date(articleToEdit.getAdded_date());

        map.put("article", article);
        map.put("old_article",articleToEdit);
        return "editArticle";
    }

    @RequestMapping("/newArticle")
    public String newArticle(Map<String, Object> map){

        Article article = new Article();
        map.put("article", article);
        return "newArticle";
    }

    @RequestMapping(value="/article.do", method= RequestMethod.POST)
    public String doActions(@ModelAttribute Article article, @RequestParam String action, Map<String, Object> map,
                            @RequestParam(required = false) CommonsMultipartFile file, HttpSession session) throws Exception {

        Article articleResult = new Article();

        if ("add".equals(action.toLowerCase())) {
            articleService.add(article);
            articleResult = article;

            int fileid = ((Article)(articleService.getAllArticle().get(0))).getId();

            fileUpload(file, session, fileid);

        } else if ("edit".equals(action.toLowerCase())) {
            articleService.edit(article);
            articleResult = article;

            if (!file.isEmpty())
                fileUpload(file, session, article.getId());

        } else if ("delete".equals(action.toLowerCase())) {
            articleService.delete(article.getId());
            articleResult = new Article();

            ServletContext context = session.getServletContext();

            String filepath = context.getRealPath(UPLOAD_DIRECTORY)+"/img_"+article.getId()+".jpg";

            File temp_file = new File(filepath);
            boolean deleted = temp_file.delete();

        } else if ("back".equals(action.toLowerCase())) {
            return "redirect:/adminPanel";

        } else if ("redirect".equals(action.toLowerCase())) {
            return "redirect:/newArticle";

        } else if ("rededit".equals(action.toLowerCase())) {
            articleToEdit = articleService.getArticle(article.getId());
            return "redirect:/editArticle";
        }

        map.put("article", articleResult);
        map.put("articleList", articleService.getAllArticle());
        return "redirect:/articles_management";
    }

    private void fileUpload(CommonsMultipartFile file, HttpSession session, int fileid) throws Exception {
        try {
            ServletContext context = session.getServletContext();
            String path = context.getRealPath(UPLOAD_DIRECTORY);
            String filename = "img_"+fileid+".jpg";

            System.out.println(path + " " + filename);

            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                    new File(path + File.separator + filename)));
            stream.write(bytes);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not uploaded");
        }
    }
}
