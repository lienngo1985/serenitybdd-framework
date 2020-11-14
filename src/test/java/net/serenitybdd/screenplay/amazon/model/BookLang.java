package net.serenitybdd.screenplay.amazon.model;

public enum BookLang {
    English("English"),
    Germany("Germany");

    private String name;

    BookLang(String name){
        this.name = name;
    }

    public String get(){
        return this.name;
    }
}
