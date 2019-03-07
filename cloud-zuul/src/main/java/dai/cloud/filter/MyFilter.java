package dai.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    /**
     * filterType: 返回过滤器的类型。有pre、route、post、error等几种取值
     *
     * pre: 这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等
     *
     * route: 这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用HttpClient或Ribbon请求微服务
     *
     * post: 这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、
     *          收集统计信息和指标、将响应从微服务发送给客户端等
     *
     * error: 在其他阶段发生错误时执行该过滤器
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 返回一个int值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字
     *
     * 优先级，数字越大，优先级越低
     * 
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    /**
     * 返回一个boolean值来判断该过滤器是否要执行，true表示执行，false表示不执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的业务逻辑 (例如权限控制等等..)
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //请求的HTTP方法以及请求的地址
        System.out.println("method: " + request.getMethod() + " url: " + request.getRequestURL().toString());
        return null;
    }
}
