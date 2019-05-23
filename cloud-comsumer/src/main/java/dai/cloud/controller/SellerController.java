package dai.cloud.controller;

import com.cloud.entity.Seller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/seller")
public class SellerController {


    private static final String CLOUD_PROVIDER = "http://CLOUD-PROVIDER";
//    private static final String CLOUD_PROVIDER = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getDetail.do",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallback")
    public Seller getSeller(){
        return restTemplate.getForObject(CLOUD_PROVIDER + "/seller/detail.do", Seller.class);
    }


    public Seller fallback(){
        Seller seller = new Seller();
        seller.setSellerName("我是熔断后的结果啊！！！").setDealerId(8003L);
        return seller;
    }

}
