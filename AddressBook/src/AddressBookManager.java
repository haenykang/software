
import java.util.ArrayList;
public class AddressBookManager {
private ArrayList<AddressBook> addressBooks = new ArrayList<AddressBook>();
	
	public AddressBookManager(){}

	//���ο� �ּҷ��� ����Ѵ�.
	public void addAddressBook(AddressBook addressBook) {
		addressBooks.add(addressBook);
	}
	
	//�ּҷ��� ��ȣ�� ã�´�.
	public AddressBook findAddressBook(int no) {
		AddressBook addressBook = null;
		int total = addressBooks.size();
		for (int i = 0; i < total; i++) {
			if (no == addressBooks.get(i).getId()) {
				addressBook = addressBooks.get(i);
			}
		}
		return addressBook;
	}
		
	//�ּҷ��� �˻���� ã�´�.
	public ArrayList<AddressBook> findAddressBook(String keyword) {
		ArrayList<AddressBook> matchedAddressBooks = new ArrayList<AddressBook>();
		int total = addressBooks.size();
		for(int i = 0; i < total; i++) {
			AddressBook addressBook = addressBooks.get(i);
			if (addressBook.getName().indexOf(keyword) != -1 || 
					addressBook.getMobile().indexOf(keyword) != -1 || 
					addressBook.getEmail().indexOf(keyword) != -1 || 
					addressBook.getDepartment().indexOf(keyword) != -1) {
				matchedAddressBooks.add(addressBook);
			}
		}
		
		return matchedAddressBooks;
	}

	//�ּҷ��� �����Ѵ�.
	public void deleteAddressBook(int id) {
		AddressBook addressBook = findAddressBook(id);
		if (addressBook != null) {
			addressBooks.remove(addressBook);
		}
	}
	
	//��� �ּҷ� ����� ����.
	public ArrayList<AddressBook> getAddressBooks() {
		return addressBooks;
	}
}
