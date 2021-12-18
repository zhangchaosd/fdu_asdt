package com.zhangchao.taskCompletion;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import com.zhangchao.taskCompletion.entity.TaskCompletion;
// import com.zhangchao.taskCompletion.repository.TaskCompletionRepository;

// import java.util.List;

@SpringBootApplication
public class TaskCompletionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskCompletionApplication.class, args);
    }

    // @Bean
    // public CommandLineRunner dataLoader(TaskCompletionRepository taskCompletionRepository) {
    //     return new CommandLineRunner() {
    //         @Override
    //         public void run(String... args) throws Exception {
    //             // TaskCompletion taskCompletion = new TaskCompletion();
    //             // taskCompletion.setName("admin");
    //             // List<TaskCompletion> taskCompletionList = taskCompletionRepository.findTaskCompletionByName(taskCompletion.getName());
    //             // if (taskCompletionList == null || taskCompletionList.isEmpty()) {
    //             //     taskCompletion.setDepartment("dep1");
    //             //     taskCompletionRepository.save(taskCompletion);
    //             // }
    //         }
    //     };
    // }
}
