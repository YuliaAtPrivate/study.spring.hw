package spring.study.ja.hw1.ui;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.study.ja.hw1.service.AuditoriumManager;

import javax.swing.*;

public class UIApp {
    public static AuditoriumManager auditoriumManager;

    private static void createGUI() {

        //main frame
        JFrame frame = new JFrame("Ticket Admin Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //main frame view
        //--JFrame.setDefaultLookAndFeelDecorated(true);

        JLabel label = new JLabel("Hello World");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().add(label);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("UIApp.xml");
        auditoriumManager = (AuditoriumManager) ctx.getBean("auditoriumManager");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
}
