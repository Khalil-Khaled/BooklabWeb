package tn.esprit.spring.DAO.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sun.istack.NotNull;


@Entity
@Table(name="Coupon")
public class Coupon implements Serializable{


private static final long serialVersionUID = 1L;

@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name="couponId")
private int couponId;

@NotNull
private String codeCoupon;

private boolean validity;

@Temporal(TemporalType.DATE)
private Date expiration_date;

@OneToOne(mappedBy="coupon")
private Order order ;

public Coupon() {
		super();
	}

public Coupon(int couponId, String codeCoupon, boolean validity, Date expiration_date) {
		super();
		this.couponId = couponId;
		this.codeCoupon = codeCoupon;
		this.validity = validity;
		this.expiration_date = expiration_date;
	}

public int getCouponId() {
	return couponId;
}

public void setCouponId(int couponId) {
	this.couponId = couponId;
}

public String getCodeCoupon() {
	return codeCoupon;
}

public void setCodeCoupon(String codeCoupon) {
	this.codeCoupon = codeCoupon;
}

public boolean isValidity() {
	return validity;
}

public void setValidity(boolean validity) {
	this.validity = validity;
}

public Date getExpiration_date() {
	return expiration_date;
}

public void setExpiration_date(Date expiration_date) {
	this.expiration_date = expiration_date;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

@Override
public String toString() {
	return "Coupon [couponId=" + couponId + ", codeCoupon=" + codeCoupon + ", validity=" + validity
			+ ", expiration_date=" + expiration_date + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codeCoupon == null) ? 0 : codeCoupon.hashCode());
	result = prime * result + couponId;
	result = prime * result + ((expiration_date == null) ? 0 : expiration_date.hashCode());
	result = prime * result + ((order == null) ? 0 : order.hashCode());
	result = prime * result + (validity ? 1231 : 1237);
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
	Coupon other = (Coupon) obj;
	if (codeCoupon == null) {
		if (other.codeCoupon != null)
			return false;
	} else if (!codeCoupon.equals(other.codeCoupon))
		return false;
	if (couponId != other.couponId)
		return false;
	if (expiration_date == null) {
		if (other.expiration_date != null)
			return false;
	} else if (!expiration_date.equals(other.expiration_date))
		return false;
	if (order == null) {
		if (other.order != null)
			return false;
	} else if (!order.equals(other.order))
		return false;
	if (validity != other.validity)
		return false;
	return true;
}

}
