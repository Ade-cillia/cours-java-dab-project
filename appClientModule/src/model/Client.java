package src.model;

import src.facade.ClientInterface;

class Client implements ClientInterface {
    /* (non-Javadoc)
     * @see src.facade.ClientInterface#withdrawMoney(double)
     */
    public boolean withdrawMoney(double p_amount) {
      return true;
    }
    /* (non-Javadoc)
     * @see src.facade.ClientInterface#depositMoney(double)
     */
    public boolean depositMoney(double p_amount) {
      return true;
    };
}
