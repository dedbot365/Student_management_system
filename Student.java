
/**
 * A public class Student is created with various attributes and methods.
 * Constructor is created that accepts four attributes.
 * Values were initialized  inside the constructor.
 * After that getter and setter methods have been defined.
 * A display method was made at last. 
 * @author (Subigyan Paudel)
 * @version (07/05/2023)
 */
//Public class created
public class Student
{
    //Attributes of the super class Student
    private String studentName;                         
    private String dateOfBirth;                         
    private String courseName;                          
    private String dateOfEnrollment;               
    private int enrollmentID;                           
    private int courseDuration;                         
    private double tuitionFee;                          

    //Creating a Constructor that accepts parameters 
    public Student (String dateOfBirth, String studentName, int courseDuration, double tuitionFee)
    {
        //Sets the value for the attributes to value passed as parameter into constructor as argument
        this.dateOfBirth= dateOfBirth;
        this.studentName=studentName;
        this.courseDuration=courseDuration;
        this.tuitionFee=tuitionFee;
        //Attribute enrollment is initilized at 0
        this.enrollmentID=0;
        //Attributes dateOfEnrollment and courseName is initilized as empty string
        this.dateOfEnrollment="";
        this.courseName="";
    }
    
    /* Getter method to get values for the attributes of the class Student
     * Attribute for class student are studentName, dateOfBirth, dateOfEnrollment, courseDuration, enrollmentID, tuitionFee, courseName.
     */
    // Accessor or getter method for each attributes
    public String getStudentName()
    {
        return studentName;                                                     
    }

    public String getDateOfBirth() 
    {
        return dateOfBirth;
    }

    public String getCourseName() 
    {
        return courseName;
    }

    public String getDateOfEnrollment() 
    {
        return dateOfEnrollment;
    }

    public int getEnrollmentID()
    {
        return enrollmentID;
    }

    public int getCourseDuration() 
    {
        return courseDuration;
    }

    public double getTuitionFee()
    {
        return tuitionFee;
    }
    /* Setter method to set values for the attributes of the class Student
     * Sets the value of the Attribute for class student are studentName, dateOfBirth, dateOfEnrollment, courseDuration, enrollmentID, tuitionFee, courseName.
     */
    // Setter or mutator methods for attrubutes of the student Class
    public void setEnrollmentId(int enrollmentID)
    {
        this.enrollmentID=enrollmentID;
    }

    public void setCourseName(String courseName)
    {
        this.courseName=courseName;
    }

    public void setDateOfEnrollment(String dateOfEnrollment)
    {
        this.dateOfEnrollment=dateOfEnrollment;
    }
    
    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth=dateOfBirth;
    }
    
    public void setStudentName (String studentName)
    {
        this.studentName=studentName;
    }
    
    public void setCourseDuration (int courseDuration)
    {
        this.courseDuration = courseDuration;
    }
    
    public void setTuitionFee(double tuitionFee)
    {
        this.tuitionFee = tuitionFee;
    }
    
    // Method to display the details of Student Class
    public void display() 
    {
        //Explicit type casting that changes the integer type courseDuration to the folating type
        float yearsEnrolled = ((float)this.courseDuration/12);

        if (getStudentName()=="" || getDateOfBirth()=="" || getCourseDuration() <= 0 || getTuitionFee() <= 0 || getEnrollmentID()<=0){
            System.out.println("Main parameters are missing or invalid Enter it again!!"); 
            return;
        } 
        else{
            System.out.println("Enrollment ID: " + getEnrollmentID());
            System.out.println("Date of Birth: " + getDateOfBirth());
            System.out.println("Course Name: " + getCourseName());
            System.out.println("Student Name: " + getStudentName());
            System.out.println("Years Enrolled: " + yearsEnrolled);
            System.out.println("Course Duration (in months): " + getCourseDuration());
            System.out.println("Tuition Fee: " + tuitionFee); 
        }

    }
}
