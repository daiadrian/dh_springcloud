package dai.cloud.service;

import com.cloud.entity.Seller;
import dai.cloud.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerMapper sellerMapper;

    public Seller getSeller(){
        Seller seller = sellerMapper.findById(2899);
        seller.setDealerId(8001L);
        return seller;
    }

}
