package home5.homework;

/**
* This class   is a chiled class of{@link AbstractAccaunt} and it  models a saveings account. 
* @Raul
*/
public class SavingsAccount extends AbstractAccaunt {
	private float fee;
	private float commission;
	private float interest;
	/**
	* This method calculates the monthly fee of the account 
	* @param month number of months for which the fee should be deducted. 
	* @Raul
	*/
	public void monthlyFee(float month) throws InsuficentMoneyException{
		withdrawMoney(month*0.02f/100f*getBalance());
			
		}
	/**
	* This method calculates the monthly fee of the account 
	* @param money that will be withdrown. 
	* @Raul
	*/
	public  void withdrawMoney(float money) throws InsuficentMoneyException{
		 super.withdrawMoney(money+money*0.02f/100f);
			
		}
	/**
	* This method calculates the Interest of the account 
	* @param numberOfMonth number of months for which the fee should be deducted. 
	* @Raul
	*/
	public  void interest(int numberOfMonth){
		addMoney(numberOfMonth*6f/100f/12);
		interest=numberOfMonth*6f/100f/12;
			
		}
	
public float getFee(){
	return fee;
}
public float getCommision(){
return commission;
}
public float getInterest(){
return interest;
}
}
