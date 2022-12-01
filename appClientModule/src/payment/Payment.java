package src.payment;

public class Payment {
	private String m_type = "cash";
	private double m_amount;
	private String m_nameFrom;
	private String m_nameTo;

	public Payment(double p_amount, String p_type){
		this.m_amount = p_amount;
		this.m_type = p_type;
	};
	public Payment(double p_amount, String p_type, String p_nameFrom){
		this.m_amount = p_amount;
		this.m_type = p_type;
		this.m_nameFrom = p_nameFrom;
	};
	public Payment(double p_amount,String p_type, String p_nameFrom,String m_nameTo){
		this.m_amount = p_amount;
		this.m_type = p_type;
		this.m_nameFrom = p_nameFrom;
		this.m_nameTo = m_nameTo;
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
	public String getNameFrom() {
		return m_nameFrom;
	}

	/**
	 * @return
	 */
	public String getNameTo() {
		return m_nameTo;
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
	public void setAmount(int m_amount) {
		this.m_amount = m_amount;
	}

	/**
	 * @param m_nameFrom
	 */
	public void setNameFrom(String m_nameFrom) {
		this.m_nameFrom = m_nameFrom;
	}

	/**
	 * @param m_nameTo
	 */
	public void setNameTo(String m_nameTo) {
		this.m_nameTo = m_nameTo;
	}
}
