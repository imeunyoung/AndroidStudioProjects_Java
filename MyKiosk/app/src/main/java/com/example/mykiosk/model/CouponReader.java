package com.example.mykiosk.model;

import android.util.Log;

public class CouponReader {
    Coupon coupon; //쿠폰
    int totalAmount;    //결제금액

}
    public CouponReader(int totalAmount,Coupon coupon) {
        this.coupon=coupon;
        this.totalAmount=totalAmount;
    }

    String readCoupon(){
        boolean isCouponValid= validCoupon(this.coupon.getBarcode());
        boolean updateCoupon = updateCoupon(this.coupon.getCouponMoney());
        if(!isCouponValid) {return "유효하지 않은 쿠폰";}
        if(!isUpdateCoupon){return "쿠폰 사용 실패";}
        if(isCouponValid && isUpdateCoupon){
            payment(this.coupon);
            return "쿠폰 사용 성공";
        }
        return "쿠폰 사용 실패";
    }

    boolean validCoupon(int barcode){//바코드 읽기
        if(barcode==0){  //바코드 읽기 실패
            return false;
        }
        else return true;
    }
    boolean updateCoupon(int barcord, int money){ //쿠폰금액이 주문 금액보다 작거나 같은지 확인. 쿠폰 금액이 더 클 경우 사용불가
        if(this.updateCoupon()<=totalAmount){
            return true;
        }else{
            return false;
        }
    }

    void payment(Coupon coupon){ //쿠폰 사용
        int couponMoney=coupon.getCouponMoney();
        coupon.setCouponMoney(totalAmount-couponMoney);
    }



}
