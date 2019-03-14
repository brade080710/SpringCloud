package com.it.cloud.feign;

import com.it.cloud.entity.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//提供Fallback
@FeignClient(name = "microservice-provider-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") int id);


}


@Component
class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User findById(int id) {
        User user = new User();
        user.setAge(11);
        user.setName("test");
        user.setBalance(1l);
        user.setId(id);
        return user;
    }
}
//  FallbackFactory获得造成回退的原因
//@FeignClient(name = "microservice-provider-user", fallback = UserFeignClientFallbackFactory.class)
//public interface UserFeignClient {
//
//    @GetMapping("/users/{id}")
//    User findById(@PathVariable("id") int id);
//
//
//}


//    @Component
//    @Slf4j
//    class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
//        @Override
//        public UserFeignClient create(Throwable throwable) {
//            return new UserFeignClient() {
//                @Override
//                public User findById(int id) {
////                    log.error("进入回退逻辑", throwable);
//                    User user = new User();
//                    user.setAge(11);
//                    user.setName("test");
//                    user.setBalance(1l);
//                    user.setId(id);
//                    return user;
//                }
//
//            };
//        }
//}