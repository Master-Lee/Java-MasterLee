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

//ʹ���߼���������
select * from emp where (sal>500 or job='MANAGER') and ename like 'J%';

//ʹ��order by�־�  Ĭ������(asc), ����Ϊ(desc)
select * from emp order by sal;
select * from emp order by sal desc;
select * from emp order by deptno, sal desc;

//ʹ���еı�������
select ename, (sal+nvl(comm,0))*12 as "YearSal" from emp order by "YearSal"

//��ҳ��ѯ

//���ݷ��� -max,min,avg,sum,count  ֻ�ܳ����ڣ�ѡ���С�group by��having��order by�־�
select max(sal),min(sal) from emp;

select ename,sal from emp where sal=(select max(sal) from emp);

select count(*) from emp;

select ename,sal from emp where sal>(select avg(sal) from emp);

//group by �� having �־�
group by���ڶԲ�ѯ�Ľ������ͳ��
having �־��������Ʒ�����ʾ���
select avg(sal),max(sal),deptno from emp group by deptno;

select avg(sal),max(sal),deptno,job from emp group by deptno,job;
select avg(sal),min(sal),max(sal),deptno,job from emp group by deptno,job;

select avg(sal),max(sal), deptno from emp group by deptno having avg(sal)>2000;
select avg(sal),max(sal),deptno,job from emp group by deptno,job having job='MANAGER';

˳��group by > having > order by
select avg(sal),max(sal), deptno from emp group by deptno having avg(sal)>2000 order by deptno;


//����ѯ �ѿ�����ԭ�򣺶���ѯ���������� ���ٲ������ڱ�ĸ�����һ
select * from dept;
select * from emp;

select a1.dname, a2.ename, a2.sal from dept a1, emp a2 where a1.deptno=a2.deptno and a1.deptno=10;
select a1.ename,a1.sal,a2.grade from emp a1,salgrade a2 where a1.sal between a2.losal and a2.hisal;
select a1.ename, a2.dname, a1.sal from emp a1,dept a2 where a1.deptno=a2.deptno order by a1.deptno;

//������
select worker.ename,boss.ename from emp worker, emp boss where worker.mgr=boss.empno and worker.ename='FORD';

//�Ӳ�ѯ
//�����Ӳ�ѯ �Ӳ�ѯֻ����һ��  ���ݿ�ִ��sql �Ǵ�����
select * from emp where deptno=(select deptno from emp where ename='SMITH');
//�����Ӳ�ѯ �Ӳ�ѯ���ض���
select * from emp where job in(select distinct job from emp where deptno=10);
 �����Ӳ�ѯʹ��all
 select  ename,sal,deptno from emp where sal > all(select sal from emp where deptno=30);
 select ename,sal,deptno from emp where sal>(select max(sal) from emp where deptno=30);
 �����Ӳ�ѯʹ��any
 select ename,sal,deptno from emp where sal> any(select sal from emp where deptno=30);
 
//�����Ӳ�ѯ
select deptno,job from emp where ename='SMITH';
 select * from emp where (deptno,job)=(select deptno,job from emp where ename='SMITH');
 
//��from�Ӿ���ʹ���Ӳ�ѯ   from�е��Ӳ�ѯ������ͼ������Ϊ��Ƕ��ͼ
select deptno,avg(sal) mysal from emp group by deptno;
select a2.ename, a2.sal, a2.deptno, a1.mysal from emp a2, (select deptno,avg(sal) mysal from emp group by deptno) a1 where a2.deptno=a1.deptno and a2.sal>a1.mysal;

//��ҳ��ѯ oracle��ҳ�����ַ�ʽ
1��rownum��ҳ
	(select * from emp)
	rownum(oracle����)
	select a1.*,rownum rn from (select * from emp) a1 where rownum<=10;
	select * from (select a1.*,rownum rn from (select * from emp) a1 where rownum<=10) where rn>=6;
	select * from (select a1.*,rownum rn from (select ename,sal from emp) a1 where rownum<=10) where rn>=6;
	select * from (select a1.*,rownum rn from (select ename,sal from emp order by sal) a1 where rownum<=10) where rn>=6;
2���������������� row_number()����
	//���ɴ���ŵļ���
	select row_number() over(order by id desc) as 'rowNumber', * from table1
	select * from (select row_number() over(order by id desc) as 'rowNumber', * from table1) as temp where rowNumber between 1 and 5
3������ROWID����

//�ò�ѯ��������±�
create table mytable (id,name,sal,job,deptno) as select empno,ename,sal,job,deptno from emp;

//�ϲ���ѯ union,union all,intersect,minus    �ϲ����select���Ľ��
1��union ȡ����
	select ename,sal,job from emp where sal>200 union select ename,sal,job from emp where job='MANAGER';
2��intersect ȡ����

3��minus ȡ�

//��ҳ��ʽ
1.oracle���ݿ��ҳ  
select * from (select a.*,rownum rc from ���� where rownum<=endrow) a where a.rc>=startrow  
   
2.DB2���ݿ��ҳ  
Select * from (select rownumber() over() as rc,a.* from (select * from ���� order by ����) as a) where rc between startrow and endrow  
   
3.SQL Server 2000���ݿ��ҳ  
Select top pagesize * from ���� where ���� not  in(select top pagesize*page ���� from  ���� order by ����) order by ����  
   
4.SQL Server 2005���ݿ��ҳ  
Select * from (select ����,row_����number() over(order by  ����1) as ����from ����) as t where t.����1>=startrow and t.����1<=endrow  
   
5.MySQL���ݿ��ҳ  
Select * from ���� limit startrow,pagesize  
(PagesizeΪÿҳ��ʾ�ļ�¼����)  
   
6.PostgreSQL���ݿ��ҳ  
Select * from ���� limit pagesize,offset startrow  
(PagesizeΪÿҳ��ʾ�ļ�¼����.)  
   
7.ͨ��ģʽ  
select * from ( select * from tb_student where sid not in(select sid from tb_student where rownum<=(currentPage-1)*pageSize)) where rownum <=pageSize; 


//***********************************
//�������ݿ�
1)ͨ��oracle�ṩ���򵼹���
	dbca
2)�ֹ�����

//to_date����
 insert into emp values(9998,'С��','MANAGER',7782,'11-11��-1988',78.9,55.33,10);
 
 to_date����
  insert into emp values(9998,'С��','MANAGER',7782,to_date('1988-12-12','yyyy-mm-dd'),78.9,55.33,10);