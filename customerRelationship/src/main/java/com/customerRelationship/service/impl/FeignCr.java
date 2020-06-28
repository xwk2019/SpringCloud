package com.customerRelationship.service.impl;

import com.customerRelationship.entity.TCustomer;
import com.customerRelationship.service.FeignCrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeignCr implements FeignCrService {

    @Autowired
    private TCustomerServiceImpl tCustomerService;
    @Autowired
    private FeignCrService feignCrService;

    @Override
    public List<TCustomer> tcList() {
        return tCustomerService.list(null);
    }

    @Override
    public TCustomer getById1(Integer customerId) {
        return  tCustomerService.getById(customerId);
    }

    @Override
    public TCustomer updata(Integer customerId) {
        TCustomer tCustomer = tCustomerService.getById(customerId);
        tCustomer.setContacts("吴计妥是大帅哥");
        boolean i = tCustomerService.updateById(tCustomer);
        if (i == true){
            return tCustomerService.getById(customerId);
        }else {
            return (TCustomer) feignCrService.tcList();
        }
    }

    @Override
    public List<TCustomer> add() {
        TCustomer tCustomer = new TCustomer();
        tCustomer.setCustomerName("wangda");
        tCustomer.setContacts("xwk2");
        tCustomer.setPhoneNumber("13555555551");
        tCustomer.setAddress("广东广州");
        tCustomer.setRemarks("wangda稳定客户");
        tCustomer.setContacts("吴计妥是大帅哥");
        tCustomerService.save(tCustomer);
        return tCustomerService.list(null);
    }

    @Override
    public List<TCustomer> delete(Integer customerId) {
        tCustomerService.removeById(customerId);
        return tCustomerService.list(null);
    }
}

