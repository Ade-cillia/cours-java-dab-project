package src.account;

import src.payment.Payment;

/**
 * Singleton class
 */
public class AccountService implements AccountInterface {
	private static AccountService instance = new AccountService();
	public String value;

	/**
	 * 
	 */
	private AccountService() {
	}

	/**
	 * @return
	 */
	public static AccountService getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * src.Account.facade.AccountInterface#depositMoney(src.Account.entity.Account,
	 * double, java.lang.String)
	 */
	@Override
	public String depositMoney(Account p_account, double p_amount, Payment p_payment) throws Exception {
		if (p_account == null) {
			throw new Exception("account is null");
		} else if (p_account.getBalance() < 0) {
			throw new Exception("amount need to be more than 0");
		}
		System.out.println(new StringBuilder("Account balance is actualy ").append(p_account.getBalance()).append(" euro").toString());
		System.out.println(new StringBuilder("Deposit of ").append(p_amount).append(" euro in account").toString());
		p_account.depositMoney(p_amount);
		System.out.println(new StringBuilder("this account balance his now ").append(p_account.getBalance()).append(" euro").toString());
		return "success";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * src.Account.facade.AccountInterface#withdrawMoney(src.Account.entity.Account,
	 * double, java.lang.String)
	 */
	@Override
	public String withdrawMoney(Account p_account, double p_amount, Payment p_payment) throws Exception {
		if (p_account == null) {
			throw new Exception("account is null");
		}else if (p_account.getBalance()-p_amount < -p_account.getOverdraftPossibility()) {
			throw new Exception("withdraw has been refuted, the amount has more than your overdraft possibility");
		}
		System.out.println(new StringBuilder("Account balance is actualy ").append(p_account.getBalance()).append(" euro").toString());
		System.out.println(new StringBuilder("Withdraw ").append(p_amount).append("euro from account").toString());
		p_account.withdrawMoney(p_amount);
		System.out.println(new StringBuilder("this account balance his now ").append(p_account.getBalance()).append(" euro").toString());
		return "success";
	}

	/* (non-Javadoc)
	 * @see src.account.AccountInterface#TransactionMoney(src.account.Account, src.account.Account, double, java.lang.String)
	 */
	@Override
	public String TransactionMoney(Account p_accountFrom, Account p_accountTo, double p_amount, Payment p_payment) throws Exception {
		// check p_accountFrom
		if (p_accountFrom == null) {
			throw new Exception("p_accountFrom is null");
		}else if (p_accountFrom.getBalance()-p_amount < -p_accountFrom.getOverdraftPossibility()) {
			throw new Exception("withdraw has been refuted, the amount has more than your overdraft possibility");
		}

		// check p_accountTo
		if (p_accountTo == null) {
			throw new Exception("p_accountTo is null");
		} else if (p_accountTo.getBalance() < 0) {
			throw new Exception("amount need to deposite for p_accountTo must be more than 0 ");
		}
		// p_accountFrom
		System.out.println(new StringBuilder("Account From :").append(p_accountFrom.getBalance()).append(" euro").toString());
		System.out.println(new StringBuilder("Account balance is actualy ").append(p_accountFrom.getBalance()).append(" euro").toString());
		System.out.println(new StringBuilder("Withdraw ").append(p_amount).append("euro from account").toString());
		p_accountFrom.withdrawMoney(p_amount);
		System.out.println(new StringBuilder("this account balance his now ").append(p_accountFrom.getBalance()).append(" euro").toString());
		
		// p_accountTo
		System.out.println(new StringBuilder("Account balance is actualy ").append(p_accountTo.getBalance()).append(" euro").toString());
		System.out.println(new StringBuilder("Deposit of ").append(p_amount).append(" euro in account").toString());
		p_accountTo.depositMoney(p_amount);
		System.out.println(new StringBuilder("this account balance his now ").append(p_accountTo.getBalance()).append(" euro").toString());
		return null;
	}
}
