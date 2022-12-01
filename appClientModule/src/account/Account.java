package src.account;

import java.util.UUID;

public class Account {
	private UUID m_uuid = UUID.randomUUID();
	private double m_balance = 0.00;

	private double m_overdraftPossibility = 0.00;
	private boolean m_actifAccount = false;
	

	/**
	 * ctor
	 */
	public Account() {
	}

	/**
	 * @return
	 */
	public String allData() {
		StringBuilder allData = new StringBuilder();
		allData.append("accountId : ").append(this.m_uuid).append("\n");
		allData.append("Solde : ").append(this.m_balance).append(" euro\n");
		allData.append("Découvert possible : ").append(this.m_overdraftPossibility).append(" euro\n");
		return allData.toString();

	}


	/**
	 * @param p_amount
	 * @return
	 */
	public boolean withdrawMoney(double p_amount) {
		double newBalance = this.m_balance - p_amount;
		this.m_balance = Math.round(newBalance*100.0)/100.0;
		// p_amount has been deposit
		return true;
	}

	/**
	 * @param p_amount
	 * @return
	 */
	public boolean depositMoney(double p_amount) {
		double newBalance = this.m_balance + p_amount;
		this.m_balance = Math.round(newBalance*100.0)/100.0;
		// p_amount has been credited
		return true;
	};

	// ------------- Getters ------------- //

	/**
	 * @return
	 */
	public UUID getUUID() {
		return this.m_uuid;
	}


	/**
	 * @return
	 */
	public double getBalance() {
		return this.m_balance;
	}

	/**
	 * @return
	 */
	public double getOverdraftPossibility() {
		return this.m_overdraftPossibility;
	}

	/**
	 * @return
	 */
	public boolean getActifAccount() {
		return this.m_actifAccount;
	}
}
