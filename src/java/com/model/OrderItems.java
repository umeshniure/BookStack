package com.model;

public class OrderItems {

    private int id;
    private int book_id;
    private int quantity;
    private String order_id;
    private double unit_price;
    private double total_price;
    private double tax_amount;
    private double shipping_amount;

    private String book_name;
    private double book_price;
    private String book_cover_name;
    private int vendor_id;

    public OrderItems() {

    }

    public OrderItems(int id, int book_id, int quantity, String order_id, double unit_price, double total_price, double tax_amount, double shipping_amount) {
        super();
        this.id = id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.order_id = order_id;
        this.unit_price = unit_price;
        this.total_price = total_price;
        this.tax_amount = tax_amount;
        this.shipping_amount = shipping_amount;
    }

    public OrderItems(int book_id, int quantity, String order_id, double unit_price, double total_price, double tax_amount, double shipping_amount) {
        super();
        this.book_id = book_id;
        this.quantity = quantity;
        this.order_id = order_id;
        this.unit_price = unit_price;
        this.total_price = total_price;
        this.tax_amount = tax_amount;
        this.shipping_amount = shipping_amount;
    }

    public OrderItems(int book_id, int quantity, String order_id, String book_name, double book_unit_price, String book_cover_name, int vendor_id, double shipping_amount, double tax_amount) {
        this.book_id = book_id;
        this.quantity = quantity;
        this.order_id = order_id;
        this.unit_price = book_unit_price;
        this.book_cover_name = book_cover_name;
        this.vendor_id = vendor_id;
        this.shipping_amount = shipping_amount;
        this.book_name = book_name;
        this.tax_amount = tax_amount;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the book_id
     */
    public int getBook_id() {
        return book_id;
    }

    /**
     * @param book_id the book_id to set
     */
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the order_id
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    /**
     * @return the total_price
     */
    public double getTotal_price() {
        return total_price;
    }

    /**
     * @param total_price the total_price to set
     */
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    /**
     * @return the tax_amount
     */
    public double getTax_amount() {
        return tax_amount;
    }

    /**
     * @param tax_amount the tax_amount to set
     */
    public void setTax_amount(double tax_amount) {
        this.tax_amount = tax_amount;
    }

    /**
     * @return the shipping_amount
     */
    public double getShipping_amount() {
        return shipping_amount;
    }

    /**
     * @param shipping_amount the shipping_amount to set
     */
    public void setShipping_amount(double shipping_amount) {
        this.shipping_amount = shipping_amount;
    }

    /**
     * @return the book_name
     */
    public String getBook_name() {
        return book_name;
    }

    /**
     * @param book_name the book_name to set
     */
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    /**
     * @return the book_price
     */
    public double getBook_price() {
        return book_price;
    }

    /**
     * @param book_price the book_price to set
     */
    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    /**
     * @return the book_cover_name
     */
    public String getBook_cover_name() {
        return book_cover_name;
    }

    /**
     * @param book_cover_name the book_cover_name to set
     */
    public void setBook_cover_name(String book_cover_name) {
        this.book_cover_name = book_cover_name;
    }

    /**
     * @return the vendor_id
     */
    public int getVendor_id() {
        return vendor_id;
    }

    /**
     * @param vendor_id the vendor_id to set
     */
    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    /**
     * @return the unit_price
     */
    public double getUnit_price() {
        return unit_price;
    }

    /**
     * @param unit_price the unit_price to set
     */
    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

}
