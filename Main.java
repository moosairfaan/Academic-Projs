import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		String name;
		String pass;
		String transactionAsk;
		String n;
		String c;
		double totalBalance = 1000.0;
		String end;
		DecimalFormat df = new DecimalFormat("#.##");
		
		do {
			name = JOptionPane.showInputDialog("Welcome to the Piggy Bank."
					+ "\nPlease enter your name");
		} while(name == null || name.equals(""));
		System.out.println(name);
		
		do {
			pass = JOptionPane.showInputDialog("Enter your Password");
			
		} while(!pass.equals("ABCD"));
		
		do {
			transactionAsk = JOptionPane.showInputDialog("Is this transaction grouping deposits"
					+ "\n(as opposed to a group of \nwithdrawls)? Yes or No?");
			
			n = JOptionPane.showInputDialog("How many transactions in this grouping?");
			int transactionNumbers = Integer.parseInt(n);
			
			double transactionAmount;
			
			double sum = 0.0;
			for (int i = 1; i<=transactionNumbers; i++) {
				
				c = JOptionPane.showInputDialog("Enter a transaction amount");
				transactionAmount = Double.parseDouble(c);
				
				if (transactionAsk.equalsIgnoreCase("yes")) {
					totalBalance = totalBalance+transactionAmount;
					sum = sum+transactionAmount;
					//System.out.println(df.format(sum));
				}
				else if (transactionAsk.equalsIgnoreCase("no")) {
					totalBalance = totalBalance-transactionAmount;
					sum = sum+transactionAmount;
					//System.out.println(df.format(sum));
				}
				else {
					JOptionPane.showMessageDialog(null, "Please click OK to try again.");
					continue;
				}
			}
		
			end = JOptionPane.showInputDialog(null, name + ", the total of the " 
									+ transactionNumbers + " transactions in this "
									+ "\ngroup of transactions is: $" + df.format(sum)
									+ "\nYour new balance is: $" + df.format(totalBalance)
									+ "\nDon't make an input, just Click: OK to"
									+ "\ncontinue, Cancel to exit the program");
			if (end == null || end.equalsIgnoreCase("Cancel")) {
				break;
			}

		} while (true);
	}

}
