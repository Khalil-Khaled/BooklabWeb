package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.CouponAdmin;
import tn.esprit.spring.DAO.entity.ShoppingCart;
import tn.esprit.spring.DAO.repository.ICouponAdminDAO;
import tn.esprit.spring.DAO.repository.ShoppingCartRepo;

@Service
public class CouponAdminService implements ICouponAdminService{
	@Autowired
	private ICouponAdminDAO couponAdminRepository;
	
	@Autowired
	private ShoppingCartRepo shoppingCartRepo;
	@Override
	public CouponAdmin addCoupon(CouponAdmin c) {
		return	couponAdminRepository.save(c);
	}

	@Override
	public List<CouponAdmin> showAllCoupons() {
		List<CouponAdmin> allCoupons= new ArrayList<>();
		couponAdminRepository.findAll().forEach(allCoupons::add);
		  return allCoupons;
	}

	@Override
	public CouponAdmin showCoupon(int id) {
		return couponAdminRepository.findById(id).get();
	}
	@Override
	public int getPercentOff(int scId) {
		return couponAdminRepository.getPourcentage(scId);
	}

	public int  checkCouponValidity(String code) {

        int  valid=0;
        for (int i = 0; i < showAllCoupons().size(); i++) {
            if (showAllCoupons().get(i).getName().equals(code)) {
               valid= showAllCoupons().get(i).getPercentOff();
            } 
        }
        return valid;
    }

	public Date checkExpirationDate( Date expiration_date) {
		return couponAdminRepository.checkDate(expiration_date);
	}
	public String getCouponsByName(String name) {
		return couponAdminRepository.findCouponByName(name);
	}
	@Override
	public String affecterShoppingCartACoupon(CouponAdmin coupon, int shoppingCartId) {
		ShoppingCart sc = shoppingCartRepo.findById(shoppingCartId).get();
		Date expiration_date =checkExpirationDate(coupon.getExpiration_date());
		String code = getCouponsByName(coupon.getName());
		String str="";
		if(coupon.getShoppingCart() == null ) {
          if (code != null  && expiration_date != null) {
        	  coupon.setShoppingCart(sc);
      			couponAdminRepository.save(coupon);
      			str="Coupon code was succefully verified .Enjoy the discount !";
          } else if(expiration_date == null){
        	  str="Coupon is expired since "+ coupon.getExpiration_date();
          }else if(code == null ) {
        	  str="Coupon code is wrong !!";
          }else {
        	  str="Coupon code is invalide";
          }
		}else {
			str="You have already used a coupon in this ShopingCart ! You can only use a coupon per shopping cart";
		}
      		
		return str;
	}
	@Override
	public void updateCoupon(CouponAdmin c) {
			couponAdminRepository.save(c);
	}

	@Override
	public void deleteCoupon(int id) {
			couponAdminRepository.deleteById(id);
	}

	
}
