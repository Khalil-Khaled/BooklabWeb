package tn.esprit.spring.services;

import java.util.ArrayList;
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
	private ShoppingCartImp shoppingCartService;
	
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
	public int getPercentOff(String name) {
		return couponAdminRepository.getPourcentage(name);
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

	
	@Override
	public String affecterShoppingCartACoupon(CouponAdmin coupon, int shoppingCartId) {
		ShoppingCart sc = shoppingCartRepo.findById(shoppingCartId).get();
		String str="";
		for (int i = 0; i < showAllCoupons().size(); i++) {
          if (showAllCoupons().get(i).getName().equals(coupon.getName())) {
        	  coupon.setShoppingCart(sc);
      			couponAdminRepository.save(coupon);
      			str="Coupon code was succefully verified .Enjoy the discount !";
          } else {
        	  coupon.setShoppingCart(null);
        	  str="Coupon code invalide";
          }
          
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
