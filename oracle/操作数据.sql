//insert  子查询插入大量数据
create table kkk (myId number(4),myname varchar2(50),myDept number(5));
insert into kkk (myId,myname,mydept) select empno,ename,deptno from emp where deptno=10;

//update 使用子查询更新数据

update emp set (job,sal,comm)=(select job,sal,comm from emp where ename='SMITH') where ename='SCOTT';

//oracle事务和锁 在被作用的表上加锁  
//事务永不保证数据的 一致性 原子性 不可分割性，由一组dml语句组成，该组的dml语句要么全部成功，要不全部失败

//提交事务 commit

//回退事务 savepoint，如果执行了commit，保存点失效

//只读事务
只读事务只允许执行查询操作，而不允许执行任何其他dml操作
使用只读事务可以确保用户只能取得某时间点的数据

//设置只读事务  set transaction read only   查询不到设置只读事务后的 数据

//sql函数   字符函数是oracle中最常用的函数
//字符函数
lower(char) 
	select lower(ename),sal from emp;
upper(char)
length(char)
	select ename,sal from emp where length(ename)=5;
substr(char,m,n):取字符串的子串   3表示取三个，不是取到第三个
	select substr(ename,1,3),sal from emp where length(ename)=5;
	select substr(ename,2,3),sal from emp where length(ename)=5;
    以首字母大写的方式显示
	select upper(substr(ename,1,1))||lower(substr(ename,2,length(ename)-1)) from emp;
	
replace(char1,search_string,replace_string)
	select replace(ename,'A','Leeeee') from emp;
instr(char1,char2,[,n[,m]]):取子串在字符串的位置

//数学函数
round(n,[m])  四舍五入，如果省掉m，则四舍五入到整数，m是正数，四舍五入到小数点的m位后，m是负数，则四舍五入到小数点的m位后 
	select ename,round(sal,3) from emp;
trunc(n,[m]   截取数字，如果省掉m，就去掉小数部分，留下正数，如果m是正数，就截取到小数点你的m位后，如果m是负数，则截取到小数点的前m位
	select trunc(comm,1),comm from emp;   不会四舍五入
	select trunc(comm,-1),comm from emp;
mod(m,n)      
floor(n)       返回小于或是等于n的最大正数
ceil(n)        返回大于或是等于n的最小正数

//数学函数
abs(n)
select abs(-13) from dual;
acos(n)
asin(n)
atan(n)
cos(n)
exp(n)
log(m,n)
power(m,n)

//日期函数
sysdate: 该函数返回系统时间
	select sysdate from dual;
add_months(d,n)
	select * from emp where sysdate>add_months(hiredate,400);
	select ename,hiredate from emp  where sysdate>=add_months(hiredate,12*10);
	select sysdate-hiredate "入职天数",ename from emp;
	select trunc(sysdate-hiredate) "入职天数",ename from emp;
last_day(d):  返回指定日期所在月份的最后一天	
	select hiredate,last_day(hiredate) from emp;
	select hiredate,ename from emp where last_day(hiredate)-2=hiredate;    倒数第三天
	
//转换函数
oracle允许值得数据类型和实际的不一样，这时oracle会隐含的转换数据类型

//to_char函数

insert into emp values(8881,'testuser','MANAGER',7782,sysdate,800,23,10);    //sysdate

select ename,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss') from emp where ename='testuser';

select ename,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss'),to_char(sal,'L99999.99') from emp where ename='testuser';  //L99999.99    L表示local,99999.99表示显示格式
select ename,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss'),to_char(sal,'L99,999.99') from emp;

select ename,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss'),to_char(sal,'C99,999.99') from emp;
select ename,to_char(hiredate,'yyyy-mm-dd hh24:mi:ss'),to_char(sal,'$99,999.99') from emp;

select * from emp where to_char(hiredate,'yyyy')=1988;
select * from emp where to_char(hiredate,'mm')=12;


//to_date函数 用于将字符串转换成date类型的数据

//系统函数
//sys_context
	terminal: 当前会话客户所对应的终端的标识符
	language: 语言
	db_name   当前数据库名称
	nis_date_format: 当前会话所对应的日期格式
	session_user:	当前会话所对应的数据库用户名
	current_schema: 当前会话客户所对应的默认方案名
	host:		返回数据库所在的主机的名称
	
	select sys_context('userenv','db_name') from dual;
	
	select sys_context('userenv','current_schema') from dual;
	
	//用户和方案
	用户被创建后，会创建一个同名的方案。
	方案中会有很多数据对象：表、视图、触发器、存储过程
