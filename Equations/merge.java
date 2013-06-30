import java.io.PrintStream;
public class merge{

	public static String combine(String alphabet,String special,int[][][] alpha_position,int[][][] special_position,PrintStream original)
	{
		String combined="";
		special = sort(special_position,special);
		int[][][] space = new int[200][2][2];
		int t=0,count=0;
		
		for(int k=0;k<special.length();k++)
		{
			while(alpha_position[t][0][0] < special_position[k][0][0])
			{
				combined = combined+alphabet.charAt(t);
				space[count][0][0]=alpha_position[t][0][0];
				space[count][0][1]=alpha_position[t][0][1];
				count++;
				t++;
			}
			combined = combined+special.charAt(k);
			space[count][0][0]=special_position[k][0][0];
			space[count][0][1]=special_position[k][0][1];
			count++;
		}
		  while(t < alphabet.length())
                        {
                                combined = combined+alphabet.charAt(t);
                                space[count][0][0]=alpha_position[t][0][0];
                                space[count][0][1]=alpha_position[t][0][1];
                                count++;
                                t++;
                        }

		
		int ArraySize = count,max_value=0;
		int[] Spacing=new int[ArraySize];
                for(int i=0; i<ArraySize; i++)
                        max_value=max(space[i][0][1]-space[i][0][0],max_value);


                double threshold=max_value/3.0;
                int index=1;

		for(int i=0; i<ArraySize-1; i++)
			Spacing[i]=space[i+1][0][0]-space[i][0][1];

		for(int i=0; i<Spacing.length; i++)
		{
			if(Spacing[i]>threshold)
			{
				combined=combined.substring(0,index)+" "+combined.substring(index);
				index++;
			}
			index++;
		}
		original.println(combined);	
		return combined;
	}
	public static int max(int a,int b)
	{
		if(a>b)
			return a;
		else
			return b;
	}
	public static String sort(int[][][] a,String special)
	{
		int temp;
		char t,k;
		int i,j;
		for(i=0;i<special.length();i++)
		{
			for(j=i+1;j<special.length();j++)
			{
				if(a[i][0][0] > a[j][0][0])
				{
					temp = a[i][0][0];
					a[i][0][0] = a[j][0][0];
					a[j][0][0] = temp;
					temp = a[i][0][1];

					a[i][0][1] = a[j][0][1];
					a[j][0][1] = temp;
					temp = a[i][1][0];
					a[i][1][0] = a[j][1][0];
					a[j][1][0] = temp;
					temp = a[i][1][1];
					a[i][1][1] = a[j][1][1];
					a[j][1][1] = temp;
					t = special.charAt(i);
					k = special.charAt(j);
					special = special.substring(0,j) + t + special.substring(j+1);
					special = special.substring(0,i) + k + special.substring(i+1);
				}
			}
		}
		return special;
	}
}

