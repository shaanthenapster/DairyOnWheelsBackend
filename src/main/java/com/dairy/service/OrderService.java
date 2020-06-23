package com.dairy.service;

import com.dairy.enums.OrderStatus;
import com.dairy.exception.CustomException;
import com.dairy.exception.UserException;
import com.dairy.model.*;
import com.dairy.repository.AcceptedOrderRepo;
import com.dairy.repository.CouponRepo;
import com.dairy.repository.PendingOrderRepo;
import com.dairy.requestDto.IncomingOrderRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

@Autowired
PendingOrderRepo pendingOrderRepo;

@Autowired
AcceptedOrderRepo acceptedOrderRepo;

@Autowired
CouponRepo couponRepo;




// todo: Change the implementation to reactive in every repo and service.

    @Transactional(rollbackFor = UserException.class)
   public OrderStatus orderRequest(IncomingOrderRequestDto incommingOrderRequestDto) throws UserException {

       PendingOrder pendingOrder = new PendingOrder();
       if(Validator.isvalidUserId(incommingOrderRequestDto.getUuid()) == null)
           throw new UserException("INVALID UUID", CustomException.INVALID_USER);
       pendingOrder.setUuid(incommingOrderRequestDto.getUuid());

       pendingOrder.setPendingOrderId(UtilityServices.genricIdgenerator(1));
       DeliveryAddress deliveryAddress = new DeliveryAddress();
       deliveryAddress.setHouseNo(incommingOrderRequestDto.getDeliveryAddress().getHouseNo());
       deliveryAddress.setLandmark(incommingOrderRequestDto.getDeliveryAddress().getLandmark());
       deliveryAddress.setStreet(incommingOrderRequestDto.getDeliveryAddress().getStreet());
       deliveryAddress.setState(incommingOrderRequestDto.getDeliveryAddress().getState());
       deliveryAddress.setCity(incommingOrderRequestDto.getDeliveryAddress().getCity());
       deliveryAddress.setPinCode(incommingOrderRequestDto.getDeliveryAddress().getPinCode());
       deliveryAddress.setLatitude(incommingOrderRequestDto.getDeliveryAddress().getLatitude());
       deliveryAddress.setLongitude(incommingOrderRequestDto.getDeliveryAddress().getLongitude());

       pendingOrder.setDeliveryAddress(deliveryAddress);

       pendingOrder.setOrderStatus(OrderStatus.RECEIVED);
       pendingOrder.setOrderQuantity(incommingOrderRequestDto.getOrderQuantity());
       pendingOrder.setTotalPrice(incommingOrderRequestDto.getTotalPrice());
       pendingOrder.setCouponCode(incommingOrderRequestDto.getCouponCode());

       pendingOrderRepo.save(pendingOrder);
       return pendingOrder.getOrderStatus();

   }


   public List<PendingOrder> showAllPendingOrderToAdmin(){
        return pendingOrderRepo.findAll();
   }


   public boolean orderStatusChange(final String orderId , final int adminSelection){

        PendingOrder pendingOrder = pendingOrderRepo.findByPendingOrderId(orderId);
        if(pendingOrder.getPendingOrderId().isEmpty())
            throw new UserException("INVALID PRODUCT ID" , CustomException.INVALID_PARAMETERS);
        else {
            switch (adminSelection){

                case 1 :
                    pendingOrder.setOrderStatus(OrderStatus.AWAITING_CONFIRMATION);
                    pendingOrderRepo.save(pendingOrder);
                    break;
                case 2 :
                    pendingOrder.setOrderStatus(OrderStatus.PROCESSING_THE_REQUEST);
                    pendingOrderRepo.save(pendingOrder);
                    break;
                case 3:
                    AcceptedOrder acceptedOrder = new AcceptedOrder();
                    acceptedOrder.setOrderId(UtilityServices.genricIdgenerator(2));
                    acceptedOrder.setUuid(pendingOrder.getUuid());
                    acceptedOrder.setDeliveryAddress(pendingOrder.getDeliveryAddress());
                    acceptedOrder.setOrderQuantity(pendingOrder.getOrderQuantity());
                    acceptedOrder.setCouponCode(pendingOrder.getCouponCode());
                    /*Payment Status of the order */
                    acceptedOrder.setPayment(new Payment());
                    acceptedOrder.getProductsList().addAll(pendingOrder.getProductsList());
                    acceptedOrder.setOrderStatus(OrderStatus.CONFIRMED);
                    /*demo price*/
                    acceptedOrder.setTotalPrice(23456.789);
                    acceptedOrderRepo.save(acceptedOrder);
                    pendingOrderRepo.delete(pendingOrder);
                    break;
                case 4:
                    AcceptedOrder dispatchedOrder = acceptedOrderRepo.findByOrderId(orderId);
                    dispatchedOrder.setOrderStatus(OrderStatus.DISPATCHED);

            }
        }
        return true;
   }


   public Coupons validateCoupon(String couponCode) throws UserException {
       Coupons coupon = couponRepo.findByCouponCode(couponCode);
       if(coupon == null || !coupon.isValid())
           throw new UserException("INVALID COUPON CODE" , CustomException.INVALID_COUPON_CODE);
       else {
           LocalDateTime validDate = coupon.getValidDate();
           if(validDate.isAfter(LocalDateTime.now()))
               throw new UserException("COUPON EXPIRED" , CustomException.COUPON_EXPIRED);
       }
       return coupon;
   }

}
