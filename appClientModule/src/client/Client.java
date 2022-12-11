package src.client;

import java.util.ArrayList;
import java.util.UUID;

import src.account.Account;

public class Client implements ClientUserInterface {
	private UUID m_uuid = UUID.randomUUID();
	private String m_lastName = "DE CILLIA";
	private String m_firstName = "Aurélien";
	private String m_bankName = "Credit agricole";
	private ArrayList<Account> m_listAccount = new ArrayList<Account>();


	// ---------- Constructor ---------- //

	/**
	 * ctor
	 */
	public Client() {
	}

	// ---------- Override ---------- //

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.client.ClientUserInterface#allData()
	 */
	@Override
	public String toString() {
		StringBuilder allData = new StringBuilder()
				.append("\nClientId : ").append(this.m_uuid).append("\n")
				.append("Nom : ").append(this.m_lastName).append("\n")
				.append("Prénom : ").append(this.m_firstName).append("\n")
				.append("Nom de la banque : ").append(this.m_bankName).append("\n")
				.append("List de compte : [\n");
		m_listAccount.forEach((e) -> allData.append("[\n").append(e).append("],\n"));
		allData.append("]\n");
		return allData.toString();
	}

	// ---------- Getters ---------- //

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.client.ClientUserInterface#getAccountByUUID(java.util.UUID)
	 */
	@Override
	public Account getAccountByUUID(UUID simulateUUIDCard) throws Exception {
		for (Account account : this.m_listAccount) {
			if (account.getUUID().equals(simulateUUIDCard)) {
				return account;
			}
		}
		throw new Exception("Account with uuid : '" + simulateUUIDCard + "' doesn't exist in this client");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.client.ClientUserInterface#getLastName()
	 */
	@Override
	public String getLastName() {
		return this.m_lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.client.ClientUserInterface#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return this.m_firstName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see src.client.ClientUserInterface#getBankName()
	 */
	@Override
	public String getBankName() {
		return this.m_bankName;
	}

	/**
	 * @return
	 */
	public ArrayList<Account> getListAccount() {
		return this.m_listAccount;
	}

	// ---------- Setters ---------- //

	/**
	 * @param m_firstName
	 */
	public void setFirstName(String m_firstName) {
		this.m_firstName = m_firstName;
	}

	/**
	 * @param m_lastName
	 */
	public void setLastName(String m_lastName) {
		this.m_lastName = m_lastName;
	}

	/**
	 * @param m_bankName
	 */
	public void setBankName(String m_bankName) {
		this.m_bankName = m_bankName;
	}

	/**
	 * @return string
	 */
	public String addAccount() {
		this.m_listAccount.add(new Account());
		return "Un compte a été rajouté au client";
	}

	/**
	 * @param account
	 * @return string
	 */
	public String addAccount(Account account) {
		this.m_listAccount.add(account);
		return "Le compte a été rajouté au client";
	}

}
