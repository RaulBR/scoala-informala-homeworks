package home5.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SavingsAccountTest {
	@Test
	public void AddMoneyTest() {
		AbstractAccaunt account = new SavingsAccount();
		account.addMoney(1000);
		assertEquals(1000f,account.getBalance() , 0);
	}

	@Test
	public void MonthlyFeeTest() throws InsuficentMoneyException {
		SavingsAccount account = new SavingsAccount();
		account.addMoney(1000);
		account.monthlyFee(1);
		assertEquals(1000F-1000f*0.02f/100f,account.getBalance() , 0);
	}
	@Test
	public void WhidroulFeeTest() throws InsuficentMoneyException {
		SavingsAccount account = new SavingsAccount();
		account.addMoney(1000);
		account.withdrawMoney(100f);
		assertEquals(1000F-100f-100f*0.02f/100f,account.getBalance() , 0);
	}
	@Test
	public void IntrestTest() {
		SavingsAccount account = new SavingsAccount();
		account.addMoney(1000);
		account.interest(4);
	
		assertEquals(1000F+4*6f/100f/12,account.getBalance() , 0);
	}
	@Test
	public void IntrestandWithdrowlTest() throws InsuficentMoneyException {
		SavingsAccount account = new SavingsAccount();
		account.addMoney(1000);
		account.withdrawMoney(100f);
		account.interest(4);
		;
		assertEquals(1000F+4*6f/100f/12-100f-100f*0.02f/100f,account.getBalance() , 0);
	}
}
