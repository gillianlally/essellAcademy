
import javax.swing.JOptionPane;    

//ticket order = pupil
//purchase = mark
// topmark = purchasemethod
public class TICKETORDER 
{ 
    private String customerID ;
    private String ticketID ;
    private char tID ;
    private int noOfTickets ;
    private String methodOfPurchase ;
    private char purchase ;
    public TICKETORDER ()
    { 
        customerID = "" ;
        tID = ' ' ;
        ticketID = "" ;
        noOfTickets = 0 ;
        methodOfPurchase = "" ;
        purchase = ' ' ;
    }

    public void readTICKETORDERDetails(String dataItems)
    {
        //unpack string of row data into fields
        String[] rowItems = dataItems.split(",") ;

        // store each data item as instance property
        customerID = rowItems[0] ;
        tID = (rowItems[1]).charAt(0) ; 
        ticketID = rowItems [1] ;
        noOfTickets =  Integer.parseInt(rowItems[2]) ;
        methodOfPurchase = rowItems[3] ; 
        purchase = rowItems[3].charAt(0) ;
        
    }

    public String writeDetails()
    {
        // join up data into a string to output as a row
        // use "," to separate csv columns
        String memberData = "";
        memberData = memberData.concat(customerID);
        memberData = memberData.concat(",");
        memberData = memberData.concat(ticketID);
        memberData = memberData.concat(",");
        memberData = memberData.concat(Float.toString(noOfTickets));
        memberData = memberData.concat(",") ;
        memberData = memberData.concat(methodOfPurchase) ;
        return memberData;
    }

    public String getmethodOfPurchase ()
    {
        return methodOfPurchase ;
    }
    
 public char getPURCHASE ()
 { 
    return purchase ;
    }
    
    public char gettID ()
    {
        return tID    ; 
    }
}