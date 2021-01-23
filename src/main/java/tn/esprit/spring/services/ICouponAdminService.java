package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.CouponAdmin;


 

public interface ICouponAdminService {
	public CouponAdmin addCoupon(CouponAdmin c);
	public  List<CouponAdmin> showAllCoupons();
	public CouponAdmin showCoupon(int id);
	public void updateCoupon(CouponAdmin c);
	public void deleteCoupon(int id);

	
}
