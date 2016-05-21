package home5.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SavingsAccountTest {
	@Test
	public void addMoneyTest() {
		AbstractAccaunt account = new SavingsAccount();
		account.addMoney(1000);
		assertEquals(1000f,account.getBalance() , 0);
	}

	@Test
	public void monthlyFeeTest() throws InsuficentMoneyException {
		SavingsAccount account = new SavingsAccount();
		account.addMoney(1000);
		account.monthlyFee(1);
		assertEquals(1000F-1000f*0.02f/100f,account.getBalance() , 0);
	}
	@Test
	public void whidroulFeeTest() throws InsuficentMoneyException {
		SavingsAccount account = new SavingsAccount();
		account.addMoney(1000f);
		account.withdrawMoney(100f);
		assertEquals(1000f-100f-100f*0.02f/100f,account.getBalance() , 0);
	}
	@Test
	public void intrestTest() {
		SavingsAccount account = new SavingsAccount();
		account.addMoney(1000f);
		account.interest(4);
	
		assertEquals(1000F+4*6f/100f/12,account.getBalance() , 0);
	}
	@Test
	public void intrestandWithdrowlTest() throws InsuficentMoneyException {
		SavingsAccount account = new SavingsAccount();
		account.addMoney(1000);
		account.withdrawMoney(100f);
		account.interest(4);
	
		assertEquals(1000F+4*6f/100f/12-100f-100f*0.02f/100f,account.getBalance() , 0);
	}
}
