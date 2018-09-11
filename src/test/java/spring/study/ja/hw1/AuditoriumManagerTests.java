package spring.study.ja.hw1;

import org.junit.Test;
import spring.study.ja.hw1.service.AuditoriumManager;

public class AuditoriumManagerTests {
    @Test
    public void testAuditoriumsInfoFile() {
        String infoPath = "./src/main/resources/data/auditoriums.info";
        AuditoriumManager manager = new AuditoriumManager(infoPath);
        manager.init();
        System.out.println(manager.auditoriums.size());
    }
}
