package com.shridhar.androidassignmentsecond.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardDetails {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("design_type")
    @Expose
    private String designType;
    @SerializedName("card_type")
    @Expose
    private Integer cardType;
    @SerializedName("cards")
    @Expose
    private List<Card> cards = null;
    @SerializedName("is_scrollable")
    @Expose
    private Boolean isScrollable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignType() {
        return designType;
    }

    public void setDesignType(String designType) {
        this.designType = designType;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Boolean getIsScrollable() {
        return isScrollable;
    }

    public void setIsScrollable(Boolean isScrollable) {
        this.isScrollable = isScrollable;
    }

}