package bank_system.config;
import bank_system.models.entities.Account;
import bank_system.models.entities.Client;
import bank_system.models.entities.Employee;
import bank_system.models.enums.Currency;
import bank_system.models.enums.PositionType;
import bank_system.services.AccountService;
import bank_system.services.ClientService;
import bank_system.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedComponent implements CommandLineRunner {
    private final AccountService accountService;
    private final ClientService clientService;
    private final EmployeeService employeeService;

    public SeedComponent(AccountService accountService,
                         ClientService clientService,
                         EmployeeService employeeService) {
        this.accountService = accountService;
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedClients();
        this.seedAccounts();
        this.seedEmployees();
    }

    private void seedClients(){
        if(this.clientService.getAllClients().isEmpty()){
            Client first = new Client();
            first.setFirstName("Nikolay");
            first.setMiddleName("Hristov");
            first.setLastName("Nikolaev");
            first.setEgn("9122388740");
            first.setEmail("top@gmail.com");

            Client second = new Client();
            second.setFirstName("Kristiqn");
            second.setMiddleName("Ivanov");
            second.setLastName("Merakov");
            second.setEgn("9422388740");
            second.setEmail("topGto@gmail.com");

            Client third = new Client();
            third.setFirstName("Ivan");
            third.setMiddleName("Dimitrov");
            third.setLastName("Kalimarov");
            third.setEgn("9022388740");
            third.setEmail("topYieti@gmail.com");

            Client fourth = new Client();
            fourth.setFirstName("Atanas");
            fourth.setMiddleName("Atanasov");
            fourth.setLastName("Genchev");
            fourth.setEgn("9122388740");
            fourth.setEmail("topNasito@gmail.com");

            Client fifth = new Client();
            fifth.setFirstName("Djenko");
            fifth.setMiddleName("Djenkov");
            fifth.setLastName("Djeeeeeeeenkov");
            fifth.setEgn("9522388740");
            fifth.setEmail("topDjenkoto@gmail.com");

            this.clientService.createClient(first);
            this.clientService.createClient(second);
            this.clientService.createClient(third);
            this.clientService.createClient(fourth);
            this.clientService.createClient(fifth);

        }
    }

    private void seedAccounts(){
        if(this.accountService.getAllAccounts().isEmpty()){
            Client first = this.clientService.getClientById(1);
            Client second = this.clientService.getClientById(2);
            Client third = this.clientService.getClientById(3);
            Client fourth = this.clientService.getClientById(4);
            Client fifth = this.clientService.getClientById(5);

            Account firstAccount = new Account();
            firstAccount.setNumber("BGOWSA32452245KFFDC");
            firstAccount.setBalance(100000);
            firstAccount.setCurrency(Currency.EUR);
            firstAccount.setClient(first);
            this.accountService.createAccount(firstAccount);

            Account secondAccount = new Account();
            firstAccount.setNumber("BG234A32452245KF2DC");
            firstAccount.setBalance(1240);
            firstAccount.setCurrency(Currency.GBR);
            firstAccount.setClient(second);
            this.accountService.createAccount(secondAccount);

            Account thirdAccount = new Account();
            firstAccount.setNumber("BGO77SA32452245KF4DC");
            firstAccount.setBalance(100400);
            firstAccount.setCurrency(Currency.BGN);
            firstAccount.setClient(third);
            this.accountService.createAccount(thirdAccount);

            Account fourthAccount = new Account();
            firstAccount.setNumber("BG11OW3SA32452245KFF4DC");
            firstAccount.setBalance(120000);
            firstAccount.setCurrency(Currency.EUR);
            firstAccount.setClient(fourth);
            this.accountService.createAccount(fourthAccount);

            Account fifthAccount = new Account();
            firstAccount.setNumber("BGO2WSA32452245KF4FDC");
            firstAccount.setBalance(100000);
            firstAccount.setCurrency(Currency.EUR);
            firstAccount.setClient(fifth);
            this.accountService.createAccount(fifthAccount);

            this.clientService.createClient(first);
            this.clientService.createClient(second);
            this.clientService.createClient(third);
            this.clientService.createClient(fourth);
            this.clientService.createClient(fifth);
        }
    }

    private void seedEmployees(){
        if(this.employeeService.getAllEmployees().isEmpty()){
            Employee employee = new Employee();
            employee.setFirstName("Hristo");
            employee.setMiddleName("Nikolaev");
            employee.setLastName("Hristov");
            employee.setPositionType(PositionType.CASHIER);
            employee.setTelephoneNumber("0872647844");

            this.employeeService.createEmployee(employee);
        }
    }
}
