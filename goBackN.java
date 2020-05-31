package goBackN;
import java.util.*;
import java.io.*;

public class goBackN
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int nf,N;
		int no_tr=0;
		Random rand=new Random(System.currentTimeMillis());
		System.out.println("\n Enter no. of frames:");
		nf=input.nextInt();
		System.out.println("\n Enter the window size:");
		N=input.nextInt();
		int i=1;
		while(i<=nf)
		{
			int x=0;
			for(int j=i;j<i+N&&j<=nf;j++)
			{
				System.out.println("\nSent Frame"+j);
				no_tr++;
			}
			for(int j=i;j<i+N&&j<=nf;j++)
			{
				int flag=rand.nextInt()%2;
				if(flag==0)
				{
					System.out.println("\nAcknowledgement for frame"+j);
					x++;
				}
				else
				{
					System.out.println("\n Frame"+j+"not received");
					System.out.println("\nRetransmitting window..");
					break;
				}
			}
			i+=x;
		}
		System.out.println("\nTotal transmission:"+no_tr);
	}
	
}
/*OUTPUT
 * Enter no. of frames:
5

 Enter the window size:
3

Sent Frame1

Sent Frame2

Sent Frame3

Acknowledgement for frame1

 Frame2not received

Retransmitting window..

Sent Frame2

Sent Frame3

Sent Frame4

Acknowledgement for frame2

Acknowledgement for frame3

Acknowledgement for frame4

Sent Frame5

 Frame5not received

Retransmitting window..

Sent Frame5

 Frame5not received

Retransmitting window..

Sent Frame5

Acknowledgement for frame5

Total transmission:9
*/
