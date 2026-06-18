import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class MainCompany {
    public static void main(String[] args) {

        TreeSet<Employee> company = new TreeSet<>();

        fillCompanySet(company);
        printEmployeeSet(company);

        String home = System.getProperty("user.home");

        String folderPath = home + File.separator + "company";
        String fileName = "employee.txt";
        saveCompanyToFile(company,folderPath,fileName);

    }

    private static void saveCompanyToFile(TreeSet<Employee> company,
                                          String folderPath,
                                          String fileName) {
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
