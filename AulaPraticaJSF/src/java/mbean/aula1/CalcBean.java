package mbean.aula1;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CalcBean {

	private Double avalue;
	private Double bvalue;
	
	private Double result;
	
	public String somar(){
		result = avalue + bvalue;
		
		return null;
	}

	public Double getAvalue() {
		return avalue;
	}

	public void setAvalue(Double avalue) {
		this.avalue = avalue;
	}

	public Double getBvalue() {
		return bvalue;
	}

	public void setBvalue(Double bvalue) {
		this.bvalue = bvalue;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}
	
	
}
