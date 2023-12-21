package lesson1;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {

        // Создаём контекст, при этом указывая путь к ApplicationContext.xml, где был описан наш bean.
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        // С помощью контекста получаем bean по его id. Также требуется указать класс, который мы хотим получить
        FirstBean first = context.getBean("firstBean", FirstBean.class);


        System.out.println(first.getName());

        // После использования контекста его необходимо закрыть
        context.close();
    }
}
