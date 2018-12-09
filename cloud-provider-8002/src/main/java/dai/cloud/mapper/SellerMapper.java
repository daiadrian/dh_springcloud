package dai.cloud.mapper;

import com.cloud.entity.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SellerMapper {

    @Select("SELECT * FROM genactivity_dealer_seller WHERE id=#{id}")
    public Seller findById(@Param("id") long id);

}
