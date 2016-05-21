package home5.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LoanAccountTest {
	@Test
	public void CheckLoanPalanceTest() throws InsuficentMoneyException {
		LoanAccount account = new LoanAccount(1000,12);
				
		assertEquals(-1100F,account.getBalance() , 0);
	}
	
	@Test
	public void paymentOnTimeTest() throws PayIsLessException, InsuficentMoneyException {
		LoanAccount account = new LoanAccount(1000,12);
		account.payLoan(12, 91.66f+0.0066604614f);
		assertEquals(-1008.34+0.0066604614f,account.getBalance() , 0.001);
	}
	@Test
	public void paymentNotOnTimeTest() throws PayIsLessException, InsuficentMoneyException {
		LoanAccount account2 = new LoanAccount(1000,12);
		account2.payLoan(21, 91.6666641f+91.6666641f*0.5f/100f);
		assertEquals(-1008.3334,account2.getBalance() , 0.1);
	}
	@Test(expected = PayIsLessException.class)
	public void paymentIsLessTest() throws PayIsLessException, InsuficentMoneyException {
		LoanAccount account2 = new LoanAccount(1000,12);
		account2.payLoan(12,12f);
	
	}
	
	
}
