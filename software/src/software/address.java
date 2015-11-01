 package software; 



import java.util.ArrayList;

import java.util.List;




public class TestAdd{

private String name;

private String number;




public TestAdd() {

super();

}




public TestAdd(String name, String number) {

super();

this.name = name;

this.number = number;

}




public String getName() {

return name;

}




public void setName(String name) {

this.name = name;

}




public String getNumber() {

return number;

}




public void setNumber(String number) {

this.number = number;

}




@Override

public String toString() {

return "TestAdd [name=" + name + ", number=" + number + "]";

}




}




class AddControl {

List<TestAdd> addList;




public AddControl() {

super();

addList = new ArrayList<>();

}




public void addPerson(String name, String number) {  //����߰�

addList.add(new TestAdd(name, number));

}




public void searchNumber(String name) { //�̸�ã��

int cnt = 0;

for (TestAdd a : addList) {

if (a.getName().equals(name)) {

System.out.println(a.toString());

cnt++;

}

}

if (cnt == 0) {

System.out.println("ã�� �̸��� �����ϴ�.");

} else {

System.out.println("��" + cnt + "���� ������ �˻� �Ϸ�");

}

}




public void namePrint() {  //�̸����

for (TestAdd a : addList) {

System.out.println(a.getName());

}

}




public void numberPrint() {  //��ȣ���

for (TestAdd a : addList) {

System.out.println(a.getNumber());

}

}




public void allPrint() {  //�������

for (TestAdd a : addList) {

System.out.println(a);

}

}




public void deleteData(String name) {  //�̸�����




for (int loop1 = 0; loop1 < addList.size(); loop1++) {

if (addList.get(loop1).getName().equals(name)) {

addList.remove(loop1);

}

}




}




public static void main(String[] args) {

new AddControl();

//new AddControl().����� �޼ҵ�

}




}