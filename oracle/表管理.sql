//����������
���Ȳ��ܳ���30���ַ�
����ʹ��oracle������
ֻ��ʹ�������ַ� A-Z a-z # $��

//��������
//�ַ���
char 	���� ���2000�ַ�    Ч�ʸߣ���ѯ�ٶȿ�
varchar2(20)      �䳤 ���4000�ַ�
clob(character large objiect)     �ַ��ʹ���� ���4G

//��������
number ��Χ -10��38�η�-10��38�η������Ա�ʾ������Ҳ���Ա�ʾС��
number(5,2)  ��ʾһ��С����5λ��Ч����2λС��
number(5)  ��ʾһ����λ����   -99999-99999

//��������
date   ���������պ�ʱ����
timestamp ����oracle��date�������͵���չ

//ͼƬ
blob   ����������  ���Դ��ͼƬ������  4G

//���� 
//ѧ����ѧ�� ���� �Ա� �������� ��ѧ��
create talbe student (
	xh number(4),
	xm varchar2(20),
	sex char(2),
	birthday date,
	sal number(7,2)
);
//�༶��
create table class (
classid number(2),
cname varchar2(20)
);
//��ռ䣺�����ļ���λ��

//���һ���ֶ�
alter table student add(classid number(2));
//�޸��ֶγ���
alter table student modify(xm varchar2(30));
//�޸��ֶ����ͻ�������  ����������
alter table student modify(xm char(30));
//ɾ��һ���ֶ�
alter table student drop column sal;
//�޸ı������
rename student to stu;
//ɾ����
drop table student;

//��������  �����ֶ� �����ṩ
insert into student values ('0001','����','��','01-5��-05',10);
//����Ĭ�ϸ�ʽ��DD-MON-YY�����޸�
alter session set nis_date_format = 'yyyy-mm-dd';
insert into student values ('0001','����','��','1905-05-06',100.0,23);

//���һ�����ֶ�
insert into student (xh,xm,sex) values ('0003','lee','��');
//��ֵ
insert into student (xh,xm,sex,birthday) values ('0004','Jhon','��',null);

//�޸�һ�����ݵ��ֶ�
update student set sex='Ů' where xh='1';
update studdent set sex='Ů',birthday='1900-09-01' where xm='lee';

//ɾ������ ɾ�����м�¼����ṹ���ڣ�д��־�����Իָ����ٶȿ�
delete from student;
savepoint aa;   //����ع���
rollback to aa;  //�ع���aa

//ɾ���������м�¼����ṹ���ڣ���д��־���޷��һ�ɾ���ļ�¼,�ٶȿ�
truncate table student;

//ɾ����
drop table student;


//����� �ۺ���ϰ
//�鿴�� �ṹ
desc dept;
desc emp;

//��ѯ������
select * from dept;

��ѯָ����
select ename, sal, job, deptno from emp;

ȡ���ظ���
select distinct deptno, job from emp;

//ʹ���������ʽ
select ename,sal*12+nvl(comm,0) "YearSal" from emp;
//ʹ���еı��� YearSal
select ename,sal*12+nvl(comm,0) "YearSal" from emp;
//��δ���nullֵ ʹ��nvl����
select ename,sal*12+nvl(comm,0) "YearSal" from emp;
//��������ַ��� (||)
select ename || 'is a ' || job from emp;

//ʹ��where�־�
select ename,hiredate from emp where hiredate>'1-1��-1982';
select ename,sal from emp where sal>2000 and sal<3000;
//ʹ��like������
%��ʾ0������ַ�  _��ʾ�����ַ�
select ename,sal from emp where ename like 'S%';
select ename,sal from emp where ename like '__O%';
//��where�־���ʹ��in
select ename,sal from emp where empno in(7900,7902,7934);
//ʹ��is null������
select * from emp where mgr is null;

��9��