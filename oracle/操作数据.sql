//insert  �Ӳ�ѯ�����������
create table kkk (myId number(4),myname varchar2(50),myDept number(5));
insert into kkk (myId,myname,mydept) select empno,ename,deptno from emp where deptno=10;

//update ʹ���Ӳ�ѯ��������

update emp set (job,sal,comm)=(select job,sal,comm from emp where ename='SMITH') where ename='SCOTT';

//oracle������� �ڱ����õı��ϼ���  
//����������֤���ݵ� һ���� ԭ���� ���ɷָ��ԣ���һ��dml�����ɣ������dml���Ҫôȫ���ɹ���Ҫ��ȫ��ʧ��

//�ύ���� commit

//�������� savepoint�����ִ����commit�������ʧЧ

//ֻ������
ֻ������ֻ����ִ�в�ѯ��������������ִ���κ�����dml����
ʹ��ֻ���������ȷ���û�ֻ��ȡ��ĳʱ��������

//����ֻ������  set transaction read only   ��ѯ��������ֻ�������� ����

//sql����   �ַ�������oracle����õĺ���
//�ַ�����
lower(char) 
	select lower(ename),sal from emp;
upper(char)
length(char)
	select ename,sal from emp where length(ename)=5;
substr(char,m,n):ȡ�ַ������Ӵ�   3��ʾȡ����������ȡ��������
	select substr(ename,1,3),sal from emp where length(ename)=5;
	select substr(ename,2,3),sal from emp where length(ename)=5;
    ������ĸ��д�ķ�ʽ��ʾ
	select upper(substr(ename,1,1))||lower(substr(ename,2,length(ename)-1)) from emp;
	
replace(char1,search_string,replace_string)
	select replace(ename,'A','Leeeee') from emp;
instr(char1,char2,[,n[,m]]):ȡ�Ӵ����ַ�����λ��

//��ѧ����
round(n,[m])  �������룬���ʡ��m�����������뵽������m���������������뵽С�����mλ��m�Ǹ��������������뵽С�����mλ�� 
	select ename,round(sal,3) from emp;
trunc(n,[m]   ��ȡ���֣����ʡ��m����ȥ��С�����֣��������������m���������ͽ�ȡ��С�������mλ�����m�Ǹ��������ȡ��С�����ǰmλ
	select trunc(comm,1),comm from emp;   ������������
	select trunc(comm,-1),comm from emp;
mod(m,n)      
floor(n)       ����С�ڻ��ǵ���n���������
ceil(n)        ���ش��ڻ��ǵ���n����С����

//��ѧ����
abs(n)
select abs(-13) from dual;
acos(n)
asin(n)
atan(n)
cos(n)
exp(n)
log(m,n)
power(m,n)

//���ں���
sysdate: �ú�������ϵͳʱ��
	select sysdate from dual;
add_months(d,n)
	select * from emp where sysdate>add_months(hiredate,400);
	select ename,hiredate from emp  where sysdate>=add_months(hiredate,12*10);
	select sysdate-hiredate "��ְ����",ename from emp;
	select trunc(sysdate-hiredate) "��ְ����",ename from emp;
last_day(d):  ����ָ�����������·ݵ����һ��	
	select hiredate,last_day(hiredate) from emp;
	select hiredate,ename from emp where last_day(hiredate)-2=hiredate;    ����������
	
//ת������
oracle����ֵ���������ͺ�ʵ�ʵĲ�һ������ʱoracle��������ת����������

//to_char����

insert into emp values(8881,'testuser','MANAGER',7782,sysdate,800,23,10);    //sysdate

select ename,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss') from emp where ename='testuser';

select ename,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss'),to_char(sal,'L99999.99') from emp where ename='testuser';  //L99999.99    L��ʾlocal,99999.99��ʾ��ʾ��ʽ
select ename,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss'),to_char(sal,'L99,999.99') from emp;

select ename,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss'),to_char(sal,'C99,999.99') from emp;
select ename,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss'),to_char(sal,'$99,999.99') from emp;

select * from emp where to_char(hiredate,'yyyy')=1988;
select * from emp where to_char(hiredate,'mm')=12;


//to_date���� ���ڽ��ַ���ת����date���͵�����

//ϵͳ����
//sys_context
	terminal: ��ǰ�Ự�ͻ�����Ӧ���ն˵ı�ʶ��
	language: ����
	db_name   ��ǰ���ݿ�����
	nis_date_format: ��ǰ�Ự����Ӧ�����ڸ�ʽ
	session_user:	��ǰ�Ự����Ӧ�����ݿ��û���
	current_schema: ��ǰ�Ự�ͻ�����Ӧ��Ĭ�Ϸ�����
	host:		�������ݿ����ڵ�����������
	
	select sys_context('userenv','db_name') from dual;
	
	select sys_context('userenv','current_schema') from dual;
	
	//�û��ͷ���
	�û��������󣬻ᴴ��һ��ͬ���ķ�����
	�����л��кܶ����ݶ��󣺱���ͼ�����������洢����
