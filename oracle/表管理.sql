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

第9讲