package com.model;

public class Books {

    protected int id, category, cover_type, type, language, price, discounted_price, published_year, vendor_id;
    protected long isbn;
    protected String name, description, author, cover_photo, cover_photo_name, publication;

    public Books() {
    }

    public Books(long isbn, String bookname, String authorname, String publication, int price, int discounted_price, int published_year, int category,
            int cover_type, int language, int type, String description, String cover_photo, String cover_photo_name, int vendor_id) {
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
        this.cover_photo = cover_photo;
        this.cover_photo_name = cover_photo_name;
        this.description = description;
        this.vendor_id = vendor_id;
    }

    public Books(int id, long isbn, String bookname, String authorname, String publication, int price, int discounted_price, int published_year, int category,
            int cover_type, int language, int type, String description, String cover_photo, String cover_photo_name, int vendor_id) {
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
        this.cover_photo = cover_photo;
        this.cover_photo_name = cover_photo_name;
        this.description = description;
        this.vendor_id = vendor_id;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(int discounted_price) {
        this.discounted_price = discounted_price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCover_type() {
        return cover_type;
    }

    public void setCover_type(int cover_type) {
        this.type = cover_type;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(String cover_photo) {
        this.cover_photo = cover_photo;
    }

    public String getCover_photo_name() {
        return cover_photo_name;
    }

    public void setCover_photo_name(String cover_photo_name) {
        this.cover_photo_name = cover_photo_name;
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

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

}
