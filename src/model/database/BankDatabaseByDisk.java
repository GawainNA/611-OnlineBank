package model.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Persistable;
import model.account.Account;
import model.loan.Loan;
import model.user.Customer;
import model.user.Manager;

/**
 * This class stores all objects that needed to be persisted.
 * Also it can search object through id.
 * Just use this class as a database interface.
 * Singleton.
 */
public class BankDatabaseByDisk implements BankDatabase, Persistable {
    // list of objects, use to persistence
    public transient static final String STORAGE_FILENAME = "data.ser";
    public transient static final String STORAGE_DIR = System.getProperty("user.dir") + "/data";
    public transient static final String STORAGE_FILEPATH = STORAGE_DIR + "/" + STORAGE_FILENAME;

    private List<Customer> customerList;
    private Manager manager;

    // map of objects, use to accelerate search speed
    // key: object id; value: object
    private transient Map<Integer, Account> idAccountMap;
    private transient Map<Integer, Customer> idCustomerMap;
    private transient Map<Integer, Loan> idLoanMap;

    private transient static BankDatabaseByDisk bankDatabase;

    private BankDatabaseByDisk() {
        customerList = new ArrayList<>();
        idAccountMap = new HashMap<>();
        idCustomerMap = new HashMap<>();
        idLoanMap = new HashMap<>();

        manager = Manager.getInstance();
        // add manager account into idAccountMap
        Account managerAccount = manager.getManagerAccount();
        idAccountMap.put(managerAccount.getId(), managerAccount);
    }


    private static BankDatabaseByDisk deserialize() {
        System.out.println("deserialize()...");
        try {
            File f = new File(STORAGE_FILEPATH);
            // f.createNewFile();
            FileInputStream fileIn = new FileInputStream(f.getAbsolutePath());
            ObjectInputStream in = new ObjectInputStream(fileIn);
            BankDatabaseByDisk res =  (BankDatabaseByDisk) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("deserialize() done");
            return res;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("deserialize() fail");
        return null;
    }

    /**
     * 
     * @param id: customer id
     * @return customer object if id exist. or null if no customer with such id.
     */
    public Customer getCustomerById(int id) {
        return idCustomerMap.get(id);
    }

    /**
     * 
     * @param id account id
     * @return account object if id exist. or null if no account with such id
     */
    public Account getAccountById(int id) {
        return idAccountMap.get(id);
    }

    /**
     * 
     * @param id loan id
     * @return loan object if id exist. or null if no loan with such id
     */
    public Loan getLoanById(int id) {
        return idLoanMap.get(id);
    }

    public static BankDatabaseByDisk getInstance() {
        if (bankDatabase == null) {
            File f = new File(STORAGE_FILEPATH);
            if (!f.exists()) {
                // if local storage file does not exist, inital from constructor
                bankDatabase = new BankDatabaseByDisk();
            } else {
                // if local storage exist, construct singleton from file
                bankDatabase = deserialize();
                // rebuild all information, such as map information
                bankDatabase.initAfterDeserialize();
            }
        }
        return bankDatabase;
    }


    /**
     * init three maps after deserialize from file.
     * 
     * because three map attributes are transient, they need to reconstruct after deserialize
     */
    private void initAfterDeserialize() {
        idCustomerMap = new HashMap<>();
        idAccountMap = new HashMap<>();
        idLoanMap = new HashMap<>();
        for(Customer customer : customerList) {
            // init customer map
            idCustomerMap.put(customer.getUid(), customer);
            // init account map
            initAccountMap(customer.getCheckingAccount());
            initAccountMap(customer.getSavingAccount());
            initAccountMap(customer.getSecurityAccount());
            // init loan map
            initLoanMap(customer.getLoanList());
        }
    }

    private void initAccountMap(Account account) {
        if(account != null) {
            idAccountMap.put(account.getId(), account);
        }
    }

    private void initLoanMap(List<Loan> loanList) {
        if(loanList != null) {
            for(Loan loan : loanList) {
                idLoanMap.put(loan.getUid(), loan);
            }
        }
    }

    @Override
    public void update() {
        flush();
    }

    /**
     * flush records to disk
     */
    private void flush() {
        serialize();
    }


    private void serialize() {
        System.out.println("serialize()...");
        new File(STORAGE_DIR).mkdir();
        try {
            File f = new File(STORAGE_FILEPATH);
            f.createNewFile();
            System.out.println("file path: " + f.getAbsolutePath());
            FileOutputStream fileOut = new FileOutputStream(f.getAbsolutePath());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("\nSerialization Successful...\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("serialize() done");
    }


    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
        idCustomerMap.put(customer.getUid(), customer);
    }


    @Override
    public void addAccount(Account account) {
        idAccountMap.put(account.getId(), account);
    }


    @Override
    public void addLoan(Loan loan) {
        idLoanMap.put(loan.getUid(), loan);
    }


    public List<Customer> getCustomerList() {
        return customerList;
    }


    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }


    public Manager getManager() {
        return manager;
    }


    public void setManager(Manager manager) {
        this.manager = manager;
    }


    @Override
    public List<Customer> getAllCustomer() {
        return getCustomerList();
    }


    @Override
    public void clear() {
        // clear attribute
        customerList = new ArrayList<>();
        manager = Manager.getInstance();
        idAccountMap.clear();
        idCustomerMap.clear();
        idLoanMap.clear();
        // delete local file
        File f = new File(STORAGE_FILEPATH);
        f.delete();
    }
}
