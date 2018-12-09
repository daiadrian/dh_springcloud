package dai.cloud.controller;

import com.cloud.entity.Seller;
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
    public Seller getSeller(){
        return restTemplate.getForObject(CLOUD_PROVIDER + "/seller/detail.do", Seller.class);
    }

}
