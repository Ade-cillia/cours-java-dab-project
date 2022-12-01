package src.client;

import java.util.UUID;

import src.account.Account;

public interface ClientUserInterface {

	/**
	 * Show all data attributes in a string
	 * @return string
	 */
  public String allData();


  /**
   * @param simulateUUIDCard
   * @return
   * @throws Exception
   */
  public Account getAccountByUUID(UUID simulateUUIDCard) throws Exception;
}
