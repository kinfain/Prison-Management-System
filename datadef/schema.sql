drop table term_information;  --  ������Ϣ
drop table medical_history;  --  ��ʷ
drop table rewords_punishments_information;  --  ������Ϣ
drop table jail;  --  ���� 
drop table prisoner;  --������Ϣ

create table prisoner --������Ϣ
	(

	file_number numeric(18,0), --������:441781AAAABBBBXXXX
	Political_status		varchar(8), --������ò:Ⱥ�ڣ���Ա����Ա������
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



	time_to_jail date,--���ʱ�䣺YYYY-MM-DD
	information_in_jail varchar(16), -- �����Ϣ���Ƿ�߷�����Ϊ����
	register_in_jail varchar(4),-- ���Ǽ�:�ͷ��˹����ľ��ٵ�����
	  
	 primary key (file_number)
	);
	create table term_information  --  ������Ϣ
	(
	file_number numeric(18,0), --������:441781AAAABBBBXXXX
	 prison_term  date,--����
     penalty_kind varchar(16),--����
     charge varchar(64), --���� 
	 primary key (file_number),
	 foreign key (file_number) references prisoner
		on delete cascade
	);

	create table medical_history  --  ��ʷ
	(
	file_number numeric(18,0), --������:441781AAAABBBBXXXX
    illness_time    varchar(16), -- ��ʷ.ʱ��
    illness_symptom  varchar(16), -- ��֢
	 primary key (file_number),
	 foreign key (file_number) references prisoner
		on delete cascade
	);
	create table  rewords_punishments_information  --  ������Ϣ
	(
	file_number numeric(18,0), --������:441781AAAABBBBXXXX
    rpi_time    varchar(16), --������Ϣ.ʱ��
    sentencing_condition varchar(16), --�������
	rpi_type  varchar(16),-- ����
	 primary key (file_number),
	 foreign key (file_number) references prisoner
		on delete cascade
	);
	   
    create table  jail  --  ���� 
	(
	
    jail_number    numeric(3,0), --���ұ��:714
    jail_equipment varchar(32), --�豸ά�޵ǼǼ�� 
	jail_check  varchar(32),-- ���Ǽ�:5.29��ƻ��������
	jail_have_person  varchar(2),-- �Ƿ����� 
	 primary key (jail_number),

	);