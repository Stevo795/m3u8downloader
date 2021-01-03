package UI;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//灰色文字提醒
//import JTextFieldHintListener;

public class TypicalWrong{

    private JFrame mainframe = new JFrame("M3U8 DOWNLOAD TOOL ");
    private Container c = mainframe.getContentPane();

    //
    private JLabel URL = new JLabel("URL:");
    private Font URL_font = new Font("Arial", Font.BOLD, 9);
    private JTextField URL_INPUT = new JTextField();
    //最终URL
    private String Final_URL = null;

    //下载地址选择
    private JLabel DOWNLOAD_PATH = new JLabel("<html>Download Path");
    private Font DOWNLOAD_PATH_font = new Font("Arial", Font.BOLD, 9);
    private  JTextField DOWNLOAD_PATH_INPUT = new JTextField();
    //灰色提示 默认下载路径 桌面
    private File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
    private String Default_DOWNLOAD_PATH_INPUT = desktopDir.getAbsolutePath();
    //最终地址
    private String Final_Path = null;

//    private JFileChooser DOWNLOAD_PATH_INPUT = new JFileChooser();
    //
    private JButton okbtn = new JButton("下载");
    private JButton cancelbtn = new JButton("取消");
    private  JButton browse_btn = new JButton("browse");

    public TypicalWrong() {
        //win 10 style


        //设置窗体的位置及大小
        mainframe.setBounds(600, 200, 500, 220);
        //设置一层相当于桌布的东西
        c.setLayout(new BorderLayout());//布局管理器
        //设置按下右上角X号后关闭
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //初始化--往窗体里放其他控件
        init();
         //设置窗体可见
        mainframe.setVisible(true);
    }

    public void init() {

        //
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("M3U8 多线程下载工具"));
        c.add(panel, "North");
        c.setFocusable(true);//使程序不默认选择文本框

        //
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        //
        URL.setBounds(15, 20, 50, 20);
        URL.setFont(URL_font);
        //
        DOWNLOAD_PATH.setBounds(15, 60, 50, 40);
        DOWNLOAD_PATH.setFont(DOWNLOAD_PATH_font);
        fieldPanel.add(URL);
        fieldPanel.add(DOWNLOAD_PATH);

        //链接输入
        URL_INPUT.setBounds(80, 20, 260, 20);
        //灰色提示
        URL_INPUT.addFocusListener(new JTextFieldHintListener(URL_INPUT, "ie: XXX.M3U8"));


        //DOWNLOAD PATH
        DOWNLOAD_PATH_INPUT.setBounds(80, 60, 220, 20);
        //灰色提示
        String Current_Path = Default_DOWNLOAD_PATH_INPUT;
        DOWNLOAD_PATH_INPUT.addFocusListener(new JTextFieldHintListener(DOWNLOAD_PATH_INPUT, Current_Path));
        //
        browse_btn.setBounds(300,60,40,20);
        //LISTENER
        browse_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //创建文件对话框，让用户选择保存的位置路径
                JFileChooser chooser=new JFileChooser("D:\\");//创建对话框对象
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//设定选择为文件夹
                int r=chooser.showOpenDialog(mainframe);
                if(r==JFileChooser.APPROVE_OPTION){
                    DOWNLOAD_PATH_INPUT.setText(chooser.getSelectedFile().getAbsolutePath());//得到选择的本地路径
                    Final_Path = DOWNLOAD_PATH_INPUT.getText();
                }
            }
        });


        fieldPanel.add(URL_INPUT);
        fieldPanel.add(DOWNLOAD_PATH_INPUT);
        fieldPanel.add(browse_btn);

        c.add(fieldPanel, "Center");

        /*按钮部分--South*/
//        okbtn.setBounds(300,150, 10,10);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        //确定按钮
        buttonPanel.add(okbtn);
        //listener
        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Final_Path == null){
                    Final_Path = Default_DOWNLOAD_PATH_INPUT;
                }
                Final_URL=URL_INPUT.getText();
                if(Final_URL.equals("ie: XXX.M3U8")){
                    System.out.println("input url");
                    JOptionPane message = new JOptionPane();

//                    message.showMessageDialog(null, "标题【错误】", "格式输入错误",JOptionPane.ERROR_MESSAGE);
//                    message.setLocation(50, 50);
                    JOptionPane.showMessageDialog(null, "请输入有效URL", "Invalid URL",JOptionPane.ERROR_MESSAGE);

                }else{
                    System.out.println(Final_Path+"---"+Final_URL);
                    try {
                        M3U8DOWNLOADER download_process = new M3U8DOWNLOADER(Final_URL,Final_Path);
//                        System.out.println("***final path "+Final_Path);

                    } catch (IOException | InterruptedException ioException) {
                        ioException.printStackTrace();
                    }

                }
                //

            }
        });
        buttonPanel.add(cancelbtn);
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        c.add(buttonPanel, "South");

    }

    public static void main (String[] args) throws IOException, InterruptedException {

        new TypicalWrong();
//        String DOWNLOAD_PATH_INPUT = "C:\\Users\\STEVO\\Desktop\\java_project\\Blob\\";
//        File file = new File(DOWNLOAD_PATH_INPUT);
//        if(! file.exists()){
//            file.mkdirs();
//        }
//        System.out.println(file.getAbsolutePath());

//        if (!filePath.endsWith("/")) {
//            filePath += "/";
//        }

    }
}