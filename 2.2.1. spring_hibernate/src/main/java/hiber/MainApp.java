package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User Jane = new User("Jane", "Ostin", "jane@mail.ru");
      User Stiven = new User("Stiven", "King", "stiven@mail.ru");
      User John = new User("John", "Tolkien", "john@mail.ru");

      Car volvo = new Car("Volvo", 9);
      Car bmw = new Car("BMW", 325);
      Car suzuki = new Car("Sizuki", 4);

      userService.add(Jane.setCar(volvo).setUser(Jane));
      userService.add(Stiven.setCar(bmw).setUser(Stiven));
      userService.add(John.setCar(suzuki).setUser(John));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }

      System.out.println(userService.getUserByCar("BMW", 325));

      context.close();
   }
}