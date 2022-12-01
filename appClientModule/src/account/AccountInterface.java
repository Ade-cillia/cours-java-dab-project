package src.account;

import src.payment.Payment;

public interface AccountInterface {
	/**
	 * @param p_amount
	 * @return string if p_amount has been deposit on acount / or throw error
	 * @throws Exception if p_accountTo == null || p_amount < 0
	 */
	public String depositMoney(Account p_account, double p_amount, Payment p_payment) throws Exception;

	/**
	 * @param p_amount
	 * @return string
	 * @throws Exception if p_account == null || p_account.getbalance()-p_amount < -overdraftPossibility
	 */
	public String withdrawMoney(Account p_account, double p_amount, Payment p_payment) throws Exception;

	/**
	 * @param p_accountFrom
	 * @param p_accountTo
	 * @param p_amount
	 * @param p_payment
	 * @return string
	 * @throws Exception if p_accountFrom == null || p_accountFrom.getbalance()-p_amount < -overdraftPossibility
	 * && if p_accountTo == null || p_amount < 0
	 */
	public String TransactionMoney(Account p_accountFrom, Account p_accountTo, double p_amount, Payment p_payment) throws Exception;
}
