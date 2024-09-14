package practice_project;

public class Account {
	
	private final int DEFAULT_TANSACTION_AMOUNT = 0;
	
	private int id;
	private Transaction[] transactions;
	
	{
		this.transactions = new Transaction[DEFAULT_TANSACTION_AMOUNT];
	}
	
	private void addTransaction(Transaction newTransaction) {
		int length = getTransactions().length;
		Transaction updatedTransactions[] = new Transaction[length + 1];
		
		for(int i = 0 ; i < length ; i++ ) {
			updatedTransactions[i] = transactions[i];
		}
		
		updatedTransactions[length] = newTransaction;
		setTransactions(updatedTransactions);
	}
	
	public Account(int id) {
		this.id = id;
	}
	
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
		if(accountTo == null || moneyAmount == 0)
			return;
		else {
			accountTo.addTransaction(new Transaction(this,accountTo,moneyAmount,StandardAccountOperations.MONEY_TRANSFER_RECEIVE));
			this.addTransaction(new Transaction(this,accountTo,moneyAmount,StandardAccountOperations.MONEY_TRANSFER_SEND));
		}
	}
	
	public void withdrawMoney(double moneyAmount) throws Exception {
		if(moneyAmount == 0)
			return;
		else {
			this.addTransaction(new Transaction(this,null,moneyAmount,StandardAccountOperations.WITHDRAW));
		}
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

