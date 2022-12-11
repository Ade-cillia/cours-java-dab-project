package src.payment;

import src.account.Account;

public class Payment {
	private String m_type = "cash";
	private double m_amount;
	private Account m_accountFrom;
	private Account m_accountTo;

	// ---------- Constructors ---------- //

	/**
	 * ctor
	 * @param p_amount
	 * @param p_type
	 */
	public Payment(double p_amount, String p_type){
		this.m_amount = p_amount;
		this.m_type = p_type;
	};

	/**
	 * ctor
	 * @param p_amount
	 * @param p_type
	 * @param p_accountFrom
	 */
	public Payment(double p_amount, String p_type,  Account p_accountFrom){
		this.m_amount = p_amount;
		this.m_type = p_type;
		this.m_accountFrom = p_accountFrom;
	};

	/**
	 * ctor
	 * @param p_amount
	 * @param p_type
	 * @param p_accountFrom
	 * @param p_accountTo
	 */
	public Payment(double p_amount,String p_type, Account p_accountFrom, Account p_accountTo){
		this.m_amount = p_amount;
		this.m_type = p_type;
		this.m_accountFrom = p_accountFrom;
		this.m_accountTo = p_accountTo;
	};

	// ---------- Getters ---------- //
	/**
	 * @return
	 */
	public String getType() {
		return m_type;
	}

	/**
	 * @return
	 */
	public double getAmount() {
		return m_amount;
	}

	/**
	 * @return
	 */
	public Account getAccountFrom() {
		return m_accountFrom;
	}

	/**
	 * @return
	 */
	public Account getAccountTo() {
		return m_accountTo;
	}

	// ---------- Setters ---------- //

	/**
	 * @param p_type
	 */
	public void setType(String p_type) {
		this.m_type = p_type;
	}
	
	/**
	 * @param m_amount
	 */
	public void setAmount(int p_amount) {
		this.m_amount = p_amount;
	}

	/**
	 * @param m_nameFrom
	 */
	public void setAccountFrom(Account p_accountFrom) {
		this.m_accountFrom = p_accountFrom;
	}

	/**
	 * @param m_nameTo
	 */
	public void setAccountTo(Account p_accountTo) {
		this.m_accountTo = p_accountTo;
	}
}
