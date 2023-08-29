import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Write a description of class StudentGUI here.
 *Created GUI for the Student 
 *Created Array list to store data
 *imported various components of the Java Swing and AWT library
 *Background image and icon image was added to the frame
 *Takes input from the textfields and combobox and binds them into an arraylist which is then sended to the regular and dropout class to perform various operation
 *
 * @author (Subigyan Paudel)
 * @version (2023/08/11)
 */
public class StudentGUI
{
    private ArrayList<Student> studentDataList;
    private JFrame frame;
    private JPanel panel, panelRegular, panelDropout;

    private JLabel lblHomepageHeading,lblHomepagefillform,lblHeading, lblEnrollmentID, lblDateofEnrollment, lblStudentName, lblDateOfBirth, lblCourseName, lblBackground,
    lblNoofModules,lblNoofremainingModules,lblRemainingfee,lblDateofDropout, lblTuitionFee, lblCourseDuration, lblCreditHours, lblPresentDays, lblMonthattended;
    private JTextField txtEnrollmentID, txtStudentName, txtCourseName, txtNoofModules, txtTuitionFee, txtCourseDuration,
    txtCreditHours, txtPresentDays, txtRemainingfee, txtNoofRemainingModules, txtMonthsattended;
    private JComboBox <String> dayComboBoxEnrollment, monthComboBoxEnrollment, yearComboBoxEnrollment, dayComboBoxDOB, monthComboBoxDOB, yearComboBoxDOB, dayComboboxDropout, monthComboboxDropout, yearComboboxDropout;
    private JButton btnRegular, btnDropout, btnSubmit, btnClear, btnBack, btnDisplay, btnGrantCertificate, btnPresentPercentage, btnRemoveStudent, btnCalculateRemainingAMT;
    private ImageIcon icon;
    private int enrollmentID, courseDuration, numOfRemainingModules, numOfMonthsAttended, numOfModules, numOfCreditHours;
    private double tuitionFee,daysPresent;
    private String enrollmentIDString, dateOfBirth, courseName, dateOfEnrollment, studentName,courseDurationString, tuitionFeeString, yearofEnrollment, monthofEnrollment, dayOfEnrollment, yearofBirth, monthofBirth, dayOfBirth,numOfModulesString,numOfCreditHoursString,daysPresentString,yearofDropout,monthofDropout,dayOfDropout,numOfRemainingModulesString,numOfMonthsAttendedString,dateOfDropout;


    public StudentGUI()
    {
        mainGUI();
    }

