

public class Transaction {

    private String type;
    private String Product;
    private String startedDate;
    private String completedDate;
    private String description;
    private double Amount;
    private double fee;
    private String currency;
    private String state;
    private double balance;

    public Transaction() {
    }

    public Transaction(String type, String product, String startedDate, String completedDate, String description, double amount, double fee, String currency, String state, double balance) {
        this.type = type;
        Product = product;
        this.startedDate = startedDate;
        this.completedDate = completedDate;
        this.description = description;
        Amount = amount;
        this.fee = fee;
        this.currency = currency;
        this.state = state;
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(String startedDate) {
        this.startedDate = startedDate;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
