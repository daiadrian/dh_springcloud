package dai.cloud.controller;

import com.cloud.entity.Seller;
import dai.cloud.mapper.SellerMapper;
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
    public Seller findSeller(){
        return sellerService.getSeller();
    }

}
