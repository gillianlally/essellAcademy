import javax.swing.JOptionPane;
import java.io.*; 
import java.util.Calendar;              // for general file handling
public class SHOW
{

    private TICKETORDER ticketorderlist[];// array of ticket orders 
    private int noOfTicketsOrdered;
    private int purchaseMethodS;
    private int purchaseMethodW;
    private int Total;
    private int year;
    private String MostPopularMethod ;

    // CLASSes to open, create, read/write, close files
    FILEREADCSV purchaseFile; 
    // CLASSes to open, create, read/write, close files
    FILEWRITECSV resultsFile;        

    public SHOW()  throws IOException
    {
        //declaring the variables
        noOfTicketsOrdered = 0 ;
        purchaseMethodS = 0 ;
        purchaseMethodW = 0 ; 
        Total = 0 ;
        year = 0 ;
        MostPopularMethod = "  " ;
        purchaseFile = new FILEREADCSV();
        resultsFile = new FILEWRITECSV();

    }

    public void processorder()  throws IOException
    {
        Ticketorder();
        countPURCHASE();
        calculateMostPopularMETHOD();
        saveNewMembers();
        getdate();
        Display();

    }

    private void Ticketorder() throws IOException
    {

        System.out.println("** Preparing to read data file.");
        String[] dataRows = purchaseFile.readCSVtable();
        noOfTicketsOrdered = dataRows.length ;// number of orders calculated after reading file
        System.out.println("** " + noOfTicketsOrdered + " rows read.\n\n");

        ticketorderlist = new TICKETORDER[noOfTicketsOrdered];

        for  (int i = 0; i < noOfTicketsOrdered; i++) {
            ticketorderlist[i] = new TICKETORDER();

            ticketorderlist[i].readTICKETORDERDetails(dataRows[i]);
        }
    }

    public void countPURCHASE() throws IOException
    {
        // *prepare a String to write data to disc
        String fileContent = "";

        // start the count
        int vcount = 0;

        // loop for each item : member
        for (int i = 0; i < noOfTicketsOrdered; i++)
        {
            // decide if current item: member matches target: bmi
            if (ticketorderlist[i].getPURCHASE() == 'S' )
            {
                purchaseMethodS = purchaseMethodS +1;
            }
            else 
            {
                purchaseMethodW = purchaseMethodW +1;
            }

            if (ticketorderlist[i].gettID() == 'T' || ticketorderlist[i].gettID() == 'W')
            { 
                Total = Total + 5;
                // *display the details for the member
            }
            else 
            {
                Total = Total + 10;
                //resultsFile.writeCSVtable(fileContent);
            }

        }

    }

    public static void main(String[] args)  throws IOException
    {
        SHOW myShow = new SHOW();
        myShow.processorder();
    }

    public void saveNewMembers() throws IOException
    {
        String fileContent = "";
        int vcount = 0;
        for (int i = 0; i < noOfTicketsOrdered; i++) 
        {
            if(ticketorderlist[i].gettID() == 'F' )
            {
                vcount = vcount + 1;
                if (vcount>1) 
                {
                    fileContent = fileContent.concat("\n");
                }
                fileContent = fileContent.concat(ticketorderlist[i].writeDetails());
            }
        }

        // *send for writing to file as a string containing all data
        System.out.println("** Preparing to write new members file.");
        resultsFile.writeCSVtable(fileContent);
        System.out.println("** File written and closed.");
    }

    public void calculateMostPopularMETHOD()
    {
        if (purchaseMethodS > purchaseMethodW)
        {
            MostPopularMethod = "sold in school";
        }
        else 
        {
            MostPopularMethod = "sold online";
        }
    }

    public void getdate()
    {
        year = Calendar.getInstance().get(Calendar.YEAR);
    }

    public void Display()
    {
        System.out.println("\n Essell Academy Choral Shield " + year);
        System.out.println("\n The total money rasied for charity is £" + Total);
        System.out.println(" The most popular method of sale is " + (MostPopularMethod));
        // A blank line to separate this report from others.
        System.out.println();
    }
}
