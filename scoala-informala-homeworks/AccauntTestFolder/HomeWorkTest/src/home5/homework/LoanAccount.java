package home5.homework;

/**
* This class   is a chiled class of{@link AbstractAccaunt} and it  models a lown account. 
* 
* @Raul
*/
public class LoanAccount extends AbstractAccaunt {


	private int numberOfInstalents;
	private float loanAmount;
	RunningAccount rAccaunt = new RunningAccount();
	/**
	* The constructor of the class takes in two parameters:
	* <p>
	* @param  loanAmount the amount of money requested as a loan
	* @param months the amount of month till payment.
	* 
	*/
	LoanAccount(float loanAmount, int months) throws InsuficentMoneyException {
		
		
		this.numberOfInstalents = months;
		rAccaunt.addMoney(loanAmount);
		this.loanAmount=loanAmount;
		creditInterest();
		withdrawMoney(loanAmount + creditInterest());
		ammoutPerInstalment();
		
		

	}
	/**
	* The constructor of the class takes in two parameters:
	* <p>
	* @param  dayOfTHeMonth the day the paiment is due (min the 20'th of the month)
	* @param ammoutPerInstalment the amount that needs to be payed.
	* 
	*/
	public void payLoan(int dayOfTHeMonth, float ammoutPerInstalment)throws  PayIsLessException, InsuficentMoneyException {
		payDedLine(dayOfTHeMonth, ammoutPerInstalment);
	}
	private float creditInterest() {
		return loanAmount * 10f / 100f;
	}

	private float ammoutPerInstalment() {
				return (creditInterest() + rAccaunt.getBalance()) / numberOfInstalents;
	}

	private void payDedLine(int dayOfTHeMonth, float ammoutPerInstalment)throws  PayIsLessException, InsuficentMoneyException {
		if (dayOfTHeMonth > 20 ){
			withdrawMoney(ammoutPerInstalment()*0.5f/100f);
		}
		if( ammoutPerInstalment < ammoutPerInstalment()){
			throw new PayIsLessException();
		}
		if (dayOfTHeMonth > 20 && ammoutPerInstalment != ammoutPerInstalment() +
				0.5f / 100 * ammoutPerInstalment()) {
			System.err.println("You have exided the pay day, pleass add penalty (0,5%)");
		} else {
			addMoney(ammoutPerInstalment);
		}
	
	}
	


}
