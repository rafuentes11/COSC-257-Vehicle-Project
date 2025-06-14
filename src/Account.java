
public class Account {

    private String creditCard_num;
    private String company_name;
    private boolean prime_customer;

    public Account(String creditCard_num, String company_name, boolean prime_customer) {
        this.creditCard_num = creditCard_num;
        this.company_name = company_name;
        this.prime_customer = prime_customer;
    }

    public String getCreditCardNum() {
        return creditCard_num;
    }

    public boolean prime_customer() {
        return prime_customer;
    }

    public String toString() {
        String prime;
        if (prime_customer())
            prime = " is a prime member.";
        else
            prime = " is not a prime member.";
        return "Company Name: " + company_name + " Credit Card Number: " + creditCard_num + prime;
    }

}