//�����û� ��ҪdbaȨ��   ����Ҫ����ĸ��ͷ
create user lee identified by Changeme123

//�޸��Լ�������
password

//ϵͳ����Ա�û� �޸ı��˵�����
password lee

//ɾ���û� ���Ҫɾ�����û��Ѿ������˱�����Ҫ����һ������ɾ����cascade;
drop user lee

//�´������û�û������Ȩ�ޣ��������ܵ�¼���ݿ�
//lee���ڰ�װʱ���������ݿ⣬���´������û��޷���¼
//system����lee�������ݿ�Ȩ�� ����create sessionȨ�ޡ�resourceȨ��
//connect���ֽ�ɫ����ɫ���԰�������Ȩ��

grant connect to lee
grant resource to lee        
grant select on scotttest to lee
grant all on emp to xiaoming

//�ջ�Ȩ��
revoke select on scotttest from lee

//oracleȨ�ޣ�
//1��ϵͳȨ�ޣ��û������ݿ�����Ȩ�� 140����
//2������Ȩ�ޣ��û��������û������ݶ��������Ȩ��,��select��insert��update��delete��all��
//��ɫ
//1��Ԥ�����ɫ����connect���������ݿ⣩��dba����������ԱȨ�ޣ��� resource����ռ�Ȩ�ޣ�
//2���Զ����ɫ

//Ȩ��ά�� scott�û���Ȩ����Ȩ��lee��lee���Լ�����Ȩ������û�
grant select on scotttest to lee with grant option



//�û�������� ʹ��profile�����û�����  �������ݿ�ʱ��oracle���Զ���������Ϊdefault��profile
//�������û�û��ָ��profileѡ��ʱ��oracle�ήdefault������û�
//system�û�����
create profile lock_account(��������) limit failed_login_attempts 3 password_lock_time 2(��);
drop profile  lock_account
alter user scott profile lock_account;

//ÿ��10���޸ĵ�¼���룬������Ϊ2��
create pofile myprofile limit password_life_time 10 password_grace_time 2;

//����
alter user scott account unlock;

//������ʷ   ָ�����������ʱ�䣬��10�������ظ�
create profile password_history limit password_life_time 10 password_grace_time 2 password_reuse_time