    private void mainGUI(){
        studentDataList = new ArrayList<Student>();

        frame = new JFrame("Student Registration System");
        icon = new ImageIcon("icon.png");
        // Define the panel for the GUI
        panel = new JPanel();
        panel.setLayout(null);

        // Label for the heading for the home page
        lblHomepageHeading = new JLabel("Welcome to Student Registration System");
        lblHomepageHeading.setFont(new Font("Sans Serif", Font.BOLD, 30));
        lblHomepageHeading.setForeground(Color.WHITE);
        lblHomepageHeading.setBounds(245, 130, 590, 50);
        panel.add(lblHomepageHeading);

        lblHomepagefillform = new JLabel("Please fill the form");
        lblHomepagefillform.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        lblHomepagefillform.setForeground(Color.WHITE);
        lblHomepagefillform.setBounds(465, 223, 149, 25);
        panel.add(lblHomepagefillform);

        //Panels for the dropout and regular students

        // Display button on Main Homepage
        btnRegular = new JButton("Regular Students");
        btnRegular.setFont(new Font("Sans Serif", Font.BOLD, 14));
        btnRegular.setBackground(new Color(255, 254, 244));
        btnRegular.setBounds(461, 284, 157, 43);
        panel.add(btnRegular);

        btnDropout = new JButton("Dropout");
        btnDropout.setFont(new Font("Sans Serif", Font.BOLD, 14));
        btnDropout.setBackground(new Color(255, 254, 244));
        btnDropout.setBounds(461, 348, 157, 43);
        panel.add(btnDropout);

        // Action listener for the regular button
        btnRegular.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    regularGUIPanel();
                }
            });
        // Action listener for the dropout button
        btnDropout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dropoutGUIPanel();
                }
            });

        // Shows Background Image for the homepage
        lblBackground = new JLabel(new ImageIcon("background.jpg"));
        lblBackground.setBounds(0, 0, 1066, 600);
        panel.add(lblBackground);

        //Operation on frame that adds and sets various components of the frame such as size, icon, etc.
        frame.add(panel);
        frame.setIconImage(icon.getImage());
        frame.setSize(1080, 608);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    //Gui for the regular student entry
    private void regularGUIPanel(){


        panelRegular = new JPanel();
        panelRegular.setLayout(null);

        lblHeading = new JLabel("Regular Students");
        lblHeading.setFont(new Font("Sans Serif", Font.BOLD, 26));
        lblHeading.setForeground(Color.WHITE);
        lblHeading.setBounds(432, 114, 220, 36);
        panelRegular.add(lblHeading);

        // Label for the enrollmentID
        lblEnrollmentID = new JLabel("Enrollment ID:");
        lblEnrollmentID.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblEnrollmentID.setForeground(Color.WHITE);
        lblEnrollmentID.setBounds(143, 178, 112, 22);
        panelRegular.add(lblEnrollmentID);

        // label for the date of enrollment
        lblDateofEnrollment = new JLabel("Date of Enrollment:");
        lblDateofEnrollment.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblDateofEnrollment.setForeground(Color.WHITE);
        lblDateofEnrollment.setBounds(539, 178, 148, 22);
        panelRegular.add(lblDateofEnrollment);

        // Label for the student name
        lblStudentName = new JLabel("Student Name:");
        lblStudentName.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblStudentName.setForeground(Color.WHITE);
        lblStudentName.setBounds(143, 226, 112, 22);
        panelRegular.add(lblStudentName);

        // Label for the date of birth
        lblDateOfBirth = new JLabel("Date of Birth:");
        lblDateOfBirth.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblDateOfBirth.setForeground(Color.WHITE);
        lblDateOfBirth.setBounds(539, 226, 101, 22);
        panelRegular.add(lblDateOfBirth);

        // Label for the course name
        lblCourseName = new JLabel("Course Name:");
        lblCourseName.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblCourseName.setForeground(Color.WHITE);
        lblCourseName.setBounds(143, 279, 112, 22);
        panelRegular.add(lblCourseName);

        // Label for the no of modules
        lblNoofModules = new JLabel("Modules:");
        lblNoofModules.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblNoofModules.setForeground(Color.WHITE);
        lblNoofModules.setBounds(539, 279, 112, 22);
        panelRegular.add(lblNoofModules);

        // Label for the tuition fee
        lblTuitionFee = new JLabel("Tuition Fee:");
        lblTuitionFee.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblTuitionFee.setForeground(Color.WHITE);
        lblTuitionFee.setBounds(540, 382, 112, 22);
        panelRegular.add(lblTuitionFee);

        // Label for the course duration
        lblCourseDuration = new JLabel("Duration:");
        lblCourseDuration.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblCourseDuration.setForeground(Color.WHITE);
        lblCourseDuration.setBounds(144, 331, 112, 22);
        panelRegular.add(lblCourseDuration);

        // Label for the credit hours
        lblCreditHours = new JLabel("Credit Hours:");
        lblCreditHours.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblCreditHours.setForeground(Color.WHITE);
        lblCreditHours.setBounds(539, 331, 112, 22);
        panelRegular.add(lblCreditHours);

        // Label for the present days
        lblPresentDays = new JLabel("Present Days:");
        lblPresentDays.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblPresentDays.setForeground(Color.WHITE);
        lblPresentDays.setBounds(144, 382, 112, 22);
        panelRegular.add(lblPresentDays);

        // define the text fields for the GUI
        // Enrollment ID
        txtEnrollmentID = new JTextField();
        txtEnrollmentID.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtEnrollmentID.setBounds(269, 173, 180, 32);
        panelRegular.add(txtEnrollmentID);

        // Student Name
        txtStudentName = new JTextField();
        txtStudentName.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtStudentName.setBounds(269, 221, 180, 32);
        panelRegular.add(txtStudentName);

        // course name
        txtCourseName = new JTextField();
        txtCourseName.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtCourseName.setBounds(269, 274, 180, 32);
        panelRegular.add(txtCourseName);

        // no of modules
        txtNoofModules = new JTextField();
        txtNoofModules.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtNoofModules.setBounds(665, 274, 180, 32);
        panelRegular.add(txtNoofModules);

        // duration
        txtCourseDuration = new JTextField();
        txtCourseDuration.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtCourseDuration.setBounds(269, 326, 180, 32);
        panelRegular.add(txtCourseDuration);

        // present days
        txtPresentDays = new JTextField();
        txtPresentDays.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtPresentDays.setBounds(269, 377, 180, 32);
        panelRegular.add(txtPresentDays);

        // Tuition fee
        txtTuitionFee = new JTextField();
        txtTuitionFee.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtTuitionFee.setBounds(665, 377, 180, 32);
        panelRegular.add(txtTuitionFee);

        // Credit hours
        txtCreditHours = new JTextField();
        txtCreditHours.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtCreditHours.setBounds(665, 326, 180, 32);
        panelRegular.add(txtCreditHours);

        // define the buttons for the GUI
        // Submit
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnSubmit.setBackground(new Color(255, 254, 244));
        btnSubmit.setBounds(252, 423, 135, 30);
        panelRegular.add(btnSubmit);

        //Action listener for submitting the data
        btnSubmit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    submitDataRegular();
                }
            });

        // Clears the text field
        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnClear.setBackground(new Color(255, 254, 244));
        btnClear.setBounds(403, 466, 135, 30);
        panelRegular.add(btnClear);

        btnClear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearFields(true);
                }
            });

        //Button back

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnBack.setBackground(new Color(255, 254, 244));
        btnBack.setBounds(550, 466, 135, 30);
        panelRegular.add(btnBack);

        //action listener for back button
        btnBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelRegular.setVisible(false);
                    panel.setVisible(true);
                }
            });
        // Display every data of the class regular
        btnDisplay = new JButton("Display");
        btnDisplay.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnDisplay.setBackground(new Color(255, 254, 244));
        btnDisplay.setBounds(403, 423, 135, 30);
        panelRegular.add(btnDisplay);

        btnDisplay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayData(true);
                }
            });

        //button for granting certificate
        btnGrantCertificate = new JButton("Grant Certificate");
        btnGrantCertificate.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnGrantCertificate.setBackground(new Color(255, 254,244));
        btnGrantCertificate.setBounds(697, 423, 135, 30);
        panelRegular.add(btnGrantCertificate);

        //Action listener for the grant certificate

        btnGrantCertificate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    grantCertificate();

                }
            });

        // calculate present percentage
        btnPresentPercentage = new JButton("Book");
        btnPresentPercentage.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnPresentPercentage.setBackground(new Color(255, 254,244));
        btnPresentPercentage.setBounds(550, 423, 135, 30);
        panelRegular.add(btnPresentPercentage);

        // Action listener for the present percentage
        btnPresentPercentage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    calculatePresentPercentage();

                }
            });

        //Combobox for calender date of enrollment
        //Days
        dayComboBoxEnrollment = new JComboBox<>(getDayOptions());
        dayComboBoxEnrollment.setFont(new Font("Sans Serif", Font.BOLD, 14));
        dayComboBoxEnrollment.setBounds(696, 173, 60, 32);
        panelRegular.add(dayComboBoxEnrollment);

        //Months
        monthComboBoxEnrollment = new JComboBox<>(getMonthOptions());
        monthComboBoxEnrollment.setFont(new Font("Sans Serif", Font.BOLD, 14));
        monthComboBoxEnrollment.setBounds(765, 173, 100, 32);
        panelRegular.add(monthComboBoxEnrollment);

        //Year

        yearComboBoxEnrollment = new JComboBox<>(getYearOptions());
        yearComboBoxEnrollment.setFont(new Font("Sans Serif", Font.BOLD, 14));
        yearComboBoxEnrollment.setBounds(874, 173, 67, 32);
        panelRegular.add(yearComboBoxEnrollment);

        //calender date of birth

        dayComboBoxDOB = new JComboBox<>(getDayOptions());
        dayComboBoxDOB.setFont(new Font("Sans Serif", Font.BOLD, 14));
        dayComboBoxDOB.setBounds(696, 221, 60, 32);
        panelRegular.add(dayComboBoxDOB);

        monthComboBoxDOB = new JComboBox<>(getMonthOptions());
        monthComboBoxDOB.setFont(new Font("Sans Serif", Font.BOLD, 14));
        monthComboBoxDOB.setBounds(765, 221, 100, 32);
        panelRegular.add(monthComboBoxDOB);

        yearComboBoxDOB = new JComboBox<>(getYearOptions());
        yearComboBoxDOB.setFont(new Font("Sans Serif", Font.BOLD, 14));
        yearComboBoxDOB.setBounds(874, 221, 67, 32);
        panelRegular.add(yearComboBoxDOB);
        //add background image
        lblBackground = new JLabel(new ImageIcon("background.jpg"));
        lblBackground.setBounds(0, 0, 1066, 600);
        panelRegular.add(lblBackground);
        // add to frame
        frame.add(panelRegular);
        frame.setSize(1080, 608);
        panelRegular.setVisible(true);
        panel.setVisible(false);

    }
    //GUI for the dropout student entry
    private void dropoutGUIPanel() {
        panelDropout = new JPanel();
        panelDropout.setLayout(null);

        // Define the labels for the GUI
        // Label for the heading
        lblHeading = new JLabel("Dropout Students");
        lblHeading.setFont(new Font("Sans Serif", Font.BOLD, 26));
        lblHeading.setForeground(Color.WHITE);
        lblHeading.setBounds(432, 114, 220, 36);
        panelDropout.add(lblHeading);

        // Label for the enrollmentID
        lblEnrollmentID = new JLabel("Enrollment ID:");
        lblEnrollmentID.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblEnrollmentID.setForeground(Color.WHITE);
        lblEnrollmentID.setBounds(143, 178, 112, 22);
        panelDropout.add(lblEnrollmentID);

        // label for the date of enrollment
        lblDateofEnrollment = new JLabel("Date of Enrollment:");
        lblDateofEnrollment.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblDateofEnrollment.setForeground(Color.WHITE);
        lblDateofEnrollment.setBounds(539, 178, 148, 22);
        panelDropout.add(lblDateofEnrollment);

        // Label for the student name
        lblStudentName = new JLabel("Student Name:");
        lblStudentName.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblStudentName.setForeground(Color.WHITE);
        lblStudentName.setBounds(143, 226, 112, 22);
        panelDropout.add(lblStudentName);

        // Label for the date of birth
        lblDateOfBirth = new JLabel("Date of Birth:");
        lblDateOfBirth.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblDateOfBirth.setForeground(Color.WHITE);
        lblDateOfBirth.setBounds(539, 226, 101, 22);
        panelDropout.add(lblDateOfBirth);

        // Label for the course name
        lblCourseName = new JLabel("Course Name:");
        lblCourseName.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblCourseName.setForeground(Color.WHITE);
        lblCourseName.setBounds(143, 279, 112, 22);
        panelDropout.add(lblCourseName);

        // Label for the no of modules
        lblNoofremainingModules = new JLabel("Rem Modules:");
        lblNoofremainingModules.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblNoofremainingModules.setForeground(Color.WHITE);
        lblNoofremainingModules.setBounds(540, 377, 112, 22);
        panelDropout.add(lblNoofremainingModules);

        // Label for the tuition fee
        lblTuitionFee = new JLabel("Tuition Fee:");
        lblTuitionFee.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblTuitionFee.setForeground(Color.WHITE);
        lblTuitionFee.setBounds(539, 331, 112, 22);
        panelDropout.add(lblTuitionFee);

        // Label for the course duration
        lblCourseDuration = new JLabel("Duration:");
        lblCourseDuration.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblCourseDuration.setForeground(Color.WHITE);
        lblCourseDuration.setBounds(144, 331, 112, 22);
        panelDropout.add(lblCourseDuration);

        // Label for the credit hours
        lblDateofDropout = new JLabel("Date of Dropout:");
        lblDateofDropout.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblDateofDropout.setForeground(Color.WHITE);
        lblDateofDropout.setBounds(540, 279, 126, 22);
        panelDropout.add(lblDateofDropout);

        // Label for the months attended
        lblMonthattended = new JLabel("Months Attended:");
        lblMonthattended.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblMonthattended.setForeground(Color.WHITE);
        lblMonthattended.setBounds(144, 384, 125, 22);
        panelDropout.add(lblMonthattended);

        //label for the remaining fee
        lblRemainingfee = new JLabel("Remaining Fee:");
        lblRemainingfee.setFont(new Font("Sans Serif", Font.BOLD, 14));
        lblRemainingfee.setForeground(Color.WHITE);
        lblRemainingfee.setBounds(144, 433, 119, 22);
        panelDropout.add(lblRemainingfee);

        // define the text fields for the GUI
        // Enrollment ID
        txtEnrollmentID = new JTextField();
        txtEnrollmentID.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtEnrollmentID.setBounds(289, 173, 180, 32);
        panelDropout.add(txtEnrollmentID);

        // Student Name
        txtStudentName = new JTextField();
        txtStudentName.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtStudentName.setBounds(289, 221, 180, 32);
        panelDropout.add(txtStudentName);

        // course name
        txtCourseName = new JTextField();
        txtCourseName.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtCourseName.setBounds(289, 274, 180, 32);
        panelDropout.add(txtCourseName);

        // no of remaining modules
        txtNoofRemainingModules = new JTextField();
        txtNoofRemainingModules.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtNoofRemainingModules.setBounds(666, 372, 180, 32);
        panelDropout.add(txtNoofRemainingModules);

        // duration
        txtCourseDuration = new JTextField();
        txtCourseDuration.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtCourseDuration.setBounds(289, 326, 180, 32);
        panelDropout.add(txtCourseDuration);

        // present days
        txtMonthsattended = new JTextField();
        txtMonthsattended.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtMonthsattended.setBounds(289, 377, 180, 32);
        panelDropout.add(txtMonthsattended);

        // Tuition fee
        txtTuitionFee = new JTextField();
        txtTuitionFee.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtTuitionFee.setBounds(666, 326, 180, 32);
        panelDropout.add(txtTuitionFee);

        //remaining fee
        txtRemainingfee = new JTextField();
        txtRemainingfee.setFont(new Font("Sans Serif", Font.BOLD, 14));
        txtRemainingfee.setBounds(289, 428, 180, 32);
        txtRemainingfee.setEditable(false);
        panelDropout.add(txtRemainingfee);

        // define the buttons for the GUI
        // Submit
        btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnSubmit.setBackground(new Color(255, 254,244));
        btnSubmit.setBounds(506, 423, 135, 30);
        panelDropout.add(btnSubmit);

        //Action listener for submit
        btnSubmit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    submitDataDropout();
                }
            });

        // Display every data of the class regular
        btnDisplay = new JButton("Display");
        btnDisplay.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnDisplay.setBackground(new Color(255, 254,244));
        btnDisplay.setBounds(653, 423, 135, 30);
        panelDropout.add(btnDisplay);
        //Action listener for display
        btnDisplay.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayData(false);
                }
            });

        // Clear
        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnClear.setBackground(new Color(255, 254,244));
        btnClear.setBounds(800, 423, 135, 30);
        panelDropout.add(btnClear);
        // action listener for clear
        btnClear.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    clearFields(false);
                }
            });

        btnRemoveStudent = new JButton("Remove Dropout");
        btnRemoveStudent.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnRemoveStudent.setBackground(new Color(255, 254,244));
        btnRemoveStudent.setBounds(653, 466, 135, 30);
        panelDropout.add(btnRemoveStudent);
        //Action listener for remove student
        btnRemoveStudent.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    removedropoutStudent();
                }
            });

        //Button back

        btnBack = new JButton("Back");
        btnBack.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnBack.setBackground(new Color(255, 254, 244));
        btnBack.setBounds(800, 466, 135, 30);
        panelDropout.add(btnBack);

        //action listener for back button
        btnBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panelDropout.setVisible(false);
                    panel.setVisible(true);

                }
            });

        btnCalculateRemainingAMT = new JButton("Amt Remained ");
        btnCalculateRemainingAMT.setFont(new Font("Sans Serif", Font.BOLD, 11));
        btnCalculateRemainingAMT.setBackground(new Color(255, 254, 244));
        btnCalculateRemainingAMT.setBounds(506, 466, 135, 30);
        panelDropout.add(btnCalculateRemainingAMT);

        btnCalculateRemainingAMT.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    calculateRemainingAmount();
                }
            });


        //calender date of enrollment
        //Combobox for calender date of enrollment
        //Days
        dayComboBoxEnrollment = new JComboBox<>(getDayOptions());
        dayComboBoxEnrollment.setFont(new Font("Sans Serif", Font.BOLD, 14));
        dayComboBoxEnrollment.setBounds(696, 173, 60, 32);
        panelDropout.add(dayComboBoxEnrollment);

        //Months
        monthComboBoxEnrollment = new JComboBox<>(getMonthOptions());
        monthComboBoxEnrollment.setFont(new Font("Sans Serif", Font.BOLD, 14));
        monthComboBoxEnrollment.setBounds(765, 173, 100, 32);
        panelDropout.add(monthComboBoxEnrollment);

        //Year

        yearComboBoxEnrollment = new JComboBox<>(getYearOptions());
        yearComboBoxEnrollment.setFont(new Font("Sans Serif", Font.BOLD, 14));
        yearComboBoxEnrollment.setBounds(874, 173, 60, 32);
        panelDropout.add(yearComboBoxEnrollment);

        //calender date of birth
        dayComboBoxDOB = new JComboBox<>(getDayOptions());
        dayComboBoxDOB.setFont(new Font("Sans Serif", Font.BOLD, 14));
        dayComboBoxDOB.setBounds(696, 221, 60, 32);
        panelDropout.add(dayComboBoxDOB);

        monthComboBoxDOB = new JComboBox<>(getMonthOptions());
        monthComboBoxDOB.setFont(new Font("Sans Serif", Font.BOLD, 14));
        monthComboBoxDOB.setBounds(765, 221, 100, 32);
        panelDropout.add(monthComboBoxDOB);

        yearComboBoxDOB = new JComboBox<>(getYearOptions());
        yearComboBoxDOB.setFont(new Font("Sans Serif", Font.BOLD, 14));
        yearComboBoxDOB.setBounds(874, 221, 60, 32);
        panelDropout.add(yearComboBoxDOB);

        //Calender date of dropout
        //calender date of birth

        dayComboboxDropout = new JComboBox<>(getDayOptions());
        dayComboboxDropout.setFont(new Font("Sans Serif", Font.BOLD, 14));
        dayComboboxDropout.setBounds(697, 274, 60, 32);
        panelDropout.add(dayComboboxDropout);

        monthComboboxDropout = new JComboBox<>(getMonthOptions());
        monthComboboxDropout.setFont(new Font("Sans Serif", Font.BOLD, 14));
        monthComboboxDropout.setBounds(766, 274, 100, 32);
        panelDropout.add(monthComboboxDropout);

        yearComboboxDropout = new JComboBox<>(getYearOptions());
        yearComboboxDropout.setFont(new Font("Sans Serif", Font.BOLD, 14));
        yearComboboxDropout.setBounds(875, 274, 60, 32);
        panelDropout.add(yearComboboxDropout);

        lblBackground = new JLabel(new ImageIcon("background.jpg"));
        lblBackground.setBounds(0, 0, 1066, 600);
        panelDropout.add(lblBackground);

        // Add the panel to the frame
        frame.add(panelDropout);
        frame.setSize(1080, 608);
        panelDropout.setVisible(true);
        panel.setVisible(false);
    }
    //Submits data of regular and dropout students


    //Submits the data of the regular students
    private void submitDataRegular(){
        enrollmentIDString = txtEnrollmentID.getText();
        studentName = txtStudentName.getText();

        yearofEnrollment = (String) yearComboBoxEnrollment.getSelectedItem();
        monthofEnrollment = (String) monthComboBoxEnrollment.getSelectedItem();
        dayOfEnrollment = (String) dayComboBoxEnrollment.getSelectedItem();

        yearofBirth = (String) yearComboBoxDOB.getSelectedItem();
        monthofBirth = (String) monthComboBoxDOB.getSelectedItem();
        dayOfBirth = (String) dayComboBoxDOB.getSelectedItem();

        courseName = txtCourseName.getText();
        courseDurationString = txtCourseDuration.getText();
        numOfModulesString = txtNoofModules.getText();
        numOfCreditHoursString = txtCreditHours.getText();
        daysPresentString = txtPresentDays.getText();
        tuitionFeeString = txtTuitionFee.getText();

        dateOfBirth = yearofBirth + "-" + monthofBirth + "-" + dayOfBirth;
        dateOfEnrollment = yearofEnrollment + "-" + monthofEnrollment + "-" + dayOfEnrollment;

        if(enrollmentIDString.isEmpty() || courseName.isEmpty() || studentName.isEmpty() || courseDurationString.isEmpty() || tuitionFeeString.isEmpty() || numOfModulesString.isEmpty() || numOfCreditHoursString.isEmpty() || daysPresentString.isEmpty()|| dayOfBirth.isEmpty() || monthofBirth.isEmpty() || yearofBirth.isEmpty() || yearofEnrollment.isEmpty() || monthofEnrollment.isEmpty() || dayOfEnrollment.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        try {
            enrollmentID = Integer.parseInt(enrollmentIDString);
            daysPresent = Integer.parseInt(daysPresentString);
            numOfCreditHours = Integer.parseInt(numOfCreditHoursString);
            numOfModules = Integer.parseInt(numOfModulesString);
            courseDuration = Integer.parseInt(courseDurationString);
            tuitionFee = Double.parseDouble(tuitionFeeString);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid data entered please check" , "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validateEnrollmentID(enrollmentID)) {
            JOptionPane.showMessageDialog(null, "Enrollment ID already exists. Please enter a unique ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!isValidName(studentName)||!isValidName(courseName)) {
            JOptionPane.showMessageDialog(null, "Invalid Name. Name should not contain any integers or special characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Student studentEntry = new Regular( enrollmentID,  dateOfBirth,  courseName,  studentName,
                dateOfEnrollment,  courseDuration,  tuitionFee,  numOfModules, numOfCreditHours, daysPresent);

        studentDataList.add(studentEntry);

        JOptionPane.showMessageDialog(null, "Regular student have been added", "Success", JOptionPane.INFORMATION_MESSAGE);
    }



    //Submits the data of the dropout students
    private void submitDataDropout(){
        enrollmentIDString = txtEnrollmentID.getText();
        studentName = txtStudentName.getText();

        yearofEnrollment = (String) yearComboBoxEnrollment.getSelectedItem();
        monthofEnrollment = (String) monthComboBoxEnrollment.getSelectedItem();
        dayOfEnrollment = (String) dayComboBoxEnrollment.getSelectedItem();

        yearofBirth = (String) yearComboBoxDOB.getSelectedItem();
        monthofBirth = (String) monthComboBoxDOB.getSelectedItem();
        dayOfBirth = (String) dayComboBoxDOB.getSelectedItem();

        yearofDropout = (String) yearComboboxDropout.getSelectedItem();
        monthofDropout = (String) monthComboboxDropout.getSelectedItem();
        dayOfDropout = (String) yearComboboxDropout.getSelectedItem();

        courseName = txtCourseName.getText();
        courseDurationString = txtCourseDuration.getText();
        numOfRemainingModulesString = txtNoofRemainingModules.getText();

        numOfMonthsAttendedString = txtMonthsattended.getText();
        tuitionFeeString = txtTuitionFee.getText();

        dateOfBirth = yearofBirth + "-" + monthofBirth + "-" + dayOfBirth;
        dateOfEnrollment = yearofEnrollment + "-" + monthofEnrollment + "-" + dayOfEnrollment;
        dateOfDropout = yearofDropout + "-" + monthofDropout + "-" + dayOfDropout;

        if(enrollmentIDString.isEmpty()  || courseName.isEmpty() || studentName.isEmpty() || courseDurationString.isEmpty() || tuitionFeeString.isEmpty() || numOfRemainingModulesString.isEmpty()  || numOfMonthsAttendedString.isEmpty()||yearofBirth.isEmpty() || yearofEnrollment.isEmpty() || monthofEnrollment.isEmpty() || dayOfEnrollment.isEmpty() || yearofDropout.isEmpty() || monthofDropout.isEmpty() || dayOfDropout.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        try {
            enrollmentID = Integer.parseInt(enrollmentIDString);
            numOfMonthsAttended = Integer.parseInt(numOfMonthsAttendedString);
            numOfRemainingModules = Integer.parseInt(numOfRemainingModulesString);
            courseDuration = Integer.parseInt(courseDurationString);
            tuitionFee = Double.parseDouble(tuitionFeeString);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid data entered please check" , "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validateEnrollmentID(enrollmentID)) {
            JOptionPane.showMessageDialog(null, "Enrollment ID already exists. Please enter a unique ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!isValidName(studentName)||!isValidName(courseName)) {
            JOptionPane.showMessageDialog(null, "Invalid Name. Name should not contain any integers or special characters.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        Student studentEntry = new Dropout(studentName, dateOfBirth, courseDuration, tuitionFee, numOfRemainingModules, numOfMonthsAttended, dateOfDropout);

        // Assuming no initial payment on enrollment
        ((Dropout) studentEntry).billsPayable(0);

        // Set the remaining fee in the txtRemainingfee text field
        txtRemainingfee.setText(String.valueOf(((Dropout) studentEntry).getRemainingAmount()));

        studentEntry.setEnrollmentId(enrollmentID);
        studentEntry.setCourseName(courseName);
        studentEntry.setDateOfEnrollment(dateOfEnrollment);// Add the dropout student to the specific ArrayList for dropout students

        studentDataList.add(studentEntry);

        JOptionPane.showMessageDialog(null, "Dropout student have been added", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // Calculate presentPercentage of the regular student
    private void calculatePresentPercentage(){

        String enrollmentIDString = JOptionPane.showInputDialog(null, "Enter Enrollment ID:", "Enter Enrollment ID", JOptionPane.QUESTION_MESSAGE);

        if (enrollmentIDString != null && !enrollmentIDString.isEmpty()) {
            int enrollmentID;
            try {
                enrollmentID = Integer.parseInt(enrollmentIDString);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Enrollment ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student foundStudent = null;
            for (Student student : studentDataList) {

                if (student.getEnrollmentID() == enrollmentID) {
                    foundStudent = student;
                    break;
                }
            }

            if (foundStudent != null && foundStudent instanceof Regular) {
                Regular regularStudent = (Regular) foundStudent;

                String daysPresentString = JOptionPane.showInputDialog(null, "Enter Days Present:", "Enter Days Present", JOptionPane.QUESTION_MESSAGE);
                if (daysPresentString != null && !daysPresentString.isEmpty()) {
                    try {
                        int daysPresent = Integer.parseInt(daysPresentString);
                        // Check the entered daysPresent with the value in the ArrayList
                        if (daysPresent <= regularStudent.getCourseDuration() * 30 && daysPresent >= 0) {
                            // Call the method to calculate present percentage from the Regular class
                            String result = regularStudent.presentPercentage(daysPresent);

                            // Display the result in a dialog box
                            JOptionPane.showMessageDialog(null, result, "Attendance Grade", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid days present. Please enter a value between 0 and " + regularStudent.getCourseDuration() * 30 + ".", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid days present. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter Days Present.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Regular student with Enrollment ID " + enrollmentID + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter an Enrollment ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    //calls method to grant certificate of the regular student from the regular class

    private void grantCertificate() {
        String enrollmentIDString = JOptionPane.showInputDialog(null, "Enter the Enrollment ID of the Regular Student to Grant Certificate:");
        if (enrollmentIDString != null && !enrollmentIDString.isEmpty()) {
            try {
                int enrollmentID = Integer.parseInt(enrollmentIDString);
                // Find the Regular student with the given enrollment ID
                Regular regularStudent = null;
                for (Student student : studentDataList) {
                    if (student instanceof Regular && student.getEnrollmentID() == enrollmentID) {
                        regularStudent = (Regular) student;
                        break;
                    }
                }

                if (regularStudent != null) {
                    // Call the grantCertificate method from the Regular class
                    String message = regularStudent.grantCertificate(regularStudent.getCourseName(), regularStudent.getEnrollmentID(), regularStudent.getDateOfEnrollment());

                    JOptionPane.showMessageDialog(null, message, "Certificate Granted", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Handle the case if regular student with enrollment ID not found
                    JOptionPane.showMessageDialog(null, "Regular student with Enrollment ID " + enrollmentID + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Enrollment ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter the Enrollment ID to grant the certificate.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Calculate the remaining amount of the dropout student by
    //Remove the dropout student

    private void removedropoutStudent() {
        String enrollmentIDString = JOptionPane.showInputDialog(null, "Enter the Enrollment ID of the Student to Remove:");
        if (enrollmentIDString != null && !enrollmentIDString.isEmpty()) {
            try {
                int enrollmentID = Integer.parseInt(enrollmentIDString);

                // Find the student with the given enrollment ID
                Student studentToRemove = null;
                for (Student student : studentDataList) {
                    if (student.getEnrollmentID() == enrollmentID) {
                        studentToRemove = student;
                        break;
                    }
                }

                if (studentToRemove != null) {
                    if (studentToRemove instanceof Dropout) {
                        Dropout dropoutStudent = (Dropout) studentToRemove;

                        if (!dropoutStudent.isHasPaid() && dropoutStudent.getRemainingAmount() > 0) {
                            // If the payment has not been cleared, show an error message
                            JOptionPane.showMessageDialog(null, "Cannot remove the student with Enrollment ID " + enrollmentID + ". All bills have not been cleared.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    // Remove the student from the ArrayList
                    studentDataList.remove(studentToRemove);
                    JOptionPane.showMessageDialog(null, "Student with Enrollment ID " + enrollmentID + " removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Handle the case if student with enrollment ID not found
                    JOptionPane.showMessageDialog(null, "Student with Enrollment ID " + enrollmentID + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Enrollment ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter the Enrollment ID to remove the student.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateRemainingAmount() {
        String enrollmentIDString = JOptionPane.showInputDialog(null, "Enter the Enrollment ID of the Dropout Student to calculate the Remaining amount:");
        if (enrollmentIDString != null && !enrollmentIDString.isEmpty()) {
            try {
                int enrollmentID = Integer.parseInt(enrollmentIDString);
                // Find the student with the given enrollment ID
                Student foundStudent = null;
                for (Student student : studentDataList) {
                    if (student.getEnrollmentID() == enrollmentID) {
                        foundStudent = student;
                        break;
                    }
                }

                if (foundStudent == null) {
                    JOptionPane.showMessageDialog(null, "Student with Enrollment ID " + enrollmentID + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if the found student is an instance of Dropout
                if (foundStudent instanceof Dropout) {
                    Dropout dropoutStudent = (Dropout) foundStudent;

                    String paidAmountString = JOptionPane.showInputDialog(null, "Enter the Paid Amount:");
                    if (paidAmountString != null && !paidAmountString.isEmpty()) {
                        try {
                            int paidAmount = Integer.parseInt(paidAmountString);

                            int remainingAmount = dropoutStudent.getRemainingAmount();
                            if (paidAmount > remainingAmount) {
                                JOptionPane.showMessageDialog(null, "Paid Amount cannot exceed the Remaining Amount.", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            dropoutStudent.billsPayable(paidAmount);
                            remainingAmount = dropoutStudent.getRemainingAmount();
                            String message = "Remaining Amount: " + "Rupees "+ remainingAmount ;
                            JOptionPane.showMessageDialog(null, message, "Remaining Amount", JOptionPane.INFORMATION_MESSAGE);
                            // Set the remaining amount in the txtRemainingfee JTextField
                            txtRemainingfee.setText(Integer.toString(remainingAmount));
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid Paid Amount. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter the Paid Amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    // Handle the case where the student is not a Dropout (e.g., Regular)
                    JOptionPane.showMessageDialog(null, "Cannot calculate remaining amount for a regular student.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Enrollment ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter the Enrollment ID to calculate the Dropout student.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private boolean isValidName(String studentName) {
        String regex = "^[a-zA-Z]*$";
        return studentName.matches(regex);
    }

    private boolean validateEnrollmentID(int enrollmentID) {
        for (Student studentEntry : studentDataList) {
            if (studentEntry.getEnrollmentID() == enrollmentID) {
                return false; // Enrollment ID already exists, return false
            }
        }
        return true; // Enrollment ID is unique, return true
    }


    public void displayData(boolean isRegularPanel) {
        if (studentDataList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Entries Found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder displayText = new StringBuilder();

        for (Student studentEntry : studentDataList) {
            if (isRegularPanel && studentEntry instanceof Regular) {
                Regular regularStudent = (Regular) studentEntry;
                displayText.append("Enrollment ID: ").append(regularStudent.getEnrollmentID()).append("\n");
                displayText.append("Student Name: ").append(regularStudent.getStudentName()).append("\n");
                displayText.append("Date of Birth: ").append(regularStudent.getDateOfBirth()).append("\n");
                displayText.append("Course Name: ").append(regularStudent.getCourseName()).append("\n");
                displayText.append("Date of Enrollment: ").append(regularStudent.getDateOfEnrollment()).append("\n");
                displayText.append("Course Duration: ").append(regularStudent.getCourseDuration()).append("\n");
                displayText.append("Tuition Fee: ").append(regularStudent.getTuitionFee()).append("\n");
                displayText.append("Number of Modules: ").append(regularStudent.getNumOfModules()).append("\n");
                displayText.append("Number of Credit Hours: ").append(regularStudent.getNumOfCreditHours()).append("\n");
                displayText.append("Days Present: ").append(regularStudent.getDaysPresent()).append("\n");
                displayText.append("---------------------------------\n");
            } else if (!isRegularPanel && studentEntry instanceof Dropout) {
                Dropout dropoutStudent = (Dropout) studentEntry;
                displayText.append("Enrollment ID: ").append(dropoutStudent.getEnrollmentID()).append("\n");
                displayText.append("Student Name: ").append(dropoutStudent.getStudentName()).append("\n");
                displayText.append("Date of Birth: ").append(dropoutStudent.getDateOfBirth()).append("\n");
                displayText.append("Course Name: ").append(dropoutStudent.getCourseName()).append("\n");
                displayText.append("Date of Enrollment: ").append(dropoutStudent.getDateOfEnrollment()).append("\n");
                displayText.append("Course Duration: ").append(dropoutStudent.getCourseDuration()).append("\n");
                displayText.append("Number of remaining Modules: ").append(dropoutStudent.getNumOfRemainingModules()).append("\n");
                displayText.append("Number of Months Attended: ").append(dropoutStudent.getNumOfMonthsAttended()).append("\n");
                displayText.append("Date of Dropout: ").append(dropoutStudent.getDateOfDropout()).append("\n");
                displayText.append("Tuition Fee: ").append(dropoutStudent.getTuitionFee()).append("\n");
                displayText.append("---------------------------------\n");
            }
        }

        if (displayText.length() > 0) {
            String panelTitle = isRegularPanel ? "Regular Entries" : "Dropout Entries";
            JOptionPane.showMessageDialog(null, displayText.toString(), panelTitle, JOptionPane.INFORMATION_MESSAGE);
        } else {
            String errorMessage = isRegularPanel ? "No Regular Entries" : "No Dropout Entries";
            JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields(boolean isRegularPanel) {
        if (isRegularPanel && panelRegular.isVisible()) {
            try {
                // Text field of the regular panel
                txtEnrollmentID.setText("");
                txtStudentName.setText("");
                txtCourseName.setText("");
                txtCourseDuration.setText("");
                txtNoofModules.setText("");
                txtCreditHours.setText("");
                txtPresentDays.setText("");
                txtTuitionFee.setText("");
                // Combo box of the regular panel
                yearComboBoxEnrollment.setSelectedIndex(0);
                monthComboBoxEnrollment.setSelectedIndex(0);
                dayComboBoxEnrollment.setSelectedIndex(0);

                yearComboBoxDOB.setSelectedIndex(0);
                monthComboBoxDOB.setSelectedIndex(0);
                dayComboBoxDOB.setSelectedIndex(0);

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } else if (!isRegularPanel && panelDropout.isVisible()) {
            try {
                // clear the textfield of the dropout
                txtEnrollmentID.setText("");
                txtStudentName.setText("");
                txtCourseName.setText("");
                txtCourseDuration.setText("");
                txtNoofRemainingModules.setText("");
                txtMonthsattended.setText("");
                txtTuitionFee.setText("");
                txtRemainingfee.setText("");

                // clear the combobox of the dropout
                yearComboBoxEnrollment.setSelectedIndex(0);
                monthComboBoxEnrollment.setSelectedIndex(0);
                dayComboBoxEnrollment.setSelectedIndex(0);

                yearComboBoxDOB.setSelectedIndex(0);
                monthComboBoxDOB.setSelectedIndex(0);
                dayComboBoxDOB.setSelectedIndex(0);

                yearComboboxDropout.setSelectedIndex(0);
                monthComboboxDropout.setSelectedIndex(0);
                dayComboboxDropout.setSelectedIndex(0);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    private String[] getDayOptions() {
        String[] dayOptions = new String[32]; // Including an empty string option
        dayOptions[0] = ""; // Empty string option
        for (int i = 1; i <= 31; i++) {
            dayOptions[i] = Integer.toString(i);
        }
        return dayOptions;
    }

    private String[] getMonthOptions() {
        String[] monthOptions = new String[]{
                "", // Empty string option
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
            };
        return monthOptions;
    }

    private String[] getYearOptions() {
        String[] yearOptions = new String[101]; // Including an empty string option
        yearOptions[0] = ""; // Empty string option
        for (int i = 1; i <= 100; i++) {
            yearOptions[i] = Integer.toString(2024 - i); // Assuming the year is 2023
        }
        return yearOptions;
    }

    public static void main(String[] args) {
        new StudentGUI() ;

    }
}
