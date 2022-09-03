import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    //throws exception for if file not found
    public static void main(String[] args) throws Exception {

        //arraylist for income
        ArrayList<Transaction> income = new ArrayList<>();

        //arraylist for expenditure
        ArrayList<Transaction> expenditure = new ArrayList<>();

        //read from csv using Scanner
        Scanner scanner = new Scanner(new File("resource/statement.csv"));
        scanner.nextLine();
        //use comma as delimiter

        while(scanner.hasNext()){

            scanner.useDelimiter("[,\n]");

            //add to a new transaction
            Transaction transaction = new Transaction();

            //fill transaction with information from file
            transaction.setType(scanner.next());
            transaction.setProduct(scanner.next());
            transaction.setStartedDate(scanner.next());
            transaction.setCompletedDate(scanner.next());
            transaction.setDescription(scanner.next());
            transaction.setAmount(Double.parseDouble(scanner.next()));
            transaction.setFee(Double.parseDouble(scanner.next()));
            transaction.setCurrency(scanner.next());
            transaction.setState(scanner.next());
            transaction.setBalance(Double.parseDouble(scanner.next()));

            //depending on first word in description, discern which category to put it in
            String check = transaction.getDescription().split(" ")[0];
            if(check.equals("To")){
                expenditure.add(transaction);
            }
            else if(check.equals("From") || check.equals("Top-Up")){
                income.add(transaction);
            }
            else{
                expenditure.add(transaction);
            }

        }

        //close scanner
        scanner.close();

        //output income
        System.out.println("__Income__");
        double totalIncome = 0.0;
        for(Transaction transaction : income){

            //sum up total income
            totalIncome += transaction.getAmount();

            System.out.println(transaction.getDescription() +" +" + transaction.getAmount() + "\n\t\t "+transaction.getBalance());
        }

        System.out.println("\n\n");

        //output expenditures
        System.out.println("__Expenditure__");
        double totalExpenditure = 0.0;
        for(Transaction transaction : expenditure){

            //sum up total income
            totalExpenditure += transaction.getAmount();
            System.out.println(transaction.getDescription() +" " + transaction.getAmount() + "\n\t\t "+transaction.getBalance());
        }

        System.out.println("\n\n");

        //output income and expenditure in rounded format
        System.out.println("Total income: +" + Math.round(totalIncome*100)/100);
        System.out.println("Total expenditure: " + Math.round(totalExpenditure*100)/100);
    }
}
