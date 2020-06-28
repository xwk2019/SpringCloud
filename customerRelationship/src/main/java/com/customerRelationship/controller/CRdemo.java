package com.customerRelationship.controller;

import com.customerRelationship.entity.ReturnList;
import com.customerRelationship.entity.TCustomer;
import com.customerRelationship.service.FeignCrService;
import com.customerRelationship.service.impl.ReturnListServiceImpl;
import com.customerRelationship.service.impl.TCustomerServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@DefaultProperties(defaultFallback = "ErrorgetById2")
public class CRdemo {
    @Qualifier("feignCr")
    @Autowired
    private FeignCrService feignCrService;


    @Autowired
    private ReturnListServiceImpl returnListService;
    @GetMapping("/crlist")
    public List<ReturnList> crList(){
        return returnListService.list(null);
    }

    @Autowired
    private TCustomerServiceImpl tCustomerService;
    private RestTemplate restTemplate;
    /**
     * 根查询顾客关系信息总表
     * @param
     * @return
     */

    @GetMapping("/tclist")
    public List<TCustomer> tcList(){
        return feignCrService.tcList();
    }

    /**
     * 根据顾客id查询顾客关系信息
     * @param customerId
     * @return
     */

    @GetMapping("/getById1")
    public TCustomer getById1(Integer customerId){
        return  feignCrService.getById1(customerId);
    }

    @GetMapping("/getById2")
    @HystrixCommand
    public String getById10(){
        return restTemplate.getForObject("http://192.168.80.1:8080/api/cr/getById1?token={d}",String.class,
                "1");

    }
    public String ErrorgetById2(){
        return "你应该根据customerId来查找";
    }

    /**
     * 根据顾客id修改顾客关系信息
     * @param customerId
     * @return
     */

    @GetMapping("/updata")
        public TCustomer updata(Integer customerId) {
        return  feignCrService.updata(customerId);
    }


    @GetMapping("/add")
    public List<TCustomer> add()  {
       return feignCrService.add();
    }

    @GetMapping("/delete")
    public List<TCustomer> delete(Integer customerId) {
        return feignCrService.delete(customerId);
    }
}
