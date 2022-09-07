import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

    //throws exception for if file not found
    public static void main(String[] args) throws Exception {

        //LinkedList for all transactions
        LinkedList<Transaction> statement = new LinkedList<>();

        //LinkedList for income
        LinkedList<Transaction> income = new LinkedList<>();

        //LinkedList for expenditure
        LinkedList<Transaction> expenditure = new LinkedList<>();

        //HashSet for categories of people
        HashSet<String> peopleFilter = new HashSet<>();
        peopleFilter.add("All");

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

            statement.add(transaction);

            //first word in description
            String firstWord = transaction.getDescription().split(" ")[0];


            String name = transaction.getDescription().substring(firstWord.length()).strip();

            //depending on first word in description, discern which category to put it in
            if(firstWord.equals("To")){
                expenditure.add(transaction);


                //add to filter with rest of sentence
                peopleFilter.add(name);
            }
            else if(firstWord.equals("From")){
                income.add(transaction);

                //add to filter with rest of sentence
                peopleFilter.add(name);
            }
            else if(firstWord.equals("Top-Up")){
                income.add(transaction);

                //add to set of filters
                peopleFilter.add(transaction.getDescription());
            }
            else{
                expenditure.add(transaction);

                //add to set of filters
                peopleFilter.add(transaction.getDescription());
            }

        }

        //close scanner
        scanner.close();

        //output statement
        System.out.println("__Statement__");
        for(Transaction transaction : statement){

            System.out.println(transaction.getStartedDate() + " " + transaction.getDescription() +" " + transaction.getAmount() + "\n\t\t "+transaction.getBalance());
        }

        //output list of transaction partners
        System.out.println("__Filters__");
        for(String string : peopleFilter){
            System.out.println("- " + string);
        }

        //chosen filter will display only those involving filter and total income and expenditure on this source
        System.out.println("Select a filter...\n");
        Scanner filterScanner = new Scanner(System.in);

        String inputFilter = filterScanner.nextLine();

        //if valid filter
        if(peopleFilter.contains(inputFilter.strip())){
            System.out.println("__"+inputFilter+"__");
            //check through all transactions
            for(Transaction transaction : statement){

                if(transaction.getDescription().contains(inputFilter)){
                    System.out.println(transaction.getStartedDate()+" " + transaction.getDescription() + " "+ transaction.getAmount());
                }
            }
        }

//        //output income
//        System.out.println("__Income__");
//        double totalIncome = 0.0;
//        for(Transaction transaction : income){
//
//            //sum up total income
//            totalIncome += transaction.getAmount();
//
//            System.out.println(transaction.getDescription() +" +" + transaction.getAmount() + "\n\t\t "+transaction.getBalance());
//        }
//
//        System.out.println("\n\n");
//
//        //output expenditures
//        System.out.println("__Expenditure__");
//        double totalExpenditure = 0.0;
//        for(Transaction transaction : expenditure){
//
//            //sum up total income
//            totalExpenditure += transaction.getAmount();
//            System.out.println(transaction.getDescription() +" " + transaction.getAmount() + "\n\t\t "+transaction.getBalance());
//        }
//
//        System.out.println("\n\n");
//
//        //output income and expenditure in rounded format
//        System.out.println("Total income: +" + Math.round(totalIncome*100)/100);
//        System.out.println("Total expenditure: " + Math.round(totalExpenditure*100)/100);
    }
}
