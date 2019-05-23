package dai.cloud.service;

import com.cloud.entity.Seller;
import dai.cloud.fallback.SellerFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign是面向接口编程的声明式web服务客户端
 */
@FeignClient(name = "CLOUD-PROVIDER", fallback = SellerFeignClientFallback.class)
public interface SellerService {

    @GetMapping(value = "/seller")
    public Seller getSeller();

}
