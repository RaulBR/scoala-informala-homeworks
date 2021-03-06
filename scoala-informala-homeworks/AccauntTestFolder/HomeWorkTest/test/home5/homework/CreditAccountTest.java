package home5.homework;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class CreditAccountTest {


	@Test
	public void createCreditAccount() {
		CreditAccount account = new CreditAccount(5000,30);
			
		assertEquals(5000,account.getBalance() , 0.001);
	}
	
		@Test
		public void withdrowMoneyTest() throws InsuficentMoneyException {
			CreditAccount account = new CreditAccount(5000,30);
				account.withdrawMoney(1000);
			assertEquals(3999.8,account.getBalance() , 0.001);
		}
	

		@Test
		public void payCreditTestS() throws InsuficentMoneyException, InsuficentMoneyAddedException {
			CreditAccount account = new CreditAccount(5000,30);
			account.withdrawMoney(1000);
			account.payCredit(1000.2f, 12);
			assertEquals(5000,account.getBalance() , 0);
		}
		@Test
		public void payCreditLateTest() throws InsuficentMoneyException, InsuficentMoneyAddedException {
			CreditAccount account = new CreditAccount(5000,30);
			account.withdrawMoney(1000);
			account.payCredit(1040.198f, 31);
		
			assertEquals(5000,account.getBalance() , 0);
		}
		@Test(expected = InsuficentMoneyAddedException.class)
		public void PayCreditLateExceptionTest() throws InsuficentMoneyException, InsuficentMoneyAddedException {
			CreditAccount account = new CreditAccount(5000,30);
			account.withdrawMoney(1000);
			account.payCredit(10f, 31);
		
		}
	}


