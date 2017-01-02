//创建用户 需要dba权限   密码要用字母开头
create user lee identified by Changeme123

//修改自己的密码
password

//系统管理员用户 修改别人的密码
password lee

//删除用户 如果要删除的用户已经创建了表，就需要带有一个参数删除：cascade;
drop user lee

//新创建的用户没有任务权限，甚至不能登录数据库
//lee属于安装时创建的数据库，但新创建的用户无法登录
//system赋予lee访问数据库权限 赋予create session权限、resource权限
//connect是种角色，角色可以包含多种权限

grant connect to lee
grant resource to lee        
grant select on scotttest to lee
grant all on emp to xiaoming

//收回权限
revoke select on scotttest from lee

//oracle权限：
//1、系统权限：用户对数据库的相关权限 140多种
//2、对象权限：用户对其他用户的数据对象操作的权限,如select、insert、update、delete、all等
//角色
//1、预定义角色，如connect（连接数据库）、dba（包含管理员权限）、 resource（表空间权限）
//2、自定义角色

//权限维护 scott用户把权限授权给lee，lee可以继续授权给别的用户
grant select on scotttest to lee with grant option



//用户口令管理 使用profile管理用户口令  建立数据库时，oracle会自动建立名称为default的profile
//当建立用户没有指定profile选项时，oracle会降default分配给用户
//system用户操作
create profile lock_account(规则名称) limit failed_login_attempts 3 password_lock_time 2(天);
drop profile  lock_account
alter user scott profile lock_account;

//每隔10天修改登录密码，宽限期为2天
create pofile myprofile limit password_life_time 10 password_grace_time 2;

//解锁
alter user scott account unlock;

//口令历史   指定口令可重用时间，即10天后可以重复
create profile password_history limit password_life_time 10 password_grace_time 2 password_reuse_time