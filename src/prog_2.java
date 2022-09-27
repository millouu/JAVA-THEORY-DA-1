import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class One{
    public synchronized void writeStringToFile(String FirstName,String SecondName)
    {
        File fileobj=new File("temporary.txt");
        try
        {
            FileWriter writeObj=new FileWriter("temporary.txt",true);
            writeObj.write(FirstName);
            writeObj.close();
        }
        catch (IOException e)
        {
            System.out.println("Unable to write to file!");
        }
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        try
        {
            FileWriter writeObj=new FileWriter("temporary.txt",true);
            writeObj.write(SecondName);
            writeObj.write("\n");
            writeObj.close();
        }
        catch (IOException e)
        {
            System.out.println("Unable to write to file!");
        }
    }
}

class Two extends Thread
{
    String f;
    String s;
    One obj;

    Two(String f,String s, One obj)
    {
        this.f=f;
        this.s=s;
        this.obj=obj;
        start();
    }

    public void run()
    {
        obj.writeStringToFile(f,s);
    }
}


public class prog_2 {
    public static void main(String[] args) {
        File fileobj=new File("temporary.txt");
        try
        {
            fileobj.createNewFile();
            System.out.println("File Successfully Created");
        }
        catch (IOException e)
        {
            System.out.println("File Creation Failed!");
        }

        One obj=new One();
        Two t1=new Two("Srishti","Chaurasia",obj);
        Two t2=new Two("Aranya","Si",obj);
        Two t3=new Two("Abhay","Nimmagadda",obj);
    }
}
