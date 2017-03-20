//Name: Tao Ling
//UFL ID: tao.ling
//Section: 5994
//Project Number: 3
//Brief description of file contents: CurrencyCalculator

import java.util.Scanner;

public class CurrencyExchange {

    private static double balance = 0;

    /**
     * Get the current balance of the account
     */
    public static double getBalance() {
        return balance;
    }

     /**
     * Update the balance of current account, will do a roundup to 2 significant digits
     *
     * @return if update succeed, will return true. If failed, return false
     */
    private static boolean updateBalance(double newBalance) {
        balance = Math.round(newBalance * 100) / 100.0;
        if (balance >= 0) {
            return true;
        } else
            return false;
    }

/****************************************************************
*        Do not modify anything above this line                 *
*****************************************************************/

    /**
     * main method, put your business logic and console input here
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Currency Exchange 2.0");
		System.out.println("\nCurrent rates are as follows:\n");
		printConversionTable();
		int currencyType = 0;
		double amount = 0;
		while(true){
					int mainMenuOptionSelector = mainMenuOptionSelector(input);
					switch(mainMenuOptionSelector){
					case 1: 
						System.out.println("Your current balance is: " + getBalance());
						break;
					case 2: 
						currencyType = currencyMenuOptionSelector(input);
						System.out.println("Please enter the deposit amount:");
						amount = input.nextDouble();
						deposit(amount, currencyType);
						System.out.println(logTransaction(amount, currencyType, true));
						break;
					case 3: 
						currencyType = currencyMenuOptionSelector(input);
						System.out.println("Please enter the withdraw amount:");
						amount = input.nextDouble();
						withdraw(amount, currencyType);
						System.out.println(logTransaction(amount, currencyType, false));
						break;
					case 4: 
						withdraw(getBalance(), 1);
						System.out.println(logTransaction(amount, 1, false));
						System.out.println("Goodbye");
						System.exit(0);
					}	
		}
    }


    /**
     * deposit the amount of a specific currency to the account
     *
     * @param amount       the amount to be deposited.
     * @param currencyType the currency type will be the same as the type number used
     *                     in the convertCurrency(double, int, boolean) method. An Invalid type will result in a
     *                     deposit failure.
     * @return if deposit succeed, will return true. If failed, return false
     */
    public static boolean deposit(double amount, int currencyType) {
    	if((amount<=0) || (currencyType<1||currencyType>11)){
    		return false;
    	}
    	else{
        	updateBalance(convertCurrency(amount, currencyType, true) + getBalance());
    		return true;
    	}
    }

    /**
     * withdraw the value amount with a specific currency from the account. The withdraw amount should never exceed the current account balance, or the withdrawal will fail. If the currency is other than USD, a 0.5% convenience fee will be charged
     *
     * @param amount       the amount to be withdrawn.
     * @param currencyType the currency type will be the same as the type number used
     *                     in the convertCurrency(double, int, boolean) method. An invalid
     * 		         type will result a withdraw failure.
     * @return if withdraw succeed, will return true. If failed, return false
     */
    public static boolean withdraw(double amount, int currencyType) {
    	double withdrawalAmount = convertCurrency(amount, currencyType, true);
    	if(currencyType<1 || currencyType>11){
    		return false;
    	}
    	if(amount<=0){
    		return false;
    	}
    	if(currencyType == 1){
    		if(amount<=getBalance()){
    			updateBalance(getBalance() - amount);
        		return true;
    		}
    		else{
    			System.out.println("Error: Insufficient funds.");
    			return false;
    		}
    	}
    	else{
    		if((withdrawalAmount*1.005)>getBalance()){
    			System.out.println("Error: Insufficient funds.");
    			return false;
    		}
    		else{
    			updateBalance(getBalance() - (withdrawalAmount*1.005));
    			return true;
    		}
    	}
    }

