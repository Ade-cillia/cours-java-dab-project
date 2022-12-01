package src.account;

import src.payment.Payment;

public interface AccountInterface {

	/**
	 * Add Monney
	 * @param p_account
	 * @param p_payment
	 * @return string if p_amount has been deposit on acount / or throw error
	 * @throws Exception if p_accountTo == null || p_amount < 0
	 */
	public String depositMoney(Account p_account, Payment p_payment) throws Exception;

	/**
	 * Reduce Monney
	 * @param p_account
	 * @param p_payment
	 * @return
	 * @throws Exception if p_account == null || p_account.getbalance()-p_amount < -overdraftPossibility
	 */
	public String withdrawMoney(Account p_account, Payment p_payment) throws Exception;

	/**
	 * Transaction money of account user to another account
	 * @param p_accountFrom
	 * @param p_accountTo
	 * @param p_payment
	 * @return
	 * @throws Exception if p_accountFrom == null || p_accountFrom.getbalance()-p_amount < -overdraftPossibility
	 * && if p_accountTo == null || p_amount < 0
	 */
	public String transactionMoney(Payment p_payment) throws Exception;
}
