package com.model;

public class Books {

    protected int id, category, cover_type, type, language, price, discounted_price, published_year, vendor_id;
    protected long isbn;
    protected String name, description, author, cover_photo, cover_photo_name, publication;
    private String category_name, language_name, book_type, cover, vendor;

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

    //constructor wit id for inner joined table
    public Books(int id, long isbn, String bookname, String authorname, String publication, int price, int discounted_price, int published_year, int category,
            int cover_type, int language, int type, String description, String cover_photo, String cover_photo_name, int vendor_id, String category_name, String language_name, String book_type, String cover, String vendor) {
        super();
        this.id = id;
        this.isbn = isbn;
        this.name = bookname;
        this.author = authorname;
        this.publication = publication;
        this.price = price;
        this.discounted_price = discounted_price;
        this.category = category;
        this.category_name = category_name;
        this.published_year = published_year;
        this.cover_type = cover_type;
        this.language = language;
        this.type = type;
        this.cover_photo = cover_photo;
        this.cover_photo_name = cover_photo_name;
        this.description = description;
        this.vendor_id = vendor_id;
        this.vendor = vendor;
        this.book_type = book_type;
        this.cover = cover;
        this.language_name = language_name;

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

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String bookname) {
        this.name = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String authorname) {
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

    /**
     * @return the category_name
     */
    public String getCategory_name() {
        return category_name;
    }

    /**
     * @param category_name the category_name to set
     */
    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    /**
     * @return the language_name
     */
    public String getLanguage_name() {
        return language_name;
    }

    /**
     * @param language_name the language_name to set
     */
    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }

    /**
     * @return the book_type
     */
    public String getBook_type() {
        return book_type;
    }

    /**
     * @param book_type the book_type to set
     */
    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    /**
     * @return the cover
     */
    public String getCover() {
        return cover;
    }

    /**
     * @param cover the cover to set
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @param vendor the vendor to set
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

}
