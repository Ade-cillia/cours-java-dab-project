package src.facade;

public interface ClientInterface {
  /**
   * @param p_amount
   * @return
   */
  public boolean depositMoney(double p_amount);
  
  /**
   * @param p_amount
   * @return
   */
  public boolean withdrawMoney(double p_amount);
}
