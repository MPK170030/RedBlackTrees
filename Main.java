import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception
	{
		try {
		String inputFile = args[0];
		String outputFile = args[1];
		Scanner input = new Scanner(new File(inputFile));
		PrintWriter output = new PrintWriter(new File(outputFile));
		if(input.hasNext())
		{
		 String s = input.next();
		 input.nextLine();
		 if(s.equals("Integer") || s.equals("String"))
		 {
			  if(s.equals("Integer"))
			  {
				  RedBlackTree<Integer> n = new RedBlackTree<>();
				  performCommandsIntegers(input,output,n);
			  } 
			  else
			  {
				  RedBlackTree<String> n = new RedBlackTree<>();
				  perform(input,output,n);
			  }
			  
		 }
		 else
		 {
			 output.println("Only works for objects Integers and Strings");
		 }
		}
		input.close();
		output.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

	}
	
	public static void perform(Scanner input,PrintWriter output, RedBlackTree<String> n)
	{
				while(input.hasNext())
				{
					String command = input.nextLine();
					if(command.contains("Insert:"))
					{
						String element = command.substring(7);
						try 
						{
							
							boolean result = n.insert(element);
							if(result == true)
							{
								output.println("True");
							}
							else
							{
								output.println("False");
							}
						}
						catch(NullPointerException ex)
						{
							output.println(ex.getMessage());
						}
						catch(Exception ex)
						{
							
						}
					}
					else if(command.contains("Contains:"))
					{
						String element = command.substring(9);
						try 
						{
							boolean result = n.contains(element);
							if(result == true)
							{
								output.println("True");
							}
							else
							{
								output.println("False");
							}
						}
						catch(NullPointerException ex)
						{
							output.println(ex.getMessage());
						}
						catch(Exception ex)
						{
							
						}
					}
					else if(command.contains("PrintTree"))
					{
						command = command.replaceAll("\\s+", "");
					    if(command.equals("PrintTree"))
						output.println(n);
					}
					else
					{
						output.println("Error in Line: " + command);
					}
				}
	}
	
    public static void performCommandsIntegers(Scanner input,PrintWriter output, RedBlackTree<Integer> tree) 
    {
    	while(input.hasNext())
		{
			String command = input.nextLine();
			if(command.contains("Insert:"))
			{
				
				try 
				{ 
					command = command.replaceAll("\\s+", "");
					int element = Integer.parseInt(command.substring(7));
					boolean result = tree.insert(element);
					if(result == true)
					{
						output.println("True");
					}
					else
					{
						output.println("False");
					}
				}
				catch(NumberFormatException ex)
				{
					output.println("Error in Line: " + command);
				}
				catch(NullPointerException ex)
				{
					output.println(ex.getMessage());
				}
				catch(Exception ex)
				{
					
				}
				
			}
			else if(command.contains("Contains:"))
			{
				
				try 
				{
					command = command.replaceAll("\\s+", "");
					int element = Integer.parseInt(command.substring(9));
					boolean result = tree.contains(element);
					if(result == true)
					{
						output.println("True");
					}
					else
					{
						output.println("False");
					}
					
				}
				catch(NumberFormatException ex)
				{
					output.println("Error in Line: " + command);
				}
				catch(NullPointerException ex)
				{
					output.println(ex.getMessage());
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
			else if(command.contains("PrintTree"))
			{  
				command = command.replaceAll("\\s+", "");
			    if(command.equals("PrintTree"))
				output.println(tree);
			}
			else
			{
				output.println("Error in Line: " + command);
			}
		}
    }

}
