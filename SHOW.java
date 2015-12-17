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
        // loop for each item : TICKETORDER

        for ( int i = 0 ; i < noOfTicketsOrdered ; i++  ) 
        {
            if (ticketorderList[i].getmethodOfPurchase() == "S" )
            {
                purchaseMethodS = purchaseMethodS + 1 ; 
            }
            else 
            {
                purchaseMethodW = purchaseMethodW + 1 ; 
            }

            if (purchaseMethodS > purchaseMethodW)
            {
                //display purchase method S
                System.out.println("The most popular method of sale is sold in school") ;
            }
        
            if ( purchaseMethodW > purchaseMethodS) 
            {
              // display purchase method W
              System.out.println("The most popular method of sale is sold through the website  ") ;
            }
            
            if (purchaseMethodS == purchaseMethodW)
            {
             // display purchase method S and W
            }

        }

    }
}
