package spring.study.ja.hw1.ui;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.study.ja.hw1.service.AuditoriumManager;

import javax.swing.*;
import java.io.File;

public class UIApp {
    public static AuditoriumManager auditoriumManager;

    private static void createGUI() {

        //main frame
        JFrame frame = new JFrame("Ticket Admin Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //main frame view
        //--JFrame.setDefaultLookAndFeelDecorated(true);

        JLabel label = new JLabel("try to get auditoriums");
//        JLabel label1 = new JLabel(auditoriumManager.getAll().toString());
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().add(label);
//        frame.getContentPane().add(label1);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // spring/UIApp.xml
        ///U./src/main/resources/spring/UIApp.xml
        String fileName = "UIApp.xml";
        File file2 = new File(fileName);
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(fileName);
        //./src/main/resources/spring/UIApp.xml
//        auditoriumManager = (AuditoriumManager) ctx.getBean("auditoriumManager");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
}
