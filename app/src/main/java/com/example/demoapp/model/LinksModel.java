package com.example.demoapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LinksModel implements Serializable {
    @SerializedName("mission_patch")
    String mission_patch;

    @SerializedName("mission_patch_small")
    String mission_patch_small;

    @SerializedName("article_link")
    String article_link;

    public String getArticle_link() {
        return article_link;
    }

    public void setArticle_link(String article_link) {
        this.article_link = article_link;
    }

    public String getMission_patch() {
        return mission_patch;
    }

    public void setMission_patch(String mission_patch) {
        this.mission_patch = mission_patch;
    }

    public String getMission_patch_small() {
        return mission_patch_small;
    }

    public void setMission_patch_small(String mission_patch_small) {
        this.mission_patch_small = mission_patch_small;
    }

    @Override
    public String toString() {
        return "{" +
                "mission_patch='" + mission_patch + '\'' +
                ", mission_patch_small='" + mission_patch_small + '\'' +
                ", article_link='" + article_link + '\'' +
                '}';
    }
}
