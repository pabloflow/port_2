public class Container {

    private int id;
    private int weight;
    private String country;
    private boolean inspected;
    private int priority;
    private String content;
    private String senderCompany;
    private String receiverCompany;

    public Container(int id, int weight, String country, boolean inspected, int priority, String content, String senderCompany, String receiverCompany) {
        this.id = id;
        this.weight = weight;
        this.country = country;
        this.inspected = inspected;
        this.priority = priority;
        this.content = content;
        this.senderCompany = senderCompany;
        this.receiverCompany = receiverCompany;
    }
    public Container(){

    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", weight=" + weight +
                ", country='" + country + '\'' +
                ", inspected=" + inspected +
                ", priority=" + priority +
                ", content='" + content + '\'' +
                ", senderCompany='" + senderCompany + '\'' +
                ", receiverCompany='" + receiverCompany + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isInspected() {
        return inspected;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderCompany() {
        return senderCompany;
    }

    public void setSenderCompany(String senderCompany) {
        this.senderCompany = senderCompany;
    }

    public String getReceiverCompany() {
        return receiverCompany;
    }

    public void setReceiverCompany(String receiverCompany) {
        this.receiverCompany = receiverCompany;
    }
}
