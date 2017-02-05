//表名和列名
长度不能超过30个字符
不能使用oracle保留字
只能使用如下字符 A-Z a-z # $等

//数据类型
//字符型
char 	定长 最大2000字符    效率高，查询速度快
varchar2(20)      变长 最大4000字符
clob(character large objiect)     字符型大对象 最大4G

//数字类型
number 范围 -10的38次方-10的38次方，可以表示整数，也可以表示小数
number(5,2)  表示一个小数有5位有效数，2位小数
number(5)  表示一个五位整数   -99999-99999

//日期类型
date   包含年月日和时分秒
timestamp 这是oracle对date数据类型的扩展

//图片
blob   二进制数据  可以存放图片、声音  4G

//建表 
//学生表：学号 姓名 性别 出生日期 奖学金
create talbe student (
	xh number(4),
	xm varchar2(20),
	sex char(2),
	birthday date,
	sal number(7,2)
);
//班级表
create table class (
classid number(2),
cname varchar2(20)
);
//表空间：保存文件的位置

//添加一个字段
alter table student add(classid number(2));
//修改字段长度
alter table student modify(xm varchar2(30));
//修改字段类型或者名字  不能有数据
alter table student modify(xm char(30));
//删除一个字段
alter table student drop column sal;
//修改表的名字
rename student to stu;
//删除表
drop table student;

//插入数据  所有字段 必须提供
insert into student values ('0001','张三','男','01-5月-05',10);
//日期默认格式：DD-MON-YY，可修改
alter session set nis_date_format = 'yyyy-mm-dd';
insert into student values ('0001','张三','男','1905-05-06',100.0,23);

//添加一部分字段
insert into student (xh,xm,sex) values ('0003','lee','男');
//空值
insert into student (xh,xm,sex,birthday) values ('0004','Jhon','男',null);

//修改一条数据的字段
update student set sex='女' where xh='1';
update studdent set sex='女',birthday='1900-09-01' where xm='lee';

//删除数据 删除所有记录，表结构还在，写日志，可以恢复，速度快
delete from student;
savepoint aa;   //保存回滚点
rollback to aa;  //回滚到aa

//删除表中所有记录，表结构还在，不写日志，无法找回删除的记录,速度快
truncate table student;

//删除表
drop table student;


//表操作 综合练习
//查看表 结构
desc dept;
desc emp;

//查询所有列
select * from dept;

查询指定列
select ename, sal, job, deptno from emp;

取消重复行
select distinct deptno, job from emp;

//使用算数表达式
select ename,sal*12+nvl(comm,0) "YearSal" from emp;
//使用列的别名 YearSal
select ename,sal*12+nvl(comm,0) "YearSal" from emp;
//如何处理null值 使用nvl函数
select ename,sal*12+nvl(comm,0) "YearSal" from emp;
//如何连接字符串 (||)
select ename || 'is a ' || job from emp;

//使用where字句
select ename,hiredate from emp where hiredate>'1-1月-1982';
select ename,sal from emp where sal>2000 and sal<3000;

//使用like操作符
%表示0到多个字符  _表示单个字符
select ename,sal from emp where ename like 'S%';
select ename,sal from emp where ename like '__O%';
//在where字句中使用in
select ename,sal from emp where empno in(7900,7902,7934);
//使用is null操作符
select * from emp where mgr is null;

//使用逻辑操作符号
select * from emp where (sal>500 or job='MANAGER') and ename like 'J%';

//使用order by字句  默认升序(asc), 降序为(desc)
select * from emp order by sal;
select * from emp order by sal desc;
select * from emp order by deptno, sal desc;

//使用列的别名排序
select ename, (sal+nvl(comm,0))*12 as "YearSal" from emp order by "YearSal"

//分页查询

//数据分组 -max,min,avg,sum,count  只能出现在：选择列、group by、having、order by字句
select max(sal),min(sal) from emp;

select ename,sal from emp where sal=(select max(sal) from emp);

select count(*) from emp;

select ename,sal from emp where sal>(select avg(sal) from emp);

//group by 和 having 字句
group by用于对查询的结果分组统计
having 字句用于限制分组显示结果
select avg(sal),max(sal),deptno from emp group by deptno;

select avg(sal),max(sal),deptno,job from emp group by deptno,job;
select avg(sal),min(sal),max(sal),deptno,job from emp group by deptno,job;

select avg(sal),max(sal), deptno from emp group by deptno having avg(sal)>2000;
select avg(sal),max(sal),deptno,job from emp group by deptno,job having job='MANAGER';

