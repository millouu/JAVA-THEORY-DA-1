import java.util.Random;
class TPRElectionVote
{
    //static variables to store the total vote count of each candidate
    public static int voteCountX,voteCountY,voteCountZ;

    //static array to record the vote of every voter
    public static int voteArr[]=new int[350];
    TPRElectionVote()
    {
        voteCountX=voteCountY=voteCountZ=0;
    }

    public void voteGenerator()
    {
        Random r=new Random();
        for(int i=0;i<350;i++)
        {
            int vote=r.nextInt(3);
            //Vote Token: X-1, Y-2, Z-3;
            vote++;
            voteArr[i]=vote;
        }
    }

    public synchronized void voteCounter(char Candidate)
    {
        for(int i=0;i<350;i++)
        {
            if(Candidate =='X')
            {
                if(voteArr[i]==1)
                    voteCountX++;
            }

            if(Candidate=='Y')
            {
                if(voteArr[i]==2)
                    voteCountY++;
            }

            if(Candidate=='Z')
            {
                if(voteArr[i]==3)
                    voteCountZ++;
            }
        }
    }

    public void displayResults()
    {
        System.out.println();
        System.out.println("\nTPR ELECTION RESULTS");
        System.out.println("----------------------------------");
        System.out.println("X: "+voteCountX);
        System.out.println("Y: "+voteCountY);
        System.out.println("Z: "+voteCountZ);

    }
}

class counterX extends Thread
{
    TPRElectionVote t;
    counterX(TPRElectionVote obj)
    {
        t=obj;
    }

    public void run()
    {
        t.voteCounter('X');
    }
}

class counterY extends Thread
{
    TPRElectionVote t;

    counterY(TPRElectionVote obj)
    {
        t=obj;
    }

    public void run()
    {
        t.voteCounter('Y');
    }
}

class counterZ extends Thread
{
    TPRElectionVote t;

    counterZ(TPRElectionVote obj)
    {
        t=obj;
    }

    public void run()
    {
        t.voteCounter('Z');
    }
}

public class prog_1 {
    public static void main(String[] args) throws InterruptedException {
        TPRElectionVote voter=new TPRElectionVote();
        voter.voteGenerator();

        counterX cx=new counterX(voter);
        counterY cy=new counterY(voter);
        counterZ cz=new counterZ(voter);

        cx.start();
        cx.join();
        cy.start();
        cy.join();
        cz.start();
        cz.join();

        voter.displayResults();
        if(voter.voteCountX>=voter.voteCountY && voter.voteCountX>=voter.voteCountZ)
        {
            if(voter.voteCountX==voter.voteCountY)
            {
                System.out.println("X and Y have a draw");
            } else if (voter.voteCountX==voter.voteCountZ) {
                System.out.println("X and Z have a draw");
            }
            else {
                System.out.println("X has won the election");
            }
        }
        else if(voter.voteCountY>voter.voteCountX && voter.voteCountY>voter.voteCountZ)
        {
            if(voter.voteCountX==voter.voteCountY)
            {
                System.out.println("X and Y have a draw");
            } else if (voter.voteCountY==voter.voteCountZ) {
                System.out.println("Y and Z have a draw");
            }
            else {
                System.out.println("Y has won the election");
            }
        }
        else
        {
            System.out.println("Z has won the election");
        }
    }
}
