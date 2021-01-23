package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.entity.CouponAdmin;
import tn.esprit.spring.DAO.repository.ICouponAdminDAO;

@Service
public class CouponAdminService implements ICouponAdminService{
	@Autowired
	private ICouponAdminDAO couponAdminRepository;
	

	
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
	public void updateCoupon(CouponAdmin c) {
			couponAdminRepository.save(c);
	}

	@Override
	public void deleteCoupon(int id) {
			couponAdminRepository.deleteById(id);
	}

}
