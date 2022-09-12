package com.model;

public class OrderItems {

    private int id;
    private int book_id;
    private int quantity;
    private String order_id;
    private double total_price;
    private double tax_amount;
    private double shipping_amount;

    public OrderItems() {

    }

    public OrderItems(int id, int book_id, int quantity, String order_id, double total_price, double tax_amount, double shipping_amount) {
        super();
        this.id = id;
        this.book_id = book_id;
        this.quantity = quantity;
        this.order_id = order_id;
        this.total_price = total_price;
        this.tax_amount = tax_amount;
        this.shipping_amount = shipping_amount;
    }

    public OrderItems(int book_id, int quantity, String order_id, double total_price, double tax_amount, double shipping_amount) {
        super();
        this.book_id = book_id;
        this.quantity = quantity;
        this.order_id = order_id;
        this.total_price = total_price;
        this.tax_amount = tax_amount;
        this.shipping_amount = shipping_amount;
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

}
