package com.startopole.model.viewModel;

import com.startopole.model.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class IndexViewModel {

    private int id;
    private String title;

    public IndexViewModel() {
    }

    public IndexViewModel(int id, String title) {
        this.id = id;
        this.title = title;
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

    public List getAllArticle(List<Article> articleList){

        List<IndexViewModel> indexViewList = new ArrayList<IndexViewModel>();

        for (Article a:articleList) {
            indexViewList.add(new IndexViewModel(a.getId(), a.getTitle()));
        }

        return indexViewList;
    }
}
