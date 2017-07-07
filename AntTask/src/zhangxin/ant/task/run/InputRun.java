/**
 * Copyright 2016 - Zhang Xin
 *
 * Date: 2016年11月17日  下午5:24:19
 */

package zhangxin.ant.task.run;

/**
 * Java Swing 之下拉列表控件
 * @author gao
 */
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InputRun extends JFrame {
    public InputRun() {
        this.setTitle("下拉列表框使用");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 250, 100);

        // int windowWidth = getWidth(); // 获得窗口宽
        // int windowHeight = getHeight(); // 获得窗口高
        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // // 获取屏幕的尺寸
        // int screenWidth = screenSize.width; // 获取屏幕的宽
        // int screenHeight = screenSize.height; // 获取屏幕的高
        // setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 -
        // windowHeight / 2);// 设置窗口居中显示
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        this.setContentPane(contentPane);

        BorderLayout mgr = new BorderLayout();
        contentPane.setLayout(mgr);
        // contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        // contentPane.setBackground(Color.RED);

        JLabel label = new JLabel("证件类型:");
        label.setBackground(Color.BLUE);
        contentPane.add(label, BorderLayout.NORTH);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.addItem("身份证");
        comboBox.addItem("驾驶证");
        comboBox.addItem("军官证");
        contentPane.add(comboBox, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        InputRun example = new InputRun();
    }
}
