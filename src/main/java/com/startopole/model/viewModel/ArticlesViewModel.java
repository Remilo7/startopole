package com.startopole.model.viewModel;

import com.startopole.model.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticlesViewModel {

    private int id;
    private String title;
    private String content;

    public ArticlesViewModel() {
    }

    public ArticlesViewModel(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List getAllArticle(List<Article> articleList){

        List<ArticlesViewModel> articleViewList = new ArrayList<ArticlesViewModel>();

        for (Article a:articleList) {
            articleViewList.add(new ArticlesViewModel(a.getId(), a.getTitle(), a.getContent()));
        }

        return articleViewList;
    }
}
