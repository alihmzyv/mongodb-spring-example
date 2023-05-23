package com.alihmzyv.mongodbspringexample;

import com.alihmzyv.mongodbspringexample.entity.Address;
import com.alihmzyv.mongodbspringexample.entity.Student;
import com.alihmzyv.mongodbspringexample.repo.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongodbSpringExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbSpringExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepo studentRepo, MongoTemplate mongoTemplate) {
        return args -> {
//            Query query = new Query()
//                    .addCriteria(Criteria.where("email").is("alihmzyv@gmail.com"));
//            List<Student> students = mongoTemplate.find(query, Student.class);
//            students.forEach(System.out::println);
            String email = "alihmzyv@gmail.com";
            studentRepo.findStudentByEmail(email)
                    .ifPresentOrElse(System.out::println, () -> {
                        throw new RuntimeException(String.format("Student not found with email: %s", email));
                    });
            Address address = Address.builder()
                    .city("Baku")
                    .country("AZE")
                    .postCode("1050")
                    .build();
            Student student = Student.builder()
                    .email("alihmzyv@gmail.com")
                    .address(address)
                    .build();
            studentRepo.insert(student);
        };
    }
}
