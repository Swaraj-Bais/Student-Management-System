//Created by Swaraj Ravindrasingh Bais

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.SQLException;

class MainFrame extends JFrame implements MouseListener {
    JLabel l0, l1, l2, l3, l4, l5,l6;

    public MainFrame() {
        this.setSize(650, 530);
        this.setTitle("Student Management System");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon obg = new ImageIcon("background4.jpg");
        Image scaledImage = obg.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH);
        ImageIcon bg = new ImageIcon(scaledImage);
        JLabel bgl = new JLabel(bg);
        bgl.setBounds(0, 0, 650, 530);
        // bgl.setLayout(null);
        // this.add(bgl);

        ImageIcon img = new ImageIcon("ImgLogo.jpg");
        JLabel lab = new JLabel(img);
        lab.setBounds(265, 10, 100, 100);

        JLayeredPane pan = new JLayeredPane();
        pan.setBounds(0, 0, 650, 530);
        pan.add(bgl, Integer.valueOf(0));
        pan.add(lab, Integer.valueOf(1));
        this.add(pan);

        l0 = new JLabel("Government Polytechnic,Nanded");
        l0.setFont(new Font("", Font.ITALIC, 27));
        l0.setBounds(110, 110, 500, 50);
        l0.setForeground(Color.BLACK);
        bgl.add(l0);

        l1 = new JLabel("Welcome to Student Management System ");
        l1.setFont(new Font("", Font.ITALIC, 27));
        l1.setBounds(60, 150, 520, 50);
        l1.setForeground(Color.BLACK);
        bgl.add(l1);

        l5 = new JLabel("Click, On ");
        l5.setFont(new Font("", Font.ITALIC, 18));
        l5.setBounds(275, 250, 100, 25);
        l5.setForeground(new Color(33, 150, 243));
        bgl.add(l5);

        l2 = new JLabel("Register new Student");
        l2.setFont(new Font("", Font.CENTER_BASELINE, 18));
        l2.setBounds(220, 270, 250, 30);
        l2.setForeground(new Color(170, 51, 106));
        l2.addMouseListener(this);
        bgl.add(l2);

        l4 = new JLabel("Or");
        l4.setFont(new Font("", Font.CENTER_BASELINE, 20));
        l4.setBounds(300, 300, 250, 30);
        l4.setForeground(Color.BLACK);
        bgl.add(l4);

        l3 = new JLabel("Login as Student");
        l3.setFont(new Font("", Font.CENTER_BASELINE, 18));
        l3.setBounds(240, 330, 250, 30);
        l3.setForeground(new Color(170, 51, 106));
        l3.addMouseListener(this);
        bgl.add(l3);

