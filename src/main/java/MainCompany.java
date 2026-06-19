import java.io.*;
import java.util.TreeSet;

public class MainCompany {
    public static void main(String[] args) throws IOException {
        String home = System.getProperty("user.home");

        TreeSet<Employee> company = new TreeSet<>();

        String folderPath = home + File.separator + "company";
        String fileName = "employee.txt";

        readEmployeesFromFile(company, folderPath, fileName);
        printEmployeeSet(company);
//        fillCompanySet(company);
//        printEmployeeSet(company);
//        saveCompanyToFile(company, folderPath, fileName);

    }

    private static void readEmployeesFromFile(TreeSet<Employee> company,
                                              String folderPath,
                                              String fileName) {
        String filePath = folderPath + File.separator + fileName;
        File fl = new File(filePath);
        if (fl.exists() == false) {


        System.out.println("file " + filePath + "not exists");
        return;}
        try {
            FileReader fr = new FileReader(fl);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String fromFile = br.readLine();
                if (fromFile == null) {
                    br.close();
                    break;
                }
                String[] ar = fromFile.split("#");
                String name = ar[0];
                int id = Integer.parseInt(ar[1]);
                String position = ar[2];
                double salary = Double.parseDouble(ar[3]);
                Employee emp = new Employee(name,id,position,salary);
                company.add(emp);
            }

        }
catch (IOException e){
    System.out.println(e.getMessage());
}
    }



    private static void saveCompanyToFile(TreeSet<Employee> company,
                                          String folderPath,
                                          String fileName) throws IOException {
        File folder = new File(folderPath);
        if (folder.exists() == false)
            folder.mkdirs();
        String filePath = folderPath + File.separator + fileName;
        File fl = new File(filePath);
        if (fl.exists() == false){
            try {
                fl.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

        //  "Yevhenii  Stupachenko#12345QA TeamLead#15000"
        try {
            FileWriter fw = new
                    FileWriter(fl);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Employee e : company) {
                String toFile = e.getName()
                        +"#" + e.getId() + "#"
                        + e.getPosition() + "#"
                        + e.getSalary();
                bw.write(toFile);
                bw.newLine();

            }
            bw.close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }



    private static void printEmployeeSet(TreeSet<Employee> company) {
        for (Employee e : company){
            System.out.println(e);
        }
        System.out.println("***********************************");
    }

    private static void fillCompanySet(TreeSet<Employee> company) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

while (true){
        try {
            System.out.print("Enter name>>>");
            String name = br.readLine();

            System.out.print("Enter ID>>>");
            String answer = br.readLine();
            int id = Integer.parseInt(answer);

            System.out.print("Enter position>>>");
            String position = br.readLine();

            System.out.print("Enter salary>>>");
            answer = br.readLine();

            double salary = Double.parseDouble(answer);
            Employee emp = new Employee(name,id,position,salary);
            company.add(emp);

            System.out.print("Another one? yes/no>>>");
            answer= br.readLine();
            if (answer.equalsIgnoreCase("no"))
            {
                br.close();
                break;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}}
/*
Homework:

    TreeSet<Book> bookStore
    Book
    -----
    title(String)
    author(String)
    pages(int)
    price(double)

    fillBooks set(bookStore)
    saveBooksToFile(bookStore,folderPath,fileName)
    readBooksFromFile(bookStore,folderPath,fileName)
    printBooksStore(bookStore)


    Advanced:*****
Project Supermarket
2.1
 add methods in class Supermarket:
 public void read productsFromFile(String folderPath,String fileName)

 public void saveProductsToFile(String folderPath,String fileName)

 public void fillProducts()


 2.
Advanced:*****
Project Supermarket
2.1
 add methods in class Supermarket:
 public void readProductsFromFile(ArrayList<Product> stock,String folderPath,String fileName)

 public void saveProductsToFile(ArrayList<Product> stock,String folderPath,String fileName)

 public void fillProducts()
 */
