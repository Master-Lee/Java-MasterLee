package com.lee.deepcopy;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Email email = new Email("���ڽ���12��30���������Ҳμӻ��顭��");
		Person person1 = new Person("����",email);
		
		Person person2 = CloneUtils.clone(person1);
		person2.setName("����");
		
		Person person3 = CloneUtils.clone(person1);
		person3.setName("����");
		person1.getEmail().setContent("���ڽ���12��00���������Ҳμӻ��顭��");
		
        System.out.println(person1.getName() + "���ʼ������ǣ�" + person1.getEmail().getContent());
        System.out.println(person2.getName() + "���ʼ������ǣ�" + person2.getEmail().getContent());
        System.out.println(person3.getName() + "���ʼ������ǣ�" + person3.getEmail().getContent());
	}

}
