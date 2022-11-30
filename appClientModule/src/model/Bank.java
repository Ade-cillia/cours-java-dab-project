package src.model;
import src.facade.BankInterface;

public class Bank extends CentralBank implements BankInterface{
  private String m_adress;
  private String m_city;
  private String m_postalCode;
  enum BankName {
    CREDIT_AGRICOLE,
    BOURSORAMA_BANQUE,
    HELLO_BANQUE,
    BNP_PARIBAS
  }

  // ------------- Constructors ------------- //

  public Bank() {
    // basic constructor
  }
  public Bank(String p_adress) {
    this.m_adress = p_adress;
  }
  public Bank(String p_adress, String p_city) {
    this.m_adress = p_adress;
    this.m_city = p_city;
  }
  public Bank(String p_adress, String p_city, String p_postalCode) {
    this.m_adress = p_adress;
    this.m_city = p_city;
    this.m_postalCode = p_postalCode;
  }
  
  // ------------- Getters ------------- //

  public String getAdress() {
    return m_adress;
  }

  public String getCity() {
    return m_city;
  }

  public String getPostalCode() {
    return m_postalCode;
  }

  // ------------- Setters ------------- //

  public void setAdress(String p_adress) {
    this.m_adress = p_adress;
  }

  public void setCity(String p_city) {
    this.m_city = p_city;
  }

  public void setPostalCode(String p_postalCode) {
    this.m_postalCode = p_postalCode;
  }
}
