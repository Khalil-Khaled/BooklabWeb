package tn.esprit.spring.DAO.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_Order")
public class Order implements Serializable{

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="order_id")
private int orderId;

private double totalPrice;

private double discount;

@OneToOne
private Coupon coupon;





public Order() {
	super();
}

public Order(int orderId, double totalPrice, double discount, Coupon coupon) {
	super();
	this.orderId = orderId;
	this.totalPrice = totalPrice;
	this.discount = discount;
	this.coupon = coupon;
}

public Order(int orderId, double totalPrice, double discount) {
	super();
	this.orderId = orderId;
	this.totalPrice = totalPrice;
	this.discount = discount;
}

public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public double getTotalPrice() {
	return totalPrice;
}

public void setTotalPrice(double totalPrice) {
	this.totalPrice = totalPrice;
}

public double getDiscount() {
	return discount;
}

public void setDiscount(Order order, double discount) {
	this.discount = discount;
}

public Coupon getCoupon() {
	return coupon;
}

public void setCoupon(Coupon coupon) {
	this.coupon = coupon;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((coupon == null) ? 0 : coupon.hashCode());
	long temp;
	temp = Double.doubleToLongBits(discount);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + orderId;
	temp = Double.doubleToLongBits(totalPrice);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Order other = (Order) obj;
	if (coupon == null) {
		if (other.coupon != null)
			return false;
	} else if (!coupon.equals(other.coupon))
		return false;
	if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
		return false;
	if (orderId != other.orderId)
		return false;
	if (Double.doubleToLongBits(totalPrice) != Double.doubleToLongBits(other.totalPrice))
		return false;
	return true;
}

@Override
public String toString() {
	return "Order [orderId=" + orderId + ", totalPrice=" + totalPrice + ", discount=" + discount + ", coupon=" + coupon
			+ "]";
}





}
