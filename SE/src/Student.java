import java.io.*;
import java.util.*;
public class Student {
       public static void main(String[] args) throws IOException   {
        
       List n_list = new ArrayList();
       List d_list = new ArrayList();
       List p_list = new ArrayList();
       List i_list = new ArrayList();
       
for(;;)  { 
        System.out.println("������ �������� �������ּ���");
        System.out.print("[1] �ּҷ� �Է�  [2] �ּҷ� ��ü ��� : ");
        BufferedReader first = new BufferedReader(new InputStreamReader(System.in));
        int se;
        se = Integer.parseInt(first.readLine()); 
 
        switch (se) {
case 1: 
        System.out.print("�̸��� �Է��ϼ��� : ");
        BufferedReader person = new BufferedReader(new InputStreamReader(System.in));
        String name;
        name = person.readLine();
        n_list.add(name);
        System.out.print("ID�� �Է��ϼ��� : ");
        String id;
        id  = person.readLine();
        i_list.add(id);
        System.out.print("�а� �Է��ϼ��� : ");
        String department;
        department = person.readLine();
        d_list.add(department);
        System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
        String phone;
        phone = person.readLine();
        p_list.add(phone);
        
        System.out.println("-----------------------------------------------------------");
        System.out.println(name + "\t" + id + "\t" + department + "\t" + phone);
        System.out.println("�׸��� �߰��Ǿ����ϴ�.");
        System.out.println("-----------------------------------------------------------");
             break;
      
case 2: 
        System.out.printf("\tID\t\t�̸�\t\t\t����\t\t\t��ȭ��ȣ\n");
        System.out.println("-----------------------------------------------------------------------------");
         for(int i = 0 ; i < n_list.size() ; i++)
            System.out.printf("%d\t%s\t%s\t\t%s\t\t%s\n", i + 1, i_list.get(i), n_list.get(i), d_list.get(i), p_list.get(i));
              break;
      
 default: 
            System.out.print("�ٽ� �Է��ϼ���");
            break;
        }
       }
      }
 
}
