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
		System.out.println("Start test TestIHM");
		AccountService accountService = AccountService.getInstance();

		// create account instance
		System.out.println("-------------");
		Account firstAccount = new Account();
		System.out.println(firstAccount);

		// create client instance for admin
		System.out.println("-------------");
		Client client = new Client();
		System.out.println(client);

		// create client instance manipulate by user
		System.out.println("-------------");
		ClientUserInterface clientUserInterface = new Client();
		System.out.println(client);

		// access ok
		System.out.println(clientUserInterface.getBankName());
		
		// access denied :
		// clientUserInterface.addAccount();
		// access denied because addAccount is not in ClientUserInterface (is only for "admin"/the complet instance)

		// insert account in client
		System.out.println("-------------");
		client.addAccount(firstAccount);
		System.out.println(client);

		// create account directly in client
		System.out.println("-------------");
		client.addAccount();
		System.out.println(client);

		// Get on Account by uuid
		System.out.println("-------------");
		Account getAccount;
		try {
			UUID simulateUUIDCard = UUID.randomUUID();
			getAccount = client.getAccountByUUID(simulateUUIDCard);
			System.out.println(getAccount);
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println("-------------");
		Account getAccount2 = null;
		try {
			UUID firstAccountUUID = firstAccount.getUUID();
			getAccount2 = client.getAccountByUUID(firstAccountUUID);
			System.out.println(getAccount2);

			// deposit Money
			System.out.println("----");
			Payment cash1 = new Payment(10.99, "cash");
			System.out.println(accountService.depositMoney(getAccount2, cash1));
			System.out.println("----");
			System.out.println(getAccount2);
			System.out.println("----");
			System.out.println(client);

			// withraw
			System.out.println("----");
			Payment cash2 = new Payment(5.22, "cash");
			System.out.println(accountService.withdrawMoney(getAccount2, cash2));
			System.out.println("----");
			System.out.println(getAccount2);
			System.out.println("----");
			System.out.println(client);
			System.out.println("----");

			// (Test exclusife) withdraw with amount more than overdraftPossibility
			System.out.println("----");
			Payment cash3 = new Payment(156.65, "cash");
			System.out.println(accountService.withdrawMoney(getAccount2, cash3));
			System.out.println("----");
			System.out.println(getAccount2);
			System.out.println("----");
			System.out.println(client);
			System.out.println("----");
		} catch (Exception e) {
			System.err.println(e);
		}

		// create third account instance
		System.out.println("-----------------------");
		Account thirdAccount = new Account();
		client.addAccount(thirdAccount);
		try {
			Payment cash4 = new Payment(3.50, "cash");
			System.out.println(accountService.depositMoney(thirdAccount, cash4));
		} catch (Exception e) {
			System.err.println(e);
		}
		System.out.println(client);

		// do an Transaction
		try {
			Payment transfert1 = new Payment(1, "transfert", thirdAccount, firstAccount);
			System.out.println(accountService.transactionMoney(transfert1));
			System.out.println(client);
			System.out.println("----");

			// (Test exclusife) too much amount
			Payment transfert2 = new Payment(10000, "transfert", thirdAccount, firstAccount);
			System.out.println(accountService.transactionMoney(transfert2));
			System.out.println(client);
			System.out.println("----");
		} catch (Exception e) {
			System.err.println(e);
		}

		// Deposit cheque
		try {

			System.out.println("----");
			Payment cheque1 = new Payment(2, "cheque", thirdAccount, firstAccount);
			System.out.println(accountService.transactionMoney(cheque1));
			System.out.println(client);
			
		return;
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
