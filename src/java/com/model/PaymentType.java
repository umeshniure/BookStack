package com.model;

public class PaymentType {

    private int id;
    private String payment_type;

    public PaymentType() {
    }

    public PaymentType(String payment_type) {
        super();
        this.payment_type = payment_type;
    }

    public PaymentType(int id, String payment_type) {
        super();
        this.id = id;
        this.payment_type = payment_type;
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
     * @return the payment_type
     */
    public String getPayment_type() {
        return payment_type;
    }

    /**
     * @param payment_type the payment_type to set
     */
    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }
}
