package com.it.cloud.feign;

import com.it.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//  FallbackFactory获得造成回退的原因 注意这是是fallbackFactory 而不是fallback，注意坑
@FeignClient(name = "microservice-provider-user", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") int id);


}


    @Component
    class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
        private static final Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

        @Override
        public UserFeignClient create(Throwable throwable) {
            return new UserFeignClient() {
                @Override
                public User findById(int id) {
                    logger.error("进入回退逻辑", throwable);
                    User user = new User();
                    user.setAge(11);
                    user.setName("回退");
                    user.setBalance(1l);
                    user.setId(id);
                    return user;
                }

            };
        }
}