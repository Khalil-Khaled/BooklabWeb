package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.repository.ICouponAdminDAO;
 
@Service
public class CouponService implements ICouponService{
	@Autowired
	private ICouponAdminDAO  couponRepository;
	
	@Autowired
	private CouponAdminService couponAdminService ;
	
	@Autowired
	private OrderService orderService;
	
//	@Override
//	public Order useCoupon(Coupon c,Order order) {
//		String code=c.getCodeCoupon();
//		int discount=checkCouponValidity(code);
//		if(discount>0) {
//        	order.setDiscount(order,discount);
//
//		}
//		return c.getOrder();
//	}
//   
//	    
//	
//	
//public int  checkCouponValidity(String code) {
//	int valid=0;
//        for (int i = 0; i < couponAdminService.showAllCoupons().size(); i++) {
//            if ( couponAdminService.showAllCoupons().get(i).getName().equals(code)) {
//            couponRepository.findAll().forEach(c->c.setValidity(true));
//            valid=  couponAdminService.showAllCoupons().get(i).getPercentOff();
//            } 
//        }
//        return valid;
//    }
//	
}
