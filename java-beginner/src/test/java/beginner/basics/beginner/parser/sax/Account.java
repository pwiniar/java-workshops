package beginner.basics.beginner.parser.sax;

/**
 * Created by Pawel on 2016-10-26.
 */
public class Account {

    private String name;
    private int id;
    private int amount;
    private String type;

    public Account() {
    }

    public Account(String name, int id, int amount, String type) {
        this.name = name;
        this.id = id;
        this.amount = amount;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Account Details - ");
        sb.append("Name:" + getName());
        sb.append(", ");
        sb.append("Type:" + getType());
        sb.append(", ");
        sb.append("Id:" + getId());
        sb.append(", ");
        sb.append("Amount:" + getAmount());
        sb.append(".");

        return sb.toString();
    }
}
