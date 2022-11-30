package src.facade;

public interface BankInterface {
  // ------------- Getters ------------- //
  public String getAdress();
  public String getCity();
  public String getPostalCode();

  // ------------- Setters ------------- //
  public void setAdress(String p_adress);
  public void setCity(String p_city);
  public void setPostalCode(String p_postalCode);
}