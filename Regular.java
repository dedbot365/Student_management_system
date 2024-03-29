
/**
 * Base class Regular for the super class Student class is created.
 * The four attributes specific to the Regular class is defined. 
 * Constructor is created that accepts ten different attributes.
 * Values is initialized  inside the constructor.
 * On the constructor call set the value of various attributes by calling the setter method of the super class.
 * Acessor methods specific to the base class is defined.
 * 
 * @author (Subigyan Paudel)
 * @version (05/07/2023)
 */
//Public base class "Regular" of super class "Student" is created
public class Regular extends Student {
    //Defining the attributes specific to the Regular Class
    private int numOfModules;
    private int numOfCreditHours;
    private double daysPresent;
    private boolean isGrantedScholarship;
    //Defining a Constructor for a base class that accepts diffrent attributes
    public Regular(int enrollmentID, String dateOfBirth, String courseName, String studentName,
    String dateOfEnrollment, int courseDuration, double tuitionFee, int numOfModules,
    int numOfCreditHours, double daysPresent)
    {
        //Calls Super class constructors
        super(dateOfBirth, studentName, courseDuration, tuitionFee);
        //Calls Super class setter methods
        super.setEnrollmentId(enrollmentID);
        super.setCourseName(courseName);
        super.setDateOfEnrollment(dateOfEnrollment);
        //Set the instance variable to the provided values
        this.numOfModules = numOfModules;
        this.numOfCreditHours = numOfCreditHours;
        this.daysPresent = daysPresent;
        //Initialize isGrantedScholarship status to false by default
        this.isGrantedScholarship = false;
    }

    /* Getter method to get values for the attributes specific to the base class Regular which
     * Attribute Specific to Base class are numOfModules, numOfCreditHours, daysPresent, isGrantedScholarship.
     */
    // Getter method that returns the number of modules the student is enrolled in for the course.
    public int getNumOfModules() 
    {
        return numOfModules;
    }
    // Getter method that returns the number of credit hours for the enrolled course
    public int getNumOfCreditHours() 
    {
        return numOfCreditHours;
    }
    // Getter method that returns the number of days the student has attended the course
    public double getDaysPresent() 
    {
        return daysPresent;
    }
    // Getter method that returns whether or not the student has been granted a scholarship
    public boolean getIsGrantedScholarship() 
    {
        return isGrantedScholarship;
    }
    // Setter method for the attributes specific to the Regular class
    public void setIsGrantedScholarship(boolean isGrantedScholarship)
    {
        this.isGrantedScholarship = isGrantedScholarship;
    }
    //     Method to calculate the present percentage and will grant scholarship if the Present precentage is 80 percentage or above

    public String presentPercentage(double daysPresent) {
        // Local variable declaration and conversion for the months entered into days
        int courseDuration = getCourseDuration();
        int courseDurationInDays = courseDuration * 30;

        if (daysPresent < 0 || daysPresent > courseDurationInDays) {
            return "Error!! CourseDuration is less than days present";
        } else {
            //Percentage calculation
            boolean isGrantedScholarship;
            double presentPercentage = (daysPresent / courseDurationInDays) * 100;

            String result;

            if (presentPercentage >= 80) {
                isGrantedScholarship = true;
                setIsGrantedScholarship(isGrantedScholarship);
                result = "Attendance Grade: A and Present Percentage is: \t" + presentPercentage;
            } else if (presentPercentage >= 60 && presentPercentage < 80) {
                result = "Attendance Grade: B and Present Percentage is: \t" + presentPercentage;
            } else if (presentPercentage >= 40 && presentPercentage < 60) {
                result = "Attendance Grade: C and Present Percentage is: \t" + presentPercentage;
            } else if (presentPercentage >= 20 && presentPercentage < 40) {
                result = "Attendance Grade: D and Present Percentage is: \t" + presentPercentage;
            } else {
                isGrantedScholarship = false;
                setIsGrantedScholarship(isGrantedScholarship);
                result = "Attendance Grade: E and Present Percentage is: \t" + presentPercentage;
            }
            return result;
        }
    }

    // This method grants a certificate to a student who has graduated from a course

    public String grantCertificate(String courseName, int enrollmentId, String dateOfEnrollment) {
        String message = "The student has graduated.\n"
                + "Course Name: " + getCourseName() + "\n"
                + "Enrollment ID: " + getEnrollmentID() + "\n"
                + "Date of Enrollment: " + getDateOfEnrollment() + "\n";


        // Check if the student has been granted a scholarship and add to the message
        if (getIsGrantedScholarship()) {
            message += "The scholarship has been granted.";

        }
        System.out.println(message);

        return message;
    }

    
    // This method displays the information about the student's enrollment
    public void display() 
    {
        super.display();
        System.out.println("Number of Modules: " + getNumOfModules());
        System.out.println("Number of Credit Hours: " + getNumOfCreditHours());
        System.out.println("Days Present: " + getDaysPresent());
        System.out.println("Is Scholarship Granted: " + getIsGrantedScholarship());
    }

}
