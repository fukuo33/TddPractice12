/**
 * Created with IntelliJ IDEA.
 * User: fukuo33
 * Date: 2013/08/11
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && currency().equals(money.currency());
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public String currency() {
        return this.currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    public Expression plus(Money addend) {
        return new Money(this.amount + addend.amount, this.currency);
    }
}
