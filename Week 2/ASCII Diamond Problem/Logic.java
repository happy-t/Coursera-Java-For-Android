package mooc.vandy.java4android.diamonds.logic;

import java.sql.Statement;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        int height = 2*size + 1;
        int width = 2*size + 2;
        int count = 1;
        mOut.print("+");
        for(int i = 0; i<width-2; i++)
        {
            mOut.print("-");
        }
        mOut.println("+");

        // Top
        for(int i = 1; i<=(height-2)/2; i++)
        {
            String c;
            if(i%2 == 0)
            {
                c = "-";
            }
            else
                c = "=";

            mOut.println("|" + spaces(i, width - 2) + "/" + center(i,c) + "\\" + spaces(i, width - 2) + "|");
            count++;
        }

        //Middle

        String c;
        if(count%2 == 0)
        {
            c = "-";
        }
        else
            c = "=";
        mOut.println("|<" + center(count, c) + ">|");

        //Bottom

        for(int i=count-1; i>0; i--)
        {
            String cstr;
            if(i%2 == 0)
            {
                cstr = "-";
            }
            else
                cstr = "=";

            mOut.println("|" + spaces(i, width - 2) + "\\" + center(i,cstr) + "/" + spaces(i, width - 2) + "|");
            count++;
        }

        mOut.print("+");
        for(int i = 0; i<width-2; i++)
        {
            mOut.print("-");
        }
        mOut.println("+");

    }

    public String spaces(int a, int size)
    {
        int letters = 2*a;
        int space_count = (size - letters)/2;
        String spaces = "";
        for(int i=0; i<space_count; i++)
        {
            spaces += " ";
        }

        return spaces;
    }

    public String center(int a, String b)
    {
        String text = "";
        int n = a-1;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<2; j++)
            {
                text += b;
            }
        }

        return text;
    }

    
}
