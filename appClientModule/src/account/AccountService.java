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
	public String depositMoney(Account p_account, Payment p_payment) throws Exception {
		double amountPayment = p_payment.getAmount();
		if (p_account == null) {
			throw new Exception("account is null");
		} else if (p_account.getBalance() < 0) {
			throw new Exception("amount need to be more than 0");
		}
		StringBuilder strResult = new StringBuilder("Account To ").append(p_account.getBalance()).append(" euro\n");
		strResult.append("Deposit of ").append(amountPayment).append(" euro in account\n");
		
		// deposit
		p_account.depositMoney(amountPayment);
		strResult.append("Account To now ").append(p_account.getBalance()).append(" euro\n");
		return strResult.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * src.Account.facade.AccountInterface#withdrawMoney(src.Account.entity.Account,
	 * double, java.lang.String)
	 */
	@Override
	public String withdrawMoney(Account p_account, Payment p_payment) throws Exception {
		double amountPayment = p_payment.getAmount();
		if (p_account == null) {
			throw new Exception("account is null");
		}else if (p_account.getBalance()-amountPayment < -p_account.getOverdraftPossibility()) {
			// if balance-amountPayment < -overdraft
			throw new Exception("withdraw has been refuted, the amount has more than your overdraft possibility");
		}
		StringBuilder strResult = new StringBuilder("Account From ").append(p_account.getBalance()).append(" euro\n");
		strResult.append("Withdraw ").append(amountPayment).append("euro from account\n");

		// withdraw
		p_account.withdrawMoney(amountPayment);
		strResult.append("Account From now ").append(p_account.getBalance()).append(" euro\n\n");
		return strResult.toString();
	}

	/* (non-Javadoc)
	 * @see src.account.AccountInterface#TransactionMoney(src.account.Account, src.account.Account, double, java.lang.String)
	 */
	@Override
	public String transactionMoney(Payment p_payment) throws Exception {
		Account accountFrom = p_payment.getAccountFrom();
		Account accountTo = p_payment.getAccountTo();
		if (!(p_payment.getType() == "transfert" || p_payment.getType() == "cheque")) {
			throw new Exception("Payment is not type 'transfert' or 'cheque'");
		}
		double amountPayment = p_payment.getAmount();
		// check p_accountFrom
		if (accountFrom == null) {
			throw new Exception("p_accountFrom is null");
		}else if (accountFrom.getBalance()-amountPayment < -accountFrom.getOverdraftPossibility()) {
			throw new Exception("withdraw has been refuted, the amount has more than your overdraft possibility");
		}

		// check p_accountTo
		if (accountTo == null) {
			throw new Exception("p_accountTo is null");
		} else if (accountTo.getBalance() < 0) {
			throw new Exception("amount need to deposite for p_accountTo must be more than 0 ");
		}
		// p_accountFrom
		accountFrom.withdrawMoney(amountPayment);

		StringBuilder strResult = new StringBuilder("Account From :").append(accountFrom.getBalance()).append(" euro\n");
		strResult.append("Withdraw : ").append(amountPayment).append(" euro from account\n");
		strResult.append("Account From now ").append(accountFrom.getBalance()).append(" euro\n\n");
		
		// p_accountTo
		accountTo.depositMoney(amountPayment);

		strResult.append("Account To ").append(accountTo.getBalance()).append(" euro\n");
		strResult.append("Deposit : ").append(amountPayment).append(" euro in account\n");
		strResult.append("Account To now ").append(accountTo.getBalance()).append(" euro\n");
		
		// TODO: refactor for call directly himself 
		return strResult.toString();
	}
}
