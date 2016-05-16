package home5.homework;
/**
* This class   is a chiled class of{@link AbstractAccaunt} and it  models a running account. 
* 
* @Raul
*/

public class RunningAccount extends AbstractAccaunt {
	
	/**
	* Calculates and deducts the monthly fee from account. 
	* @param money to be withdrawn.
	* 
	*/

	
public void monthlyFee(float month) throws InsuficentMoneyException{
		
	 withdrawMoney(month*0.05f/100f*getBalance());
		
	}

/**
* Override the parent method, it throws an exception if amout is biger the balance 
* @param money to be withdrawn.
* 
*/

public void withdrawMoney(float money) throws InsuficentMoneyException  {
	
	if(getBalance()<money){
		throw new InsuficentMoneyException();
	}else{
		super.withdrawMoney(money);
	}
	
		
}

		

}
