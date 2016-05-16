package home5.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RunningAccountTest {
	@Test
	public void AddMoneyTest() {
		RunningAccount account = new RunningAccount();
		account.addMoney(1000);
		assertEquals(1000f,account.getBalance() , 0);
	}

	@Test
	public void WithdrowMoneyTest() throws InsuficentMoneyException {
		RunningAccount account = new RunningAccount();
		account.addMoney(1000);
		account.withdrawMoney(1000);
		assertEquals(0F,account.getBalance() , 0.001);
	}
	@Test(expected = InsuficentMoneyException.class)
	public void WithdrowMoneyMoreThenBalanceTest() throws InsuficentMoneyException {
		RunningAccount account = new RunningAccount();
		account.withdrawMoney(1000);
		
	}
	@Test
	public void MonthlyFeeTest() throws InsuficentMoneyException {
		RunningAccount account = new RunningAccount();
		account.addMoney(1000);
		account.monthlyFee(1);
		assertEquals(1000F-1000f*0.05f/100f,account.getBalance() , 0);
	}
	
	

}
