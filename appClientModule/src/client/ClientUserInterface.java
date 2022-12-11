package src.client;

import java.util.UUID;

import src.account.Account;

public interface ClientUserInterface {

  /**
   * @param simulateUUIDCard
   * @return
   * @throws Exception
   */
  public Account getAccountByUUID(UUID simulateUUIDCard) throws Exception;

  /**
   * @return
   */
  public String getLastName();

	/**
	 * @return
	 */
	public String getFirstName();

  /**
   * @return
   */
  public String getBankName();
}
