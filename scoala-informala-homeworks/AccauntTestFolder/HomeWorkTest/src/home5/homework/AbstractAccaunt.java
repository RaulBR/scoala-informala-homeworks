package home5.homework;
/**
* Abstract Class to model bank accaunts
* 
* 
* @Raul
*/

abstract class AbstractAccaunt {
	
	// TODO CODE REVIEW: pay attention to code formatting
	private float balance=0;
private float money;


	public float getBalance() {
		return balance;
	}
	/**
	* this method is used to withdraw money from the account.
	*
	*/
	public void withdrawMoney(float money) throws InsuficentMoneyException {
		
			this.money=money;
			balance = getBalance()- money;
				
	}
	/**
	* this method is used to add money to a account.
	*
	*/
	public void addMoney(float money) {
		balance = getBalance()+ money;
		
	}
	
	public float getWithMoneyAmaunt(){
		return money;
	}

	
	

}
