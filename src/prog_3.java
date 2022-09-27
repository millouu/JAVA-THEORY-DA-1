import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class prog_3 {
    static boolean isLowercase(int i)
    {
        if(i>=97 && i<=122)
            return true;
        return false;
    }

    static boolean isUppercase(int i)
    {
        if(i>=65 && i<=90)
            return true;
        return false;
    }

    static boolean isInteger(int i)
    {
        if(i>=48 && i<=57)
            return true;
        return false;
    }

    static boolean isSpChar(int i)
    {
        if((i>=32 && i<=47) || (i>=58 && i<=64) || (i>=91 && i<=96) || (i>=123 && i<=126))
            return true;
        return false;
    }

    public static void main(String[] args) {

        int lowercaseCount=0,uppercaseCount=0,integerCount=0,spcharCount=0;

        try{
            FileReader readobj=new FileReader("data.txt");
            int i;
            System.out.println("Contents of the File");
            System.out.println("---------------------------------------------");
            while((i=readobj.read())!=-1)
            {
                System.out.print((char)i);

                //ASCII value for space=32
                if(i!=32 && i!=13)
                {
                    if(isLowercase(i))
                        lowercaseCount++;
                    else if(isUppercase(i))
                        uppercaseCount++;
                    else if(isInteger(i))
                        integerCount++;
                    else if(isSpChar(i))
                        spcharCount++;
                }
            }

        }
        catch (IOException e)
        {
            System.out.println("Unable to Read from File!");
        }
        System.out.println("\n---------------------------------------------");
        System.out.println("TEXT ANALYSIS RESULTS");
        System.out.println("---------------------------------------------");
        System.out.println("Lowecase Characters : "+lowercaseCount);
        System.out.println("Uppercase Characters: "+uppercaseCount);
        System.out.println("Integer Characters  : "+integerCount );
        System.out.println("Special Characters  : "+spcharCount);
    }
}
