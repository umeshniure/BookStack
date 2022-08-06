package com.model;

public class Books {

    protected int id, price, discounted_price, published_year;
    long isbn;
    protected String name, category, description, cover_type, type;
    protected String author, cover_page, publication, language;

    public Books() {
    }

    public Books(long isbn, String bookname, String authorname, String publication, int price, int discounted_price,
            int published_year, String category, String cover_type, String language, String type, String description, String cover_page) {
        super();
        this.isbn = isbn;
        this.name = bookname;
        this.author = authorname;
        this.publication = publication;
        this.price = price;
        this.discounted_price = discounted_price;
        this.category = category;
        this.published_year = published_year;
        this.cover_type = cover_type;
        this.language = language;
        this.type = type;
        this.cover_page = cover_page;
        this.description = description;
    }

    public Books(int id, long isbn, String bookname, String authorname, String publication, int price, int discounted_price,
            int published_year, String category, String cover_type, String language, String type, String description, String cover_page) {
        super();
        this.id = id;
        this.isbn = isbn;
        this.name = bookname;
        this.author = authorname;
        this.publication = publication;
        this.price = price;
        this.discounted_price = discounted_price;
        this.category = category;
        this.published_year = published_year;
        this.cover_type = cover_type;
        this.language = language;
        this.type = type;
        this.cover_page = cover_page;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getISBN() {
        return isbn;
    }

    public void setISBN(long isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String bookname) {
        this.name = bookname;
    }

    public String getAuthorName() {
        return author;
    }

    public void setAuthorName(String authorname) {
        this.author = authorname;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(int discounted_price) {
        this.discounted_price = discounted_price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCover_type() {
        return cover_type;
    }

    public void setCover_type(String cover_type) {
        this.type = cover_type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCover_page() {
        return cover_page;
    }

    public void setCover_page(String cover_page) {
        this.cover_page = cover_page;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublished_year() {
        return published_year;
    }

    public void setPublished_year(int published_year) {
        this.published_year = published_year;
    }

}
