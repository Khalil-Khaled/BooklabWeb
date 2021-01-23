package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.services.CouponService;

@RestController
public class CouponController {
	@Autowired
	private CouponService couponService;
	
//	@RequestMapping("/orders/{orderId}/useCoupon")
//    public Order  getOrderAfterCoupon(@RequestBody Coupon coupon,@PathVariable Long orderId) {
//        coupon.setOrder(new Order(orderId,0,0));
//		return  couponService.useCoupon(coupon, coupon.getOrder());
//    }
}
