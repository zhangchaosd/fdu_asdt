package com.zhangchao.user;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import com.zhangchao.user.entity.User;
// import com.zhangchao.user.repository.UserRepository;

// import java.util.List;

@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    // @Bean
    // public CommandLineRunner dataLoader(UserRepository userRepository) {
    //     return new CommandLineRunner() {
    //         @Override
    //         public void run(String... args) throws Exception {
    //             // User user = new User();
    //             // user.setName("admin");
    //             // List<User> userList = userRepository.findUserByName(user.getName());
    //             // if (userList == null || userList.isEmpty()) {
    //             //     user.setDepartment("dep1");
    //             //     userRepository.save(user);
    //             // }
    //         }
    //     };
    // }
}
