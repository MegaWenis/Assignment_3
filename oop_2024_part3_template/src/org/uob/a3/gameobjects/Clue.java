package org.uob.a3.gameobjects;

import java.util.List;

public class Clue extends GameObject {

    //fields unique to clue class
    protected String hint;
    protected List<String> keywords;
    protected int relevance;

    //contructor
    public Clue(String id, String name, String description, List<String> keywords, int relevance, String hint) {
        super(id, name, description);
        this.keywords = keywords;
        this.relevance = relevance;
        this.hint = hint;
    }

    //getters
    public String getHint() {return hint;
    }

    public List<String> getKeywords() {
        return keywords;}


    public int getRelevance() {
        return relevance;
    }

    //clue string
    @Override
    public String toString() {
        return "Clue[id:'" + id + "', name:'" + name + "', description:'" + description +
                "', keywords:" + keywords + ", relevance:" + relevance + ", hint:'" + hint + "']";
    }
}
