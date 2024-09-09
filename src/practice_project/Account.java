package practice_project;

public class Account {
	
	private int id;
	private Transaction[] transactions;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}

	public Transaction[] getTransactions() {
		return this.transactions;
	}

	public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
	    //<write your code here>
	}
	
	public void withdrawMoney(double moneyAmount) {
		//<write your code here>
	}
	
	public static class Transaction {
        private Account accountFrom;
        private Account accountTo;
        private double moneyAmount;
        private StandardAccountOperations operation;
        
        private Transaction(Account accountFrom, Account accountTo, double moneyAmount, StandardAccountOperations operation) {
        	this.accountFrom = accountFrom;
        	this.accountTo = accountTo;
        	this.moneyAmount = moneyAmount;
        	this.operation = operation;
        }
        
		public Account getAccountFrom() {
			return accountFrom;
		}
		public void setAccountFrom(Account accountFrom) {
			this.accountFrom = accountFrom;
		}
		public Account getAccountTo() {
			return accountTo;
		}
		public void setAccountTo(Account accountTo) {
			this.accountTo = accountTo;
		}
		public double getMoneyAmount() {
			return moneyAmount;
		}
		public void setMoneyAmount(double moneyAmount) {
			this.moneyAmount = moneyAmount;
		}
		public StandardAccountOperations getOperation() {
			return operation;
		}
		public void setOperation(StandardAccountOperations operation) {
			this.operation = operation;
		}
	}
}

