package dai.cloud.controller;

import com.cloud.entity.Seller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dai.cloud.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/seller", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallback")
    public Seller findSeller(){
        return sellerService.getSeller();
    }

    public Seller fallback(){
        Seller seller = sellerService.getSeller();
        seller.setSellerName("我是熔断后的结果啊！！！").setDealerId(8003L);
        return seller;
    }

}
