package spring.study.ja.hw1;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.study.ja.hw1.service.AuditoriumManager;

import java.io.File;
// I don't remember how to make it work.  ((
public class AuditoriumManagerTests {
    @Test
    public void testAuditoriumsInfoFile() {
        String infoPath = "./src/main/resources/data/auditoriums.info";
        AuditoriumManager manager = new AuditoriumManager(infoPath);
        manager.init();
        System.out.println(manager.auditoriums.size());
    }

    @Test
    public void AuditoriumInfoForManagerCanBeReadFromSpringContext() {

        File file1 = new File("./src/main/resources/data/auditoriums.info");
        File file2 = new File("./src/main/resources/spring/UIApp.xml");
        System.out.println(file1.exists());
        System.out.println(file2.exists());


        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("UIApp.xml");
        //./src/main/resources/spring/UIApp.xml
        AuditoriumManager auditoriumManager = (AuditoriumManager) ctx.getBean("auditoriumManager");
        System.out.println(auditoriumManager.getAll().size());
    }
}
