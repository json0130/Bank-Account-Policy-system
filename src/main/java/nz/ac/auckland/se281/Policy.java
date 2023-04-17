package nz.ac.auckland.se281;

public abstract class Policy {

    // instance fields
    protected String Sum_Insured;
    protected String address;
    protected String rental;

    public Policy(String Sum_Insured, String address, String rental, String mechanical) {
        this.Sum_Insured = Sum_Insured;
        this.address = address;
        this.rental = rental;
    }

    public String getSum_Insured() {
        return Sum_Insured;
    }

    public void setSum_Insured(String sum_Insured) {
        Sum_Insured = sum_Insured;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRental() {
        return rental;
    }

    public void setRental(String rental) {
        this.rental = rental;
    }

    public void printDetails() {
        System.out.println(Sum_Insured + ", " + address + ", " + rental);
    }

}
