package home5.homework;
/**
* This class   is a chiled class of{@link AbstractAccaunt} and it  models a credit account. It does te folowing:
* @Raul
*/
public class CreditAccount extends AbstractAccaunt {
	private 	int days;
	private float money;
	
	/**
	* The constructor of the class takes in two parameters:
	* <p>
	* @param creditMoney the amount of money requested as a credit
	* @param days the amount of days till payment
	* 
	* @Raul
	*/
	public CreditAccount(float creditMoney,int  days){
		addMoney(creditMoney);
		this.days=days;
		
	}
	private float latePenalty(float creditMoney,int  daysFormCredit){
		if(daysFormCredit>days){
					return getBalance()*(days-daysFormCredit)*1f/100f+ creditMoney;
		}else{
			return  creditMoney;
					}
			
	}
	
	/**
	* Method usedto pey credit, it uses two :
	* <p>
	* @param creditMoney the amount of mony credited.
	* @param daysFormCredit the amount of days elapsed form credit withdrawal.
	* 
	* @Raul
	*/
	public void payCredit(float creditMoney,int  daysFormCredit) throws InsuficentMoneyAddedException{
		if(daysFormCredit>days&&creditMoney<(money+getBalance()*(days-daysFormCredit)*1f/100f)){
									throw new InsuficentMoneyAddedException();
			}else{addMoney(latePenalty(creditMoney, daysFormCredit));
		}
					
	}
	/**
	* Method usedto pey credit, it uses two :
	* <p>
	* @param money the amount of money credited.
	* 
	* 
	* @Raul
	*/
	public  void withdrawMoney(float money) throws InsuficentMoneyException{
		this.money= money;
		 super.withdrawMoney(money+money*0.02f/100f);
			
		}
	public float getMoney() {
	return money;
	}

	
}
