package com.dehu.order.pojo;

public class Order {
    private Integer id;

    private Integer productId;

    private Integer totalAmount;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 一定要声明toString方法，否则在链路追踪中显示的是地址，而非值
     * @return
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productId=" + productId +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }
}