    /**
     * Convert the value amount between U.S. dollars and a specific currency.
     *
     * @param amount         The amount of the currency to be converted.
     * @param currencyType   The integer currencyType works as follows:
     *                       1 for usd (U.S. Dollars)
     *                       2 for eur (Euros)
     *                       3 for bri (British Pounds)
     *                       4 for inr (Indian Rupees)
     *                       5 for aus (Australian Dollars)
     *                       6 for cnd (Canadian Dollars)
     *                       7 for sid (Singapore Dollars)
     *                       8 for swf (Swiss Francs)
     *                       9 for mar (Malaysian Ringgits)
     *                       10 for jpy (Japanese Yen)
     *                       11 for cyr (Chinese Yuan Renminbi)
     * @param isConvertToUSD Tells the direction of the conversion. If the value is true, then the conversion is from a
     *                       foreign currency to USD. If the value is false, then the conversion is from USD to the
     *                       foreign currency
     * @return the converted amount
     */
    public static double convertCurrency(double amount, int currencyType, boolean isConvertToUSD) {
    	double convertCurrency = 0;
		if(isConvertToUSD){
			switch(currencyType){
			case 1: convertCurrency = amount/1.00;
				break;
			case 2: convertCurrency = amount/.89;
				break;
			case 3: convertCurrency = amount/.78;
				break;
			case 4: convertCurrency = amount/66.53;
				break;
			case 5: convertCurrency = amount/1.31;
				break;
			case 6: convertCurrency = amount/1.31;
				break;
			case 7: convertCurrency = amount/1.37;
				break;
			case 8: convertCurrency = amount/.97;
				break;
			case 9: convertCurrency = amount/4.12;
				break;
			case 10: convertCurrency = amount/101.64;
				break;
			case 11: convertCurrency = amount/6.67;
				break;
			}
		}
		else{
			switch(currencyType){
			case 1: convertCurrency = amount*1.00;
				break;
			case 2: convertCurrency = amount*.89;
				break;
			case 3: convertCurrency = amount*.78;
				break;
			case 4: convertCurrency = amount*66.53;
				break;
			case 5: convertCurrency = amount*1.31;
				break;
			case 6: convertCurrency = amount*1.31;
				break;
			case 7: convertCurrency = amount*1.37;
				break;
			case 8: convertCurrency = amount*.97;
				break;
			case 9: convertCurrency = amount*4.12;
				break;
			case 10: convertCurrency = amount*101.64;
				break;
			case 11: convertCurrency = amount*6.67;
				break;
			}
		}
		return convertCurrency;
    }

    /**
     * Displays message at the end of the withdraw, deposit, and endTransaction stating
     * how much the user just withdrew/deposited and what type (this will be used in both features B, C and D of the
     * main menu).
     *
     * @param amount       the amount of currency withdrew/deposited
     * @param currencyType the currency type will be the same as the type number used
     *                     in {@link #convertCurrency(double, int, boolean)}
     * @param isDeposit    if true log the deposit transaction, false log the withdraw transaction
     * @return Return the formatted log message as following examples:
     * You successfully withdrew 10.0 U.S. Dollars
     * You successfully deposited 30.0 Japanese Yen
     * <p>
     * The invalid input like invalid currencyType or negative amount,
     * will return a "Logging Error"
     */
    private static String logTransaction(double amount, int currencyType, boolean isDeposit) {
    	String type = null;
    	switch(currencyType){
    	case 1: type = "U.S. Dollars";
    	break;
    	case 2: type = "Euros";
    	break;
    	case 3: type = "British Pounds";
    	break;
    	case 4: type = "Indian Rupees";
    	break;
    	case 5: type = "Australian Dollars";
    	break;
    	case 6: type = "Canadian Dollars";
    	break;
    	case 7: type = "Singapore Dollars";
    	break;
    	case 8: type = "Swiss Francs";
    	break;
    	case 9: type = "Malaysian Ringgits";
    	break;
    	case 10: type = "Japanese Yen";
    	break;
    	case 11: type = "Chinese Yuan Renminbi";
    	break;
    	default: return "Logging Error";
    	}
    	
    	if(isDeposit){
    		if(amount<=0){
    			return "Logging Error"; 
        	}
    		else{
        		return "You successfully deposited " + amount + " " + type;
    		}
    	}
    	else{
    		if(amount<0){
        		return "Logging Error";	
    		}
    		if((amount == 0) && (getBalance() == 0)){
				return "Your remaining balance is 0.0 U.S. dollars";
			}
    		if((getBalance()<amount) && (getBalance()>0)){
    			return "Logging Error";	
    		}
    		else{
    			return "You successfully withdrew " + amount + " " + type;
    		}
    	}
   }

