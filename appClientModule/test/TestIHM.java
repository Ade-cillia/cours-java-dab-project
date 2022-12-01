package test;

import java.util.UUID;

import src.account.*;
import src.client.*;
import src.payment.Payment;

public abstract class TestIHM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start test TestIHM  only");
		lunchTest();
	}

	/**
	 * Test simulate and test IHM for DAB
	 * 
	 * @return void
	 */
	public static void lunchTest() {
		AccountService accountService = AccountService.getInstance();

		// create account instance
		System.out.println("-------------");
		Account firstAccount = new Account();
		System.out.println(firstAccount.allData());



		// create client instance for admin
		System.out.println("-------------");
		Client client = new Client();
		System.out.println(client.allData());
		
		// create client instance manipulate by user
		System.out.println("-------------");
		ClientUserInterface clientUserInterface = new Client();
		System.out.println(client.allData());
		// access ok
		clientUserInterface.allData();

		// access denied because addAccount is not in ClientUserInterface (is only for admin)  : clientUserInterface.addAccount(firstAccount);

	


		// insert account in client
		System.out.println("-------------");
		client.addAccount(firstAccount);
		System.out.println(client.allData());

		// create account directly in client
		System.out.println("-------------");
		client.addAccount();
		System.out.println(client.allData());

		// Get on Account by uuid
		System.out.println("-------------");
		Account getAccount;
		try {
			UUID simulateUUIDCard = UUID.randomUUID();
			getAccount = client.getAccountByUUID(simulateUUIDCard);
			System.out.println(getAccount.allData());
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println("-------------");
		Account getAccount2 = null;
		try {
			UUID firstAccountUUID = firstAccount.getUUID();
			getAccount2 = client.getAccountByUUID(firstAccountUUID);
			System.out.println(getAccount2.allData());

			//deposit Money
			System.out.println("----");
			Payment cash1 = new Payment(10.99, "cash");
			accountService.depositMoney(getAccount2, 10.99, cash1);
			System.out.println("----");
			System.out.println(getAccount2.allData());
			System.out.println("----");
			System.out.println(client.allData());

			// withraw
			System.out.println("----");
			accountService.withdrawMoney(getAccount2, 5.22, cash1);
			System.out.println("----");
			System.out.println(getAccount2.allData());
			System.out.println("----");
			System.out.println(client.allData());
			System.out.println("----");

			// (Test exclusife) withdraw with amount more than overdraftPossibility
			System.out.println("----");
			accountService.withdrawMoney(getAccount2, 156.65, cash1);
			System.out.println("----");
			System.out.println(getAccount2.allData());
			System.out.println("----");
			System.out.println(client.allData());
			System.out.println("----");
		} catch (Exception e) {
			System.err.println(e);
		}
		

		// create third account instance
		System.out.println("-----------------------");
		Account thirdAccount = new Account();
		client.addAccount(thirdAccount);
		Payment cash1 = new Payment(10.99, "cash");
		try {
			accountService.depositMoney(thirdAccount, 3.50, cash1);
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println(client.allData());

		// do an Transaction
		try {
			accountService.TransactionMoney(thirdAccount, firstAccount,1, cash1);
			System.out.println(client.allData());
			System.out.println("----");

			// (Test exclusife) too much amount
			accountService.TransactionMoney(thirdAccount, firstAccount,1000, cash1);
			System.out.println(client.allData());
			System.out.println("----");
		} catch (Exception e) {
			System.err.println(e);
		}

		//TODO USE ALL P_AMOUNT IN PAYMENT
		return;
	}
}
