import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class AddressBookUI {


	private AddressBookManager mgr = new AddressBookManager();
	private static final String ADDRESS_FILE = "/home/kim/java/�ּҷϰ���/google.csv";
	private static final String ENTER = System.getProperty("line.separator");
	
	private void readCSV() throws IOException {
		FileReader fr = null;
		try {
			fr = new FileReader(ADDRESS_FILE);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("CSV ������ �����ϴ�.");
		}
		BufferedReader br = new BufferedReader(fr);
		String addrStr = null;

		
		try {
			br.readLine(); 
			while ((addrStr = br.readLine()) != null) {
				
				String[] addrArray = addrStr.split(",", -1);
				String name = addrArray[0];
				String mobile = addrArray[30];
				String email = addrArray[28];
				String department = addrArray[34];
				AddressBook addressBook = new AddressBook(name,mobile,email,department);
				mgr.addAddressBook(addressBook);
			}
		} catch (IOException e) {
			throw new IOException("CSV ������ �дµ� �����߽��ϴ�.");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void startWork() {
		try {
			readCSV();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("���Ϸκ��� �ּҷ��� �ε��ϴµ� ���������� ���α׷��� �����մϴ�.");
		}
		
		String menu = null;
		
		do {
			System.out.println(" ** �޴��� �����ϼ��� ** ");
			System.out.println(" 1. ���   ");
			System.out.println(" 2. ���   ");
			System.out.println(" 3.  ã��(Ű����)   ");
			System.out.println(" 4.  ����   ");
			System.out.println(" 5. ����   ");
			System.out.println(" q. ����   ");
			System.out.println(" ********************** ");
			System.out.print(">>");
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				menu = br.readLine();

				if (menu.equals("1")) {
					// register
					System.out.print("�̸��� �Է��ϼ���>>");
					String name = br.readLine();
					System.out.print("��ȭ��ȣ�� �Է��ϼ���>>");
					String mobile = br.readLine();
					System.out.print("�̸����� �Է��ϼ���>>");
					String email = br.readLine();
					System.out.print("�а��� �Է��ϼ���>>");
					String department = br.readLine();
					AddressBook addressBook = new AddressBook(name, mobile, email, department);
					mgr.addAddressBook(addressBook);
				} else if ( menu.equals("2") ) {
					// list
					ArrayList<AddressBook> addressBooks = mgr.getAddressBooks();
					int total = addressBooks.size();
					for (int i = 0; i < total; i++) {
						System.out.println(addressBooks.get(i));
					}
				} else if ( menu.equals("3") ) {
					// search(keyword)
					System.out.print("Ű���带 �Է��ϼ���>>");
					String keyword = br.readLine();
					ArrayList<AddressBook> matchedAddressBooks = mgr.findAddressBook(keyword);
					int total = matchedAddressBooks.size();
					for (int i = 0; i < total;i++) {
						System.out.println(matchedAddressBooks.get(i));
					}
				} else if (menu.equals("4")) {
					//����
					System.out.print("��ȣ�� �Է��ϼ���>>");
					int no = Integer.parseInt(br.readLine());
					AddressBook addressBook = mgr.findAddressBook(no);
					if (addressBook != null) {
						System.out.print("�����Ϸ��� �̸��� �Է��ϼ���.[�������� �������� �׳� ����]>>");
						String name = br.readLine();
						if (!name.equals("")) {
							addressBook.setName(name);
						}
						System.out.print("�����Ϸ��� ����ȭ�� �Է��ϼ���.[�������� �������� �׳� ����]>>");
						String mobile = br.readLine();
						if (!mobile.equals(mobile)) {
							addressBook.setMobile(mobile);
						}
						System.out.print("�����Ϸ��� �̸����� �Է��ϼ���.[�������� �������� �׳� ����]>>");
						String email = br.readLine();
						if (!email.equals("")) {
							addressBook.setEmail(email);
						}
						System.out.print("�����Ϸ��� ȸ�縦 �Է��ϼ���.[�������� �������� �׳� ����]>>");
						String department = br.readLine();
						if (!department.equals("")) {
							addressBook.setDepartment(department);
						}
					} else {
						System.out.println("��ȣ�� �߸��Է��ϼ̽��ϴ�.");
					}
				} else if (menu.equals("5")) {
					// ����
					System.out.print("������ �ּҷ� ��ȣ�� �Է��ϼ���>>");
					int no = Integer.parseInt(br.readLine());
					AddressBook addressBook = mgr.findAddressBook(no);
					if (addressBook != null) {
						System.out.print("������ �����Ϸ��� 1�� �Է��ϼ���>>");
						int chk = Integer.parseInt(br.readLine());
						if (chk == 1) {
							mgr.deleteAddressBook(no);
						}
					} else {
						System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
					}
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (!menu.equals("q"));
		
	}
	
	public void endWork() {
		StringBuilder sb = new StringBuilder();
		ArrayList<AddressBook> addressBooks = mgr.getAddressBooks();
		int total = addressBooks.size();
		sb.append("Name,Mobile Phone,E-mail Address,Company");
		sb.append(ENTER);
		for (int i = 0; i < total; i++) {
			sb.append(addressBooks.get(i).toCSV());
			sb.append(ENTER);
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(ADDRESS_FILE, false);
			bw = new BufferedWriter(fw);
			bw.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		AddressBookUI ui = null;
		try {
			ui = new AddressBookUI();
			ui.startWork();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ui.endWork();
		}
		System.out.println("���α׷��� ���������� ����Ǿ����ϴ�.");
	}
}