顺序：group by > having > order by
select avg(sal),max(sal), deptno from emp group by deptno having avg(sal)>2000 order by deptno;


//多表查询 笛卡尔集原则：多表查询的条件个数 至少不能少于表的个数减一
select * from dept;
select * from emp;

select a1.dname, a2.ename, a2.sal from dept a1, emp a2 where a1.deptno=a2.deptno and a1.deptno=10;
select a1.ename,a1.sal,a2.grade from emp a1,salgrade a2 where a1.sal between a2.losal and a2.hisal;
select a1.ename, a2.dname, a1.sal from emp a1,dept a2 where a1.deptno=a2.deptno order by a1.deptno;

//自连接
select worker.ename,boss.ename from emp worker, emp boss where worker.mgr=boss.empno and worker.ename='FORD';

//子查询
//单行子查询 子查询只返回一行  数据库执行sql 是从左到右
select * from emp where deptno=(select deptno from emp where ename='SMITH');
//多行子查询 子查询返回多行
select * from emp where job in(select distinct job from emp where deptno=10);
 多行子查询使用all
 select  ename,sal,deptno from emp where sal > all(select sal from emp where deptno=30);
 select ename,sal,deptno from emp where sal>(select max(sal) from emp where deptno=30);
 多行子查询使用any
 select ename,sal,deptno from emp where sal> any(select sal from emp where deptno=30);
 
//多列子查询
select deptno,job from emp where ename='SMITH';
 select * from emp where (deptno,job)=(select deptno,job from emp where ename='SMITH');
 
//在from子句中使用子查询   from中的子查询当做视图处理，称为内嵌视图
select deptno,avg(sal) mysal from emp group by deptno;
select a2.ename, a2.sal, a2.deptno, a1.mysal from emp a2, (select deptno,avg(sal) mysal from emp group by deptno) a1 where a2.deptno=a1.deptno and a2.sal>a1.mysal;

//分页查询 oracle分页有三种方式
1、rownum分页
	(select * from emp)
	rownum(oracle分配)
	select a1.*,rownum rn from (select * from emp) a1 where rownum<=10;
	select * from (select a1.*,rownum rn from (select * from emp) a1 where rownum<=10) where rn>=6;
	select * from (select a1.*,rownum rn from (select ename,sal from emp) a1 where rownum<=10) where rn>=6;
	select * from (select a1.*,rownum rn from (select ename,sal from emp order by sal) a1 where rownum<=10) where rn>=6;
2、按分析函数来分 row_number()函数
	//生成带序号的集合
	select row_number() over(order by id desc) as 'rowNumber', * from table1
	select * from (select row_number() over(order by id desc) as 'rowNumber', * from table1) as temp where rowNumber between 1 and 5
3、按照ROWID来分

//用查询结果创建新表
create table mytable (id,name,sal,job,deptno) as select empno,ename,sal,job,deptno from emp;

//合并查询 union,union all,intersect,minus    合并多个select语句的结果
1、union 取并集
	select ename,sal,job from emp where sal>200 union select ename,sal,job from emp where job='MANAGER';
2、intersect 取交集

3、minus 取差集

//分页方式
1.oracle数据库分页  
select * from (select a.*,rownum rc from 表名 where rownum<=endrow) a where a.rc>=startrow  
   
2.DB2数据库分页  
Select * from (select rownumber() over() as rc,a.* from (select * from 表名 order by 列名) as a) where rc between startrow and endrow  
   
3.SQL Server 2000数据库分页  
Select top pagesize * from 表名 where 列名 not  in(select top pagesize*page 列名 from  表名 order by 列名) order by 列名  
   
4.SQL Server 2005数据库分页  
Select * from (select 列名,row_搜索number() over(order by  列名1) as 别名from 表名) as t where t.列名1>=startrow and t.列名1<=endrow  
   
5.MySQL数据库分页  
Select * from 表名 limit startrow,pagesize  
(Pagesize为每页显示的记录条数)  
   
6.PostgreSQL数据库分页  
Select * from 表名 limit pagesize,offset startrow  
(Pagesize为每页显示的记录条数.)  
   
7.通用模式  
select * from ( select * from tb_student where sid not in(select sid from tb_student where rownum<=(currentPage-1)*pageSize)) where rownum <=pageSize; 


//***********************************
//创建数据库
1)通过oracle提供的向导工具
	dbca
2)手工创建

//to_date函数
 insert into emp values(9998,'小红','MANAGER',7782,'11-11月-1988',78.9,55.33,10);
 
 to_date函数
  insert into emp values(9998,'小红','MANAGER',7782,to_date('1988-12-12','yyyy-mm-dd'),78.9,55.33,10);