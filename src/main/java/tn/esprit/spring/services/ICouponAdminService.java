package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.CouponAdmin;
import tn.esprit.spring.DAO.entity.ShoppingCart;


 

public interface ICouponAdminService {
	public CouponAdmin addCoupon(CouponAdmin c);
	public  List<CouponAdmin> showAllCoupons();
	public CouponAdmin showCoupon(int id);
	public void updateCoupon(CouponAdmin c);
	public void deleteCoupon(int id);
	public int getPercentOff(int scId);
	public String affecterShoppingCartACoupon(CouponAdmin c, int shoppingCartId);
}
