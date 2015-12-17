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

    public SHOW() 
    {  
        purchaseFile = new FILEREADCSV () ;
    }

    public void processTICKETORDER () throws IOException
    {
        setUpticketorderList () ;
        countmethodOfPurchase () ;

    }

    public void setUpticketorderList () throws IOException
    {
        System.out.println("Essell Academy: Show update") ;
        System.out.println("** Preparing to read data file") ;
        
        String[] dataRows = purchaseFile.readCSVtable () ;
        noOfTicketsOrdered = dataRows.length ;
        
        System.out.println("**" + noOfTicketsOrdered + "rows read. \n\n") ;
        
        ticketorderList = new TICKETORDER[noOfTicketsOrdered] ;
        
        for (int i = 0 ; i < noOfTicketsOrdered ; i++) {
        
        ticketorderList[i] = new TICKETORDER () ;
        
        ticketorderList[i].readTICKETORDERDetails(dataRows[i]) ;
        
        }
    }

    public void countmethodOfPurchase ()
    {
        // 
    }

    
}




