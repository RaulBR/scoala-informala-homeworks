package home5.homework;

public class Main {

	public static void main(String[] args) throws InsuficentMoneyAddedException, InsuficentMoneyException  {
		
		CreditAccount account = new CreditAccount(5000,30);
		account.withdrawMoney(1000);
		account.payCredit(1000.2f, 12);
		
	System.out.println(account.getBalance());

	}

}
