import javax.swing.JOptionPane;    
import java.io.* ;

public class SHOW 
{
    // array

    private TICKETORDER ticketorderList [] ;
    private int noOfTicketsOrdered ; 
    private int purchaseMethodW ;
    private int purchaseMethodS ;
    private String mostPopular ;
    private int Total ;
    
    FILEREADCSV purchaseFile ;
    
    FILEWRITECSV resultsFile ; 

    public SHOW() throws IOException
    {  
        purchaseMethodFile = new FILEREADCSV () ;
        resultsFile = new FILEWRITECSV () ;
        Total = 0 ;
        purchaseMethodW = 0 ;
        purchaseMethodS = 0 ;
        noOfTicketsOrdered = 0 ;
        mostPopular = "" ;
    }

    public void processticketOrder () 
    {
        setUpticketOrderList () ;
        

    }

    public void setUpticketorder () 
    {
        //
    }
}