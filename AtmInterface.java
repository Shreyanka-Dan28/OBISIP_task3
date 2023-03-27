package project.osais;
import java.util.*;

 class AtmInterface {
    String userid;
    String userpin;
    String accountholder;
    String accountNo;
    String TransactionDetails = "";
    int TransactionsCount = 0;
    float AvailableBalance = 0;

    public void createAccount() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the AC holder name:");
        this.accountholder = in.nextLine();
        System.out.println("Enter the Account Number:");
        this.accountNo = in.nextLine();
        System.out.println("Enter your valid_id:");
        this.userid = in.nextLine();
        System.out.println("Enter the valid_pin:");
        this.userpin = in.nextLine();
        System.out.println("Congratulation..!!");
        System.out.println(" Your account is successfully created. ");

    }

    public void login() {
        boolean flag = true;
        Scanner in = new Scanner(System.in);
        while (flag == true) {
            System.out.println("Enter your valid_id :");
            String UserId = in.nextLine();
            if (UserId.equals(userid)) {
                System.out.println("Enter your valid_pin :");
                String UserPin = in.nextLine();
                if (UserPin.equals(userpin)) {
                    System.out.println("Congratulation..!!");
                    System.out.println("your account has been successfully logedin.");
                    flag = false;
                } else
                    System.out.println("\n please recheck valid_pin.");
            } else
                System.out.println("\n please recheck valid_id.");
        }
    }

    public void withdraw() {
        System.out.println("Enter the amount to withdraw: ");
        Scanner in = new Scanner(System.in);
        float WithdrawAmount = in.nextFloat();
        if (AvailableBalance >= WithdrawAmount) {
            AvailableBalance = AvailableBalance - WithdrawAmount;
            System.out.println(WithdrawAmount + " has withdrawl successfully.");
            String transaction = WithdrawAmount + " has withdrawn \n";
            TransactionDetails = TransactionDetails.concat(transaction);
            TransactionsCount++;
        } else
            System.out.println("Account doesn't have enough balance.");
    }

    public void deposit() {
        System.out.println("Enter the amount to deposit:");
        Scanner in = new Scanner(System.in);
        float depositedAmount = in.nextFloat();
        AvailableBalance = AvailableBalance + depositedAmount;
        System.out.println(depositedAmount + " Amount has been deposited in your AC successfully.");
        String transaction = depositedAmount + " Amount has deposited .\n";
        TransactionDetails = TransactionDetails.concat(transaction);
        TransactionsCount++;
    }

    public void transfer() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter Receiver's Accountno.");
        String Receiveracntno = in.nextLine();
        System.out.println("\nEnter amount to transfer:");
        float amount = in.nextFloat();
        if (amount <= AvailableBalance) {
            AvailableBalance = AvailableBalance - amount;
            System.out.println(amount + " Amount has been transferred successfully.");
            String transaction = amount + " Amount has transfered to " + Receiveracntno + "\n";
            TransactionDetails = TransactionDetails.concat(transaction);
            TransactionsCount++;

        }

    }

    public void CheckBalance() {
        System.out.println("your Available balance is " + AvailableBalance);
    }

    public void TransactionHistory() {
        System.out.println("\n" + TransactionDetails);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n\n------------------WELCOME TO ATM INTERFACE--------------------\n\n");
        System.out.println("Enter\t1 to Create account\n \t0 to exit\n");
        System.out.println("Enter your choice");
        int input = in.nextInt();
        if (input == 1) {
            AtmInterface user = new AtmInterface();
            user.createAccount();
            System.out.println("\nplease enter atm details to login\n");
            user.login();
            boolean exit = false;
            while (!exit) {
                System.out.println(
                        "-----------------------------------------------------------------------------------------");
                System.out.println(
                        "\n1.withdraw \n2.deposit \n3.Trasfer \n4.check balance \n5.check transactions \n6.Exit\n");
                System.out.println("Enter your choice");
                int choice = in.nextInt();
                if (choice < 7 && choice > 0) {
                    switch (choice) {
                        case 1:
                            user.withdraw();
                            break;
                        case 2:
                            user.deposit();
                            break;
                        case 3:
                            user.transfer();
                            break;
                        case 4:
                            user.CheckBalance();
                            break;
                        case 5:
                            user.TransactionHistory();
                            break;
                        case 6:
                            exit = true;
                            break;
                        default:
                            System.out.println("Enter a valid input.\n");
                            break;
                    }
                }
            }
        }
    }

}