    /**
     * Prints the currency menu (see output examples), allows the user to make a selection from available currencies
     *
     * @param input the Scanner object you created at the beginning of the main method. Any value other than the
     *              11 valid valid currency types should generate an invalid value prompt. Print the list again
     *              and prompt user to select a valid value from the list. the currency type will be the same as
     *              the type number used in {@link #convertCurrency(double, int, boolean)}
     * @return an integer from 1-11 inclusive representing the user’s selection.
     */
    private static int currencyMenuOptionSelector(Scanner input) {
		while(true){
			System.out.println("Please select the currency type:\n"
					+ "1. U.S. Dollars\n"
					+ "2. Euros\n"
					+ "3. British Pounds\n"
					+ "4. Indian Rupees\n"
					+ "5. Australian Dollars\n"
					+ "6. Canadian Dollars\n"
					+ "7. Singapore Dollars\n"
					+ "8. Swiss Francs\n"
					+ "9. Malaysian Ringgits\n"
					+ "10. Japanese Yen\n"
					+ "11. Chinese Yuan Renminbi");
			int currencyMenuOptionSelector = input.nextInt();
			if((currencyMenuOptionSelector>0) && (currencyMenuOptionSelector<=11)){
				return currencyMenuOptionSelector;
			}
			else{
				System.out.println("Input failed validation. Please try again.");
			}
		}
    }

    /**
     * Prints the main menu (see output examples), allows the user to make a selection from available operations
     *
     * @param input the Scanner object you created at the beginning of the main method. Any value other than the 4
     *              valid selections should generate an invalid value prompt. Print the list again and prompt user to
     *              select a valid value from the list.
     * @return an integer from 1-4 inclusive representing the user’s selection.
     */
    private static int mainMenuOptionSelector(Scanner input) {
		while(true){
			System.out.println("Please select an option from the list below:"
					+ "\n1. Check the balance of your account"
					+ "\n2. Make a deposit"
					+ "\n3. Withdraw an amount in a specific currency"
					+ "\n4. End your session (and withdraw all remaining currency in U.S. Dollars)");
			int mainMenuOptionSelector = input.nextInt();
				switch(mainMenuOptionSelector){
				case 1: return 1;
				case 2: return 2;
				case 3: return 3;
				case 4: return 4;
				default: System.out.println("Input failed validation. Please try again.\n");
				
			}
		}
    }

    /**
     * Prints the conversion table at the start of the program (see the output examples).
     */
    private static void printConversionTable() {
		System.out.println("1 -  U.S. Dollar - 1.00"
		+ "\n2 - Euro - 0.89"
		+ "\n3 - British Pound - 0.78"
		+ "\n4 - Indian Rupee - 66.53"
		+ "\n5 - Australian Dollar - 1.31"
		+ "\n6 - Canadian Dollar - 1.31"
		+ "\n7 - Singapore Dollar - 1.37"
		+ "\n8 - Swiss Franc - 0.97"
		+ "\n9 - Malaysian Ringgit - 4.12"
		+ "\n10 - Japanese Yen - 101.64"
		+ "\n11 - Chinese Yuan Renminbi - 6.67\n");
    }
}