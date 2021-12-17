package com.zhangchao.task;

// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import com.zhangchao.task.entity.Task;
// import com.zhangchao.task.repository.TaskRepository;

// import java.util.List;

@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }

    // @Bean
    // public CommandLineRunner dataLoader(TaskRepository taskRepository) {
    //     return new CommandLineRunner() {
    //         @Override
    //         public void run(String... args) throws Exception {
    //             // Task task = new Task();
    //             // task.setName("admin");
    //             // List<Task> taskList = taskRepository.findTaskByName(task.getName());
    //             // if (taskList == null || taskList.isEmpty()) {
    //             //     task.setDepartment("dep1");
    //             //     taskRepository.save(task);
    //             // }
    //         }
    //     };
    // }
}
