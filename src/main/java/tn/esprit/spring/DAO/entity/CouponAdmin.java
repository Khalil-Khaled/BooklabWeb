package tn.esprit.spring.DAO.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;



@Entity
@Table(name="CouponAdmin")
public class CouponAdmin implements Serializable{
	


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="adminCouponId")
	private int adminCouponId;
	@NotNull
	private String name;
	
	@NotNull
	private int percentOff;

	@OneToOne 
	ShoppingCart shoppingCart; 
	
	@Enumerated(EnumType.STRING)
	private Duration duration;

	
	public CouponAdmin() {
		super();
	}

	
	public CouponAdmin(int adminCouponId, String name, int percentOff, Duration duration) {
		super();
		this.adminCouponId = adminCouponId;
		this.name = name;
		this.percentOff = percentOff;
		this.duration = duration;
	}
	public int getAdminCouponId() {
		return adminCouponId;
	}


	public void setAdminCouponId(int adminCouponId) {
		this.adminCouponId = adminCouponId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPercentOff() {
		return percentOff;
	}


	public void setPercentOff(int percentOff) {
		this.percentOff = percentOff;
	}


	public Duration getDuration() {
		return duration;
	}


	public void setDuration(Duration duration) {
		this.duration = duration;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}


	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}


	@Override
	public String toString() {
		return "CouponAdmin [adminCouponId=" + adminCouponId + ", name=" + name + ", percentOff=" + percentOff
				+ ", duration=" + duration + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		CouponAdmin other = (CouponAdmin) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
