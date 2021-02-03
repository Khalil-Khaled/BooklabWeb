package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.CouponAdmin;
import tn.esprit.spring.DAO.entity.ShoppingCart;
import tn.esprit.spring.services.CouponAdminService;

@RestController
public class CouponAdminController {
	@Autowired
	private CouponAdminService couponAdminService;
	
	@RequestMapping(method=RequestMethod.POST ,value="/admin/coupons/newCoupon")
	public CouponAdmin addCoupon(@RequestBody CouponAdmin couponAdmin ) {
		return  couponAdminService.addCoupon(couponAdmin);
	}
	@RequestMapping("/admin/coupons")
    public List<CouponAdmin> getAllCoupons() {
        return couponAdminService.showAllCoupons();
    }
	@RequestMapping("/admin/coupons/{couponId}")
    public CouponAdmin getCouponById(@PathVariable int couponId) {
        return couponAdminService.showCoupon(couponId);
    }
	@RequestMapping(method=RequestMethod.PUT , value="/admin/coupons/{couponId}/update")
	public void updateCoupon(@RequestBody CouponAdmin couponAdmin ,@PathVariable int couponId) {
		couponAdminService.updateCoupon(couponAdmin);
	}
	@RequestMapping(method=RequestMethod.DELETE , value="/admin/coupons/{couponId}/delete")
	public void deleteCoupon(@PathVariable int couponId) {
		couponAdminService.deleteCoupon(couponId);
	}
	
	@RequestMapping(method=RequestMethod.PUT ,value="/user/shoppingCart/{shoppingCartId}/useCoupon/{adminCouponId}")
	public String affecterCouponAShoppingCart(@PathVariable int shoppingCartId,@RequestBody CouponAdmin c,@PathVariable int adminCouponId) {
		return couponAdminService.affecterShoppingCartACoupon(c, shoppingCartId);
	}
}
