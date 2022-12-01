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

	public Client() {
	}


	/* (non-Javadoc)
	 * @see src.client.ClientUserInterface#allData()
	 */
	public String allData() {
		StringBuilder allData = new StringBuilder()
		.append("\nClientId : ").append(this.m_uuid).append("\n")
		.append("Nom : ").append(this.m_lastName).append("\n")
		.append("Prénom : ").append(this.m_firstName).append("\n")
		.append("Nom de la banque : ").append(this.m_bankName).append("\n")
		.append("List de compte : [\n");
		m_listAccount.forEach((e) -> allData.append("[\n").append(e.allData()).append("],\n"));
		allData.append("]\n");
		return allData.toString();
	}

	// ---------- Getters ---------- //

	/* (non-Javadoc)
	 * @see src.client.ClientUserInterface#getAccountByUUID(java.util.UUID)
	 */
	public Account getAccountByUUID(UUID simulateUUIDCard) throws Exception  {
		for(Account account : this.m_listAccount) { 
			if (account.getUUID().equals(simulateUUIDCard)) { 
				return account;
			} 
	 	}
		 throw new Exception("Account with uuid : '"+ simulateUUIDCard + "' doesn't exist in this client");
	}

	// ---------- Setters ---------- //

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
