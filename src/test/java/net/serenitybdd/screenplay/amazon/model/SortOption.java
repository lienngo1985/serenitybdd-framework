package net.serenitybdd.screenplay.amazon.model;

public enum SortOption {
    PublicationDate("Publication Date"),
    Features("Featured");

    private String text;

    SortOption(String text){
        this.text = text;
    }

    public String get(){
        return this.text;
    }
}