        l6 = new JLabel("~ Developed By Swaraj Bais");
        l6.setFont(new Font("", Font.ITALIC, 15));
        l6.setBounds(420, 460, 200, 25);
        l6.setForeground(new Color(33, 150, 243));
        bgl.add(l6);

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == l2) {
            this.setVisible(false);
            new RegisterApp().setVisible(true);
        } else if (e.getSource() == l3) {
            this.setVisible(false);
            new LoginApp().setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

class RegisterApp extends JFrame implements ActionListener, MouseListener {
    JButton reset, submit;
    JTextField f1;
    JPasswordField f2;
    JLabel l1, l2, br1, back;
    JCheckBox showPassword;

    public RegisterApp() {
        this.setSize(650, 530);
        this.setTitle("Student Management System");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon obg = new ImageIcon("background4.jpg");
        Image scaledImage = obg.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH);
        ImageIcon bg = new ImageIcon(scaledImage);
        JLabel bgl = new JLabel(bg);
        bgl.setBounds(0, 0, 650, 530);
        bgl.setLayout(null);
        this.add(bgl);

        back = new JLabel("←");
        back.setFont(new Font("", Font.BOLD, 40));
        back.setBounds(10, 10, 50, 20);
        back.addMouseListener(this);
        bgl.add(back);

        br1 = new JLabel("Register");
        br1.setFont(new Font("", Font.BOLD, 30));
        br1.setBounds(250, 50, 120, 50);
        bgl.add(br1);

        l1 = new JLabel("Enter UserName: ");
        l1.setFont(new Font("", Font.CENTER_BASELINE, 16));
        l1.setBounds(150, 150, 135, 30);
        bgl.add(l1);

        f1 = new JTextField();
        f1.setFont(new Font("", Font.BOLD, 14));
        f1.setBounds(320, 150, 170, 30);
        bgl.add(f1);

        l2 = new JLabel("Enter Password: ");
        l2.setFont(new Font("", Font.CENTER_BASELINE, 16));
        l2.setBounds(150, 210, 130, 30);
        bgl.add(l2);

        f2 = new JPasswordField();
        f2.setFont(new Font("", Font.BOLD, 12));
        f2.setBounds(320, 210, 170, 30);
        bgl.add(f2);

        showPassword = new JCheckBox("Show");
        showPassword.setBounds(420, 250, 70, 25);
        showPassword.setBackground(new Color(250, 198, 217));
        bgl.add(showPassword);
        showPassword.addActionListener(this);

        reset = new JButton("Reset");
        reset.setBounds(200, 300, 80, 30);
        reset.setBackground(new Color(250, 198, 217));
        reset.addActionListener(this);
        bgl.add(reset);

        submit = new JButton("Submit");
        submit.setBounds(330, 300, 80, 30);
        submit.setBackground(new Color(250, 198, 217));
        submit.addActionListener(this);
        bgl.add(submit);

        // this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e1) {
        if (e1.getSource() == reset) {
            f1.setText("");
            f2.setText("");
        } else if (e1.getSource() == submit) {
            String username = f1.getText();
            String password = new String(f2.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username and Password cannot be empty.", "Register",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            AuthenticationDatabase d1 = new AuthenticationDatabase();
            try {
                String existing = d1.result(username);
                if (existing != null) {
                    JOptionPane.showMessageDialog(this, "Username already exists!", "Register",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                d1.insert(username, password);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Registration failed: " + e.getMessage(), "Register",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            LoginApp l1 = new LoginApp();
            // this.dispose();
            this.setVisible(false);
            l1.setVisible(true);
            JOptionPane.showMessageDialog(l1, "Registered!", "Register", JOptionPane.PLAIN_MESSAGE);

        } else if (showPassword.isSelected()) {
            f2.setEchoChar((char) 0);
        } else {
            f2.setEchoChar('\u2022');
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
            new MainFrame().setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

class LoginApp extends JFrame implements ActionListener, MouseListener {
    JButton reset, submit;
    JTextField f1;
    JPasswordField f2;
    JLabel l1, l2, bl1, back, forget;
    String User_Password = null;
    JCheckBox showPassword;

    public LoginApp() {
        this.setSize(650, 530);
        this.setTitle("Student Management System");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon obg = new ImageIcon("background4.jpg");
        Image scaledImage = obg.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH);
        ImageIcon bg = new ImageIcon(scaledImage);
        JLabel bgl = new JLabel(bg);
        bgl.setBounds(0, 0, 650, 530);
        bgl.setLayout(null);
        this.add(bgl);

        back = new JLabel("←");
        back.setFont(new Font("", Font.BOLD, 40));
        back.setBounds(10, 10, 50, 20);
        back.addMouseListener(this);
        bgl.add(back);

        bl1 = new JLabel("Login");
        bl1.setFont(new Font("", Font.BOLD, 35));
        bl1.setBounds(280, 50, 100, 50);
        bgl.add(bl1);

        l1 = new JLabel("UserName: ");
        l1.setFont(new Font("", Font.CENTER_BASELINE, 17));
        l1.setBounds(190, 150, 120, 30);
        bgl.add(l1);

        f1 = new JTextField();
        f1.setFont(new Font("", Font.BOLD, 14));
        f1.setBounds(300, 150, 170, 30);
        bgl.add(f1);

        l2 = new JLabel("Password: ");
        l2.setFont(new Font("", Font.CENTER_BASELINE, 17));
        l2.setBounds(190, 210, 120, 30);
        bgl.add(l2);

        f2 = new JPasswordField();
        f2.setFont(new Font("", Font.BOLD, 12));
        f2.setBounds(300, 210, 170, 30);
        bgl.add(f2);

        showPassword = new JCheckBox("Show");
        showPassword.setBounds(400, 250, 70, 25);
        showPassword.setBackground(new Color(250, 198, 217));
        bgl.add(showPassword);
        showPassword.addActionListener(this);

        reset = new JButton("Reset");
        reset.setBounds(220, 330, 80, 30);
        reset.setBackground(new Color(250, 198, 217));
        reset.addActionListener(this);
        bgl.add(reset);

        submit = new JButton("Submit");
        submit.setBounds(350, 330, 80, 30);
        submit.setBackground(new Color(250, 198, 217));
        submit.addActionListener(this);
        bgl.add(submit);

        forget = new JLabel("forget password");
        forget.setFont(new Font("", Font.BOLD, 12));
        forget.setBounds(376, 285, 100, 20);
        forget.setForeground(new Color(3, 155, 229));
        forget.addMouseListener(this);
        bgl.add(forget);

        // this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e1) {
        if (e1.getSource() == reset) {
            f1.setText("");
            f2.setText("");
        } else if (e1.getSource() == submit) {
            String username = f1.getText();
            String password = new String(f2.getPassword());

            if (password.isEmpty() || username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No Input!!", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                AuthenticationDatabase d1 = new AuthenticationDatabase();
                User_Password = d1.result(username);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Register", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (User_Password == null) {
                JOptionPane.showMessageDialog(this, "Username does not exist!", "Login Failed",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (password.equals(User_Password)) {
                OptionFrame s1 = new OptionFrame();
                // this.dispose();
                this.setVisible(false);
                s1.setVisible(true);
                JOptionPane.showMessageDialog(s1, "Login Successfully!!", "", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Wrong Password!!", "Login Failed",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else if (showPassword.isSelected()) {
            f2.setEchoChar((char) 0);
        } else {
            f2.setEchoChar('\u2022');
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean exists;
        String username = f1.getText();
        if (e.getSource() == back) {
            this.setVisible(false);
            new MainFrame().setVisible(true);
        } else if (e.getSource() == forget) {
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No Input!!", "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            try {
                exists = new AuthenticationDatabase().isUserNameExits(username);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Forget Password", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!exists) {
                JOptionPane.showMessageDialog(null, "Username doesn't Exist!!", "Forget Password",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            String val = JOptionPane.showInputDialog(null, "Enter New Password", "Forget Password",
                    JOptionPane.PLAIN_MESSAGE);
            try {
                new AuthenticationDatabase().updatePassword(username, val);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(), "Forget Password", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Password is Changed!!", "Forget Password",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

class SecondFrame extends JFrame implements ActionListener {
    JLabel name, address, enroll, con, stud_Grade, mob_no, email, age, Branch, stud_id;
    JTextField n, a, e, c, s, m, ema, a1, b, id;
    JButton reset, submit, back;

    public SecondFrame() {
        this.setSize(650, 670);
        this.setTitle("Student Management System");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(219, 234, 254));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel sname = new JLabel("Student Registration");
        sname.setForeground(Color.BLACK);
        sname.setFont(new Font("", Font.BOLD, 20));
        sname.setBounds(220, 10, 200, 28);
        this.add(sname);

        name = new JLabel("Student Name");
        name.setForeground(Color.BLACK);
        name.setBounds(100, 70, 100, 25);
        this.add(name);

        n = new JTextField();
        n.setForeground(Color.BLACK);
        n.setBounds(340, 70, 180, 30);
        this.add(n);

        enroll = new JLabel("Enrollment Number");
        enroll.setForeground(Color.BLACK);
        enroll.setBounds(100, 120, 120, 25);
        this.add(enroll);

        e = new JTextField();
        e.setForeground(Color.BLACK);
        e.setBounds(340, 120, 180, 30);
        this.add(e);

        con = new JLabel("Date of Birth");
        con.setForeground(Color.BLACK);
        con.setBounds(100, 170, 140, 25);
        this.add(con);

        c = new JTextField();
        c.setForeground(Color.BLACK);
        c.setBounds(340, 170, 180, 30);
        this.add(c);

        mob_no = new JLabel("Student Contact Number");
        mob_no.setForeground(Color.BLACK);
        mob_no.setBounds(100, 220, 145, 25);
        this.add(mob_no);

        m = new JTextField();
        m.setForeground(Color.BLACK);
        m.setBounds(340, 220, 180, 30);
        this.add(m);

        stud_id = new JLabel("Student ID");
        stud_id.setForeground(Color.BLACK);
        stud_id.setBounds(100, 270, 140, 25);
        this.add(stud_id);

        id = new JTextField();
        id.setForeground(Color.BLACK);
        id.setBounds(340, 270, 180, 30);
        this.add(id);

        stud_Grade = new JLabel("Student 10th Grade");
        stud_Grade.setForeground(Color.BLACK);
        stud_Grade.setBounds(100, 320, 130, 25);
        this.add(stud_Grade);

        s = new JTextField();
        s.setForeground(Color.BLACK);
        s.setBounds(340, 320, 180, 30);
        this.add(s);

        email = new JLabel("Email Address");
        email.setForeground(Color.BLACK);
        email.setBounds(100, 370, 130, 25);
        this.add(email);

        ema = new JTextField();
        ema.setForeground(Color.BLACK);
        ema.setBounds(340, 370, 180, 30);
        this.add(ema);

        address = new JLabel("Student Address");
        address.setForeground(Color.BLACK);
        address.setBounds(100, 420, 140, 25);
        this.add(address);

        a = new JTextField();
        a.setForeground(Color.BLACK);
        a.setBounds(340, 420, 180, 30);
        this.add(a);

        age = new JLabel("Student Age");
        age.setForeground(Color.BLACK);
        age.setBounds(100, 470, 100, 25);
        this.add(age);

        a1 = new JTextField();
        a1.setForeground(Color.BLACK);
        a1.setBounds(340, 470, 180, 30);
        this.add(a1);

        Branch = new JLabel("Student Departement");
        Branch.setForeground(Color.BLACK);
        Branch.setBounds(100, 520, 140, 25);
        this.add(Branch);

        b = new JTextField();
        b.setForeground(Color.BLACK);
        b.setBounds(340, 520, 180, 30);
        this.add(b);

        reset = new JButton("Reset");
        reset.setForeground(Color.BLACK);
        reset.setBackground(new Color(144, 202, 249));
        reset.setBounds(200, 580, 80, 25);
        this.add(reset);
        reset.addActionListener(this);

        submit = new JButton("Submit");
        submit.setForeground(Color.BLACK);
        submit.setBackground(new Color(144, 202, 249));
        submit.setBounds(350, 580, 80, 25);
        this.add(submit);
        submit.addActionListener(this);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.LIGHT_GRAY);
        back.setBounds(10, 15, 80, 25);
        this.add(back);
        back.addActionListener(this);

        // this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e1) {
        if (e1.getSource() == reset) {
            n.setText("");
            a.setText("");
            e.setText("");
            c.setText("");
            s.setText("");
            m.setText("");
            ema.setText("");
            a1.setText("");
            b.setText("");
            id.setText("");
        } else if (e1.getSource() == back) {
            this.setVisible(false);
            new OptionFrame().setVisible(true);
        } else if (e1.getSource() == submit) {
            String[] arr = new String[10];
            arr[0] = n.getText();
            arr[1] = e.getText();
            arr[2] = c.getText();
            arr[3] = m.getText();
            arr[4] = id.getText();
            arr[5] = s.getText();
            arr[6] = ema.getText();
            arr[7] = a.getText();
            arr[8] = a1.getText();
            arr[9] = b.getText();
            for (String val : arr) {
                if (val.equals("")) {
                    JOptionPane.showMessageDialog(this, "No Input!!", "", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            try {
                AuthenticationDatabase dam = new AuthenticationDatabase();
                if (dam.isEnrollmentExists(arr[1])) {
                    JOptionPane.showMessageDialog(this, "Enrollment number already exists!", "Duplicate Entry",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                dam.insertIntoStudent(arr);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Registration failed: " + e.getMessage(), "Register",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, "Data Added Successfully!", "Student Data", JOptionPane.PLAIN_MESSAGE);
        }
    }
}

class AuthenticationDatabase {

    void createTable() throws SQLException, ClassNotFoundException {
        String query = "Create table Authentication(username varchar(20) primary key,Password varchar(20))";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        Statement s1 = con.createStatement();
        s1.executeUpdate(query);
    }

    void createStudentTable() throws SQLException, ClassNotFoundException {
        String query = "Create table StudentInfo(name varchar(25), enrollment_no varchar(15) primary key,D_O_B varchar(12),s_contact_no varchar(12),Student_Id varchar(10),grade varchar(10),Email varchar(25),student_address varchar(30), age number,Dept varchar(10))";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        Statement s1 = con.createStatement();
        s1.executeUpdate(query);
    }

    void insert(String username, String password) throws SQLException, ClassNotFoundException {
        String query = "insert into Authentication values(?,?)";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p1 = con.prepareStatement(query);
        p1.setString(1, username);
        p1.setString(2, password);
        p1.executeUpdate();
    }

    void updatePassword(String username, String password) throws SQLException, ClassNotFoundException {
        String query = "update Authentication set Password = ? where username= ?";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p1 = con.prepareStatement(query);
        p1.setString(1, password);
        p1.setString(2, username);
        p1.executeUpdate();
    }

    void insertIntoStudent(String[] arr) throws SQLException, ClassNotFoundException {
        String query = "insert into StudentInfo values( ? , ? , ? , ? , ? , ? , ? , ? , ?, ? )";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p1 = con.prepareStatement(query);
        p1.setString(1, arr[0]);
        p1.setString(2, arr[1]);
        p1.setString(3, arr[2]);
        p1.setString(4, arr[3]);
        p1.setString(5, arr[4]);
        p1.setString(6, arr[5]);
        p1.setString(7, arr[6]);
        p1.setString(8, arr[7]);
        p1.setInt(9, Integer.parseInt(arr[8]));
        p1.setString(10, arr[9]);
        p1.executeUpdate();
    }

    boolean isUserNameExits(String username) throws SQLException, ClassNotFoundException {
        String query = "select count(*) as count from Authentication where username= ? ";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p1 = con.prepareStatement(query);
        p1.setString(1, username);
        ResultSet r1 = p1.executeQuery();
        Boolean exits = false;
        if (r1.next()) {
            exits = r1.getInt("count") > 0;
        }
        return exits;
    }

    String result(String username) throws SQLException, ClassNotFoundException {
        String password = null;
        String query = "select Password from Authentication where Username=?";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p1 = con.prepareStatement(query);
        p1.setString(1, username);
        ResultSet r1 = p1.executeQuery();
        if (r1.next()) {
            password = r1.getString("Password");
        }
        return password;
    }

    int deleteStudentInfo(String enrollment) throws SQLException, ClassNotFoundException {
        String query1 = "delete from admission where enrollment_no= ? ";
        String query = "delete from studentInfo where enrollment_no= ? ";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p2 = con.prepareStatement(query1);
        p2.setString(1, enrollment);
        p2.executeUpdate();
        PreparedStatement p1 = con.prepareStatement(query);
        p1.setString(1, enrollment);
        int count = p1.executeUpdate();
        return count;
    }

    boolean isEnrollmentExists(String enrollment) throws SQLException, ClassNotFoundException {
        String query = "select count(*) from studentinfo where enrollment_no=?";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p1 = con.prepareStatement(query);
        p1.setString(1, enrollment);
        ResultSet r1 = p1.executeQuery();
        boolean exists = false;
        if (r1.next()) {
            exists = r1.getInt(1) > 0;
        }
        return exists;
    }

    void resultStudent(String[][] data) throws SQLException, ClassNotFoundException {

        // Clear all values in the array to avoid amibiguity
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = "";
            }
        }

        // use to fetch data into string 2d array and display using Jtable
        String query = "select * from studentinfo";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        Statement s1 = con.createStatement();
        ResultSet r1 = s1.executeQuery(query);
        int i = 0;
        while (r1.next() && i < data.length) {
            data[i][0] = r1.getString("name");
            data[i][1] = r1.getString("enrollment_no");
            data[i][2] = r1.getString("D_O_B");
            data[i][3] = r1.getString("s_contact_no");
            data[i][4] = r1.getString("Student_Id");
            data[i][5] = r1.getString("grade");
            data[i][6] = r1.getString("Email");
            data[i][7] = r1.getString("student_address");
            data[i][8] = r1.getString("age");
            data[i][9] = r1.getString("Dept");
            i++;
        }
    }

    void StudentBonafiedData(String[] data, String enroll) throws SQLException, ClassNotFoundException {
        // use to fetch data into string array and to display using Jtable
        String query = "select name, D_O_B, student_address from studentinfo where enrollment_no = ?";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p1 = con.prepareStatement(query);
        p1.setString(1, enroll);
        ResultSet r1 = p1.executeQuery();
        if (r1.next()) {
            data[0] = r1.getString("name");
            data[1] = r1.getString("D_O_B");
            data[2] = r1.getString("student_address");
        }
    }

    void updateStudentInfo(String enroll, String item, String value) throws SQLException, ClassNotFoundException {
        String query = "update studentinfo set " + item + " = ? where enrollment_no = ? ";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p1 = con.prepareStatement(query);
        if (item.equals("age")) {
            p1.setInt(1, Integer.parseInt(value));
        } else {
            p1.setString(1, value);
        }
        p1.setString(2, enroll);
        p1.executeUpdate();
    }

    void StudentLeavinngData(String[] data, String enroll) throws SQLException, ClassNotFoundException {
        // use to fetch data into string array and to display using Jtable
        String query = "select enrollment_no,Stud_name,Fath_name,branch,D_O_B,Gender,Contact,P_Address,category from admission where enrollment_no = ? ";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p1 = con.prepareStatement(query);
        p1.setString(1, enroll);
        ResultSet r1 = p1.executeQuery();
        if (r1.next()) {
            data[0] = r1.getString("enrollment_no");
            data[1] = r1.getString("Stud_name");
            data[2] = r1.getString("Fath_name");
            data[3] = r1.getString("branch");
            data[4] = r1.getString("D_O_B");
            data[5] = "Indian";
            data[6] = r1.getString("Gender");
            data[7] = r1.getString("Contact");
            data[8] = r1.getString("P_Address");
            data[9] = r1.getString("category");
        }
    }

    void InsertStudentAdmmission(String[] data) throws SQLException, ClassNotFoundException{
        String query="INSERT INTO admission VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        PreparedStatement p1=con.prepareStatement(query);
        for(int i=0;i<data.length;i++){
            p1.setString(i+1, data[i]);
        }
        p1.executeUpdate();
    }

    void admissionData(String[][] data) throws SQLException, ClassNotFoundException{
        String query="select * from admission";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe", "system", "bais");
        Statement s1 = con.createStatement();
        ResultSet r1 = s1.executeQuery(query);
        // Clear all values in the array to avoid amibiguity
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = "";
            }
        }
        
        int i=0;
        while(r1.next() && i < data.length){
            data[i][0]=r1.getString("ADMISSION_ID");
            data[i][1]=r1.getString("STUD_NAME");
            data[i][2]=r1.getString("BRANCH");
            data[i][3]=r1.getString("D_O_B");
            data[i][4]=r1.getString("GENDER");
            data[i][5]=r1.getString("FATH_NAME");
            data[i][6]=r1.getString("P_ADDRESS");
            data[i][7]=r1.getString("CONTACT");
            data[i][8]=r1.getString("L_ADDRESS");
            data[i][9]=r1.getString("CATEGORY");
            data[i][10]=r1.getString("SCHOLARSHIP");
            data[i][11]=r1.getString("ENROLLMENT_NO");
            data[i][12]=r1.getString("CLG_PLACE");
            data[i][13]=r1.getString("ADMISSION_DATE");
            data[i][14]=r1.getString("MARK_MEMO");
            data[i][15]=r1.getString("TC");
            data[i][16]=r1.getString("CASTE_CERTIFICATE");
            data[i][17]=r1.getString("DEFENCE_CERT");
            data[i][18]=r1.getString("NON_CREAMY_CERT");
            data[i][19]=r1.getString("EBC_FORM");
            data[i][20]=r1.getString("FREESHIP_FORM");
            i++;
        }
    }
}

class OptionFrame extends JFrame implements ActionListener {
    MenuBar mb;
    Menu m1, m2,m1_sub,m1_sub2;
    MenuItem neww, delete, show, back, logout, update, bonafite, addmission, leaving,admiss_data;
    JLabel l1, l2, message, l3,h1,h2,h3,h4,h5;
    JTextField t1, t2;
    JButton b1, b2, b3, b4, b5;
    JTable tab;
    JScrollPane p1;
    JComboBox<String> com;
    String[][] data;
    String[] Bonafieddata = new String[3];
    String[] Leavingdata = new String[10];
    public OptionFrame() {
        this.setSize(680, 560);
        this.setTitle("Student Management System");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(219, 234, 254));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mb = new MenuBar();
        mb.setFont(new Font("", Font.BOLD, 13));
        this.setMenuBar(mb);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 0, 666, 5);
        separator.setForeground(Color.DARK_GRAY);
        this.add(separator);

        m1 = new Menu("New");
        mb.add(m1);

        m1_sub = new Menu("New Registeration");
        m1.add(m1_sub);

        neww = new MenuItem("Register");
        m1_sub.add(neww);
        
        update = new MenuItem("Update");
        m1_sub.add(update);
        
        delete = new MenuItem("Delete");
        m1_sub.add(delete);
        
        show = new MenuItem("Show");
        m1_sub.add(show);
        
        m1_sub2 = new Menu("New Admission");
        m1.add(m1_sub2);

        addmission = new MenuItem("Admission");
        m1_sub2.add(addmission);

        admiss_data=new MenuItem("Show data");
        m1_sub2.add(admiss_data);
        
        back = new MenuItem("Back");
        m1.add(back);

        logout = new MenuItem("Logout");
        m1.add(logout);

        m2 = new Menu("View");
        mb.add(m2);

        bonafite = new MenuItem("Bonafied");
        m2.add(bonafite);

        leaving = new MenuItem("Leaving Cer.");
        m2.add(leaving);

        message = new JLabel("No Activity Clicked!!");
        message.setFont(new Font("", Font.ITALIC, 18));
        message.setBounds(240, 200, 200, 20);
        this.add(message);

        h1 = new JLabel("DELETE RECORD");
        h1.setFont(new Font("", Font.BOLD, 20));
        h1.setForeground(Color.red);
        h1.setBounds(240, 60, 400, 23);
        h1.setVisible(false);
        this.add(h1);

        h2 = new JLabel("UPDATE RECORD");
        h2.setFont(new Font("", Font.BOLD, 20));
        h2.setForeground(Color.red);
        h2.setBounds(240, 60, 400, 23);
        h2.setVisible(false);
        this.add(h2);

        h3 = new JLabel(" Admission Form ");
        h3.setFont(new Font("", Font.BOLD, 25));
        h3.setForeground(Color.red);
        h3.setBounds(225, 60, 400, 23);
        h3.setVisible(false);
        this.add(h3);

        h4 = new JLabel("Student Bonafided");
        h4.setFont(new Font("", Font.BOLD, 25));
        h4.setForeground(Color.red);
        h4.setBounds(220, 60, 400, 23);
        h4.setVisible(false);
        this.add(h4);

        h5 = new JLabel("Student Leaving Certificate");
        h5.setFont(new Font("", Font.BOLD, 25));
        h5.setForeground(Color.red);
        h5.setBounds(170, 60, 400, 23);
        h5.setVisible(false);
        this.add(h5);

        l1 = new JLabel("Enter Enrollment Number");
        l1.setFont(new Font("", Font.BOLD, 15));
        l1.setBounds(235, 150, 200, 20);
        l1.setVisible(false);
        this.add(l1);

        l3 = new JLabel("Enter Value");
        l3.setFont(new Font("", Font.BOLD, 14));
        l3.setBounds(235, 285, 200, 20);
        l3.setVisible(false);
        this.add(l3);

        t1 = new JTextField("");
        t1.setFont(new Font("", Font.PLAIN, 14));
        t1.setBounds(230, 180, 200, 30);
        t1.setVisible(false);
        this.add(t1);

        b1 = new JButton("Delete");
        b1.setForeground(Color.BLACK);
        b1.setBackground(new Color(144, 202, 249));
        b1.setBounds(280, 225, 80, 25);
        b1.setVisible(false);
        this.add(b1);

        data = new String[30][30];
        String[] column = { "Name", "Enrollment", "D.O.B", "S_contact", "Id", "Grade", "Email", "Address", "Age",
                "Dept" };
        tab = new JTable(data, column);
        p1 = new JScrollPane(tab);
        p1.setBounds(1, 1, 665, 505);
        p1.setVisible(false);
        this.add(p1);

        l2 = new JLabel("Select Attribute you want to change");
        l2.setFont(new Font("", Font.BOLD, 15));
        l2.setBounds(190, 215, 280, 20);
        l2.setVisible(false);
        this.add(l2);

        t2 = new JTextField();
        t2.setFont(new Font("", Font.PLAIN, 14));
        t2.setBounds(230, 310, 200, 30);
        t2.setVisible(false);
        this.add(t2);

        b2 = new JButton("Update");
        b2.setForeground(Color.BLACK);
        b2.setBackground(new Color(144, 202, 249));
        b2.setBounds(280, 360, 80, 25);
        b2.setVisible(false);
        this.add(b2);

        b3 = new JButton("Generate");
        b3.setForeground(Color.BLACK);
        b3.setBackground(new Color(144, 202, 249));
        b3.setBounds(280, 225, 100, 25);
        b3.setVisible(false);
        this.add(b3);

        b4 = new JButton("Submit");
        b4.setForeground(Color.BLACK);
        b4.setBackground(new Color(144, 202, 249));
        b4.setBounds(280, 225, 100, 25);
        b4.setVisible(false);
        this.add(b4);

        b5 = new JButton("Generate");
        b5.setForeground(Color.BLACK);
        b5.setBackground(new Color(144, 202, 249));
        b5.setBounds(280, 225, 100, 25);
        b5.setVisible(false);
        this.add(b5);

        String[] item = { "name", "enrollment_no", "D_O_B", "s_contact_no", "Student_Id", "grade", "Email",
                "student_address", "age", "Dept" };
        com = new JComboBox<String>(item);
        com.setBounds(230, 250, 200, 30);
        com.setVisible(false);
        this.add(com);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        neww.addActionListener(this);
        addmission.addActionListener(this);
        show.addActionListener(this);
        admiss_data.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        back.addActionListener(this);
        bonafite.addActionListener(this);
        leaving.addActionListener(this);
        logout.addActionListener(this);

        // this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int count = 0;
        if (e.getSource() == neww) {
            this.setVisible(false);
            new SecondFrame().setVisible(true);
        } else if (e.getSource() == delete) {
            h1.setVisible(true);
            h2.setVisible(false);
            h3.setVisible(false);
            h4.setVisible(false);
            h5.setVisible(false);
            l1.setVisible(true);
            t1.setVisible(true);
            b1.setVisible(true);
            message.setVisible(false);
            p1.setVisible(false);
            t2.setVisible(false);
            l2.setVisible(false);
            l3.setVisible(false);
            com.setVisible(false);
            b2.setVisible(false);
            b3.setVisible(false);
            b4.setVisible(false);
            b5.setVisible(false);
        } else if (e.getSource() == back) {
            message.setVisible(true);
            h1.setVisible(false);
            h2.setVisible(false);
            h3.setVisible(false);
            h4.setVisible(false);
            h5.setVisible(false);
            p1.setVisible(false);
            l1.setVisible(false);
            l2.setVisible(false);
            l3.setVisible(false);
            t1.setVisible(false);
            t2.setVisible(false);
            com.setVisible(false);
            b1.setVisible(false);
            b2.setVisible(false);
            b3.setVisible(false);
            b4.setVisible(false);
            b5.setVisible(false);
        } else if (e.getSource() == b1) {
            String str = t1.getText().trim();
            if (str.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Enrollment Number", "Input Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                count = new AuthenticationDatabase().deleteStudentInfo(str);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, "Registration failed: " + e1.getMessage(), "Register",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (count > 0) {
                JOptionPane.showMessageDialog(this, count + " Rows Deleted", "Database", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, count + " Rows Deleted", "Database", JOptionPane.PLAIN_MESSAGE);
            }
            t1.setText("");
            l1.setVisible(false);
            t1.setVisible(false);
            b1.setVisible(false);
            h1.setVisible(false);
            h2.setVisible(false);
            h3.setVisible(false);
            h4.setVisible(false);
            h5.setVisible(false);
            message.setVisible(true);
        } else if (e.getSource() == show) {
            try {
                new AuthenticationDatabase().resultStudent(data);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Database", JOptionPane.ERROR_MESSAGE);
                return;
            }
            t1.setText("");
            t2.setText("");
            h1.setVisible(false);
            h2.setVisible(false);
            h3.setVisible(false);
            h4.setVisible(false);
            h5.setVisible(false);
            p1.setVisible(true);
            message.setVisible(false);
            l1.setVisible(false);
            l2.setVisible(false);
            l3.setVisible(false);
            t1.setVisible(false);
            t2.setVisible(false);
            b1.setVisible(false);
            com.setVisible(false);
            b2.setVisible(false);
            b3.setVisible(false);
            b4.setVisible(false);
            b5.setVisible(false);
        } else if (e.getSource() == logout) {
            this.setVisible(false);
            new MainFrame().setVisible(true);
        } else if (e.getSource() == update) {
            message.setVisible(false);
            h1.setVisible(false);
            h2.setVisible(true);
            h3.setVisible(false);
            h4.setVisible(false);
            h5.setVisible(false);
            p1.setVisible(false);
            b1.setVisible(false);
            b4.setVisible(false);
            b3.setVisible(false);
            b5.setVisible(false);
            l1.setVisible(true);
            l2.setVisible(true);
            l3.setVisible(true);
            t1.setVisible(true);
            t2.setVisible(true);
            com.setVisible(true);
            b2.setVisible(true);
        } else if (e.getSource() == b2) {
            String enroll = t1.getText();
            String value = t2.getText();
            String item = (String) com.getSelectedItem();

            if (enroll.isEmpty() || value.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Input", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                new AuthenticationDatabase().updateStudentInfo(enroll, item, value);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Database", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(this, "Data Updated!", "Database", JOptionPane.PLAIN_MESSAGE);
            t1.setText("");
            t2.setText("");
            h1.setVisible(false);
            h2.setVisible(false);
            h3.setVisible(false);
            h4.setVisible(false);
            h5.setVisible(false);
            message.setVisible(true);
            l1.setVisible(false);
            l2.setVisible(false);
            l3.setVisible(false);
            t1.setVisible(false);
            t2.setVisible(false);
            com.setVisible(false);
            b2.setVisible(false);
        } else if (e.getSource() == bonafite) {
            message.setVisible(false);
            h1.setVisible(false);
            h2.setVisible(false);
            h3.setVisible(false);
            h4.setVisible(true);
            h5.setVisible(false);
            p1.setVisible(false);
            l1.setVisible(true);
            t1.setVisible(true);
            b3.setVisible(true);
            b4.setVisible(false);
            b5.setVisible(false);
            b1.setVisible(false);
            t2.setVisible(false);
            l2.setVisible(false);
            l3.setVisible(false);
            com.setVisible(false);
            b2.setVisible(false);
        } else if (e.getSource() == b3) {
            String enroll = t1.getText();
            if (enroll.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Enrollment Number", "Input Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                new AuthenticationDatabase().StudentBonafiedData(Bonafieddata, enroll);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Database", JOptionPane.ERROR_MESSAGE);
                return;
            }
            t1.setText("");
            l1.setVisible(false);
            t1.setVisible(false);
            b3.setVisible(false);
            h1.setVisible(false);
            h2.setVisible(false);
            h3.setVisible(false);
            h4.setVisible(false);
            h5.setVisible(false);
            message.setVisible(true);
            // this.setVisible(false);
            StudentBonafied s1 = new StudentBonafied();
            s1.data(this);
            s1.setVisible(true);
        } else if (e.getSource() == addmission) {
            message.setVisible(false);
            h1.setVisible(false);
            h2.setVisible(false);
            h3.setVisible(true);
            h4.setVisible(false);
            h5.setVisible(false);
            p1.setVisible(false);
            l1.setVisible(true);
            t1.setVisible(true);
            b4.setVisible(true);
            b5.setVisible(false);
            b3.setVisible(false);
            b1.setVisible(false);
            t2.setVisible(false);
            l2.setVisible(false);
            l3.setVisible(false);
            com.setVisible(false);
            b2.setVisible(false);
        } else if (e.getSource() == b4) {
            String enroll = t1.getText();
            boolean con = false;
            if (enroll.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Enrollment Number", "Input Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            try {
                con = new AuthenticationDatabase().isEnrollmentExists(enroll);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Database", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (con) {
                t1.setText("");
                l1.setVisible(false);
                t1.setVisible(false);
                b4.setVisible(false);
                h1.setVisible(false);
                h2.setVisible(false);
                h3.setVisible(false);
                h4.setVisible(false);
                h5.setVisible(false);
                message.setVisible(true);
                // this.setVisible(false);
                StudentAdmission a1 = new StudentAdmission();
                a1.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Do Registeration!!", "Admission", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else if (e.getSource() == leaving) {
            message.setVisible(false);
            h1.setVisible(false);
            h2.setVisible(false);
            h3.setVisible(false);
            h4.setVisible(false);
            h5.setVisible(true);
            p1.setVisible(false);
            l1.setVisible(true);
            t1.setVisible(true);
            b5.setVisible(true);
            b3.setVisible(false);
            b4.setVisible(false);
            b1.setVisible(false);
            t2.setVisible(false);
            l2.setVisible(false);
            l3.setVisible(false);
            com.setVisible(false);
            b2.setVisible(false);
        } else if (e.getSource() == b5) {
            String enroll = t1.getText();
            if (enroll.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter Enrollment Number", "Input Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            // edit
            try {
                new AuthenticationDatabase().StudentLeavinngData(Leavingdata, enroll);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Database", JOptionPane.ERROR_MESSAGE);
                return;
            }
            t1.setText("");
            l1.setVisible(false);
            t1.setVisible(false);
            b5.setVisible(false);
            h1.setVisible(false);
            h2.setVisible(false);
            h3.setVisible(false);
            h4.setVisible(false);
            h5.setVisible(false);
            message.setVisible(true);
            StudentLeavingCer s1 = new StudentLeavingCer();
            s1.assign(this);
            s1.setVisible(true);
        }else if(e.getSource()==admiss_data){
            new ShowAdmissionData().setVisible(true);
        }
    }
}

class StudentBonafied extends JFrame implements ActionListener{
    JLabel d1;
    static int count = 1010;
    String[] data = new String[3];
    JButton print;
    public StudentBonafied() {
        this.setSize(700, 600);
        this.setTitle("Bonafied Certificate");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel head = new JLabel("GOVERNMENT POLYTECHNIC, NANDED");
        head.setFont(new Font("", Font.BOLD, 20));
        head.setForeground(Color.red);
        head.setBounds(150, 1, 400, 23);
        this.add(head);

        print=new JButton("Print ");
        print.setBounds(570,5,110,25);
        print.setBackground(new Color(208, 211, 212));
        print.addActionListener(this);
        this.add(print);

        JLabel sub = new JLabel("VEER SAWARKAR MARK, BABANAGAR, NANDED");
        sub.setFont(new Font("", Font.BOLD, 12));
        sub.setForeground(Color.BLACK);
        sub.setBounds(200, 25, 300, 15);
        this.add(sub);

        JLabel sub1 = new JLabel("PHONE : 02462 - 254210, Tele. Fax. : 252520");
        sub1.setFont(new Font("", Font.BOLD, 12));
        sub1.setForeground(Color.BLACK);
        sub1.setBounds(220, 40, 300, 15);
        this.add(sub1);

        JLabel sub2 = new JLabel("www.gpnanded.org.in");
        sub2.setFont(new Font("", Font.BOLD, 12));
        sub2.setForeground(Color.BLACK);
        sub2.setBounds(280, 55, 300, 15);
        this.add(sub2);

        ImageIcon i1 = new ImageIcon("logoo.jpg");
        JLabel img = new JLabel(i1);
        img.setBounds(5, 3, 80, 80);
        this.add(img);

        JSeparator sep = new JSeparator();
        sep.setBounds(0, 80, 700, 10);
        sep.setForeground(Color.BLACK);
        this.add(sep);

        JLabel no = new JLabel("No. " + count);
        no.setFont(new Font("", Font.BOLD, 12));
        no.setForeground(Color.BLACK);
        no.setBounds(25, 100, 50, 15);
        this.add(no);

        JLabel a1 = new JLabel("No. GPND/SS/Bonafied/ 2024 - 2025");
        a1.setFont(new Font("", Font.BOLD, 12));
        a1.setForeground(Color.BLACK);
        a1.setBounds(450, 100, 210, 15);
        this.add(a1);

        LocalDate loc = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = loc.format(formatter);

        JLabel a2 = new JLabel("Date: " + formattedDate);
        a2.setFont(new Font("", Font.BOLD, 12));
        a2.setForeground(Color.BLACK);
        a2.setBounds(450, 120, 120, 15);
        this.add(a2);

        JLabel text = new JLabel("Bonafied Certificate");
        text.setFont(new Font("", Font.ITALIC, 25));
        text.setForeground(Color.red);
        text.setBounds(240, 160, 250, 23);
        this.add(text);

        d1 = new JLabel();
        d1.setFont(new Font("", Font.BOLD, 20));
        d1.setForeground(Color.BLACK);
        d1.setBounds(25, 130, 600, 400);
        this.add(d1);

        JLabel o1 = new JLabel("Principal");
        o1.setFont(new Font("", Font.BOLD, 13));
        o1.setForeground(Color.red);
        o1.setBounds(510, 485, 100, 20);
        this.add(o1);
        JLabel o = new JLabel("Government Polytechnic, Nanded.");
        o.setFont(new Font("", Font.BOLD, 13));
        o.setForeground(Color.red);
        o.setBounds(425, 500, 220, 30);
        this.add(o);

        // this.setVisible(true);
    }

    public void data(OptionFrame o1) {
        this.data = o1.Bonafieddata;
        d1.setText("<html>"
                + "<p style='font-size:14px;'>"
                + "This is to certify that, Mr./Miss. <u>" + data[0] + "</u><br><br>"
                + "is/was a Bonafide student of this institute studying in I/II/III/IV/V/VI Semester Diploma Course "
                + "in CE/EE/ME/IF/PG/MU/CE(SS)/ME(SS) Engineering during the academic year <b>2024-2025</b>.<br><br>"
                + "As per this office record, his/her Date of Birth is <u>" + data[1] + "</u>,<br>"
                + "and Residential Address is <u>" + data[2] + "</u>.<br><br>"
                + "He/She bears a good moral character."
                + "</p>"
                + "</html>");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        pjob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                // Print the entire JFrame content
                StudentBonafied.this.printAll(g2d); 

                return PAGE_EXISTS;
            }
        });

        if (pjob.printDialog()) {
            try {
                pjob.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Printing error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

class StudentAdmission extends JFrame implements ActionListener {
    JLabel head, sub, sub1, h1, img, b1, c1, name, branch, dob, gender, FName, img1, P_address, contact, L_address,
            category, scholarship, table, undertakingLabel, placeLabel, dateLabel, signLabel, officeLabel,e1;
    JButton print, submit;
    JTextField t1, t2, t3, t5, t6, t7, t8, t9, t10,t11, placeField, dateField,text;
    JRadioButton male, female, rad, R[]=new JRadioButton[7];
    boolean con = false;
    String[] data = new String[21];

    public StudentAdmission() {
        this.setSize(1100, 650);
        this.setTitle("Student Admission Form");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        head = new JLabel("GOVERNMENT POLYTECHNIC, NANDED");
        head.setFont(new Font("", Font.BOLD, 25));
        head.setForeground(Color.red);
        head.setBounds(300, 3, 500, 23);
        this.add(head);

        sub = new JLabel("VEER SAWARKAR MARK, BABANAGAR, NANDED");
        sub.setFont(new Font("", Font.BOLD, 15));
        sub.setForeground(Color.BLACK);
        sub.setBounds(350, 30, 400, 15);
        this.add(sub);

        sub1 = new JLabel("PHONE : 02462 - 254210, Email :  govtpolynanded@yahoo.com");
        sub1.setFont(new Font("", Font.BOLD, 11));
        sub1.setForeground(Color.BLACK);
        sub1.setBounds(375, 45, 400, 15);
        this.add(sub1);

        JSeparator sep = new JSeparator();
        sep.setBounds(0, 80, 1100, 5);
        sep.setForeground(Color.black);
        this.add(sep);

        h1 = new JLabel("ADMISSION FORM( SEMESTER : _______________ )");
        h1.setFont(new Font("", Font.BOLD, 11));
        h1.setForeground(Color.BLACK);
        h1.setBounds(10, 90, 300, 15);
        this.add(h1);

        ImageIcon i1 = new ImageIcon("logoo.jpg");
        img = new JLabel(i1);
        img.setBounds(5, 1, 80, 80);
        this.add(img);

        b1 = new JLabel("BRANCH : _______________");
        b1.setFont(new Font("", Font.BOLD, 11));
        b1.setForeground(Color.BLACK);
        b1.setBounds(920, 90, 300, 15);
        this.add(b1);

        c1 = new JLabel("Roll.no : ");
        c1.setFont(new Font("", Font.BOLD, 11));
        c1.setForeground(Color.BLACK);
        c1.setBounds(930, 10, 300, 15);
        this.add(c1);

        text = new JTextField();
        text.setFont(new Font("", Font.BOLD, 15));
        text.setForeground(Color.BLACK);
        text.setBackground(Color.WHITE);
        text.setBounds(990, 10, 80, 20);
        this.add(text);

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(0, 110, 1100, 5);
        sep2.setForeground(Color.black);
        this.add(sep2);

        JPanel content = new JPanel();
        content.setLayout(null);
        content.setBackground(Color.WHITE);
        content.setPreferredSize(new Dimension(1070, 1600));

        JScrollPane scroll = new JScrollPane(content);
        scroll.setBounds(0, 110, 1090, 505);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);

        name = new JLabel("1.     Full Name of the Student :");
        name.setFont(new Font("", Font.BOLD, 15));
        name.setForeground(Color.BLACK);
        name.setBounds(10, 25, 300, 15);
        content.add(name);

        t1 = new JTextField();
        t1.setFont(new Font("", Font.BOLD, 15));
        t1.setForeground(Color.BLACK);
        t1.setBounds(350, 18, 250, 30);
        content.add(t1);

        branch = new JLabel("2.     Branch :");
        branch.setFont(new Font("", Font.BOLD, 15));
        branch.setForeground(Color.BLACK);
        branch.setBounds(10, 65, 300, 15);
        content.add(branch);

        t2 = new JTextField();
        t2.setFont(new Font("", Font.BOLD, 15));
        t2.setForeground(Color.BLACK);
        t2.setBounds(350, 58, 150, 30);
        content.add(t2);

        dob = new JLabel("3.     Date of Birth :");
        dob.setFont(new Font("", Font.BOLD, 15));
        dob.setForeground(Color.BLACK);
        dob.setBounds(10, 105, 300, 15);
        content.add(dob);

        t3 = new JTextField();
        t3.setFont(new Font("", Font.BOLD, 15));
        t3.setForeground(Color.BLACK);
        t3.setBounds(350, 98, 150, 30);
        content.add(t3);

        gender = new JLabel("4.     Gender :");
        gender.setFont(new Font("", Font.BOLD, 15));
        gender.setForeground(Color.BLACK);
        gender.setBounds(10, 145, 300, 15);
        content.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(350, 138, 80, 30);
        male.setBackground(Color.WHITE);
        content.add(male);
        male.addActionListener(this);

        female = new JRadioButton("Female");
        female.setBounds(450, 138, 80, 30);
        female.setBackground(Color.WHITE);
        content.add(female);
        female.addActionListener(this);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(male);
        g1.add(female);

        FName = new JLabel("5.     Father Name :");
        FName.setFont(new Font("", Font.BOLD, 15));
        FName.setForeground(Color.BLACK);
        FName.setBounds(10, 185, 300, 15);
        content.add(FName);

        t5 = new JTextField();
        t5.setFont(new Font("", Font.BOLD, 15));
        t5.setForeground(Color.BLACK);
        t5.setBounds(350, 178, 250, 30);
        content.add(t5);

        ImageIcon i2 = new ImageIcon("student.png");
        img1 = new JLabel(i2);
        img1.setBounds(850, 30, 150, 150);
        content.add(img1);

        P_address = new JLabel("6.     Permanent Address :");
        P_address.setFont(new Font("", Font.BOLD, 15));
        P_address.setForeground(Color.BLACK);
        P_address.setBounds(10, 225, 300, 15);
        content.add(P_address);

        t6 = new JTextField();
        t6.setFont(new Font("", Font.BOLD, 15));
        t6.setForeground(Color.BLACK);
        t6.setBounds(350, 218, 300, 30);
        content.add(t6);

        contact = new JLabel("7.     Contact. no :");
        contact.setFont(new Font("", Font.BOLD, 15));
        contact.setForeground(Color.BLACK);
        contact.setBounds(730, 225, 150, 15);
        content.add(contact);

        t8 = new JTextField();
        t8.setFont(new Font("", Font.BOLD, 15));
        t8.setForeground(Color.BLACK);
        t8.setBounds(880, 218, 180, 30);
        content.add(t8);

        L_address = new JLabel("8.     Local Address :");
        L_address.setFont(new Font("", Font.BOLD, 15));
        L_address.setForeground(Color.BLACK);
        L_address.setBounds(10, 265, 300, 15);
        content.add(L_address);

        t7 = new JTextField();
        t7.setFont(new Font("", Font.BOLD, 15));
        t7.setForeground(Color.BLACK);
        t7.setBounds(350, 258, 300, 30);
        content.add(t7);

        category = new JLabel("9.     Category :");
        category.setFont(new Font("", Font.BOLD, 15));
        category.setForeground(Color.BLACK);
        category.setBounds(730, 265, 150, 20);
        content.add(category);

        t9 = new JTextField();
        t9.setFont(new Font("", Font.BOLD, 15));
        t9.setForeground(Color.BLACK);
        t9.setBounds(880, 258, 180, 30);
        content.add(t9);

        scholarship = new JLabel("10.     Scholarship available :");
        scholarship.setFont(new Font("", Font.BOLD, 15));
        scholarship.setForeground(Color.BLACK);
        scholarship.setBounds(10, 305, 300, 15);
        content.add(scholarship);

        t10 = new JTextField();
        t10.setFont(new Font("", Font.BOLD, 15));
        t10.setForeground(Color.BLACK);
        t10.setBounds(350, 298, 300, 30);
        content.add(t10);

        e1 = new JLabel("11.   Enrollment no. :");
        e1.setFont(new Font("", Font.BOLD, 14));
        e1.setForeground(Color.BLACK);
        e1.setBounds(730, 305, 150, 20);
        content.add(e1);

        t11 = new JTextField();
        t11.setFont(new Font("", Font.BOLD, 15));
        t11.setForeground(Color.BLACK);
        t11.setBounds(880, 298, 180, 30);
        content.add(t11);

        table = new JLabel("12.     Details of Previous examination passed :");
        table.setFont(new Font("", Font.BOLD, 15));
        table.setForeground(Color.BLACK);
        table.setBounds(10, 365, 350, 15);
        content.add(table);

        String[] column = { "Sr. no", "Name of Exam", "Month of Pass", "Enrollment. no", "Exam seat. no",
                "Marks Obatained " };
        String[][] data = new String[8][6];
        JTable tab = new JTable(data, column);
        JScrollPane p1 = new JScrollPane(tab);
        p1.setBounds(100, 400, 900, 152);
        content.add(p1);

        // Undertaking Section
        undertakingLabel = new JLabel("UNDERTAKING");
        undertakingLabel.setFont(new Font("", Font.BOLD, 15));
        undertakingLabel.setBounds(490, 560, 200, 20);
        content.add(undertakingLabel);

        JTextArea undertakingText = new JTextArea(
                "A)  I, the undersigned agree to confirm to any rule and laws enforced by the Government and I hereby under"
                        +
                        " take that, I will not do anything either inside or outside the College which may result in disciplinary action"
                        +
                        " against me under these rules, act and laws.\n" +
                        "B)  I fully understand that the Principal of this College, has a right to expel me from the College for any"
                        +
                        " infringement of the Rules of Conduct and discipline Prescribed by the College or MSBTE or Government.\n"
                        +
                        "C)  I am fully aware that if I do not attend the classes regularly (for attendance not less then 75% average) for"
                        +
                        " theory, practical or if I fail to submit regular assignments / term work specified by the college / MSBTE,"
                        +
                        " within the stipulated time limit, that I will not be allowed to appear for the examination i.e. I will be detained.\n\n");
        undertakingText.setFont(new Font("Serif", Font.PLAIN, 15));
        undertakingText.setLineWrap(true);
        undertakingText.setWrapStyleWord(true);
        undertakingText.setEditable(false);
        undertakingText.setBounds(10, 590, 1050, 120);
        content.add(undertakingText);

        placeLabel = new JLabel("Place :-");
        placeLabel.setBounds(10, 730, 50, 20);
        content.add(placeLabel);

        placeField = new JTextField();
        placeField.setBounds(60, 730, 150, 20);
        content.add(placeField);

        dateLabel = new JLabel("Date :-");
        dateLabel.setBounds(10, 750, 50, 20);
        content.add(dateLabel);

        dateField = new JTextField();
        dateField.setBounds(60, 755, 150, 20);
        content.add(dateField);

        signLabel = new JLabel("Signature of the student");
        signLabel.setBounds(850, 755, 200, 20);
        content.add(signLabel);

        JSeparator sep3 = new JSeparator();
        sep3.setBounds(0, 780, 1100, 5);
        sep3.setForeground(Color.black);
        content.add(sep3);

        officeLabel = new JLabel("(FOR OFFICE USE)");
        officeLabel.setFont(new Font("", Font.BOLD, 14));
        officeLabel.setBounds(488, 785, 200, 20);
        content.add(officeLabel);

        JLabel o1 = new JLabel("Following Original Certificate are verified : ");
        o1.setFont(new Font("", Font.BOLD, 14));
        o1.setBounds(10, 820, 400, 20);
        content.add(o1);

        String[] labels = { "A) Mark Memo ", "B) T.C", "C) Cast Certificate", "D) FF/Defence Cer.",
                "E) Non Cremmy Layer Cer.", "F) E.B.C Form ", "G) Freeship Form" };

        R = new JRadioButton[7];
        int y = 30;
        for (int i = 0; i < 7; i++) {
            rad = new JRadioButton(labels[i]);
            R[i] = rad;
            rad.setBackground(Color.WHITE);
            rad.setFont(new Font("", Font.BOLD, 14));
            if (i == 0) {
                rad.setBounds(100, 850, 300, 20);
            } else if (i % 2 == 0) {
                rad.setBounds(100, 800 + y, 300, 20);
            } else {
                rad.setBounds(650, 800 + y, 300, 20);
            }
            R[i].addActionListener(this);
            content.add(rad);
            y = y + 30;
        }

        JLabel o2 = new JLabel(
                "This Candidate is eligible for admission to ____________________ Class please accept the fees as follows. ");
        o2.setFont(new Font("", Font.BOLD, 15));
        o2.setBounds(10, 1050, 1000, 30);
        content.add(o2);

        JSeparator j1 = new JSeparator();
        j1.setBounds(0, 1100, 1100, 5);
        content.add(j1);

        JLabel center1 = new JLabel("FEES DETAILS");
        center1.setFont(new Font("", Font.BOLD, 14));
        center1.setBounds(500, 1110, 250, 30);
        content.add(center1);

        JLabel l1 = new JLabel("GOVERNMENT FEES");
        l1.setFont(new Font("", Font.BOLD, 14));
        l1.setBounds(100, 1190, 250, 30);
        content.add(l1);

        JLabel l2 = new JLabel("TUITION FEES :                         6000");
        l2.setFont(new Font("", Font.BOLD, 14));
        l2.setBounds(100, 1220, 250, 30);
        content.add(l2);

        JLabel l12 = new JLabel("TOTAL :                                     6000");
        l12.setFont(new Font("", Font.BOLD, 14));
        l12.setBounds(100, 1330, 250, 30);
        content.add(l12);

        JLabel l3 = new JLabel("Govt. Fees Receipt No. : ");
        l3.setFont(new Font("", Font.BOLD, 14));
        l3.setBounds(100, 1350, 250, 30);
        content.add(l3);
        JLabel l4 = new JLabel("Date : ");
        l4.setFont(new Font("", Font.BOLD, 14));
        l4.setBounds(100, 1370, 250, 30);
        content.add(l4);

        String[] labels1 = { "NON GOVERNMENT FEES", "Development Fee :                             1000",
                "GymKhana Fee :                                   200",
                "Libary Fee :                                           100",
                "Internet & Email Fee :                           150",
                "Annual Social Gathering :                    100",
                "TOTAL :                                               1550", "Non. Govt.Receipt. No. : ", "Date : " };
        int x = 60;
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels1[i]);
            label.setFont(new Font("", Font.BOLD, 14));
            label.setBounds(650, 1130 + x, 300, 20);
            content.add(label);
            x += 30;
        }

        JLabel bob = new JLabel("Chairman Admission Commitee");
        bob.setBounds(850, 1410, 250, 30);
        content.add(bob);

        JSeparator j2 = new JSeparator();
        j2.setBounds(0, 1440, 1100, 5);
        content.add(j2);

        JLabel center = new JLabel("Total Fees Received by");
        center.setBounds(485, 1450, 250, 30);
        content.add(center);

        JLabel studentSec = new JLabel("Student Section Govt. Polytechnic, Nanded");
        studentSec.setBounds(10, 1530, 250, 30);
        content.add(studentSec);

        JLabel registrar = new JLabel("Registrer Govt. Polytechnic, Nanded");
        registrar.setBounds(450, 1530, 250, 30);
        content.add(registrar);

        JLabel cashier = new JLabel("Cashier Govt. Polytechnic, Nanded");
        cashier.setBounds(850, 1530, 250, 30);
        content.add(cashier);

        submit = new JButton("Submit");
        submit.setBounds(450, 1570, 80, 25);
        content.add(submit);

        print = new JButton("Print");
        print.setBounds(580, 1570, 80, 25);
        content.add(print);

        submit.addActionListener(this);
        print.addActionListener(this);

        // this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = "", s[] = new String[7];
        if (e.getSource() == print) {
            if (con) {
                // print logic
                this.printFrame();
                con = false;
            } else {
                JOptionPane.showMessageDialog(null, "Firstly Submit the Information!!", "Print",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        } else if (e.getSource() == submit) {
            con = true;
            if (male.isSelected()) {
                str = "Male";
            } else if (female.isSelected()) {
                str = "Female";
            } else {
                str = "Other";
            }
            for(int i=0;i<7;i++){
                if (R[i].isSelected()){
                    s[i] = "Yes";
                }else{
                    s[i] = "No";
                }
            }
            data[0] = text.getText();
            data[1] = t1.getText();
            data[2] = t2.getText();
            data[3] = t3.getText();
            data[4] = str;
            data[5] = t5.getText();
            data[6] = t6.getText();
            data[7] = t8.getText();
            data[8] = t7.getText();
            data[9] = t9.getText();
            data[10] = t10.getText();
            data[11] = t11.getText();
            data[12] = placeField.getText();
            data[13] = dateField.getText();
            data[14] = s[0];
            data[15] = s[1];
            data[16] = s[2];
            data[17] = s[3];
            data[18] = s[4];
            data[19] = s[5];
            data[20] = s[6];
            try{
                new AuthenticationDatabase().InsertStudentAdmmission(data);
            }catch(Exception e1){
                JOptionPane.showMessageDialog(this, e1.getMessage(), "Database", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null,"Data Added SuccessFully!!","DataBase",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void printFrame() {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        pjob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                // Print the entire JFrame content
                StudentAdmission.this.printAll(g2d); 

                return PAGE_EXISTS;
            }
        });

        if (pjob.printDialog()) {
            try {
                pjob.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Printing error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

class StudentLeavingCer extends JFrame implements ActionListener{
    JLabel l[], l1;
    JLabel t1;
    int count = 1010;
    JButton print;
    String[] data;

    public StudentLeavingCer() {
        this.setSize(800, 700);
        this.setTitle("Student Leaving Certificate");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel head = new JLabel("GOVERNMENT POLYTECHNIC, NANDED");
        head.setFont(new Font("", Font.BOLD, 20));
        head.setForeground(Color.red);
        head.setBounds(190, 1, 400, 23);
        this.add(head);

        print=new JButton("Print ");
        print.setBounds(650,5,110,25);
        print.setBackground(new Color(208, 211, 212));
        print.addActionListener(this);
        this.add(print);

        JLabel sub = new JLabel("VEER SAWARKAR MARK, BABANAGAR, NANDED");
        sub.setFont(new Font("", Font.BOLD, 12));
        sub.setForeground(Color.BLACK);
        sub.setBounds(240, 25, 300, 15);
        this.add(sub);

        JLabel sub1 = new JLabel("PHONE : 02462 - 254210, Tele. Fax. : 252520");
        sub1.setFont(new Font("", Font.BOLD, 12));
        sub1.setForeground(Color.BLACK);
        sub1.setBounds(260, 40, 300, 15);
        this.add(sub1);

        JLabel sub2 = new JLabel("www.gpnanded.org.in");
        sub2.setFont(new Font("", Font.BOLD, 12));
        sub2.setForeground(Color.BLACK);
        sub2.setBounds(320, 55, 300, 15);
        this.add(sub2);

        ImageIcon i1 = new ImageIcon("logoo.jpg");
        JLabel img = new JLabel(i1);
        img.setBounds(5, 3, 80, 80);
        this.add(img);

        JSeparator sep = new JSeparator();
        sep.setBounds(0, 80, 800, 10);
        sep.setForeground(Color.BLACK);
        this.add(sep);

        JLabel leave = new JLabel("LEAVING CERTIFICATE");
        leave.setFont(new Font("", Font.BOLD, 25));
        leave.setForeground(Color.red);
        leave.setBounds(240, 100, 400, 23);
        this.add(leave);

        t1 = new JLabel();
        t1.setFont(new Font("", Font.BOLD, 12));
        t1.setForeground(Color.BLACK);
        t1.setBounds(640, 50, 100, 15);
        this.add(t1);
        l = new JLabel[9];
        int x = 40;
        for (int i = 0; i < 9; i++) {
            l[i] = new JLabel();
            l[i].setFont(new Font("", Font.BOLD, 18));
            l[i].setForeground(Color.BLACK);
            l[i].setBounds(80, 120 + x, 400, 30);
            this.add(l[i]);
            x += 30;
        }

        LocalDate loc = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = loc.format(formatter);

        String[] item1 = { "10. Progress : Good ", "11. Date of Leaving : " + formattedDate, "12. Remarks : PASSED " };
        int y = 40;
        for (int i = 0; i < item1.length; i++) {
            l1 = new JLabel(item1[i]);
            l1.setFont(new Font("", Font.BOLD, 18));
            l1.setForeground(Color.BLACK);
            l1.setBounds(80, 390 + y, 300, 30);
            this.add(l1);
            y += 30;
        }

        JLabel o1 = new JLabel("Certified that the above Information is in accordance with the Collage Register. ");
        o1.setFont(new Font("", Font.BOLD, 12));
        o1.setForeground(Color.BLACK);
        o1.setBounds(80, 520, 460, 15);
        this.add(o1);

        JLabel a2 = new JLabel("Date: " + formattedDate);
        a2.setFont(new Font("", Font.BOLD, 12));
        a2.setForeground(Color.BLACK);
        a2.setBounds(30, 600, 120, 15);
        this.add(a2);

        JLabel p1 = new JLabel("Head Master of GP, Nanded");
        p1.setFont(new Font("", Font.BOLD, 12));
        p1.setForeground(Color.BLACK);
        p1.setBounds(600, 600, 180, 15);
        this.add(p1);

        // this.setVisible(true);
    }

    void assign(OptionFrame o1) {
        count++;
        this.data = o1.Leavingdata;
        t1.setText("Reg. no : " + count);
        String[] item = { "1. Student Name : " + data[1], "2. Father Name : " + data[2], "3. Department : " + data[3],
                "4. Date of Birth : " + data[4], "5. Nationality : " + data[5], "6. Gender : " + data[6],
                "7. Contact no. : " + data[7], "8. Address : " + data[8], "9. Category : " + data[9] };
        for (int i = 0; i < item.length; i++) {
            l[i].setText(item[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        pjob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return NO_SUCH_PAGE;
                }

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

                // Print the entire JFrame content
                StudentLeavingCer.this.printAll(g2d); 

                return PAGE_EXISTS;
            }
        });

        if (pjob.printDialog()) {
            try {
                pjob.print();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this, "Printing error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

class ShowAdmissionData extends JFrame{
    JTable t1;
    JScrollPane p1;
    String[][] data;
    public ShowAdmissionData(){
        this.setSize(1300,550);
        this.setTitle("Admission Data");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[] c1={"ADMISSION_ID","STUD_NAME","BRANCH","D_O_B","GENDER","FATH_NAME","P_ADDRESS","CONTACT","L_ADDRESS","CATEGORY","SCHOLARSHIP","ENROLLMENT_NO","CLG_PLACE","ADMISSION_DATE","MARK_MEMO","TC","CASTE_CERTIFICATE","DEFENCE_CERT","NON_CREAMY_CERT","EBC_FORM","FREESHIP_FORM"};
        data=new String[40][40];
        this.getdata();
        t1=new JTable(data,c1);
        p1=new JScrollPane(t1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        p1.setBounds(1, 1, 1275, 510);
        p1.setVisible(true);
        this.add(p1);
        // this.setVisible(true);
    }
    public void getdata(){
        try{
            new AuthenticationDatabase().admissionData(data);
        }catch (Exception e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Database", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}

public class Project_Student {
    public static void main(String[] args) {
        new MainFrame();
    }
}