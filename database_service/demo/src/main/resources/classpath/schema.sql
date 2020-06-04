create table prisoner --������Ϣ
	(
	file_number char(18), --������:441781AAAABBBBXXXX
	political_status		varchar(8), --������ò:Ⱥ�ڣ���Ա����Ա������
	education_background		varchar(8),--ѧ����Сѧ�����У����У���ר�����ƣ�����
	name		varchar(8),--����
	birth_date  date,--�������ڣ�YYYY-MM-DD
	sex   varchar(2),--�Ա��У�Ů
	native_place  varchar(16),--���᣺�㶫����
	nationality  varchar(10),--���壺
	address  varchar(50),--��ͥסַ���㶫ʡ�����з�خ����ѧ��У����������ѧC10¥��714
	family_background  varchar(16),--��ͥ�������ĸ���ڣ���ĸ˫�������׼�ͥ
	blood_type  varchar(4),--Ѫ�ͣ�A,B,O,AB
	job   varchar(16),--����������Ա����ʦ
	time_to_jail varchar(10),--���ʱ�䣺YYYY-MM-DD
	information_in_jail varchar(16), -- �����Ϣ���Ƿ�߷�����Ϊ����
	register_in_jail varchar(4),-- ���Ǽ�:�ͷ��˹����ľ��ٵ�����
	  
	 primary key (file_number)
	);