package dai.cloud.controller;

import com.cloud.entity.Seller;
import dai.cloud.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(value = "/getDetail.do",method = RequestMethod.GET)
    public Seller getSeller(){
        return sellerService.getSeller();
    }

}
