package com.lee.classadapter;

public class ClassAdapterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OldCellPhone myPhone = new OldCellPhone();
		myPhone.call();
		myPhone.text();
		System.out.println("�ֻ�����ǰ��");
		CellPhoneTransformer transformedPhone = new CellPhoneTransformer();
		transformedPhone.call();
		transformedPhone.text();
		transformedPhone.internet();
	}
}

//���������Ͷ�����������Ȩ��
//
//�񡡡���������ʹ�ö���̳еķ�ʽ���Ǿ�̬�Ķ��巽ʽ��������������ʹ�ö�����ϵķ�ʽ���Ƕ�̬��ϵķ�ʽ��
//
//�񡡡�������������������������ֱ�Ӽ̳���Adaptee��ʹ�����������ܺ�Adaptee������һ��������Ϊ�̳��Ǿ�̬�Ĺ�ϵ�����������̳���Adaptee�󣬾Ͳ�������ȥ����  Adaptee�������ˡ�
//
//���� ���ڶ�����������һ�����������԰Ѷ��ֲ�ͬ��Դ���䵽ͬһ��Ŀ�ꡣ����֮��ͬһ�����������԰�Դ����������඼���䵽Ŀ��ӿڡ���Ϊ�������������õ��Ƕ�����ϵĹ�ϵ��ֻҪ����������ȷ���ǲ������඼����ν��
//
//��  �������������������������ض���Adaptee�Ĳ�����Ϊ���൱�����า�Ǹ���Ĳ���ʵ�ַ�����
//
//���� ���ڶ�����������Ҫ�ض���Adaptee����Ϊ�Ƚ����ѣ���������£���Ҫ����Adaptee��������ʵ���ض��壬Ȼ����������������ࡣ��Ȼ�ض���Adaptee����Ϊ�Ƚ����ѣ�������Ҫ����һЩ�µ���Ϊ�򷽱�ĺܣ����������ӵ���Ϊ��ͬʱ���������е�Դ��
//
//�񡡡�������������������������һ�����󣬲�����Ҫ�������������ӵõ�Adaptee��
//
//���� ���ڶ�������������Ҫ�������������ӵõ�Adaptee��
