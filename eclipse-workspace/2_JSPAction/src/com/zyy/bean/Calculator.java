package com.zyy.bean;

public class Calculator {
	private double firstNum;
	
	private String operator;
	
	private double secondNum;
	
	private double result;

	public double getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(double firstNum) {
		this.firstNum = firstNum;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public double getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(double secondNum) {
		this.secondNum = secondNum;
	}

	public double getResult() {
		if(operator != null && operator.equals("+")) {
			result = firstNum + secondNum;
		}
		else if(operator != null && operator.equals("-")) {
			result = firstNum - secondNum;
		}else if(operator != null && operator.equals("*")) {
			result = firstNum * secondNum;
		}else if(operator != null && operator.equals("/")) {
			result = firstNum / secondNum;
		}else
		{result = 0;}
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
}
