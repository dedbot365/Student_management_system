/**
 *A class Dropout is created. 
 *This class is the base class for the super class Student.
 *Attributes specific to the Dropout class is defined inside the class.
 *Constructor is created for the dropout class.
 *Super class constructor is called from inside the constructor just created.
 *Setting the value using setter method using getter method and super class.
 *Accessor method being created to those attributes that are obly specific to the Dropout class.
 *A method is defined that is used to calculate the remaining amount to be paid, local variable is declared in that method.
 *Method to remove student is made if has paid is true and the method to display the output of the dropout class is also created.
 *
 *
 * @author (Subigyan Paudel)
 * @version (a version number or a date)
 */
//Public base class Dropout of super class Student 
public class Dropout extends Student {
    // attributes only of the  Dropout class
    private int numOfRemainingModules;
    private int numOfMonthsAttended;
    private String dateOfDropout;
    private int remainingAmount;
    private boolean hasPaid;

    // Constructor for Dropout class
    public Dropout(String studentName, String dateOfBirth, int courseDuration, double tuitionFee, int numOfRemainingModules, int numOfMonthsAttended, String dateOfDropout) 
    {
        // Calling superclass constructor with four parameters
        super(dateOfBirth, studentName, courseDuration, tuitionFee);
        // Setting enrollment id, course name and date of enrollment using parent class setter methods
        super.setEnrollmentId(super.getEnrollmentID());
        super.setCourseName(super.getCourseName());
        super.setDateOfEnrollment(super.getDateOfEnrollment());
        // Initializing attributes of the Dropout class
        this.numOfRemainingModules = numOfRemainingModules;
        this.numOfMonthsAttended = numOfMonthsAttended;
        this.dateOfDropout = dateOfDropout;
        this.remainingAmount = 0;
        this.hasPaid = false;
    }

    // Acessor methods for attributes of the base class Dropout only
    public int getNumOfRemainingModules() 
    {             
        return numOfRemainingModules;
    }

    public int getNumOfMonthsAttended() 
    {
        return numOfMonthsAttended;
    }

    public String getDateOfDropout() 
    {
        return dateOfDropout;
    }

    public int getRemainingAmount() 
    {
        return remainingAmount;
    }

    public boolean isHasPaid() 
    {
        return hasPaid;
    }
    // Setter method for the attributes specific to the dropout class
     public void setNumOfRemainingModules(int numOfRemainingModules)
    {
        this.numOfRemainingModules = numOfRemainingModules;
    }
    
     public void setDateOfDropout(String dateOfDropout)
    {
        this.dateOfDropout = dateOfDropout;
    }
    
    public void setNumOfMonthsAttended(int numOfMonthsAttended)
    {
        this.numOfMonthsAttended = numOfMonthsAttended;
    }
    
     public void setRemainingAmount(int remainingAmount)
    {
        this.remainingAmount = remainingAmount;
    }

     public void setHasPaid(boolean hasPaid)
    {
        this.hasPaid = hasPaid;
    }
    
    // Method to calculate pending tuition fee and set remainingAmount and hasPaid attributes

    public void billsPayable(int paidAmount) {
        if (!hasPaid) {
            int totalAmount = (int) ((getCourseDuration() - numOfMonthsAttended) * getTuitionFee());
            setRemainingAmount(totalAmount);
        }

        if (paidAmount > 0) {
            setRemainingAmount(getRemainingAmount() - paidAmount);

            if (getRemainingAmount() <= 0) {
                setHasPaid(true);
            }
        }
    }

    // method to remove student and clear bills if hasPaid is true
    public void removeStudent()
    {
        if (hasPaid) {
            setDateOfBirth("");
            setCourseName("");
            setStudentName("");
            setDateOfEnrollment("");
            setEnrollmentId(0);
            setCourseDuration(0);
            setTuitionFee(0);
            setDateOfDropout("");
            setNumOfRemainingModules(0);
            setNumOfMonthsAttended (0);
            setRemainingAmount (0);
            setHasPaid (false);
        }
        else {
            System.out.println("All bills not cleared");
        }

    }

    // method to display details of Dropout class
    public void display() 
    {
        super.display();
        System.out.println("Number of Remaining Modules: " + numOfRemainingModules);
        System.out.println("Number of Months Attended: " + numOfMonthsAttended);
        System.out.println("Date of Dropout: " + dateOfDropout);
        System.out.println("Remaining Amount: " + remainingAmount);
        System.out.println("Has Paid: " + hasPaid);
    }
}
