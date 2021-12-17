# 611-OnlineBank

# CS611- Bank ATM

Documentation : https://docs.google.com/document/d/1Tjf8lfppLrrwDLIDh7oFr3gvM2M06qBMAFcVij9g8p8/edit?usp=sharing

Slides : https://docs.google.com/presentation/d/15SUfuwP0GoFRW2UBAzz46b43BBt_47k66A-lyeBxGhA/edit?usp=sharing
## Name
-------------------------------------------------------------------------------------------------
Yan Tong
U31059912

Junyi Huang
U57383185

Chenyang Zhang
U95109583

## Compile & Run:
-------------------------------------------------------------------------------------------------
- Running Main.java

## Notes:
-------------------------------------------------------------------------------------------------

### System instruction notes:

- Running the system will present GUI to users.
- After successfully compile, the login window for users(customers and manager) will be displayed at first. User enter their name and password to sign in.
- After login, the home page will be displayed. Click buttons to corresponding specific function interfaces.
- Customer functions include manage their three accounts(saving, checking, security), transfer, withdraw, save, request loan, trade stock.
- Manager functions include view transaction report, manage stock market, manage loan records.

### Design patterns used:

1. Factory Pattern

    - Factories are used for creating accounts, customers and collateral.

2. MVC Pattern

    - The system is separated to Model(back-end data), View and Controllers. More details of classes can be found in corresponding packages.

3. Observer Pattern

    - Observers are all customers' security accounts. Subject is the stock market. Used for customer geting the update infomation of stock market.

4. Singleton Pattern

    - Many objects should be singleton: manager, stock market, manager account, factories.

### Extra features(bonus)

1. Use design patterns

    - Factory, MVC, Observer, Singleton. The analysis and reason for using them can be found in design documentation.

2. Transfer between different customers' accounts

    - Each account have a distinct id like the primary key. One customer can transfer money to other customers' account by entering the account id.

## Files & Classes Explanation
-------------------------------------------------------------------------------------------------
Bank
- DataModel for the whole bank. Include manager, BankDatabase, etc. Can add customer to the system, mange the database of the bank system, mange users login.

Account
- DataModel for the account of users. Abstract class. Common variables of all accounts(id, currency, etc.). Include main method of transfer and error hint.

AccountFactory
- Factory class for creating account. Include method for creating Checking, Saving, Security.

CheckingAccount
- DataModel for checking account. Inherited from Account.

SavingAccount
- DataModel for saving account. Inherited from Account.

SecurityAccount
- DataModel for security account. Inherited from Account.

ManagerAccount
- DataModel for manager's account. Inherited from Account.

IdCreator
- DataModel for randomly creating the id of all accounts. Each id means a distinct account. It is  the primary key of account.

CurrencyType
- DataModel for different types of currency and their exchange rates. Enum class.

Currency
- DataModel for currency. Include amount and CurrencyType.

Stock
- DataModel for single stock. Include private variables : name, price, amount.

StockMarket
- DataModel for the stock market. Include methods to add, remove, update stock information.

User
- DataModel for users in the bank system. Abstract class. Include common variables of all users' information(name, gender, password, etc.)

Customer
- DataModel for customer. Inherited from User. Include three types of accounts and loan list. Have methods to open/close account, apply loan.

CustomerFactory
- Factory class for creating customers.

Manager
- DataModel for manager. Inherited from User. Include method to get, approve loan request.

Collateral
- DataModel for collateral. Include variables: id, name, price. Customer use it to apply the loan.

CollateralFactory
- Factory class for creating collateral.

Loan
- DataModel for every loan record. Include variables: id, loan price, Collateral, etc.

Transaction
- DataModel for every transfer records. Include variables: from account, to account, amount.

BankDatabase
- Interface of Bank database.

BankDatabaseByDisk
- An implementation of the BankDatabase interface. use a disk as storage.

Persistable
- Interface use to do persistence

ErrCode
- DataModel for error message hint.

Sign
- Interface for user to login. Enter username and password. Click sign in button to Main interface, click sign up button to sign up interface. Screenshot is shown below.

SignUP
- Interface for customer to sign up. Enter personal information of customer. Click confirm, cancel button to back to Sign interface.

CustomerMain
- Home page interface for customer. Click buttons(tree account, log, transaction, etc.) to corresponding interfaces.

OpenAccount
- Interface for customer to open a new account.

Checking
- Interface for customer to manage the checking account. Include balance records, deposit, withdraw, transfer functions. Click transfer button to Transfer interface.

Saving
- Interface for customer to manage the saving account. Same as the Checking.

Security
- Interface for customer to manage the security account. Click transfer, stock button to corresponding interfaces.

Transfer
- Interface for customer to transfer. Enter account id, amount, currency type to confirm the transfer. Checking, Saving interfaces can link to this transfer interface by click transfer button.


TransferInside
- Interface for customer to transfer from his security account to his other accounts. Enter amount, currency type, account type to confirm the transfer.

Stock
- Interface for customer to manage his stocks. Include customer's stock records, stock market records, buy and sell functions.

Loan
- Interface for customer to manage his loans. Include current loan records. Click New Loan button, Repayment button to corresponding interfaces.

RequestLoan
- Interface for customer to request a new loan.


Transaction
- Interface for customer and manager to check transaction records.

ManagerMain
- Home page Interface for manager. Click buttons( transaction, loans, stocks) to corresponding interfaces.

ManageLoan
- Interface for manager to mange loans. Include existing loan records, loan request. Manager can choose loan request to approve.

ManageStock
- Interface for manager to mange stocks. Include active stocks, stock market records. Manger can update the stock market and active/remove single stock.

SigninController
- Controller class for the Signin UI

SignupController
- Controller class for the Signup UI

CustomerMainController
- Controller class for the home page of customer


LoanController
- Controller class for the customer’s loan management UI

RequestLoanController
- Controller class for the customer to request new loan UI

ManageLoanController
- Controller class for the manager’s loan management UI

ManageStockController
- Controller class for the manager’s loan management UI

ManagerMainController
- Controller class for the home page of manager

OpenAccountController
- Controller class for the customer to open new account UI

CheckingController
- Controller class for the Checking account UI

SavingController
- Controller class for the Saving account UI

SecurityController
- Controller class for the Security account UI

StockController
- Controller class for the customer's stock management UI

TransferController
- Controller class for the customer's transfer UI

TransactionController
- Controller class for the Transaction Log UI

TransferInsideController
- Controller class for the customer's security account transfer UI
