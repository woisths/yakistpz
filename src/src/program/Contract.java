package program;
import java.util.Date;

// Клас Contract (Контракт)
public class Contract {
    private int contractId;
    private Manager manager;
    private Customer customer;
    private Date startDate;
    private Date endDate;

    public Contract(int contractId, Manager manager, Customer customer, Date startDate, Date endDate) {
        this.contractId = contractId;
        this.manager = manager;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Геттери і сеттери
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}